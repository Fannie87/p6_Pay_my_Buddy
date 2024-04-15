<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body class="container text-center">
	<button type="button" class="btn btn-success">Pay My Buddy</button>
   	<div class="row justify-content-center">
        <h3>Create your accompt</h3>
        <form:form method="POST" action="/registration-success" modelAttribute="registration">
 
	
          	<div class="mb-3 row">
          		<div class="col-2"></div>
            	<form:label for="firstName" class="col-sm-2 col-form-label" path="firstName">First Name</form:label>
               	<div class="col-sm-4">
                   	<form:input class="form-control" path="firstName" cssErrorClass="form-control is-invalid"/>
					<form:errors path = "firstName" id="firstName" cssClass = "invalid-feedback" />
                </div>
           	</div>

			<div class="mb-3 row">
				<div class="col-2"></div>
            	<form:label for="lastName" class="col-sm-2 col-form-label" path="lastName">Last Name</form:label>
				<div class="col-sm-4">
               		<form:input class="form-control" path="lastName" cssErrorClass="form-control is-invalid"/>
               		<form:errors path = "lastName" id="lastName" cssClass = "invalid-feedback" />
              	</div>
			</div>
				
            <div class="mb-3 row">
            	<div class="col-2"></div>
                <form:label for="mail" class="col-sm-2 col-form-label" path="mail">Mail</form:label>
               	<div class="col-sm-4">
               		<form:input class="form-control" path="mail" cssErrorClass="form-control is-invalid"/>
               		<form:errors path = "mail" id="mail" cssClass = "invalid-feedback" />
               	</div>
             </div>
              
			<div class="mb-3 row">
				<div class="col-2"></div>
                <form:label for="password" class="col-sm-2 col-form-label" path="password">Password</form:label>
               	<div class="col-sm-4">
               		<form:input class="form-control" path="password" cssErrorClass="form-control is-invalid"/>
               		<form:errors path = "password" id="password" cssClass = "invalid-feedback" />
               	</div>
            </div>
                    
			<div class="input mt-3">
				<input type="submit" class="btn btn-primary" value="Submit"/>
         	</div>
         </div>
        </form:form>
         	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"
			></script>
         
    </body>
</html>