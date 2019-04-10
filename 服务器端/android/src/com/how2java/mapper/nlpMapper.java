package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.Student;
import com.how2java.pojo.Teacher;


public interface nlpMapper {

	public int addstu(Student stu); 
	
	public int addtch(Teacher tch);
    
    public void delete(int id); 
        
    public Teacher get(); 
      
    public int update(Student student);  
        
    public List<Student> list();
     
    public int count();
}
