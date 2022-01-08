package sec02_exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NowTime
 */
@WebServlet("/NowTime")
public class NowTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
    public NowTime() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ڼ� ����
		response.setContentType("text/html; charset=utf-8");
		
		//������ JSPǥ�� ������ ������ ǥ��. ���� �ڹ������ø����̼� ���� ����.
		//web.xml���ΰ� ������̼� ���ι���� �ִµ�
		//������̼� ������ �ϰ� �Ǹ� ���α׷� ������ �ϼ��� �� ����� �ߴµ� ������ �ڹټҽ�������
		//������ �ؾߵǰ� �ƿ﷯ ���������� ��� �ϰ� �� ���̴�. �������� �������� �ʴ�.
		//web.xml�� �̿��ؼ� �����ϴ� ����� ������, ��쿡 ���� �ٸ��� �����Ǿ�� �Ѵ�.
		
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>���� �ð�</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("���� �ð���");
		out.println(new Date());
		out.println("�Դϴ�.");
		out.println("���� �ð���");
		out.println("</BODY>");
		out.println("</HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
