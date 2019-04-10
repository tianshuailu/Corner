package com.how2java.pojo;

public class Classtime {

	private int id;
    private String name;
    private String week;
    private String day;
    private String start;
    private String finish;
    private String room;
    private String teacher;
    
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
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
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
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
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	
	@Override
	public String toString() {
		return "Classtime [id=" + id + ", name=" + name + ", week=" + week + ", day=" + day + ", start=" + start
				+ ", finish=" + finish + ", room=" + room + "]";
	}
    
}
