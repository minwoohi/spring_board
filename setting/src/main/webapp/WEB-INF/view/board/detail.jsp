<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>/board/detail.jsp</title>
</head>
<body>

	<h1>${board.boardId }</h1>
	<h2>${board.subject }</h2>
	<h2>${board.content }</h2>
	<h2>${board.writer }</h2>
	<h2>${board.likeCount }</h2>
	<a href="/setting/board/delete/${board.boardId }">글 삭제~</a>

</body>
</html>