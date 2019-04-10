package com.how2java.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.mapper.StudentMapper;
import com.how2java.pojo.Student;
import com.how2java.service.StudentService;
 
@Service
public class StudentServiceImpl  implements StudentService{
    @Autowired
    StudentMapper studentMapper;
     
    public List<Student> list(){
        return studentMapper.list();
    }
 
    public Student get(int userid1) {
    	return studentMapper.get(userid1);
    }
}
