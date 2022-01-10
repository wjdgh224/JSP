package sec03_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextInitParam
 */
@WebServlet("/CP")
public class ContextInitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;     
  
    public ContextInitParam() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()ȣ��");
		//getServletContext()�� �̿��ؼ� web.xml������ context-param������ �����ٰ� �� �� �ִ�.
		String id = this.getServletContext().getInitParameter("id");
		String pw = this.getServletContext().getInitParameter("pw");
		String path = this.getServletContext().getInitParameter("path");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("���̵� : " + id + "<br>");
		out.println("��й�ȣ : " + pw + "<br>");
		out.println("��� : " + path + "<br>");
		out.println("</body></html>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
