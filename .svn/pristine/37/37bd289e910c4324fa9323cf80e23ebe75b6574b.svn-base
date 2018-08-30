<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String sAction = (session.getAttribute("CheckEmail") != null) ? (String) session.getAttribute("CheckEmail")
			: "";
	System.out.println("strMsg >> " + sAction);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/custom.css" rel="stylesheet">

</head>
<body class="forgotPassword">
	<div class="panel-body">

		<div class="container">
			<div class="wow fadeInDown">
				<div class="col-sm-6 col-sm-offset-3 form-box">
					<div class="form-top">
						<div class="form-top-left">
							<img src="resources/images/login_Logo.png" alt="">
							<p>Forgot your password? Let's get you a new one.</p>
						</div>
						<div class="form-top-right">
							<i class="fa fa-key"></i>
						</div>
					</div>
					<div class="form-bottom">

						<form action="getPassword" method="get">
							<div class="form-group">
								<input class="form-control" type="text" name="emailId"
									placeholder="Enter your email" required="" autofocus="" />
							</div>
							<p class="alert-danger" style="color: red;">
								<%=sAction%>
							</p>
							<div class="form-group">
								<a href="login" class="pull-right" style="margin-bottom: 15px;">Login</a>
							</div>

							<input type="submit" class="btn btn-lg btn-primary btn-block"
								value="Reset Password" />
							<div></div>
						</form>

					</div>
				</div>

			</div>
			<div class="clearfix"></div>

			<!--section-->
		</div>
		<!--/.container-->


		<div class="clearfix" style="margin-bottom: 20px;">
			<!-- <button type="button" class="btn btn-danger pull-right"
			onClick="javascript:location='members'">+ Add team members</button> -->
		</div>
		<div class="row"></div>

	</div>
	
<%session.removeAttribute("CheckEmail"); %>
</body>
</html>