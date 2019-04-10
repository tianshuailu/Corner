package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Student;
import com.how2java.pojo.Teacher;

 
public interface nlpService {
 
    List<Student> list();

	Teacher get();

	int addstu(Student stu);
	
	int addtch(Teacher tch);
}