package member.service;

import java.util.List;

import member.vo.MemberVO;

public interface MemberService {
	


		List<MemberVO> list();

		void register(MemberVO memberVo);
		
		void remove(String id);
		
		MemberVO login(String id, String pwd);

}
