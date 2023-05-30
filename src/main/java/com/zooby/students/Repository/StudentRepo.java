package com.zooby.students.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zooby.students.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Long>{

}
