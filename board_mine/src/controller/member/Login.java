package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Member;
import service.MemberService;
import utils.Const;

@WebServlet("/member/login")
public class Login extends HttpServlet{
	private MemberService memberService = MemberService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(Const.member("login")).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String link = req.getParameter("link");
		System.out.println(id);
		System.out.println(pw);
		System.out.println(link);
		
		Member member = memberService.login(new Member(id, pw, null));
//		Member member = new Member(id, pw, null);
		if(member== null) { // 로그인 실패
//			resp.sendRedirect(req.getRequestURI());
			req.setAttribute("msg","로그인 실패");
			req.setAttribute("href",req.getRequestURI() + (link == null ? "" : "?link="+link));
			req.getRequestDispatcher(Const.common("msg")).forward(req, resp);
		}
		else {// 로그인 성공
			req.getSession().setAttribute("member", member);
			link = link == null ? req.getContextPath()+"/board/list" :link;
			
			req.setAttribute("msg","환영합니다 "+id+"님");
			req.setAttribute("href",link);
			req.getRequestDispatcher(Const.common("msg")).forward(req, resp);
//			resp.sendRedirect(link);
		}
	}
	
}