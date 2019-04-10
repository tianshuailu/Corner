package com.how2java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.mapper.GradeMapper;
import com.how2java.pojo.Grade;
import com.how2java.service.GradeService;
 
@Service
public class GradeServiceImpl  implements GradeService{
    @Autowired
    GradeMapper gradeMapper;
     
    public List<Grade> list(int sid){
        return gradeMapper.list(sid);
    }
 
    public Grade get(int sid, int cid) {
    	return gradeMapper.get(sid,cid);
    }
    
    public int add(Grade grade) {
    	return gradeMapper.add(grade);
    }
    
    public List<Grade> listall(int cid){
    	return gradeMapper.listall(cid);
    }
    
    public int update(int sid, int cid, int grade) {
    	return gradeMapper.update(sid, cid, grade);
    }
}