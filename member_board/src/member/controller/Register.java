package member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVo;

@WebServlet("/member/register")
public class Register extends HttpServlet{
	private MemberService memberService = MemberServiceImpl.getInstance();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 화면(회원 등록)
		req.getRequestDispatcher("/WEB-INF/jsp/member/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로직(회원 등록)
		
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		MemberVo memberVo = new MemberVo(id, pwd, name, email, null);
		memberService.register(memberVo);
		
		System.out.println("아이디:"+id);
		System.out.println("비밀번호:"+pwd);
		System.out.println("이름:"+name);
		System.out.println("이메일:"+email);
		
		
//		req.getRequestDispatcher("/WEB-INF/jsp/member/register_test.jsp").forward(req, resp);
		
		
		
		resp.sendRedirect("list");
	}
	
}
