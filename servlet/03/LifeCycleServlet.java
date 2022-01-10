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
    	System.out.println("생성자 호출");
    }
	
	//init()는 ctrl+space, 최초 한번 호출
	@Override
	public void init() throws ServletException {
			System.out.println("init()호출");
		}
    
    //실행되었을 때, 서블릿 객체가 메모리에 로딩 되고, 계속 재사용.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()호출");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()호출");
	}
	
	//doGet(), doPost()가 없다면 service()가 호출
	//세가지 메서스 다 존재하여도 service()호출
	//service()는 get, post방식으로 어떤 메서드 방식으로 호출 되었는지 알 수 없다.
	/*
	 * @Override protected void service(HttpServletRequest arg0, HttpServletResponse
	 * arg1) throws ServletException, IOException {
	 * System.out.println("service()호출"); }
	 */
	
	//서버를 중지시키면 호출
	@Override
	public void destroy() {
		System.out.println("destroy()호출");
	}
	
	//오버라이딩이 아니라 직접 메서드를 만들어 준다.
	//선처리 부분에 해당.
	//init()메서드 호출되기 전 먼저 실행.
	//어노테이션이 컴파일러한테 따로 지시.
	@PostConstruct
	private void initPostConstructor() {
		System.out.println("initPostConstructor() 후처리");
	}
	
	//오버라이딩이 아니라 직접 메서드를 만들어 준다.
	//후처리 부분에 해당.
	//destroy()메서드 호출된 후 먼저 실행.
	//어노테이션이 컴파일러한테 따로 지시.
	@PreDestroy
	private void destroyPredestroy() {
		System.out.println("destroyPredestroy() 후처리");
	}
	
}
