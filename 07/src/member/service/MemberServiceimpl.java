package member.service;

import java.sql.ResultSet;
import java.util.List;

import member.dao.MemberDao;
import member.vo.MemberVO;
import utils.DBConn;

public class MemberServiceimpl implements MemberService{
	private static final MemberService mermberService = new MemberServiceimpl();
	
	public static MemberService getInstance() {
		return mermberService;
	}
	
	private MemberServiceimpl() {
		}
	
	private MemberDao memberDao  = MemberDao.getInstance();


	public void register(MemberVO memberVo) {
		memberDao.register(memberVo);
		
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		memberDao.remove(id);
	}
	@Override
	public List<MemberVO> list() {
		return memberDao.list();
	}

	@Override
	public MemberVO login(String id, String pwd) {
			
		return memberDao.login(id,pwd);
	}
	
	
	
}
