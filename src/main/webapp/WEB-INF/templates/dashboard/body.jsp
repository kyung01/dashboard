<!--body_beacons.jsp-->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div id = 'body_main'>
	<div id = 'navigator' class="index_div"><tiles:insertAttribute name="navigator" /></div><!--commenting out the white space between divs
	--><div id = 'body_content' class="index_div"><tiles:insertAttribute name="body_content" />
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
		background-color: rgb(130,50,50);
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