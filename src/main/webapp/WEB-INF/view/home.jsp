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
	<h1>Homepage, Welcome.</h1>
	</div>
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
			<tr>
				<th scope="row">1</th>
				<td>Hayley</td>
				<td>Restaurant bill share</td>
				<td>10€</td>
			</tr>
			<tr>
				<th scope="row">2</th>
				<td>Clara</td>
				<td>Trip money</td>
				<td>25€</td>
			</tr>
			<tr>
				<th scope="row">3</th>
				<td>Larry the Bird</td>
				<td>Movie tickets</td>
				<td>8€</td>
			</tr>
		</tbody>
	</table>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>

</body>
</html>