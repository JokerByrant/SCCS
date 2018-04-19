package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Course;
import entity.Student;
import util.JdbcUtil;

public class StudentDao {
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	// 学生登录
	public Student findStudentByNamePwd(String name,String password) {
		conn = JdbcUtil.getConn();
		String sql = "select * from t_student where name = ? and password = ?";
		Student student = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, password);
			rs = pst.executeQuery();
			student = new Student();
			
			while(rs.next()) {
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.free(conn, pst, rs);
		} 
		
		return student;
		
	}
	
	// 查看某门课程的所有学生
	public List<Student> findStudentByCourse(Course course){
		conn = JdbcUtil.getConn();
		List<Student> students = null;
		String sql = "select * from t_student where sid in"
				+ "(select sid from t_choose where cid = ?)";
		
		try {
			students = new ArrayList<>();
			pst = conn.prepareStatement(sql);
			pst.setString(1, course.getId());
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				students.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.free(conn, pst, rs);
		}
		
		return students;
	}
}
