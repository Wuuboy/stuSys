package edu.hnust.stu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import edu.hnust.stu.bean.Student;
import edu.hnust.stu.service.StudentService;

@Controller
@RequestMapping("/stu")
public class StudentController {

	@Autowired
	StudentService studentService;
	//登入
	@RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(@RequestParam(value="username",required=false)String username,@RequestParam(value="password",required=false)String password,Model model) throws Exception {
       Student  student=studentService.checkLogin(username,password);
        if(student!=null){
            model.addAttribute(student);
            return "main";           
        }
        System.out.println(student);
        return "fail";//需要添加错误页面
    }
	//获取学生列表
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(@RequestParam(value = "pn", defaultValue = "5") Integer pn,Model model) throws ParseException {
		PageHelper.startPage(pn,5);
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		List<Student>students=studentService.getStus();
//		for (Student student : students) {
//			String dateString = formatter.format(student.getBirth());
//			student.setBirth(formatter.parse(dateString));
//			System.out.println(dateString);
//		}
		PageInfo<Student>page=new PageInfo<>(students,5);
		model.addAttribute("page",page);
		return "list";
	}
	//添加学生
	@RequestMapping(value="/add_stu",method=RequestMethod.POST)
	public String Insert(Student student)
	{
	  studentService.saveStu(student);
	  System.out.println(student);
	  return "redirect:list";
	}
	
	//用学号查询学生
	/*@RequestMapping(value="/getStu",method=RequestMethod.GET)
	public String getStuById(@RequestParam(value="id",required=false)Integer id,Model model) {
		Student student=studentService.getStusById(id);
		System.out.println(id);
		System.out.println(student);
		model.addAttribute("page",student);
		return "list_by_id";
	}*/
	
	//用姓名查询学生
	@RequestMapping(value="/getStuByName",method=RequestMethod.GET)
	public String getStuByName(@Param(value="name")String name,Model model) {
			List<Student>students=studentService.getStus(name);
			if (students.size()==0) {
				return "null";
			}
			System.out.println(name);
//			for (Student student : students) {
//				System.out.println(student);
//			}
			model.addAttribute("page",students);
			return "list_by_name";
		}
		
	//删除学生
		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable(value="id",required=false)Integer id) {
			studentService.delete(id);
			return"list";
		}
	//更新学生信息
		@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
		public String updateStu(Student student) {
			System.out.println(student);
			studentService.updateStu(student);
			return "redirect:list";
		}
	//返回main页面
		@RequestMapping("/back")
		public String back_main() {
			System.out.println("back");
			return "main";
		}
}
