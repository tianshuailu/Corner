package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.Homework;

public interface HomeworkMapper {

	public int add(Homework homework); 
    
    public void delete(int id); 
        
    public Homework get(int id); 
      
    public int update(Homework homework);  
        
    public List<Homework> list(int cid);
     
    public int count();
}
