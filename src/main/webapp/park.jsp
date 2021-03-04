<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>

	function buttonClick() {
		var i = document.getElementById('inc').value;
		document.getElementById('inc').value = ++i;
	}

	function buttonClickless() {

		document.getElementById('inc').value = --i;
		
	}
	function totalPrice()  {
		
		let tariff = document.getElementById("tariffa").innerText;
		let hour = document.getElementById("inc").value;
		let product = tariff*hour;
		document.getElementById("price").innerText = product;
		document.getElementById("tot").value = product;
		
	}
</script>
</head>
<body>
	
	<h1>Your Parking has been Reserved!</h1>
	<div>
		<p>Remember your tariff is:  <span id="tariffa" >${tariff}</span> €/hr</p>
		<br>
		<label for="choose">Please, select how long will you stay: </label>

<!-- 		<button onclick="buttonClickless()">-</button>
		<button onclick="buttonClick()">+</button> -->

		<input type="number" id="inc" value="0" name="value"></input> <b>hr</b>
	</div>
	<div>

		<button onclick="totalPrice()">Total to pay:</button>
		<p id="price" name = "prezzo"> </p> <span>€</span>
	</div>
	<br>
	<form action = "confirm" method="get">
	<input id = "tot" type="hidden" name="prezzo">
	<input type="submit" value="confirm">
	</form>
	<c:if test="${message ne null}">
	<p>${message}</p>
	</c:if>
	<c:if test="${message ne null}">
	<p>${message_2}</p>
	</c:if>

</body>
</html>