<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board/list.jsp</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
			<th>좋아요</th>
			<th>작성일</th>
		</tr>	
		<c:forEach items="${boardList }" var="board">
			<tr>
				<td>${board.boardId }</td>
				<td><img src="/setting/board/post/${board.boardId }" width="200px" height="200px" /></td>
				<td><a href="/setting/board/detail/${board.boardId }">${board.subject }</a></td>
				<td>${board.writer }</td>
				<td>${board.content }</td>
				<td>${board.likeCount }</td>
				<td>${board.writeDate }</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<form id="searchForm">
					${pager }<br/>
					
					<input type="text" name="keyword" placeholder="검색어 입력하세요"/>
					<input type="text" name="writer" placeholder="작성자 입력하세요"/>
					<input type="text" name="content" placeholder="내용 입력하세요"/>
					<input type="button" value="검색" onclick="movePage(0)" />
					
				</form>
			</td>
		</tr>
	</table>
	<a href="/setting/board/write">글 쓰기</a>
</body>
</html>