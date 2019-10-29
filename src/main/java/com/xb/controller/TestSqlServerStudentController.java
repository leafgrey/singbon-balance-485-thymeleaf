package com.xb.controller;
import com.xb.domain.Student;
import com.xb.services.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/***
 * @class TestController
 * @description 测试 mybatis springboot
 * @author zch
 * @date 2019/7/13
 * @version V0.0.1.201907131515.01
 * @function function
 * @modfiyDate modfiyDate
 * @createDate createDate
 * @package package
 */
@RestController
@RequestMapping("/testSqlServerStudent")
public class TestSqlServerStudentController {
	@Resource
	public StudentService studentService;
	@RequestMapping("/index")
	public String index() {
		Student student = studentService.selectByPrimaryKey(1L);
		if(null != student) {
			System.out.println(student.toString());
		}
		List<Student> studentList = studentService.selectAllStudentList();
		if(null == studentList) {
			Student studentNew = new Student();
			studentNew.setId(10L);
			studentNew.setCourse("e");
			studentNew.setName("haha");
			studentNew.setAddtime(new Date());
			studentService.insert(studentNew);
		}
		if(studentList != null) {
			return Arrays.toString(studentList.toArray());
		}
		else {
			return "zch err";
		}
	}
}
