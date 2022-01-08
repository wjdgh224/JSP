package sec04_exam;

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
		System.out.println("doGet()ȣ���");
		
		//Ŭ���̾�Ʈ�� ��û�� �Ķ���� ���� ���ڵ��� �������ִ� �ڵ�.
		request.setCharacterEncoding("utf-8");
		//Ŭ���̾�Ʈ���Լ� �Ѿ���� id, pass�� �ް� ���ڵ� ���� �� ��½�Ʈ���� ��� ȭ�鿡 �Ѹ�. name �Ӽ�
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("���̵� : " + id + "<br>");
		writer.println("��й�ȣ : " + passwd + "<br>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()ȣ���");
		
		//Ŭ���̾�Ʈ�� ��û�� �Ķ���� ���� ���ڵ��� �������ִ� �ڵ�.
		request.setCharacterEncoding("utf-8");
		//Ŭ���̾�Ʈ���Լ� �Ѿ���� id, pass�� �ް� ���ڵ� ���� �� ��½�Ʈ���� ��� ȭ�鿡 �Ѹ�. name �Ӽ�
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("���̵� : " + id + "<br>");
		writer.println("��й�ȣ : " + passwd + "<br>");
	}

}
