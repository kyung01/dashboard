<!--index.jsp-->
<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<style type="text/css">
		html, body { height: 100%; width: 100%; margin: 0;overflow-x:hidden; }
		.index_div{margin: 0px;vertical-align: top;display: grid;}
	</style><title>Welcome to Smart Signage (<tiles:getAsString name="title" />)</title>
	<title>Welcome to Smart Signage (<tiles:getAsString name="title" />)</title>
<body>
<p>BODY HERE</p>
	<div id = 'header' class="index_div"><tiles:insertAttribute name="header" /></div>
	<div id = 'body'class = 'index_div'><tiles:insertAttribute name="body" /></div>
	<div id = 'footer' class="index_div"><tiles:insertAttribute name="footer" /></div>
</body>
</html>
<!--end of index.jsp-->