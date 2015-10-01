<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>College Books</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	
		<nav class="navbar navbar-fixed-top navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#menu">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">College Books</a>
			</div>
			</div>
			</nav>
	
</head>
<body style="padding-top: 100px"><body>



	<div class="col-md-6  body-section">

		<form class="form-horizontal " action="<c:url value='/registered' />"
			method="POST">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<fieldset>
				<div id="legend">
					<legend class="">Register</legend>
				</div>
				<div class="control-group">
					<label class="control-label" for="username">Username</label>
					<div class="controls">
						<input id="userName" name="userName" required="true"
							placeholder="" class="form-control input-lg" type="text">

					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="emailAddress">E-mail</label>
					<div class="controls">
						<input id="emailAddress" required="true" name="emailAddress"
							placeholder="" class="form-control input-lg" type="email">
						<p class="help-block">Please provide your E-mail</p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="phoneNumber">Phone Number</label>
					<div class="controls">
						<input id="phoneNumber" required="true" name="phoneNumber"
							placeholder="" class="form-control input-lg" type="text">
						<p class="help-block">Please provide your Phone Number(optional)</p>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="password">Password</label>
					<div class="controls">
						<input id="password" required="true" name="password"
							placeholder="" class="form-control input-lg" type="password">
						<p class="help-block">Password should be at least 6 characters</p>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="password_confirm">Password
						(Confirm)</label>
					<div class="controls">
						<input id="password_confirm" required="true"
							name="password_confirm" placeholder=""
							class="form-control input-lg" type="password">
						<p class="help-block">Please confirm password</p>
					</div>
				</div>

				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>

				<div class="control-group">
					<!-- Button -->
					<div class="controls">
						<button class="btn btn-success">Register</button>
					</div>
				</div>
			</fieldset>
		</form>




	</div>

</body>
</html>