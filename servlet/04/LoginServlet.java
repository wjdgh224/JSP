package sec01_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		//hidden�Ӽ��� �ޱ�
		String address = request.getParameter("user_address");
		System.out.println("���̵� : " + id);
		System.out.println("��й�ȣ : " + pw);
		System.out.println("�ּ� : " + address);
		
		String data = "<html><body>";
		data += "���̵� : " + id + "<br>"; 
		data += "��й�ȣ : " + pw + "<br>";
		data += "�ּ� : " + address + "<br>"; 
		data += "</body></html>";
		out.print(data);
	}

}
