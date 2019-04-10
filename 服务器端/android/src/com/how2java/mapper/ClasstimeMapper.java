package com.how2java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.how2java.pojo.Classtime;

public interface ClasstimeMapper {

	public int add(Classtime ctime); 
    
    public void delete(int id); 
        
    public Classtime get(int id); 
      
    public int update(Classtime ctime);  
        
    public List<Classtime> list(@Param(value = "cid")int cid, @Param(value = "week")String week);
     
    public int count();
}

