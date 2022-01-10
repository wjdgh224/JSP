package sec04_exam;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

@WebListener
public class ServletListener implements ServletContextListener {

	//아래 2개의 콜백 메서드는 다른 웹어플리케이션(타 프로젝트)이 실행될 때와 종료될 때에
	//같이 실행 되기 때문에 아래와 같은 코드를 보여주기 싫다면 주석처리.
	
	//톰캣서버가 중지될 때 자동 호출
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed()호출");

	}

	//톰캣서버가 시작될 때 자동 호출
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextInitialized()호출");

	}
}

/*서블릿의 실행 순서
1. contextInitialized()
2. 생성자
3. initPostConstructor() 선처리
4. init()
5. doGet(), doPost()
6. contextDestroyed()
7. destroy()
8. destroyPredestroy()*/
