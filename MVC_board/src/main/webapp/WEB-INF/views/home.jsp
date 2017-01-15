<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h2>게시판 목록</h2>

<table style="border: 1px solic #ccc;">
	<thead>
		<tr>
			<td style="width: 20%">글번호</td>
			<td style="width: 40%"></td>
			<td style="width: 40%"></td>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${fn:length(list)>0 }">
				<c:forEach items="${list }" var="list">
					<tr>
						<td>${list.deptno }</td><td>${list.dname }</td><td>${list.loc }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4">조회된 결과가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr>
		
		</tr>
	</tbody>
	
</table>

<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
