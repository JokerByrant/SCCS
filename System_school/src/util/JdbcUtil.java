package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JdbcUtil {
	
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	
	//�����ʱ��ʼ��
	static{
		ResourceBundle rb = ResourceBundle.getBundle("db");
		driverClass = rb.getString("driverClass");
		url = rb.getString("url");
		username = rb.getString("username");
		password = rb.getString("password");
	}
	
	/**
	 * ���ӵĻ�ȡ
	 * @return
	 */
    public static Connection getConn(){
    	//0����������
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//1����������,��ȡһ�����Ӷ���conn
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
    }
    
    /**
     * ��Դ�ͷ�
     * @param conn
     * @param st
     * @param rs
     */
    public static void free(Connection conn,Statement st,ResultSet rs){
    	try {
			if(rs!=null){
				rs.close();
				rs = null;
			}
			if(st!=null){
				st.close();
				st = null;
			}
			if(conn!=null){
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    }
}
