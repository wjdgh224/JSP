package sec02_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//두번째 방법
//아래와 같이 어노테이션을 적용하기 위해서는 web.xml에 기술되어 있는 부분을 일단 주석처리 한다.
//주석 처리를 해야 아래코드가 적용이 된다. 어노테이션을 이용해서 직접 초기화 파라메타 값을 지정.
@WebServlet(urlPatterns = {"/IP"},
			initParams = {
					@WebInitParam(name = "id", value="admin"),
					@WebInitParam(name = "pw", value="1234abcd!!"),
					@WebInitParam(name = "path", value="C:\\Temp"),
			})


//결론은 초기화 파라메터를 사용하는 곳은, 보통 관리자 계정을 많이 사용하고, 통상 web.xml파일에 기술하는 것이 바람직.
public class initParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public initParam() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet호출");
	
		//상속 계층도를 쉽게 보려면 Ctrl+T를 이용.
		//ServletConfig(인터페이스)의 추상메서드를 HttpServlet클래스에서 구현하였다.
		//현재 this는 자기 자신의 주소.
		//getInitParameter()는 HttpServlet클래스에 조상클래스인 GenericServlet클래스에 선언된 메서드.
		String id = this.getInitParameter("id");
		String pw = this.getInitParameter("pw");
		String path = this.getServletContext().getInitParameter("path");
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("아이디 : " + id + "<br>");
		out.println("비밀번호 : " + pw + "<br>");
		out.println("경로 : " + path + "<br>");
		out.println("</body></html>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
