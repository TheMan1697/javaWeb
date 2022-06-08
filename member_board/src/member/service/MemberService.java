package member.service;

import java.util.List;

import member.vo.MemberVo;

public interface MemberService {
    List<MemberVo> list();

    void register(MemberVo memberVo);

    void remove(String id);

    MemberVo login(String id, String pwd);

    List<MemberVo> list(String keyword);

}