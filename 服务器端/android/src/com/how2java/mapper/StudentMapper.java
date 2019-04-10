package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.Student;

public interface StudentMapper {

	public int add(Student stu); 
    
    public void delete(int id); 
        
    public Student get(int id); 
      
    public int update(Student student);  
        
    public List<Student> list();
     
    public int count();
}
