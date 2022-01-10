package sec01_exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//javax.servlet패키지에 예외 발생시, 프로젝트 우클릭 build path에서 libraries -> add external jars
//->톰캣폴더\lib\ -> 찾기(jsp_api.jar, servlet_api.jar추가)

/**
 * Servlet implementation class HelloWorld
 */
//URL매핑코드가 @WebServlet어노테이션에 명시.
//@WebServlet어노테이션보다 web.xml에서 지정한 매핑코드 우선순위가 높다.
//서블릿 파일이 되면 HttpServlet클래스를 자동으로 상속.
@WebServlet("/Hworld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloWorld() {
    }

    //2가지 메서드 doGet(), doPost()은 서블릿 파일이 처리하는 부분.
    //이 서블릿을 호출할 때 클라이언트에서 요청이 들어올 때, get이냐 post냐에 따라 호출이 달라짐.
    //doGet()메서드는 폼을 그냥 출력하는 형태, doPost()는 데이터를 가공이나 처리코드를 실행할 때.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hellow World");
		System.out.println("doGet()");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hellow World");
		System.out.println("doPost()");
	}
	//결론
	//1.jsp파일 : HTML파일내 jsp코드를 넣는 것.
	//2.servlet파일 : 자바파일이고, 아울러 반드시 매핑을 해서 사용.
}
