<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">

	$().ready(function(){
		
		$("#signUpBtn").click(function(){
			$("#signUpForm").attr({
				"method" : "post",
				"action" : "<c:url value="/user/signUp" />"
			});
			$("#signUpForm").submit();
		});
		
	});
</script>
</head>
<body>
	<form:form commandName="signUpForm" >
		<input type="text" name="userId" placeholder="ID를 입력하세요" />
			<form:errors path="userId"></form:errors><br/>
		<input type="password" name="userPassword" placeholder="비밀번호를 입력하세요" />
			<form:errors path="userPassword"></form:errors><br/>
		<input type="text" name="userName" placeholder="이름을 입력하세요" />
			<form:errors path="userName"></form:errors><br/>
		<input type="button" id="signUpBtn" value="가입하기" />
	</form:form>
</body>
</html>