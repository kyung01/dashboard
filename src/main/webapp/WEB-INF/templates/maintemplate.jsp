<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<title>Welcome to smart signage (<tiles:getAsString name="title" />)</title>
	<!--good old jquery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!--textfit is js library that allows text to be wrapped properly to fit into the container -->
    <script src="textFit.min.js"></script>
	<style type="text/css">
		html, body { height: 100%; width: 100vw; margin: 0; 
			overflow-x:hidden; 
		}
		.index_div{margin: 0px;vertical-align: top;display: grid;}
	</style>
<body>
	<div id = 'header' class="index_div"><tiles:insertAttribute name="header" /></div>
	<div id = 'navigator' style="width:20%; height:100%"><tiles:insertAttribute name="navigator" /></div>
	<div id = 'body'class = 'index_div' style="width:80%"><tiles:insertAttribute name="body" /></div>
	<div id = 'footer' class="index_div" style="width:80%"><tiles:insertAttribute name="footer" /></div>
</body>
 <!-- <script type="text/javascript">
	$(document).ready( 
		function() {
			$("#header").load("header.html");
			$("#body").load("body.html");
			$("#footer").load("footer.html");
		}
	);
</script>  --> 
</html>
