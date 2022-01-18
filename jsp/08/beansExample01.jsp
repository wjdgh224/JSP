<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jsp액션태그 중, useBean태그를 이용하여 아래와 같이 설정하였다.
여기서 id는 자바에서의 참조변수와 같은 역할.
class속성은 student의 원본 클래스의 패키지명.클래스명을 지정해 준다.
이렇게 해주면 자바에서 new연산자로 객체(인스턴스)를 생성한 것과 동일한 개념. -->
<jsp:useBean id="student" class="sec01_exam.Student" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>빈 예제-1</title>
</head>
<body>
	<h1>빈에 데이터 값들을 저장하였습니다.</h1><br>
	
	<!-- 속성(맴버변수)에 '*'는 빈객체의 속성 값을 기본값으로 지정하는 것이다. -->
	<jsp:setProperty property="*" name="student"/>
	
	<font size="10" color="blue">
	<!-- 여기서 중요한 것은 getProperty가 student클래스의 getter메서드를 호출하는 태그. -->
		이름 : <jsp:getProperty property="name" name="student"/><br>
		나이 : <jsp:getProperty property="age" name="student"/><br>
		학년 : <jsp:getProperty property="grade" name="student"/><br>
		번호 : <jsp:getProperty property="studentNum" name="student"/><br>
	</font>
	
	<!-- jsp액션태그 중 setProperty를 이용해서 name에는 bean의 id값, property는 빈의 속성(맴버변수),
	value는 실제 값을 주어 저장하는 것.
	중요한 것은 setProperty가 student클래스의 setter메서드를 호출하는 태그. -->
	<jsp:setProperty property="name" name="student" value="신은혁"/>
	<jsp:setProperty property="age" name="student" value="13"/>
	<jsp:setProperty property="grade" name="student" value="6"/>
	<jsp:setProperty property="studentNum" name="student" value="15"/>
	
	<h1>빈에서 데이터 가져온 값입니다.</h1><br>
	<font size="10" color="blue">
	<!-- 여기서 중요한 것은 getProperty가 student클래스의 getter메서드를 호출하는 태그. -->
		이름 : <jsp:getProperty property="name" name="student"/><br>
		나이 : <jsp:getProperty property="age" name="student"/><br>
		학년 : <jsp:getProperty property="grade" name="student"/><br>
		번호 : <jsp:getProperty property="studentNum" name="student"/><br>
	</font>
</body>
</html>