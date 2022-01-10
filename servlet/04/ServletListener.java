package sec04_exam;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

@WebListener
public class ServletListener implements ServletContextListener {

	//�Ʒ� 2���� �ݹ� �޼���� �ٸ� �����ø����̼�(Ÿ ������Ʈ)�� ����� ���� ����� ����
	//���� ���� �Ǳ� ������ �Ʒ��� ���� �ڵ带 �����ֱ� �ȴٸ� �ּ�ó��.
	
	//��Ĺ������ ������ �� �ڵ� ȣ��
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed()ȣ��");

	}

	//��Ĺ������ ���۵� �� �ڵ� ȣ��
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextInitialized()ȣ��");

	}
}

/*������ ���� ����
1. contextInitialized()
2. ������
3. initPostConstructor() ��ó��
4. init()
5. doGet(), doPost()
6. contextDestroyed()
7. destroy()
8. destroyPredestroy()*/
