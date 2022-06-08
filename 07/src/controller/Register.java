package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberVO.MemberVo;
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/member/register")
public class Register extends HttpServlet{
	private MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String nick = req.getParameter("nick");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		MemberVo meberVo = new MemberVo(id, pw, name, nick, email, null);
		memberService.register(meberVo);
	
	}
	
}
