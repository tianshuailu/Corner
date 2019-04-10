package com.how2java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.mapper.nlpMapper;

import com.how2java.pojo.Student;
import com.how2java.pojo.Teacher;

import com.how2java.service.nlpService;

 
@Service
public class nlpServiceImpl  implements nlpService{
    @Autowired
    nlpMapper nlpMapper_;
     
    public List<Student> list(){
        return nlpMapper_.list();
    }
 
    public Teacher get() {
    	return nlpMapper_.get();
    }

	public int addstu(Student stu) {
		// TODO Auto-generated method stub
		return nlpMapper_.addstu(stu);
	}

	public int addtch(Teacher tch) {
		// TODO Auto-generated method stub
		return nlpMapper_.addtch(tch);
	}
}
