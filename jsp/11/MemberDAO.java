package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MemberDTO;

public class MemberDAO {
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Context context;
	private ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
	
	public MemberDAO() {
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/" + "jdbc/dbconn");
			conn = dataSource.getConnection();
			System.out.println("DBCP�� �ִ� Ŀ�ؼ� ��ü ������ ����");
			System.out.println("������� : " + Thread.currentThread().getName());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DAO������ ȣ��");
		System.out.println("������� : " + Thread.currentThread().getName());
	}
	//DBCP���� Connection�� ��ȯ�ϴ� �޼���
	/*
	 * public Connection getConnection() { try { context = new InitialContext();
	 * dataSource = (DataSource)context.lookup("java:comp/env/" + "jdbc/dbconn");
	 * conn = dataSource.getConnection();
	 * System.out.println("DBCP�� �ִ� Ŀ�ؼ� ��ü ������ ����"); System.out.println("������� : " +
	 * Thread.currentThread().getName()); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * return conn; }
	 */
	
	//MemberDTO���̺� �ִ� ������ ����Ʈ�� �������� �޼���
	public ArrayList<MemberDTO> memberList() {
		
		try {
			//Connection conn = this.getConnection();
			String sql = "select * from MemberDTO";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String username = rs.getString("username");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				
				MemberDTO dto = new MemberDTO(username, id, pw, phone1, phone2, phone3, gender);
				dtos.add(dto);
			}
			
			System.out.println("DB�� �ִ� ������ �������� ����");
			System.out.println("������� : " + Thread.currentThread().getName());

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	//�ű� ȸ�������� DB �� ArrayList�߰�, �����ϴ� �޼���
	public void addMember(MemberDTO dto) {
		int n = 0;
		try {
		String sql = "insert into MemberDTO values (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getUsername());
		pstmt.setString(2, dto.getId());
		pstmt.setString(3, dto.getPw());
		pstmt.setString(4, dto.getPhone1());
		pstmt.setString(5, dto.getPhone2());
		pstmt.setString(6, dto.getPhone3());
		pstmt.setString(7, dto.getGender());
		
		n = pstmt.executeUpdate();
		System.out.println("���� ���� : " + n);
		
		dtos.add(dto);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
