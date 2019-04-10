package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Course;
 
public interface CourseService {
 
    List<Course> list();

	Course get(String cname);

}