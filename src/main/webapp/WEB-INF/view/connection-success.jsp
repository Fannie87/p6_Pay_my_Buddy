<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"
>

</head>
<body>
	<jsp:include page="layout/nav.jsp" />

	<div class="container">
		<h1 class="text-center">Add a connection - succeess</h1>
	<div class="row justify-content-center">
		
		<h4 class="m-6">Congratulation, you added your friend: ${connection.mail}</h4>
					
	</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"
	></script>

</body>
</html>