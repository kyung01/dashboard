<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String strMsg = (session.getAttribute("frmMessage")!=null) ?  (String)session.getAttribute("frmMessage") : "";
   Boolean blnTyp = (session.getAttribute("frmTyp")!=null) ?  (Boolean)session.getAttribute("frmTyp") : false;
   System.out.println("strMsg >> "+strMsg);
   System.out.println("blnTyp >> "+blnTyp);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Sunil Gemini">
<title>Organization Level - Overall Performance</title>

<!-- core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/animate.min.css" rel="stylesheet">
<link href="resources/css/main.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">
<link href="resources/css/custom.css" rel="stylesheet">

<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="images/ico/....ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="images/ico/apple-touch-icon-57-precomposed.png">
</head>
<!--/head-->

<body class="login">
	<header id="header">
		<nav class="navbar navbar-inverse" role="banner">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html"><img
						src="resources/images/logo.png" alt="logo"></a>
				</div>

				<div class="collapse navbar-collapse navbar-right">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Sign Up</a></li>
						<li><a href="#" onclick="javascript:location='login'">Login</a></li>
					</ul>
				</div>
			</div>
			<!--/.container-->
		</nav>
		<!--/nav-->
	</header>
	<!--/header-->
	<section id="login">
		<div class="container">
			<div class="wow fadeInDown">
				<div class="col-sm-6 col-sm-offset-3 form-box">
					<div class="form-top">
						<div class="form-top-left">
							<img src="resources/images/login_Logo.png" alt="">
							<p>Enter your username and password to log on:</p>
						</div>
						<div class="form-top-right">
							<i class="fa fa-key"></i>
						</div>
					</div>
					<div class="form-bottom">
						<form role="form" name="frmAdd" method="post"
							action="userRegister" commandName="clients" class="login-form">
							<div class="form-group">
								<input class="form-control" name="name" placeholder="Your Name"
									type="text" required autofocus />
							</div>
							<div class="form-group">
								<input class="form-control" name="emailId"
									placeholder="Your email" type="text" required autofocus />
							</div>
							<div class="form-group">
								<input class="form-control" name="companyName"
									placeholder="Comapany/Team Name" type="text" required autofocus />
							</div>
							<div class="form-group">
								<!-- input class="form-control" name="timeZone" placeholder="Time Zone" type="text" required autofocus /-->
								<select name="timeZone" id="timeZone" class="form-control">
									<c:if test="${!empty timeZones}">
										<c:forEach items="${timeZones}" var="g">
											<option value="${g.id}">${g.timeZone}</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
							<div class="form-group">
								<input class="form-control" name="password"
									placeholder="Password" type="password" required />
							</div>
							<div class="form-group">
								<input class="form-control" name="repassword"
									placeholder="Confirm Password" type="password" required />
							</div>

							<p class="alert-danger" <%if(blnTyp){%> style="color: green;"
								<%}else{%> style="color: red;" <%}%>><%=strMsg %></p>
							<div class="form-group"></div>
							<button type="submit" class="btn btn-lg btn-primary btn-block">Sign
								Up!</button>
						</form>
						<div class="clearfix"></div>
					</div>
				</div>

			</div>
			<div class="clearfix"></div>

			<!--section-->
		</div>
		<!--/.container-->
	</section>
	<!--/about-us-->



	<script src="js/jquery.js"></script>
	<script type="text/javascript">
        $('.carousel').carousel()
    </script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.prettyPhoto.js"></script>
	<script src="resources/js/jquery.isotope.min.js"></script>
	<script src="resources/js/main.js"></script>
	<script src="resources/js/wow.min.js"></script>
</body>
</html>