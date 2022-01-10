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
		System.out.println("doPost()호출");
		//한글 깨짐을 방지하기 위해서 설정.
		request.setCharacterEncoding("UTF-8");
		
		//html의 form태그에서 클라이언트가 입력하고 전송한 값을 직접 request 객체의 메서드로 얻어서 출력.
		//request, response객체 톰캣 서버가 자동으로 생성.
		//request객체로부터 값을 얻고 응답할 시에는 response객체를 이용.
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//체크박스의 경우 다중값이므로 String[]타입으로 리턴.
		String[] hobby = request.getParameterValues("hobby");
		String major = request.getParameter("major");
		String protocol = request.getParameter("protocol");
		
		//위의 값들을 받아서 클라이언트에게 출력.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter(); //출력스트림 얻기
		
		writer.println("<html><head></head><body>");
		writer.println("이름 :" + name + "<br>");
		writer.println("아이디" + id + "<br>");
		writer.println("비밀번호 :" + pw + "<br>");
		writer.println("취미 :" + Arrays.toString(hobby) + "<br>");
		writer.println("전공 :" + major + "<br>");
		writer.println("프로토콜 :" + protocol + "<br>");
		writer.println("</body></html>");
		writer.close();
	}

}
