package com.how2java.pojo;

public class Grade {

	private int cid;
	private int sid;
	private int grade;
	private String cname;
    private String sname;
    
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@Override
	public String toString() {
		return "Grade [cid=" + cid + ", sid=" + sid + ", grade=" + grade + ", cname=" + cname + ", sname=" + sname
				+ "]";
	}
    
}
