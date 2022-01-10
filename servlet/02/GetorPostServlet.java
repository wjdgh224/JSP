package sec03_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetorPostServlet
 */
@WebServlet("/GetorPost")
public class GetorPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetorPostServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet메서드 호출됨");
		response.setContentType("text/html; charset=utf-8" );
		PrintWriter writer = response.getWriter();
		writer.print("안녕하세요.");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>doGet방식입니다.반갑습니다.</h1>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost메서드 호출됨");
		response.setContentType("text/html; charset=utf-8" );
		PrintWriter writer = response.getWriter();
		writer.print("안녕하세요.");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>doPost방식입니다.반갑습니다.</h1>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	}

}
