package com.how2java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.how2java.pojo.Grade;


public interface GradeMapper {

	public int add(Grade grade); 
    
    public void delete(int id); 
        
    public Grade get(int sid, int cid); 
      
    public int update(@Param(value = "sid")int sid, @Param(value = "cid")int cid, @Param(value = "grade")int grade);
        
    public List<Grade> list(int sid);
    
    public List<Grade> listall(int cid);
     
    public int count();
}
