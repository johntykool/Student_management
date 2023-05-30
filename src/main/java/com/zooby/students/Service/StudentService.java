package com.zooby.students.Service;

import java.util.List;

import com.zooby.students.entity.Student;

public interface StudentService {
	
	List<Student> getallstudents();
	Student saveStudent(Student student);
	
	Student updatestudent(Student student);
	
	Student gtestubyid(Long id);
	
	void deleteStu(Long id);

}
