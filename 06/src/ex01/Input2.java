package ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input2")
public class Input2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/input.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		System.out.println("아이디:"+user_id);
		System.out.println("비밀번호:"+user_pw);
		String[] subject= req.getParameterValues("subject");
		if(subject != null)
		for(String str: subject) {
			System.out.println("선택한 과목:"+str);
		}
		System.out.println(user_id);
		System.out.println(user_pw);
		req.getRequestDispatcher("/WEB-INF/jsp/member/input_test.jsp").forward(req, resp);
	}
	



	

}

