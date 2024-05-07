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
        <h1 class="text-center">Add your bank account</h1>
        <form:form method="POST" action="/addAccount" modelAttribute="account">
	
          	<div class="mb-3 row">
          		<div class="col-2"></div>
            	<form:label for="iban" class="col-sm-2 col-form-label" path="iban">IBAN</form:label>
               	<div class="col-sm-4">
                   	<form:input class="form-control" path="iban" cssErrorClass="form-control is-invalid"/>
					<form:errors path = "iban" id="iban" cssClass = "invalid-feedback" />
                </div>
           	</div>
           	
     		<div class="mb-3 row">
				<div class="col-2"></div>
            	<form:label for="bic" class="col-sm-2 col-form-label" path="bic">BIC</form:label>
				<div class="col-sm-4">
               		<form:input class="form-control" path="bic" cssErrorClass="form-control is-invalid"/>
               		<form:errors path = "bic" id="bic" cssClass = "invalid-feedback" />
              	</div>
			</div>
			
			<div class="mb-3 row">
				<div class="col-2"></div>
            	<form:label for="nameAccount" class="col-sm-2 col-form-label" path="nameAccount">Name account</form:label>
				<div class="col-sm-4">
               		<form:input class="form-control" path="nameAccount" cssErrorClass="form-control is-invalid"/>
               		<form:errors path = "nameAccount" id="nameAccount" cssClass = "invalid-feedback" />
              	</div>
			</div>
			
			<div class="input mt-3 text-center">
				<input type="submit" class="btn btn-primary" value="Submit"/>
         	</div>
		</form:form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>

</body>
</html>