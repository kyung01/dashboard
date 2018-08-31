<!--body_beacons.jsp-->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<div id = 'body_main'>
	<div id = 'navigator'></div><!--commenting out the white space between divs
	--><div id ='body_content'>content </div>
</div>
<p>Apple</p>
<style type="text/css">
	#body_main{
		width: 100vw;
		max-width:100%;
		height: 100%;
		min-height: 50vh;
	}
	#navigator{
		width: 30%;
		height: 100%;
		background-color: rgb(100,120,130);
		display: inline-flex;
	}
	#body_content{
		width: 70%;
		height: 100%;
		background-color: rgb(130,150,180);
		display: inline-grid;
		vertical-align: top;
	}
</style>

<script type="text/javascript">

	$(document).ready( 
		function() {
			//$("#navigator").load("navigator.html");
		}
	);
</script>
<!--body_beacons.jsp end-->