<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="layout/head.jsp" /> 
<body>
	<jsp:include page="layout/nav.jsp" />  

	<div class="container">
		<nav aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="home">Home</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Transfer</li>
		  </ol>
		</nav>
        <h1 class="text-center">Transfer your money to your friends.</h1>
       	<form:form method="POST" action="/transfer-success" modelAttribute="pay">
       	<div class="mb-3 row">
           	<div class="col-sm-8"><legend>Send money</legend></div>
  	            <div class="col-sm-2"><a href="connection" class="btn btn-primary">Add Connection</a></div>
       		</div>
			<div class="mb-3 row">
				<div class="col-sm-4">
				<form:select path="idFriend" class="form-select" aria-label="Default select example" cssErrorClass="form-select is-invalid" >
				    <form:option value="NONE"> --Select a friend--</form:option>
					<form:options items="${sessionScope.friendList}"></form:options>
				</form:select>
				<form:errors path = "idFriend" id="idFriend" cssClass = "invalid-feedback" />
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
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Connections</th>
					<th scope="col">Description</th>
					<th scope="col">Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="transaction" items="${sessionScope.transactions}" >
					<tr>
						<th scope="row">${transaction.idTrade}</th>
						<td>${transaction.friend}</td>
						<td>${transaction.description}</td>
						<td>${transaction.amount} &#x20AC;</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>

</body>
</html>