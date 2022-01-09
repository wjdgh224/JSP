package sec02_exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public JoinServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()ȣ��");
		//�ѱ� ������ �����ϱ� ���ؼ� ����.
		request.setCharacterEncoding("UTF-8");
		
		//html�� form�±׿��� Ŭ���̾�Ʈ�� �Է��ϰ� ������ ���� ���� request ��ü�� �޼���� �� ���.
		//request, response��ü ��Ĺ ������ �ڵ����� ����.
		//request��ü�κ��� ���� ��� ������ �ÿ��� response��ü�� �̿�.
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//üũ�ڽ��� ��� ���߰��̹Ƿ� String[]Ÿ������ ����.
		String[] hobby = request.getParameterValues("hobby");
		String major = request.getParameter("major");
		String protocol = request.getParameter("protocol");
		
		//���� ������ �޾Ƽ� Ŭ���̾�Ʈ���� ���.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter(); //��½�Ʈ�� ���
		
		writer.println("<html><head></head><body>");
		writer.println("�̸� :" + name + "<br>");
		writer.println("���̵�" + id + "<br>");
		writer.println("��й�ȣ :" + pw + "<br>");
		writer.println("��� :" + Arrays.toString(hobby) + "<br>");
		writer.println("���� :" + major + "<br>");
		writer.println("�������� :" + protocol + "<br>");
		writer.println("</body></html>");
		writer.close();
	}

}
