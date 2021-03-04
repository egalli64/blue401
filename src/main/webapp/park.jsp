<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
		
	}
</script>
</head>
<body>
	
	<h1>Your Parking has been Reserved!</h1>
	<div>
		<p>Remember your tariff is: </p> <p id="tariffa" hidden>${tariff}</p> <p>€/hr</p>
		<br>
		<label for="choose">Please, select how long will you stay: </label>

<!-- 		<button onclick="buttonClickless()">-</button>
		<button onclick="buttonClick()">+</button> -->

		<input type="number" id="inc" value="0" name="value"></input> <b>hr</b>
	</div>
	<div>

		<button onclick="totalPrice()">Total to pay:</button>
		<p id="price"> </p> <p>€</p>
	</div>
	<br>
	<form action = "confirm" method="get">
	<input type="submit">
	</form>


</body>
</html>