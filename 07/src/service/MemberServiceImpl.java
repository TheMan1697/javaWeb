package service;

import java.util.List;

import dao.MemberDao;
import memberVO.MemberVo;

public class MemberServiceImpl implements MemberService {
	private static MemberService memberService = new MemberServiceImpl();
	public static MemberService getInstance() {
		return memberService;
	}
	private MemberDao memberDao= MemberDao.getInstance();
	public MemberServiceImpl() {};
	
	public List<MemberVo> list(){
		return memberDao.list();
	}

	@Override
	public void register(MemberVo memberVo) {
		memberDao.register(memberVo);
		
	}
	
}
