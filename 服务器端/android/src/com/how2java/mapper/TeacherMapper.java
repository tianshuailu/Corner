package com.how2java.mapper;
import java.util.List;

import com.how2java.pojo.Teacher;

public interface TeacherMapper {

	public int add(Teacher teacher); 
    
    public void delete(int id); 
        
    public Teacher get(int id); 
      
    public int update(Teacher teacher);  
        
    public List<Teacher> list();
     
    public int count();
}
