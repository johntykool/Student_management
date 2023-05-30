package com.zooby.students.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zooby.students.Repository.StudentRepo;
import com.zooby.students.entity.Student;

@Service
public class implStudentService implements StudentService {

	@Autowired
	private StudentRepo studentRepo;	
	
	@Override
	public List<Student> getallstudents() {
		
		List<Student> stulist=studentRepo.findAll();
		return stulist;
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public Student updatestudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public Student gtestubyid(Long id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id).get();
	}

	@Override
	public void deleteStu(Long id) {
		studentRepo.deleteById(id);
		
	}

	
	

}
