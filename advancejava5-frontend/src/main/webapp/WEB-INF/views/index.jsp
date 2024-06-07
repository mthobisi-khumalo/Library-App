<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<style>
.auth-card{
  background: #fff;  /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #ccc, #333);  /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #ccc, #333); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  border-radius: 5px;
  box-shadow: 0px 0px 30px #f7f7f7;
}
</style>

<body>
	<div style="position: relative; top: 70px">
		<!-- Start: Hero Clean Reverse -->
		<div class="row">
			<div class="col-md-4 offset-md-4 col-sm-6 offset-sm-3">
				<div class="card auth">
					<div class="card-body auth-card">

						<form action="login" method="post">
							<div class="form-group">
								<label for="email">Email : </label> <input type="email"
									name="email" class="form-control"
									placeholder="johndoe@mail.com">
							</div>

							<div class="form-group">
								<label for="password">Password : </label> <input type="password"
									name="password" class="form-control" placeholder="********">
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-dark pr-5 pl-5">Login</button>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
		<h6 class="text-center" style="color: red;">${wrongUname}</h6>
	</div>

</body>
</html>