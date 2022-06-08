package service;

import dao.MemberDao;
import domain.Member;

public class MemberService {
	private static MemberService memberService = new MemberService();
	public static MemberService getInstance() {
		return memberService;
	}
	private MemberService() {}
	
	private MemberDao memberDao = MemberDao.getInstance();
	
	public void register(Member member) {
		memberDao.register(member);
	}
	public Member login(Member member) {
		return memberDao.login(member.getId(), member.getPw());
	}
	public Member get(String id) {
		return memberDao.get(id);
	}
	public Member findBy(String email) {
		return memberDao.findBy(email);
	}
	public void updateAuthToken(Member member) {
		memberDao.updateAuthToken(member);
	}
	public void updateAuth(Member member) {
		memberDao.updateAuth(member);
	}
	public void remove(Member member) {
//		boardDao.modifyByWriter(member.getId());
//		replyDao.modifyByWriter(member.getId());
		memberDao.remove(member.getId());
	}
	public void modify(Member member) {
		memberDao.modify(member);
		
	}
}

