package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Grade;
 
public interface GradeService {
 
    List<Grade> list(int sid);
    
    List<Grade> listall(int cid);
    
	Grade get(int sid, int cid);

	int add(Grade grade);
	
	int update(int sid, int cid, int grade);
	
}