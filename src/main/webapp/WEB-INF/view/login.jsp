<%@ page contentType="text/html; charset = UTF-8"%>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body class="container text-center">
	<button type="button" class="btn btn-success">Pay My Buddy</button>
   	<div class="row justify-content-center">

	<form name='login' action="perform_login" method='POST'>
		<div class="mb-3">
			<label for="username" class="form-label">Email</label>
			<div class="row">
			<div class="col-4"></div>
			<div class="col-4">
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">
						 <i class="bi bi-envelope">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
								<path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1zm13 2.383-4.708 2.825L15 11.105zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741M1 11.105l4.708-2.897L1 5.383z"/>
							</svg>
						</i>
					</span>
					<input type="text" name="username" class="form-control" placeholder="Email">
				</div>
			</div>
			</div>
		</div>
		<div class="mb-3">
		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">
				<label for="Password" class="form-label">Password</label>
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">
						<i class="bi bi-asterisk">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-asterisk" viewBox="0 0 16 16">
  								<path d="M8 0a1 1 0 0 1 1 1v5.268l4.562-2.634a1 1 0 1 1 1 1.732L10 8l4.562 2.634a1 1 0 1 1-1 1.732L9 9.732V15a1 1 0 1 1-2 0V9.732l-4.562 2.634a1 1 0 1 1-1-1.732L6 8 1.438 5.366a1 1 0 0 1 1-1.732L7 6.268V1a1 1 0 0 1 1-1"/>
							</svg>
						</i>
					</span>
					<input type="password" class="form-control" name="password" placeholder="Password">
				</div>
			</div>
			</div>
		</div>
		
		<div class="mb-3 form-check">
		<div class="row">
			<div class="col-5"></div>
			<div class="col-4">
				<div class="input-group">
				<input type="checkbox" class="form-check-input" id="remember-me" name="remember-me">
				<label class="form-check-label ms-2" for="remember-me">Remember me</label>
			</div>
		</div>
		</div>
		</div>
			<input type="submit" class="btn btn-primary" value="Login"/>
		<div class="input mt-3">
			<a type="button" class="btn btn-secondary" href="registration">Registration</a>
		</div>

	</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"
	></script>

</body>
</html>