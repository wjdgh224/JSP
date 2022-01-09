package sec03_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/Calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static float USD_RATE = 1210.75F;
	private static float JPY_RATE = 10.113F;
	private static float CNY_RATE = 160.31F;
	private static float GBP_RATE = 1475.75F;
	private static float EUR_RATE = 1295.75F;
 
    public CalcServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		
		if(command!=null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won), operator);
			writer.print("<html><font size=10>��ȯ ���</font><br>");
			writer.print("<font size=10>" + result + "</font><br>");
			writer.print("<a href='Calc'>ȯ�� ����</a>");
			return;
		}
		
		writer.print("<html><title>ȯ�� ����</title>");
		writer.print("<font size=5>ȯ�� ����</font><br>");
		writer.print("<form name='frmCalc' method='get' action='Calc'>");
		writer.print("��ȭ : <input type='text' name='won' size=10>");
		writer.print("<select name='operator'>");
		writer.print("<option value='dollar'>�޷�</option>");
		writer.print("<option value='en'>��ȭ</option>");
		writer.print("<option value='wian'>����</option>");
		writer.print("<option value='pound'>�Ŀ��</option>");
		writer.print("<option value='euro'>����</option>");
		writer.print("</select>");
		
		writer.print("<input type='hidden' name='command' value='calculate'>");
		writer.print("<input type='submit' value='��ȯ'>");
		writer.print("</form></html>");
		writer.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	private static String calculate(float won, String operator) {
		String result = null;
	
		if(operator.equals("dollar")) {
			result = String.format("%.6f", won/USD_RATE);
		}
		else if(operator.equals("en")) {
			result = String.format("%.6f", won/JPY_RATE);
		}
		else if(operator.equals("wian")) {
			result = String.format("%.6f", won/CNY_RATE);
		}
		else if(operator.equals("pound")) {
			result = String.format("%.6f", won/GBP_RATE);
		}
		else if(operator.equals("euro")) {
			result = String.format("%.6f", won/EUR_RATE);
		}
	
		return result;
	}
}
