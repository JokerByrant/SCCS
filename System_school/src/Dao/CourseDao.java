package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Course;
import entity.Student;
import entity.Teacher;
import util.JdbcUtil;

public class CourseDao {
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	// 学生选课
	public boolean addCourseByStudent(Student student,Course course) {
		conn = JdbcUtil.getConn();
		String sql = "insert into t_choose(sid,cid) values (?,?)";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, student.getId());
			pst.setString(2, course.getId());
			int r = pst.executeUpdate();
			
			if(r==1) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JdbcUtil.free(conn, pst, rs);
		}
		
	}
	
	// 老师选课
	public boolean addCourseByTeacher(Teacher teacher,Course course) {
		conn = JdbcUtil.getConn();
		String sql = "insert into t_course(cid,cname,tid) values (?,?,?)";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, course.getId());
			pst.setString(2, course.getName());
			pst.setInt(3, teacher.getId());
			int r = pst.executeUpdate();
			
			if(r==1) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JdbcUtil.free(conn, pst, rs);
		}
	}
	
	// 查看所有课程
	public List<Course> FindAllCourse() {
		conn = JdbcUtil.getConn();
		List<Course> courses = null;
		String sql = "select c.cid,c.cname,c.tid,t.name from t_course c "
				+ "join t_teacher t on c.tid=t.tid";
		
		try {
			courses = new ArrayList<>();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Course course = new Course();
				Teacher teacher = new Teacher();
				course.setId(rs.getString(1));
				course.setName(rs.getString(2));
				teacher.setId(rs.getInt(3));
				teacher.setName(rs.getString(4));
				course.setTeacher(teacher);
				courses.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.free(conn, pst, rs);
		}
		
		return courses;
		
	}
	
	// 学生查看自己所选课程
	public List<Course> FindAllCourseByStudent(Student student) {
		conn = JdbcUtil.getConn();
		List<Course> courses = null;
		String sql = "select c.cid,c.cname,c.tid,t.name from t_course c"
				+ " join t_teacher t on c.tid=t.tid "
				+ "where cid in(select cid from t_choose where sid = ?)";
		
		try {
			courses = new ArrayList<>();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, student.getId());
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Course course = new Course();
				course.setId(rs.getString(1));
				course.setName(rs.getString(2));
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt(3));
				teacher.setName(rs.getString(4));
				course.setTeacher(teacher);
				courses.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.free(conn, pst, rs);
		}
		
		return courses;
	}
	
	// 教师查看自己所选课程
	public List<Course> FindAllCourseByTeacher(Teacher teacher) {
		conn = JdbcUtil.getConn();
		List<Course> courses = null;
		String sql = "select * from t_course where tid = ?";
		
		try {
			courses = new ArrayList<>();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, teacher.getId());
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Course course = new Course();
				course.setId(rs.getString(1));
				course.setName(rs.getString(2));
				course.setTeacher(teacher);
				courses.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.free(conn, pst, rs);
		}
		
		return courses;
	}
	

	
	
}
