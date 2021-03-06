<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>College Books</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	 <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	 <script src="<c:url value="/resources/js/app.js" />"></script>
	 
</head>
<body style="padding-top: 100px">

	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

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
				<a class="navbar-brand" href="<c:url value="/"/>">College Books</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="menu">
				<ul class="nav navbar-nav navbar-right">
									
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<li><a href="#"><font color="Green"> Signed in as :
								${pageContext.request.userPrincipal.name}</font></a></li>								
							<li><a href="addListing">Add Listing </a></li>	
							<li><a href="accountPage?username=${pageContext.request.userPrincipal.name}">
									Account Administration</a>						
						</li>
						<li><a href="javascript:formSubmit()">
									Logout</a>						
						</li>
					</c:if>
					<c:if test="${pageContext.request.userPrincipal.name == null}">
						<li><a href="login">Login</a></li>
						<li><a href="login">Add Listing </a></li>
					</c:if>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>