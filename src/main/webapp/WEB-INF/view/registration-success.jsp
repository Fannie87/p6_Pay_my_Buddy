<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<button type="button" class="btn btn-success">Pay My Buddy</button>
		<h1>Congratulation, you're registrated!</h1>
		<table class="table">
			<tr>
				<td>First Name</td>
				<td>${registration.firstName}</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>${registration.lastName}</td>
			</tr>
			<tr>
				<td>Mail</td>
				<td>${registration.mail}</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>${registration.password}</td>
			</tr>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>

</body>
</html>