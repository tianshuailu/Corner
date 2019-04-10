package com.how2java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.mapper.CourseMapper;
import com.how2java.pojo.Course;
import com.how2java.service.CourseService;
 
@Service
public class CourseServiceImpl  implements CourseService{
    @Autowired
    CourseMapper courseMapper;
     
    public List<Course> list(){
        return courseMapper.list();
    }
 
    public Course get(String cname) {
    	return courseMapper.get(cname);
    }
}