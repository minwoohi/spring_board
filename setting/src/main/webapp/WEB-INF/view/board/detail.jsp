<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>/board/detail.jsp</title>
</head>
<body>

	<h1>boardId : ${board.boardId }</h1>
	<h2>subject : ${board.subject }</h2>
	<c:if test="${not empty board.post }">
		<a href="<c:url value="/board/download/${board.boardId }"/>">${board.post }</a>
	</c:if>
	<h2>content : ${board.content }</h2>
	<h2>writer : ${board.writer }</h2>
	<h2>likeCount : ${board.likeCount }</h2>
	<h2>userVO.userId : ${board.userVO.userId }</h2>
	<h2>userVO.userName : ${board.userVO.userName }</h2>
	<h2>userVO.joinDate : ${board.userVO.joinDate }</h2>
	<a href="<c:url value="board/delete/${board.boardId }" />">글 삭제~</a>

</body>
</html>