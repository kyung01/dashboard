<!-- navigator.jsp begin -->
<div id ='navigator-main'>
	<ul class="bttn">
		<li id = 'nav-beacons'><a class = 'nav' href="https://i.imgur.com/hhAMqDm.mp4">Beacons</a></li>
		<li id = 'nav-messages'><a  class = 'nav' href="https://i.imgur.com/tE6YQV1.mp4">Messages</a></li>
		<li id = 'nav-locations'><a  class = 'nav' href="https://i.imgur.com/VKjWBKH.gif">Locations</a></li>
		<li id = 'nav-analytics'><a  class = 'nav' href="https://i.imgur.com/Hogicvd.mp4">Analytics</a></li>
		<li id = 'nav-company'><a  class = 'nav' href="https://i.imgur.com/od6BYLY.mp4">Company</a></li>
		<li id = 'nav-users'><a  class = 'nav' href="https://i.imgur.com/RqkHNkd.jpg">Users</a></li>
	</ul>
</div>
<div>
</div>
<style type="text/css">
	#navigator-main{
		width: 100%;
		height: 100%;
		min-height: 70vh;
	}
	.bttn{
		width:100%;
	    list-style-type: none;
	    margin: 0;
	    padding: 0;
		color: rgb(198,225,242);

	}
	li{
		width: 100%;
		height: 10vh;
	}
	a.nav:link {
		color: rgb(198,225,242);
	}

	/* visited link */
	a.nav:visited {
		color: rgb(198,225,242);
	}

	/* mouse over link */
	a.nav:hover {
	    color: hotpink;
	}

	/* selected link */
	a.nav:active {
	    color: blue;
	}	
</style>
<script type="text/javascript">

	function selectNavigator(id) {
		var color = "";
		var colorSelected = "rgba(80,165,219)";
		$("#nav-beacons").css("background-color", color);
		$("#nav-messages").css("background-color", color);
		$("#nav-locations").css("background-color", color);
		$("#nav-analytics").css("background-color", color);
		$("#nav-company").css("background-color", color);
		$("#nav-users").css("background-color", color);
		$(id).css("background-color", colorSelected);
	}

	$(document).ready( 
		function(){
			selectNavigator('#nav-analytics');

		}
	);
</script>
<!-- navigator.jsp end -->