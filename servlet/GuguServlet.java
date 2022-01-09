package sec04_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuguServlet
 */
@WebServlet("/gugudan")
public class GuguServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GuguServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		int number = Integer.parseInt(request.getParameter("number"));
		
		if(number < 2 || number > 9) {
			writer.print("<html><head></head><body>");
			writer.print("<h1>�������� 2~9�� �����Դϴ�.</h1>");
			writer.print("</body></html>");
			return;
		}
		
		writer.print("<table border=1 width=800 align=center>");
		writer.print("<tr align=center bgcolor='#FFFF66'>");
		writer.print("<td colspan=4>" + number + "�� ���</td></tr>");
		
		for(int i=1; i<=9; i++) {
			if(i%2==0) {
				writer.print("<tr align=center bgcolor='#ACFA58'>");
			}
			else {
				writer.print("<tr align=center bgcolor='#81BEF7'>");
			}
			writer.print("<td width=200>" + number + "<td>");
			writer.print("<td width=200>" + i + "<td>");
			writer.print("<td width=200>" + number +  "*" + i + "<td>");
			writer.print("<td width=200>" + number*i + "<td>");
			writer.print("</tr>");
		}
		writer.print("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
