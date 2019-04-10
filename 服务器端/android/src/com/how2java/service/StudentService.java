package com.how2java.service;
 
import java.util.List;

import com.how2java.pojo.Student;
 
public interface StudentService {
 
    List<Student> list();

	Student get(int userid1);

}