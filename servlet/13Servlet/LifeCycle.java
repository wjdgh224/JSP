package servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/13Servlet/LifeCycle.do")
public class LifeCycle extends HttpServlet {
	
	@PostConstruct
	public void myPostConstruct() {
		System.out.println("myPostConstruct() ȣ��");
	}
	
	public void init() throws ServletException {
		System.out.println("init() ȣ��");
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() ȣ��");
		super.service(req, resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() ȣ��");
		req.getRequestDispatcher("/13Servlet/LifeCycle.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() ȣ��");
		req.getRequestDispatcher("/13Servlet/LifeCycle.jsp").forward(req, resp);
	}
	
	public void destroy() {
		System.out.println("destroy() ȣ��");
	}
	
	@PreDestroy
	public void myPreDestroy() {
		System.out.println("myPreDestroy() ȣ��");
	}
}
