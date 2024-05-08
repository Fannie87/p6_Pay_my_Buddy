<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<jsp:include page="layout/head.jsp" /> 
<body>
	<jsp:include page="layout/nav.jsp" />  

	<div class="container">
		<nav aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="home">Home</a></li>
		    <li class="breadcrumb-item"><a href="account">Account</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Account Success</li>
		  </ol>
		</nav>
        <h3 class="text-center">Congratulations, your bank account has been created with success.</h3>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>

</body>
</html>