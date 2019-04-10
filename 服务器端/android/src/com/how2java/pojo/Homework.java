package com.how2java.pojo;

public class Homework {

	private int cid;
    private String hname;
    private String cname;
    private String start;
    private String finish;
    private String hcontent;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getFinish() {
		return finish;
	}
	public void setFinish(String finish) {
		this.finish = finish;
	}
	public String getHcontent() {
		return hcontent;
	}
	public void setHcontent(String hcontent) {
		this.hcontent = hcontent;
	}
	@Override
	public String toString() {
		return "Homework [cid=" + cid + ", hname=" + hname + ", cname=" + cname + ", start=" + start + ", finish="
				+ finish + ", hcontent=" + hcontent + "]";
	}
    
}
