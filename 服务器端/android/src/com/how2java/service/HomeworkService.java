package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Homework;
 
public interface HomeworkService {
 
    List<Homework> list(int cid);

    Homework get(int userid1);

    int add(Homework homework);
}