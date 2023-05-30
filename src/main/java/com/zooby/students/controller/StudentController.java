package com.zooby.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import  com.zooby.students.entity.Student;
import com.zooby.students.Service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	 private StudentService studentService;
	
	
	@GetMapping("/Students")
	public String getallstudent(Model model)
	{
		model.addAttribute("students",studentService.getallstudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createsudentform(Model model)
	{
		Student student= new Student();
		model.addAttribute("student",student);
		return "createstudent";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
             studentService.saveStudent(student);
             return "redirect:/Students";
	}
	
	@GetMapping("/contact")
	public String contact(Model model)
	{
		return "contact";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editstudentform(@PathVariable Long id,Model model)
	{
		model.addAttribute("student",studentService.gtestubyid(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updatestu(@PathVariable Long id,@ModelAttribute("student") Student student,Model model)
	{
		Student extstudent=studentService.gtestubyid(id);
		extstudent.setId(student.getId());
		extstudent.setFirstname(student.getFirstname());
		extstudent.setLastname(student.getLastname());
		extstudent.setEmail(student.getEmail());
		
		studentService.updatestudent(extstudent);
		
		return "redirect:/Students";
		
	}
	@GetMapping("/students/{id}")
	public String deletestu(@PathVariable Long id)
	{
		studentService.deleteStu(id);
		
		return "redirect:/Students";
	}

}
