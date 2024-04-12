<%@ page contentType="text/html; charset = UTF-8"%>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>

<body class="container">
	<button type="button" class="btn btn-success">Pay My Buddy</button>

	<form name='login' action="perform_login" method='POST'>
		<div class="mb-3">
		
		<label for="username" class="form-label">Username</label>
		<div class="col-3">
			<div class="input-group mb-3">
				<span class="input-group-text" id="basic-addon1">
					 <i class="bi bi-envelope">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
							<path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1zm13 2.383-4.708 2.825L15 11.105zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741M1 11.105l4.708-2.897L1 5.383z"/>
						</svg>
					</i>
				</span>
				<input type="text" name="username" id="username" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
			</div>
		</div>
		</div>
<!-- 		<div class="mb-3"> -->
<!-- 			<label for="exampleInputEmail1" class="form-label">Email address</label> -->
<!-- 			<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"> -->
<!-- 		</div> -->
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label> 
			<div class="col-3">
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">
						<i class="bi bi-asterisk">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-asterisk" viewBox="0 0 16 16">
  								<path d="M8 0a1 1 0 0 1 1 1v5.268l4.562-2.634a1 1 0 1 1 1 1.732L10 8l4.562 2.634a1 1 0 1 1-1 1.732L9 9.732V15a1 1 0 1 1-2 0V9.732l-4.562 2.634a1 1 0 1 1-1-1.732L6 8 1.438 5.366a1 1 0 0 1 1-1.732L7 6.268V1a1 1 0 0 1 1-1"/>
							</svg>
						</i>
					</span>
					<input type="password" class="form-control" id="exampleInputPassword1">
				</div>
			</div>
		</div>
		
		<div class="mb-3 form-check">
			<input type="checkbox" class="form-check-input" id="exampleCheck1">
			<label class="form-check-label" for="exampleCheck1">Remember me</label>
		</div>
		<input type="submit" class="btn btn-primary" value="Login"/>


		<!-- 		<table> -->
		<!-- 			<tr> -->
		<!-- 				<td>User:</td> -->
		<!-- 				<td><input type='text' name='username' value=''></td> -->
		<!-- 			</tr> -->
		<!-- 			<tr> -->
		<!-- 				<td>Password:</td> -->
		<!-- 				<td><input type='password' name='password' /></td> -->
		<!-- 			</tr> -->
		<!-- 			<tr> -->
		<!-- 				<td><input name="submit" type="submit" value="submit" /></td> -->
		<!-- 			</tr> -->
		<!-- 			<tr> -->
		<!-- 				<td><a href="registration">Registration</a></td> -->
		<!-- 			</tr> -->
		<!-- 		</table> -->

	</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"
	></script>

</body>
</html>