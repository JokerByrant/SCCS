package entity;

import java.util.List;

/**
 * author:Lionel-Messi
 * date:18-04-19
 * Course类，用于接收从t_Course表中传过来数据
 * */

public class Course {
	private String id;
	private String name;
	private Teacher teacher;
		
	public Course(String id, String name, Teacher teacher) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
	}
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	

	public Course(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", teacher=" + teacher + "]";
	}
	
}
