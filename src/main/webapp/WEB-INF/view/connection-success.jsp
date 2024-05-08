<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<jsp:include page="layout/head.jsp" /> 
<body>
	<jsp:include page="layout/nav.jsp" />

	<div class="container">
		<nav aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="home">Home</a></li>
		    <li class="breadcrumb-item"><a href="connection">Connection</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Connection Success</li>
		  </ol>
		</nav>	
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