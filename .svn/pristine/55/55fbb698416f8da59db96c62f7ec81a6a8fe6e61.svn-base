<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" language="java"
	import="javax.servlet.jsp.PageContext"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="<c:url value="/resources/theme/css/bookSellingApp.css" />"
	rel="stylesheet">

<title>Login</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>

</head>
<body>
	<div id="login-overlay" class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Login to booksalesapp
					website</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-xs-6">
						<c:if test="${not empty error}">
							<div class="error">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="msg">${msg}</div>
						</c:if>
						<div class="well">
							<form id="loginForm" method="POST"
								action="<c:url value='/j_spring_security_check'/>"
								novalidate="novalidate">

								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />

								<div class="form-group">
									<label for="username" class="control-label">Username</label> <input
										type="text" class="form-control" id="username" name="username"
										value="" required="" title="Please enter you username"
										placeholder="example@gmail.com"> <span
										class="help-block"></span>
								</div>
								<div class="form-group">
									<label for="password" class="control-label">Password</label> <input
										type="password" class="form-control" id="password"
										name="password" value="" required=""
										title="Please enter your password"> <span
										class="help-block"></span>
								</div>
								<div id="loginErrorMsg" class="alert alert-error hide">Wrong
									username or password</div>
								<div class="checkbox">
									<label> <input type="checkbox" name="remember"
										id="remember"> Remember login
									</label>
									<p class="help-block">(if this is a private computer)</p>
								</div>
								<button type="submit" name="submit"
									class="btn btn-success btn-block">Login</button>
								<a href="/forgot/" class="btn btn-default btn-block">Help to
									login</a>
							</form>
						</div>
					</div>
					<div class="col-xs-6">
						<p class="lead">
							Register now for <span class="text-success">FREE</span>
						</p>
						<ul class="list-unstyled" style="line-height: 2">
							<li><span class="fa fa-check text-success"></span> Sell books
							for free</li>
							<li><span class="fa fa-check text-success"></span> Receive
								notifications</li>
							<li><span class="fa fa-check text-success"></span> Rate
								book sellers</li>

							<li><span class="fa fa-check text-success"></span> Add
								comments</li>							
						</ul>
						<p>
							<a href="registration" class="btn btn-info btn-block">Yes
								please, register now!</a>
						</p>
						<p>
							<a href="welcome" class="btn btn-info btn-block">View Listings as guest</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>