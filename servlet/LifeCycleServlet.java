package sec01_exam;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jws.soap.InitParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/LC")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LifeCycleServlet() {
    	System.out.println("������ ȣ��");
    }
	
	//init()�� ctrl+space, ���� �ѹ� ȣ��
	@Override
	public void init() throws ServletException {
			System.out.println("init()ȣ��");
		}
    
    //����Ǿ��� ��, ���� ��ü�� �޸𸮿� �ε� �ǰ�, ��� ����.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()ȣ��");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()ȣ��");
	}
	
	//doGet(), doPost()�� ���ٸ� service()�� ȣ��
	//������ �޼��� �� �����Ͽ��� service()ȣ��
	//service()�� get, post������� � �޼��� ������� ȣ�� �Ǿ����� �� �� ����.
	/*
	 * @Override protected void service(HttpServletRequest arg0, HttpServletResponse
	 * arg1) throws ServletException, IOException {
	 * System.out.println("service()ȣ��"); }
	 */
	
	//������ ������Ű�� ȣ��
	@Override
	public void destroy() {
		System.out.println("destroy()ȣ��");
	}
	
	//�������̵��� �ƴ϶� ���� �޼��带 ����� �ش�.
	//��ó�� �κп� �ش�.
	//init()�޼��� ȣ��Ǳ� �� ���� ����.
	//������̼��� �����Ϸ����� ���� ����.
	@PostConstruct
	private void initPostConstructor() {
		System.out.println("initPostConstructor() ��ó��");
	}
	
	//�������̵��� �ƴ϶� ���� �޼��带 ����� �ش�.
	//��ó�� �κп� �ش�.
	//destroy()�޼��� ȣ��� �� ���� ����.
	//������̼��� �����Ϸ����� ���� ����.
	@PreDestroy
	private void destroyPredestroy() {
		System.out.println("destroyPredestroy() ��ó��");
	}
	
}
