package sec02_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�ι�° ���
//�Ʒ��� ���� ������̼��� �����ϱ� ���ؼ��� web.xml�� ����Ǿ� �ִ� �κ��� �ϴ� �ּ�ó�� �Ѵ�.
//�ּ� ó���� �ؾ� �Ʒ��ڵ尡 ������ �ȴ�. ������̼��� �̿��ؼ� ���� �ʱ�ȭ �Ķ��Ÿ ���� ����.
@WebServlet(urlPatterns = {"/IP"},
			initParams = {
					@WebInitParam(name = "id", value="admin"),
					@WebInitParam(name = "pw", value="1234abcd!!"),
					@WebInitParam(name = "path", value="C:\\Temp"),
			})


//����� �ʱ�ȭ �Ķ���͸� ����ϴ� ����, ���� ������ ������ ���� ����ϰ�, ��� web.xml���Ͽ� ����ϴ� ���� �ٶ���.
public class initParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public initParam() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGetȣ��");
	
		//��� �������� ���� ������ Ctrl+T�� �̿�.
		//ServletConfig(�������̽�)�� �߻�޼��带 HttpServletŬ�������� �����Ͽ���.
		//���� this�� �ڱ� �ڽ��� �ּ�.
		//getInitParameter()�� HttpServletŬ������ ����Ŭ������ GenericServletŬ������ ����� �޼���.
		String id = this.getInitParameter("id");
		String pw = this.getInitParameter("pw");
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
