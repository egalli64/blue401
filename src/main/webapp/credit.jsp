<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Credit update</title>
<meta name="author" content="Team Blue">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="aw.css">
<meta name="keywords" content="WebApp Parking">
</head>
<body>
	<h1>My credit area</h1>
	<form action="credit" method="get">

		<p>Credit:</p>
		<label>Quanto vuoi ricaricare?</label>
		<div>
			<input type="radio" id="5" name="money" value="5"> <label
				for="5">5€</label>
		</div>
		<div>
			<input type="radio" id="10" name="money" value="10"> <label
				for="10">10€</label>
		</div>
		<div>
			<input type="radio" id="25" name="money" value="25"> <label
				for="25">25€</label>
		</div>
		<div>
			<input type="radio" id="50" name="money" value="50"> <label
				for="50">50€</label>
		</div>

		<input type="password" id="code" name="code"> <label
			for="code">Inserisci coupon</label>

		<div>
			<button type="submit">Invio</button>
			<button type="reset">Reset</button>
		</div>

	</form>

</body>