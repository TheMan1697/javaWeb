package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.vo.MemberVO;
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
    
    public List<MemberVO> list() {
        List<MemberVO> list = new ArrayList<>();
        
        try {
            conn = DBConn.getConnection();
            String query = "SELECT * FROM T_MEMBER";
//            query = "INSERT INTO(ID, PWD, NAME, EMAIL) VALUES ('" + memberVo.getId() + "')";
//            stmt = conn.createStatement();
//            System.out.println(stmt);
//            ResultSet rs = stmt.executeQuery(query); 
            //NullPointerException 뜨는 이유 stmt가 Null이기 때문에
            
            pstmt = conn.prepareStatement(query); // 전처리 시킴
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                int idx = 1;
                MemberVO vo = new MemberVO(
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
    
    public void register(MemberVO memberVo) {
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
            
//            int idx = 1;
//            pstmt.setString(idx++, id);
            
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MemberDao().list().forEach(System.out::println);
    }
    
    public MemberVO login(String id, String pwd) {
        MemberVO memberVo = null;
        try {
            conn = DBConn.getConnection();
            String query = "SELECT * FROM T_MEMBER WHERE ID = ? AND PWD = ?";
            
            pstmt = conn.prepareStatement(query); // 전처리 시킴
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);            
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                int idx = 1;
                memberVo = new MemberVO(
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
    
}