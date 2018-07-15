package edu.hnust.stu.util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hnust.stu.bean.Student;
import edu.hnust.stu.dao.StudentMapper;
@Service
public class ViewExcel {
	
	@Autowired
	StudentMapper studentMapper;
	
	public void export(String[] titles,ServletOutputStream out) throws Exception {
			try {
				// 1.创建一个workbook，对应一个Excel文件
				HSSFWorkbook workbook=new HSSFWorkbook();
				//2.在webbook中添加一个sheet,对应Excel文件中的sheet
				HSSFSheet hssfSheet=workbook.createSheet("sheet1");
				//3.在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
				HSSFRow hssfRow=hssfSheet.createRow(0);
				//4.创建单元格，并设置值表头 设置表头居中
				HSSFCellStyle hssfCellStyle=workbook.createCellStyle();
				hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				HSSFCell hssfCell=null;
				for(int i=0;i<titles.length;i++) {
					hssfCell=hssfRow.createCell(i);
					hssfCell.setCellValue(titles[i]);
					hssfCell.setCellStyle(hssfCellStyle);
				}
				
				//5.写入数据
//				Student student=new Student(1, "cao", "F", new Date(), 1.0, 1.0, 1.0, 1.0);
//				Student student2=new Student(2, "guo", "m", new Date(), 2.2, 1.0, 1.0, 1.0);
//				List<Student>students=new ArrayList<>();
//				students.add(student);
//				students.add(student2);
				List<Student>students=studentMapper.selectAll();
				for (Student student4 : students) {
					System.out.println(student4);
				}
				for(int i=0;i<students.size();i++) {
					hssfRow=hssfSheet.createRow(i+1);
					Student student3=students.get(i);
					
					//6.创建单元格，并设置值
					Integer id=null;
					if (student3.getId()!=null) {
						id=student3.getId();
					}
					hssfRow.createCell(0).setCellValue(id);
					String name=null;
					if (student3.getName()!=null) {
						name=student3.getName();
					}
					hssfRow.createCell(1).setCellValue(name);
					String sex=null;
					if (student3.getSex()!=null) {
						sex=student3.getSex();
					}
					hssfRow.createCell(2).setCellValue(sex);
					SimpleDateFormat simFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
					Date birth = null;
					if (student3.getBirth()!=null) {
						birth=student3.getBirth();
					}
					hssfRow.createCell(3).setCellValue(birth);
					Double java=null;
					if (student3.getJava()!=null) {
						java=student3.getJava();
					}
					hssfRow.createCell(4).setCellValue(java);
					Double math=null;
					if (student3.getMath()!=null) {
						math=student3.getMath();
					}
					hssfRow.createCell(5).setCellValue(math);
					Double english=null;
					if (student3.getEnglish()!=null) {
						english=student3.getEnglish();
					}
					hssfRow.createCell(6).setCellValue(english);
					Double pe=null;
					if (student3.getPe()!=null) {
						pe=student3.getPe();
					}
					hssfRow.createCell(7).setCellValue(pe);
				}
				//7.将文件输出到客户端浏览器
				try {
					workbook.write(out);
					out.flush();
					out.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
                throw new Exception("导出信息失败！");
			}
		}
}
