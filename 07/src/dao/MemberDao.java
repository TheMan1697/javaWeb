package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import memberVO.MemberVo;
import utils.DBConn;

public class MemberDao {
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {
		return memberDao;
	}
	
	private MemberDao() {
		// TODO Auto-generated constructor stub
	}
	private Connection conn;
	private PreparedStatement pstmt;
	
	public List<MemberVo> list() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		
		try {
			conn = DBConn.getConnection();
			String query = "SELECT * FROM T_HOME";
			pstmt =conn.prepareStatement(query);
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				int idx=1;
				MemberVo memberVo = new MemberVo(rs.getString(idx++),
						rs.getString(idx++), 
						rs.getString(idx++), 
						rs.getString(idx++), 
						rs.getString(idx++),
						rs.getDate(idx++));
				list.add(memberVo);
			}
		conn.close();
		rs.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		new MemberDao().list().forEach(System.out::println);
	}

	public void register() {
		try {
			MemberVo memberVo = new MemberVo();
			conn = DBConn.getConnection();
			String query = "INSERT INTO FROM T_HOME VALUES(?,?,?,?,?,SYSDATE";
			pstmt =conn.prepareStatement(query);
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				int idx=1;
				pstmt.setString(idx++, memberVo.getId());
				pstmt.setString(idx++, memberVo.getPw());
				pstmt.setString(idx++, memberVo.getNick());
				pstmt.setString(idx++, memberVo.getName());
				pstmt.setString(idx++, memberVo.getEmail());
			}
		conn.close();
		rs.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
