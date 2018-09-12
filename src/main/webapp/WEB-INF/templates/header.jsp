<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<div id ='header_main'>
	
	<div id = 'header_left'>
		<img src="resources/images/logo.png" alt="Company Logo">
	</div><!--commenting out the white space between divs
	--><div id = 'header_right'>
		<h1 id ='right'>SMART SIGNAGE DASHBOARD</h1>
	</div>
</div>

<link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:700" rel="stylesheet"><!--font-family: 'IBM Plex Sans', sans-serif;-->
<style type="text/css">
	#header_main{
		width: 100vw;
		max-width:100%;
		height: 10vh;
		font-family: 'IBM Plex Sans', sans-serif;
	}
	#header_left{
		width: 20%;
		height: 100%;
		background-color: rgb(64,64,64);
		display: inline-flex;
    	box-sizing: border-box; /*Required to make border-right to be inwards*/
		border-right: 3px groove rgba(203, 216, 224, 0.5);
	}
	#header_left img {
		max-width:100%;
		max-height:100%;
		object-fit: contain;

	}
	#header_right{
		width: 80%;
		height: 100%;
		display: inline-grid;
		vertical-align: top;

		background: #6797b2;
background: -moz-linear-gradient(top, #6797b2 2%, #4289b5 57%, #4289b5 99%);
background: -webkit-linear-gradient(top, #6797b2 2%,#4289b5 57%,#4289b5 99%);
background: linear-gradient(to bottom, #6797b2 2%,#4289b5 57%,#4289b5 99%);
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#6797b2', endColorstr='#4289b5',GradientType=0 );
	}
	#header_right h1{
		text-align: left;
		margin-left: 10px;
		color: rgb(198,225,242);
	}
</style>
<script type="text/javascript">;
	function fitHeader(){
        textFit(document.getElementById('header_right'), {maxFontSize: 100});

	}

	$(document).ready( 
		function(){
			fitHeader();
		}
	);
	$(window).on('resize', fitHeader);
</script>