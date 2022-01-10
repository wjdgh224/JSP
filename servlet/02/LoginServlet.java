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
		System.out.println("doGet()호출됨");
		
		//클라이언트가 요청한 파라메터 값의 인코딩을 설정해주는 코드.
		request.setCharacterEncoding("utf-8");
		//클라이언트에게서 넘어오는 id, pass를 받고 인코딩 설정 후 출력스트림을 얻고 화면에 뿌림. name 속성
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("아이디 : " + id + "<br>");
		writer.println("비밀번호 : " + passwd + "<br>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()호출됨");
		
		//클라이언트가 요청한 파라메터 값의 인코딩을 설정해주는 코드.
		request.setCharacterEncoding("utf-8");
		//클라이언트에게서 넘어오는 id, pass를 받고 인코딩 설정 후 출력스트림을 얻고 화면에 뿌림. name 속성
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("아이디 : " + id + "<br>");
		writer.println("비밀번호 : " + passwd + "<br>");
	}

}
