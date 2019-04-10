package com.how2java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.mapper.ClasstimeMapper;
import com.how2java.pojo.Classtime;
import com.how2java.service.ClasstimeService;
 
@Service
public class ClasstimeServiceImpl  implements ClasstimeService{
    @Autowired
    ClasstimeMapper classtimeMapper;
     
    public List<Classtime> list(int cid, String week){
        return classtimeMapper.list(cid,week);
    }
 
    public Classtime get(int userid1) {
    	return classtimeMapper.get(userid1);
    }
}
