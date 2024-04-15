<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body class="container text-center">
	<button type="button" class="btn btn-success">Pay My Buddy</button>
	<div class="row justify-content-center">
		
		<h1 class="m-6">Congratulation, you're registrated!</h1>
					
		<h4 class="m-3">First Name</h4>
		<p>${registration.firstName}</p>
	
		<h4 class="m-3">Last Name</h4>
		<p>${registration.lastName}</p>
	
		<h4 class="m-3">Mail</h4>
		<p>${registration.mail}</p>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>

</body>
</html>