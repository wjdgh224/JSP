package sec01_exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//javax.servlet��Ű���� ���� �߻���, ������Ʈ ��Ŭ�� build path���� libraries -> add external jars
//->��Ĺ����\lib\ -> ã��(jsp_api.jar, servlet_api.jar�߰�)

/**
 * Servlet implementation class HelloWorld
 */
//URL�����ڵ尡 @WebServlet������̼ǿ� ���.
//@WebServlet������̼Ǻ��� web.xml���� ������ �����ڵ� �켱������ ����.
//���� ������ �Ǹ� HttpServletŬ������ �ڵ����� ���.
@WebServlet("/Hworld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloWorld() {
    }

    //2���� �޼��� doGet(), doPost()�� ���� ������ ó���ϴ� �κ�.
    //�� ������ ȣ���� �� Ŭ���̾�Ʈ���� ��û�� ���� ��, get�̳� post�Ŀ� ���� ȣ���� �޶���.
    //doGet()�޼���� ���� �׳� ����ϴ� ����, doPost()�� �����͸� �����̳� ó���ڵ带 ������ ��.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hellow World");
		System.out.println("doGet()");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hellow World");
		System.out.println("doPost()");
	}
	//���
	//1.jsp���� : HTML���ϳ� jsp�ڵ带 �ִ� ��.
	//2.servlet���� : �ڹ������̰�, �ƿ﷯ �ݵ�� ������ �ؼ� ���.
}
