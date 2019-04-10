package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.Course;

public interface CourseMapper {

	public int add(Course course); 
    
    public void delete(int id); 
        
    public Course get(String cname); 
      
    public int update(Course course);  
        
    public List<Course> list();
     
    public int count();
}
