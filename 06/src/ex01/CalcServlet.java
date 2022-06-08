package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet{
	private static final float USD_RATE =0.00081f;
	private static final float JPY_RATE =0.095f;
	private static final float CNY_RATE=0.0051f;
	private static final float GBP_RATE=0.00062f;
	private static final float EUR_RATE=0.00074f;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw=resp.getWriter();
		
		String command = req.getParameter("command");
		String won = req.getParameter("won");
		String operator = req.getParameter("operator");
		
		if(command !=null && command.equals("calculate")) {
			String result=calculate(Float.parseFloat(won), operator);
			pw.print("<html><font size=10>변환 결과</font><br>");
			pw.print("<font size=10>"+result+"</font><br>");
			pw.print("<a href='calc?command=calculate&operator=dollar&won=10000'>환율 계산기</a>");
		}
		else {
			pw.print("<html><title>환율 계산기</title>");
			pw.print("<font size=5>환율 계산기</font><br>");
			pw.print("<form name ='frmCalc' method='get' action='calc'	/>");
			pw.print("원화 : <input type='text' name='won' size=10/>");
			pw.print("<select name='operator'	>");
			pw.print("<option value='dollar'>달러</option>");
			pw.print("<option value='en'>엔화</option>");
			pw.print("<option value='wian'>위안</option>");
			pw.print("<option value='pound'>파운드</option>");
			pw.print("<option value='euro'>유로</option>");
			pw.print("</select>");
			pw.print("<input type='hidden' name='command' value='calculate'	/>");
			pw.print("<input type='submit' value='변환'/>");
			pw.print("</form>");
			pw.print("</html>");
			pw.close();
		}
	}
	private static String calculate(float won, String operator) {
		String result = null;
		
		if(operator.equals("dollar")) {
			result=String.format("%.6f", won*USD_RATE);
		} else if(operator.equals("en")) {
			result=String.format("%.6f", won*JPY_RATE);
		} else if(operator.equals("wian")) {
			result=String.format("%.6f", won*CNY_RATE);
		} else if(operator.equals("pound")) {
			result=String.format("%.6f", won*GBP_RATE);
		} else if(operator.equals("euro")) {
			result=String.format("%.6f", won*EUR_RATE);
		}
		return result;
	}
}