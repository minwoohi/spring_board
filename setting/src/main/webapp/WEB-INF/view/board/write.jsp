<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>/board/write.jsp</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
		
		$("#writeBtn").click(function(){
			$("#writeForm").attr({
				"method" : "post",
				"action" : "<c:url value="/board/write" />"
			});
			$("#writeForm").submit();
		});
		
	});
</script>
</head>
<body>
	
	<form:form commandName="writeForm" enctype="multipart/form-data"> <!-- 스프링 태그의 form으로 변경 id 대신 commandName 사용 -->
		<input type="text" name="subject" placeholder="input subject"/>
			<form:errors path="subject" /><br/>
		<input type="text" name="writer" placeholder="input writer" />
			<form:errors path="content" /><br/>
		<input type="text" name="content" placeholder="input content" /><br/>
		<input type="file" name="file">
		<input type="button" id="writeBtn" value="등록" /><br/>
	</form:form>
	
</body>
</html>