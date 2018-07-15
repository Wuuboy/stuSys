package edu.hnust.stu.test;

import java.util.Date;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.hnust.stu.bean.Student;
import edu.hnust.stu.dao.StudentMapper;

/**
 * 测试dao层的工作
 * @author lfy
 *推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 *1、导入SpringTest模块
 *2、@ContextConfiguration指定Spring配置文件的位置
 *3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCRUD(){
		//1、创建SpringIOC容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2、从容器中获取mapper
		StudentMapper bean = ioc.getBean(StudentMapper.class);
		System.out.println(studentMapper);
		
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Student student=mapper.selectByName("a40aaa");
		System.out.println(student);
		for(int i = 0;i<1000;i++){
			String uid = UUID.randomUUID().toString().substring(0,2)+i;
			mapper.insertSelective(new Student(null,uid, "M", new Date(),100.00,100.00,100.00,100.00));
		}
		System.out.println("批量完成");
		
	}

}
