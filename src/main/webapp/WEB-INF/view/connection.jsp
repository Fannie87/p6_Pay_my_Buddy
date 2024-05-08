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
		<nav aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="home">Home</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Connection</li>
		  </ol>
		</nav>	
		<h1 class="text-center">Add a connection</h1>
		<form:form method="POST" action="/connection" modelAttribute="connection">
			<div class="mb-3 row">
				<div class="col-2"></div>
				<form:label for="mail" class="col-sm-2 col-form-label" path="mail">Email</form:label>
				<div class="col-sm-4">
					<form:input class="form-control" path="mail" cssErrorClass="form-control is-invalid" placeholder="example@gmail.com"/>
					<form:errors path="mail" id="mail" cssClass="invalid-feedback" />
				</div>
				<div class="col-sm-2">
					<input type="submit" class="btn btn-success" value="Add connection" />
				</div>
			</div>
	</div>
	</form:form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"
	></script>

</body>
</html>