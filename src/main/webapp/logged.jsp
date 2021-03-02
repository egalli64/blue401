<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Logged</title>
<meta name="author" content="Team Blue">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="aw.css">
<meta name="keywords" content="WebApp Parking">
</head>
<body>
	<c:choose>
		<c:when test="${warning ne null}">
			<p>${warning}</p>
		</c:when>
		<c:otherwise>
			<h1>Hello ${user.firstName}</h1>

		</c:otherwise>
	</c:choose>
	<p>
		Back <a href="index.html">Home</a>
	</p>
	<div id="footer">
		<a href="home.html">Home</a> | <a href="topup.html">Recharge</a><br>
		Copyright © 2021 | Designed by Team Blue
	</div>
	<!-- end of footer -->
</body>
</html>