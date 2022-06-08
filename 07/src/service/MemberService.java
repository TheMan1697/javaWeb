package service;

import java.util.List;

import dao.MemberDao;
import memberVO.MemberVo;

public interface MemberService {
	List<MemberVo> list();

	void register(MemberVo meberVo);
	
}
