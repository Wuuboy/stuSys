package edu.hnust.stu.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.xmlbeans.impl.jam.mutable.MPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.hnust.stu.bean.Student;
import edu.hnust.stu.service.StudentService;
import edu.hnust.stu.util.ViewExcel;

@Controller
@RequestMapping("/stu")
class UtilController {
	@Autowired
	ViewExcel viewExcel;
	
	@Autowired
	StudentService studentService;
	
	//导出EXCEL
	@RequestMapping("/excel")
	@ResponseBody
	public String exortExcell(HttpServletResponse response){
	     	response.setContentType("application/vnd.ms-excel;charset=UTF-8");
	    	 try{
                 ServletOutputStream out=response.getOutputStream();
				 response.setHeader("Content-Disposition", "attachment;fileName=excel.xls");
                 String[] titles = { "学号", "姓名", "性别", "生日","java","数学","英语","体育" }; 
                 viewExcel.export(titles, out);      
                 return "success";
             } catch(Exception e){
                 e.printStackTrace();
                 return "导出信息失败";
             }
         }
	@RequestMapping(value="/echart_bar1")
	@ResponseBody
	public Object getEchartBar1(@RequestParam(value="id",required=false)Integer id) {
		Student student=studentService.getStusById(23);
		List<Double>grades=new ArrayList<>();
		grades.add(student.getJava());
		grades.add(student.getMath());
		grades.add(student.getEnglish());
		grades.add(student.getPe());
		for (Iterator iterator = grades.iterator(); iterator.hasNext();) {
			Double double1 = (Double) iterator.next();
			System.err.println(double1);
		}
//		List<Student>students=studentService.getStus();
		return grades;
	}
	
	//去柱状图页面
	@RequestMapping("/echart")
	public Object toEchartBar(@RequestParam(value="id",required=false)Integer id,Model model) {
		model.addAttribute("id",id);
		return "echart_bar";
	}
	//生成柱状图
	@RequestMapping(value="/echart_bar/{id}")
	@ResponseBody
	public Object getEchartBar(@PathVariable(value="id",required=false)Integer id) {
		Student student=studentService.getStusById(id);
		List<Double>grades=new ArrayList<>();
		grades.add(student.getJava());
		grades.add(student.getMath());
		grades.add(student.getEnglish());
		grades.add(student.getPe());
		for (Iterator iterator = grades.iterator(); iterator.hasNext();) {
			Double double1 = (Double) iterator.next();
			System.err.println(double1);
		}
//		List<Student>students=studentService.getStus();
		return grades;
	}
	
}


