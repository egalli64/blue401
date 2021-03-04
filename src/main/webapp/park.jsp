<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<p id="tariffa">${tariff}</p>
	<h1>Your Parking has been Reserved!</h1>
	<div>
		<label for="choose">Please, select how long will you stay: </label>

		<button onclick="buttonClickless()">-</button>
		<button onclick="buttonClick()">+</button>

		<input type="number" id="inc" value="0" name="value"></input> <b>hr</b>
	</div>
	<div>

		<button onclick="totalPrice()">Total to pay:</button>
		<p id="price"> </p>
	</div>



</body>
</html>