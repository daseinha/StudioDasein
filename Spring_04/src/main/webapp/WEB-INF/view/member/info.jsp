<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Member Info Page</title>
</head>
<body>

<table border="1">
	<caption>Member Info Page</caption>
	
	<tr>		
		<th>ID</th>
		<th>PW</th>
		<th>NAME</th>
	</tr>
		
	<tr>			
		<td>${member.id}</td>	
		<td>${member.pw}</td>
		<td>${member.name}</td>
	</tr>
	

</table>

</body>
</html>











