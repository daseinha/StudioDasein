<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Member List Page</title>
</head>
<body>

<table border="1">
	<caption>Member List Page</caption>
	
	<tr>
		<th>INDEX</th>
		<th>ID</th>
		<th>PW</th>
		<th>NAME</th>
	</tr>
	
	<c:forEach var="member" items="${memberList}" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>
			<a href="${pageContext.request.contextPath}/memberInfo/${member.id}">${member.id}</a>
			</td>	
			<td>${member.pw}</td>
			<td>${member.name}</td>
		</tr>
	</c:forEach>

</table>

</body>
</html>











