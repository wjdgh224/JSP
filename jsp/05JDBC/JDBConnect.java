package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletContext;

public class JDBConnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public JDBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/testdb";
			String id = "root";
			String pw = "1234";
			con = DriverManager.getConnection(url, id, pw);
			
			System.out.println("DB ���� ����(�⺻ ������)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public JDBConnect(String driver, String url, String id, String pwd) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB ���� ����(�μ� ������ 1)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public JDBConnect(ServletContext application) {
		try {
			String driver = application.getInitParameter("Driver");
			Class.forName(driver);
			String url = application.getInitParameter("URL");
			String id = application.getInitParameter("Id");
			String pwd = application.getInitParameter("Pwd");
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB ���� ����(�μ� ������ 2)");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(psmt != null) psmt.close();
			if(con != null) con.close();
			
			System.out.println("JDBC �ڿ� ����");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
