package com.how2java.pojo;

public class Teacher {

	private int id;
    private String name;
    private String pwd;
    private String dept;
    private String major;
    private String gender;
    
    public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getPwd() {
        return pwd;
    }
    @Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", pwd=" + pwd + ", dept=" + dept + ", major=" + major
				+ ", gender=" + gender + "]";
	}
}
