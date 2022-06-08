package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.vo.MemberVo;
import utils.DBConn;

public class MemberDao {
	/*
	 * singleton
	 */
	private static MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}
	private MemberDao() {}
	
	/*
	 * 
	 */
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private Connection conn;
	
	public List<MemberVo> list() {
		List<MemberVo> list = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			String query = "SELECT * FROM T_MEMBER";
//			query = "INSERT INTO(ID, PWD, NAME, EMAIL) VALUES ('" + memberVo.getId() + "')";
//			stmt = conn.createStatement();
//			System.out.println(stmt);
//			ResultSet rs = stmt.executeQuery(query); 
			//NullPointerException 뜨는 이유 stmt가 Null이기 때문에
			
			pstmt = conn.prepareStatement(query); // 전처리 시킴
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx = 1;
				MemberVo vo = new MemberVo(
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getDate(idx++)
						);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void register(MemberVo memberVo) {
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO T_MEMBER VALUES(?, ?, ?, ?, SYSDATE)");
			int idx = 1;
			pstmt.setString(idx++, memberVo.getId());
			pstmt.setString(idx++, memberVo.getPwd());
			pstmt.setString(idx++, memberVo.getName());
			pstmt.setString(idx++, memberVo.getEmail());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remove(String id) {
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement("DELETE FROM T_MEMBER  WHERE ID = '"+ id +"'");
			
//			int idx = 1;
//			pstmt.setString(idx++, id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MemberDao().list("순").forEach(System.out::println);
	}
	
	public MemberVo login(String id, String pwd) {
		MemberVo memberVo = null;
		try {
			conn = DBConn.getConnection();
			String query = "SELECT * FROM T_MEMBER WHERE ID = ? AND PWD = ?";
			
			pstmt = conn.prepareStatement(query); // 전처리 시킴
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);			
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx = 1;
				memberVo = new MemberVo(
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getDate(idx++)
						);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberVo;
	}
	public List<MemberVo> list(String keyword) {
		List<MemberVo> list = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			String query = "SELECT * FROM T_MEMBER";
			
//			keyword = "홍길동"; >> LIKE '%"홍길동"%';
			if(keyword != null && !keyword.isEmpty()) {
				query += " WHERE NAME LIKE '%' || ? || '%'";
			}
			
			pstmt = conn.prepareStatement(query); // 전처리 시킴
			
			if(keyword != null && !keyword.isEmpty()) {
				pstmt.setString(1, keyword);
			}
						
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx = 1;
				MemberVo vo = new MemberVo(
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getDate(idx++)
						);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
