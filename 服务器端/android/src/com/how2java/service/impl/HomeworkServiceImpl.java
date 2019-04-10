package com.how2java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.mapper.HomeworkMapper;
import com.how2java.pojo.Homework;
import com.how2java.service.HomeworkService;
 
@Service
public class HomeworkServiceImpl  implements HomeworkService{
    @Autowired
    HomeworkMapper homeworkMapper;
     
    public List<Homework> list(int cid){
        return homeworkMapper.list(cid);
    }
 
    public Homework get(int userid1) {
    	return homeworkMapper.get(userid1);
    }
    
    public int add(Homework homework) {
    	return homeworkMapper.add(homework);
    }
}