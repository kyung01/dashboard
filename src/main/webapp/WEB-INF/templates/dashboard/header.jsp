<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<div id ='header_main'>
	
	<div id = 'header_left'>
		<img src="/smart-signage/resources/images/logo.png" alt="Company Logo">
	</div><!--commenting out the white space between divs
	--><div id = 'header_right'>
		<h1 id =	'right'>HEADING</h1>
	</div>
</div>

<style type="text/css">
	#header_main{
		width: 100vw;
		max-width:100%;
		height: 10vh;
	}
	#header_left{
		width: 30%;
		height: 100%;
		background-color: rgb(64,64,64);
		display: inline-flex;
	}
	#header_left img {
		max-width:100%;
		max-height:100%;
		object-fit: contain;

	}
	#header_right{
		width: 70%;
		height: 100%;
		display: inline-grid;
		background-color: rgb(71,142,190);
		vertical-align: top;
	}
	#header_right h1{
		text-align: left;
		margin-left: 10px;
		color: rgb(198,225,242);
	}
</style>
<script type="text/javascript">;
</script>