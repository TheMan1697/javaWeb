package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Board;
import domain.Member;
import utils.DBConn;

public class MemberDao {
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {
		return memberDao;
	}
	private MemberDao() {}
	
	public void register(Member member) {
		try {
			Connection conn = DBConn.getConnection();
			String sql = "{call PROC_INSERT_MEMBER(?,?,?,?,?,?,?,?,?,?,?,?)}";
			// 문장 생성
			//PreparedStatement pstmt = conn.prepareStatement(sql);
			CallableStatement cstmt = conn.prepareCall(sql);
			
			// 파라미터 바인딩
			int idx = 1;
			cstmt.setString(idx++, member.getId());
			cstmt.setString(idx++, member.getPw());
			cstmt.setString(idx++, member.getName());
			
			cstmt.setString(idx++, member.getSi());
			cstmt.setString(idx++, member.getSgg());
			cstmt.setString(idx++, member.getEmd());
			cstmt.setString(idx++, member.getRoadAddr());
			cstmt.setString(idx++, member.getAddrDetail());
			cstmt.setString(idx++, member.getZipNo());
			cstmt.setString(idx++, member.getRoadFullAddr());
			cstmt.setString(idx++, member.getJibunAddr());
			
			cstmt.setString(idx++, member.getEmail());
			
			// 문장 실행(반영)
			cstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modify(Member member) {
		try {
			//클래스 로드
			// connection 취득
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", 
//					"odoung", "1234");
			Connection conn =DBConn.getConnection();
			
			// 문장 생성
			String sql = "UPDATE TBL_MEMBER SET\r\n" + 
					"PW = ?,\r\n" + 
					"NAME = ?\r\n" + 
					"WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 파라미터 바인딩
			int idx = 1;
			pstmt.setString(idx++, member.getPw());
			pstmt.setString(idx++, member.getName());
			pstmt.setString(idx++, member.getId());
			
			// 문장 실행(반영)
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remove(String id) {
		try {
			//클래스 로드
			// connection 취득
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", 
//					"odoung", "1234");
			Connection conn =DBConn.getConnection();
			
			// 문장 생성
			
			// 문장 생성
//			String sql = "DELETE TBL_MEMBER \r\n" + 
//					"WHERE ID = ?";
			String sql="{call quit_proc(?)}";
			CallableStatement pstmt = conn.prepareCall(sql);
			
			// 파라미터 바인딩
			pstmt.setString(1, id);
			
			// 문장 실행(반영)
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Member login(String id, String pw) {
		Member member = null;
		System.out.println(id);
		System.out.println(pw);
		try {
			//클래스 로드
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			// connection 취득
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", 
//					"odoung", "1234");
			Connection conn =DBConn.getConnection();
			
			// 문장 생성
			String sql = "SELECT * FROM TBL_MEMBER\r\n" + 
					"WHERE ID = ? AND PW = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, id.trim());
			pstmt.setString(idx++, pw.trim());
			// 결과집합 생성
			ResultSet rs = pstmt.executeQuery();
			
			// 결과집합 순회 후 데이터 바인딩
			while(rs.next()) {
				int idx2 = 1;
				member = new Member(rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	public Member get(String id) {
		Member member = null;
		try {
			//클래스 로드
			// connection 취득
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", 
//					"odoung", "1234");
			Connection conn =DBConn.getConnection();
			
			// 문장 생성
			String sql = "SELECT * FROM TBL_MEMBER\r\n" + 
					"WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, id.trim().toLowerCase());
			
			// 결과집합 생성
			ResultSet rs = pstmt.executeQuery();
			
			// 결과집합 순회 후 데이터 바인딩
			while(rs.next()) {
				int idx2 = 1;
				member = new Member(
						rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++),
						rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++),
						rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++),
						rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++),
						rs.getString(idx2++),rs.getString(idx2++)
						);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	public Member findBy(String email) {
		Member member = null;
		try {
			//클래스 로드
			// connection 취득
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", 
//					"odoung", "1234");
			Connection conn =DBConn.getConnection();
			
			// 문장 생성
			String sql = "SELECT * FROM TBL_MEMBER\r\n" + 
					"WHERE EMAIL = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, email.trim().toLowerCase());
			
			// 결과집합 생성
			ResultSet rs = pstmt.executeQuery();
			
			// 결과집합 순회 후 데이터 바인딩
			while(rs.next()) {
				int idx2 = 1;
				member = new Member(rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
		public void updateAuthToken(Member member) {
			try {
				//클래스 로드
				// connection 취득
//				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", 
//						"odoung", "1234");
				Connection conn =DBConn.getConnection();
				
				// 문장 생성
				String sql = "UPDATE TBL_MEMBER SET\r\n" + 
						"AUTH_TOKEN=? \r\n" + 
						"WHERE ID = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				// 파라미터 바인딩
				pstmt.setString(1, member.getAuth_token());
				pstmt.setString(2, member.getId());
				
				// 문장 실행(반영)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void updateAuth(Member member) {
			try {
				//클래스 로드
				// connection 취득
				Connection conn =DBConn.getConnection();
				
				// 문장 생성
				String sql = "UPDATE TBL_MEMBER SET\r\n" + 
						"AUTH=? \r\n" + 
						"WHERE ID = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				// 파라미터 바인딩
				pstmt.setString(1, member.getAuth());
				pstmt.setString(2, member.getId());
				
				// 문장 실행(반영)
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
