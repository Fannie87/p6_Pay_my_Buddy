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
	<jsp:include page="layout/nav.jsp" />  

	<div class="container">
        <h1 class="text-center">Transfer your money to Pay my Buddy.</h1>
       	<form:form method="POST" action="/nameAccount" modelAttribute="pay">
       	<div class="mb-3 row">
           	<div class="col-sm-8"><legend>Send money</legend></div>
  	            <div class="col-sm-2"><a href="connection" class="btn btn-primary">Add Connection</a></div>
       		</div>
			<div class="mb-3 row">
				<div class="col-sm-4">
				<form:select path="connection" class="form-select" aria-label="Default select example">
					<option selected>Select a connection</option>
					<option value="1">One</option>
					<option value="2">Two</option>
					<option value="3">Three</option>
					<form:errors path = "connection" id="connection" cssClass = "invalid-feedback" />
				</form:select>
				</div>
				<div class="col-sm-4">
               		<form:input class="form-control" path="amount" cssErrorClass="form-control is-invalid" type="number" placeholder="0"/>
               		<form:errors path = "amount" id="amount" cssClass = "invalid-feedback"/>
              	</div>
				<div class="col-sm-2">
					<input type="submit" class="btn btn-success" value="Pay"/>
	         	</div>
			</div>
		</form:form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>

</body>
</html>