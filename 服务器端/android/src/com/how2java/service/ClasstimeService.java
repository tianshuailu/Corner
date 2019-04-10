package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Classtime;
 
public interface ClasstimeService {
 
    List<Classtime> list(int cid, String week);

    Classtime get(int userid1);

}