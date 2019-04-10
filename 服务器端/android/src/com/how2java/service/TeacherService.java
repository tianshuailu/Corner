package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Teacher;
 
public interface TeacherService {
 
    List<Teacher> list();

    Teacher get(int userid1);

}
