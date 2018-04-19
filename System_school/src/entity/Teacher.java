package entity;

import java.util.List;

/**
 * author:Lionel-Messi
 * date:18-04-19
 * 用于接收t_teacher表中传来的数据
 * */

public class Teacher {
	private int id;
	private String name;
	private String password;
	private List<Course> courses;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", password=" + password + ", courses=" + courses + "]";
	}
	
	
}
