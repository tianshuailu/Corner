package com.how2java.controller;
 
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.how2java.pojo.Grade;
import com.how2java.pojo.Student;
import com.how2java.pojo.Teacher;
import com.how2java.pojo.Classtime;
import com.how2java.pojo.Homework;


import com.how2java.service.StudentService;
import com.how2java.service.TeacherService;
import com.how2java.service.nlpService;
import com.how2java.service.ClasstimeService;
import com.how2java.service.CourseService;
import com.how2java.service.GradeService;
import com.how2java.service.HomeworkService;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class StudentController {
    @Autowired
    GradeService gradeService;
    @Autowired
    StudentService studentService;
    @Autowired
    ClasstimeService classtimeService;
    @Autowired
    HomeworkService homeworkService;
    @Autowired
    nlpService nlp_Service;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;
    
    @RequestMapping("login")
    public void login(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
        	InputStream is = request.getInputStream();
        	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        	byte[] buffer = new byte[1024 * 1024];
        	int len = -1;
            while ((len = is.read(buffer)) != -1) {
                // 将Buffer中的数据写到outputStream对象中
                outStream.write(buffer, 0, len);
            }
            is.close();
            
            String result2 = new String(outStream.toByteArray());
            //System.out.println(result2);
            
            JSONObject json = JSONObject.fromObject(result2);
            JSONObject result = new JSONObject();
            
            String userid = json.getString("userid");
            String password = json.getString("password");
        
            //System.out.println(userid);
            //System.out.println(password);
            
            
            int userid1  = Integer.valueOf(userid).intValue();
            Student stu1 = studentService.get(userid1);
            
            System.out.println(stu1.getPwd());
       
            if(password.equals(stu1.getPwd())) {                              
            	result.put("status", 1);
            	
        	}
        	else {
        		result.put("status", 0);
        	}
            
            out = response.getWriter();
            out.write(result.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
	}
 
    @RequestMapping("tch_login")
    public void tch_login(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
        	InputStream is = request.getInputStream();
        	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        	byte[] buffer = new byte[1024 * 1024];
        	int len = -1;
            while ((len = is.read(buffer)) != -1) {
                // 将Buffer中的数据写到outputStream对象中
                outStream.write(buffer, 0, len);
            }
            is.close();
            
            String result2 = new String(outStream.toByteArray());
            System.out.println(result2);
            
            JSONObject json = JSONObject.fromObject(result2);
            JSONObject result = new JSONObject();
            
            String userid = json.getString("userid");
            String password = json.getString("password");
            
            int userid1  = Integer.valueOf(userid).intValue();
            Teacher tch = teacherService.get(userid1);
            
            System.out.println(tch.getPwd());
       
            if(password.equals(tch.getPwd())) {                              
            	result.put("status", 1);
            	
        	}
        	else {
        		result.put("status", 0);
        	}
            
            out = response.getWriter();
            out.write(result.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
	}
    
	@RequestMapping(value = "grade",produces = "text/html;charset=UTF-8")
	public void grade(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
        	InputStream is = request.getInputStream();
        	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        	byte[] buffer = new byte[1024 * 1024];
        	int len = -1;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            String result2 = new String(outStream.toByteArray());
            JSONObject json = JSONObject.fromObject(result2);
            JSONArray jsa = new JSONArray();
            
            String userid = json.getString("userid");
            int sid  = Integer.valueOf(userid).intValue();
            System.out.println(sid);
            List<Grade> gradelist = gradeService.list(sid);
            
            for(int i=0;i<gradelist.size();i++) {
            	JSONObject result = new JSONObject();
            	result.put("subject",gradelist.get(i).getCname());
            	result.put("grade", gradelist.get(i).getGrade());
            	jsa.add(result);
            }
            
            out = response.getWriter();
            out.write(jsa.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
	}
	
	@RequestMapping(value = "schedule",produces = "text/html;charset=UTF-8")
	public void schedule(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
        	InputStream is = request.getInputStream();
        	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        	byte[] buffer = new byte[1024 * 1024];
        	int len = -1;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            String result2 = new String(outStream.toByteArray());
            JSONObject json = JSONObject.fromObject(result2);
            JSONArray jsa = new JSONArray();
            
            String userid = json.getString("userid");
            String week = json.getString("week");
            int sid  = Integer.valueOf(userid).intValue();
            
            
            List<Grade> gradelist= gradeService.list(sid);
            for(int j=0;j<gradelist.size();j++) {
            	
            	int cid=gradelist.get(j).getCid();
            	System.out.println(cid);
                
            	List<Classtime> ctimelist = classtimeService.list(cid,week);
            	
            	for(int i=0;i<ctimelist.size();i++) {
            		System.out.println(ctimelist.get(i));
                    
	            	JSONObject result = new JSONObject();
	            	result.put("cname",ctimelist.get(i).getName());
	            	result.put("room",ctimelist.get(i).getRoom());
	            	result.put("day",ctimelist.get(i).getDay());
	            	result.put("start",ctimelist.get(i).getStart());
	            	result.put("finish",ctimelist.get(i).getFinish());
	            	result.put("teacher",ctimelist.get(i).getTeacher());
	            	jsa.add(result);
	            }
            }
            
            
            out = response.getWriter();
            out.write(jsa.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
	}
	
	@RequestMapping(value = "homework",produces = "text/html;charset=UTF-8")
	public void homework(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
        	InputStream is = request.getInputStream();
        	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        	byte[] buffer = new byte[1024 * 1024];
        	int len = -1;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            String result2 = new String(outStream.toByteArray());
            JSONObject json = JSONObject.fromObject(result2);
            JSONArray jsa = new JSONArray();
            
            String userid = json.getString("userid");
            int sid = Integer.valueOf(userid).intValue();
            List<Grade> gradelist= gradeService.list(sid);
            
            for(int i=0;i<gradelist.size();i++) {
            	List<Homework> homeworklist= homeworkService.list(gradelist.get(i).getCid());
            	for(int j=0;j<homeworklist.size();j++) {
            		JSONObject result = new JSONObject();
            		result.put("subject", homeworklist.get(j).getCname());
            		result.put("homework", homeworklist.get(j).getHcontent());
            		System.out.println(homeworklist.get(j).getHcontent());
            		result.put("finish", homeworklist.get(j).getFinish());
            		jsa.add(result);
            	}
            }
            out = response.getWriter();
            out.write(jsa.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
	}
	
	@RequestMapping(value = "sign",produces = "text/html;charset=UTF-8")
	public void sign(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
        	InputStream is = request.getInputStream();
        	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        	byte[] buffer = new byte[1024 * 1024];
        	int len = -1;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            String result2 = new String(outStream.toByteArray());
            JSONObject json = JSONObject.fromObject(result2);
            JSONObject result = new JSONObject();
            
            String userid_ = json.getString("userid");
            String pin_ = json.getString("pin");
            System.out.println(userid_);
            System.out.println(result2);
            
            //int pin = Integer.valueOf(pin_).intValue();
            int userid = Integer.valueOf(userid_).intValue();
            
            if(pin_.equals(nlp_Service.get().getPwd())) {
            	Student stu = new Student();
            	stu.setId(userid);
            	int re = nlp_Service.addstu(stu);
            	result.put("status",1);
            }
            else {
            	result.put("status",0);
            }
            
            out = response.getWriter();
            out.write(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
	}
	
	@RequestMapping(value="stuinfo",produces = "text/html;charset=UTF-8")
	public void stuinfo(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
        	InputStream is = request.getInputStream();
        	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        	byte[] buffer = new byte[1024 * 1024];
        	int len = -1;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            String result2 = new String(outStream.toByteArray());
            JSONObject json = JSONObject.fromObject(result2);
            
            String userid = json.getString("userid");
            int sid = Integer.valueOf(userid).intValue();
            System.out.println(sid+"   1");
            Student stu = studentService.get(sid);
            
            List<Student> ss= studentService.list();
            for(int i=0;i<ss.size();i++) {
            	System.out.println(ss.get(i).toString());
            }
            
            //System.out.println(sid+stu.getName());
            JSONObject result = new JSONObject();
            result.put("name", stu.getName());
            result.put("gender", stu.getGender());
            result.put("sid", stu.getId());
            result.put("dept", stu.getDept());
            result.put("major", stu.getMajor());
            
            out = response.getWriter();
            out.write(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
	}
	
	@RequestMapping(value = "sign_tch_sub",produces = "text/html;charset=UTF-8")
	public void sign_tch_sub(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
        	InputStream is = request.getInputStream();
        	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        	byte[] buffer = new byte[1024 * 1024];
        	int len = -1;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            String result2 = new String(outStream.toByteArray());
            JSONObject json = JSONObject.fromObject(result2);
            
            String userid_ = json.getString("userid");
            String pin_ = json.getString("pin");
            
            //int pin = Integer.valueOf(pin_).intValue();
            int userid = Integer.valueOf(userid_).intValue();
            
            Teacher tch = new Teacher();
            tch.setId(userid);
            tch.setPwd(pin_);
            int re = nlp_Service.addtch(tch);
            
            System.out.println(tch.toString());

            JSONObject result = new JSONObject();
            result.put("status",re);
            
            out = response.getWriter();
            out.write(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
	}
	
	@RequestMapping(value = "sign_tch_view",produces = "text/html;charset=UTF-8")
	public void sign_tch_view(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
        	InputStream is = request.getInputStream();
        	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        	byte[] buffer = new byte[1024 * 1024];
        	int len = -1;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            String result2 = new String(outStream.toByteArray());
            JSONObject json = JSONObject.fromObject(result2);
            JSONArray jsa = new JSONArray();
            
            List<Student> stulist = nlp_Service.list();

            for(int i=0;i<stulist.size();i++) {
            	JSONObject result = new JSONObject();
            	result.put("name",stulist.get(i).getName());
            	result.put("id",stulist.get(i).getId());
            	
            	jsa.add(result);
            }
            out = response.getWriter();
            out.write(jsa.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
	}
	
	@RequestMapping(value = "ddl_tch_sub",produces = "text/html;charset=UTF-8")
	public void ddl_tch_sub(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
        	InputStream is = request.getInputStream();
        	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        	byte[] buffer = new byte[1024 * 1024];
        	int len = -1;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            String result2 = new String(outStream.toByteArray(),"utf-8");
            JSONObject json = JSONObject.fromObject(result2);
            
            String cname = json.getString("cname");
            String hname = json.getString("hname");
            String finish = json.getString("finish");
            
            Homework homework = new Homework();
            homework.setCname(cname);
            homework.setCid(courseService.get(cname).getId());
            homework.setHname(hname);
            homework.setFinish(finish);
            int re = homeworkService.add(homework);
            System.out.println(homework.toString());
            
            JSONObject result = new JSONObject();
            result.put("status", 1);
            out = response.getWriter();
            out.write(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
	}
	
	@RequestMapping(value = "score_fix",produces = "text/html;charset=UTF-8")
	public void score_fix(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
        	InputStream is = request.getInputStream();
        	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        	byte[] buffer = new byte[1024 * 1024];
        	int len = -1;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            String result2 = new String(outStream.toByteArray());
            JSONObject json = JSONObject.fromObject(result2);
            
            System.out.println(result2);
            
            String cid_ = json.getString("cid");
            String sid_ = json.getString("sid");
            String grade_ = json.getString("grade");
            int cid = Integer.valueOf(cid_).intValue();
            int sid = Integer.valueOf(sid_).intValue();
            int grade = Integer.valueOf(grade_).intValue();
            
            gradeService.update(sid, cid, grade);
            
            JSONObject result = new JSONObject();
            result.put("status", 1);
            out = response.getWriter();
            out.write(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
	}
	
	@RequestMapping(value = "score_view",produces = "text/html;charset=UTF-8")
	public void score_view(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
        	InputStream is = request.getInputStream();
        	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        	byte[] buffer = new byte[1024 * 1024];
        	int len = -1;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            String result2 = new String(outStream.toByteArray());
            JSONObject json = JSONObject.fromObject(result2);
            JSONArray jsa = new JSONArray();
            
            System.out.println(result2);
            
            String cid_ = json.getString("course");
            int cid = Integer.valueOf(cid_).intValue();
            List<Grade> gradelist = gradeService.listall(cid);
            
            for(int i=0;i<gradelist.size();i++) {
            	JSONObject result = new JSONObject();
            	result.put("cname", gradelist.get(i).getCname());
            	result.put("sname", gradelist.get(i).getSname());
            	result.put("grade", gradelist.get(i).getGrade());
            	jsa.add(result);
            }
            out = response.getWriter();
            out.write(jsa.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
	}
}

