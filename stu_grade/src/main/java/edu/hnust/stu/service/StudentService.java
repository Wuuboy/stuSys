package edu.hnust.stu.service;

import java.util.List;

import org.apache.taglibs.standard.tag.common.core.SetSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hnust.stu.bean.Student;
import edu.hnust.stu.dao.StudentMapper;

@Service
public class StudentService {

	@Autowired
	StudentMapper studentMapper;
	
	/* 登陆验证 */
    public Student checkLogin(String username, String password) {
        //根据用户名实例化用户对象
        Student student = studentMapper.selectByName(username);
        if (student != null) {
            return student;
        }
        System.out.println(student);
        return null;
    }

    /*获取学生列表*/
	public List<Student> getStus() {
		// TODO Auto-generated method stub
		return studentMapper.selectByExample(null);
	}

	public void saveStu(Student student) {
		// TODO Auto-generated method stub
		studentMapper.insertSelective(student);
	}

	
	public Student getStusById(Integer id) {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(id);
	}

	public List<Student> getStus(String name) {
		// TODO Auto-generated method stub
		return studentMapper.selectByName1(name);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		studentMapper.deleteByPrimaryKey(id);
	}

	public void updateStu(Student student) {
		// TODO Auto-generated method stub
		studentMapper.updateByPrimaryKeySelective(student);
	}

	
}
