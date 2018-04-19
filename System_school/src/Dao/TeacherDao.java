package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Student;
import entity.Teacher;
import util.JdbcUtil;

public class TeacherDao {
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	public Teacher findTeacherByNamePwd(String name,String password) {
		conn = JdbcUtil.getConn();
		String sql = "select * from t_teacher where name = ? and password = ?";
		Teacher teacher = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, password);
			rs = pst.executeQuery();
			teacher = new Teacher();
			
			while(rs.next()) {
				teacher.setId(rs.getInt(1));
				teacher.setName(rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.free(conn, pst, rs);
		}
		
		return teacher;
		
	}
}
