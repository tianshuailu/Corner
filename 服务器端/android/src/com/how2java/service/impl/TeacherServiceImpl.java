package com.how2java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.mapper.TeacherMapper;
import com.how2java.pojo.Teacher;
import com.how2java.service.TeacherService;
 
@Service
public class TeacherServiceImpl  implements TeacherService{
    @Autowired
    TeacherMapper teacherMapper;
     
    public List<Teacher> list(){
        return teacherMapper.list();
    }
 
    public Teacher get(int userid1) {
    	return teacherMapper.get(userid1);
    }
}