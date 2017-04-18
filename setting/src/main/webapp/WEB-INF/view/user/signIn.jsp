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
		
		$("#signInBtn").click(function(){
			$("#signInForm").attr({
				"method" : "post",
				"action" : "<c:url value="/user/signIn" />"
			});
			$("#signInForm").submit();
		});
		
	});

</script>
</head>
<body>

	<form:form id="signInForm" >
		<input type="text" name="userId" placeholder="ID 입력하렴"/>
			<form:errors path="userId"></form:errors><br/>
		<input type="password" name="userPassword" placeholder="비밀번호 입력해라" /><br/>
			<form:errors path="userPassword"></form:errors><br/>
		<input type="button" id="signInBtn" value="sign in" />
	</form:form>

</body>
</html>