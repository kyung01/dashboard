<div id ='navigator-main'>
	<div id = 'user-overview'>
		<div id = 'user-picture'>
		<img src= "resources/images/user.png" alt="user's picture">
		</div><!--commenting out the white space between divs
	--><div id= 'user-overview-right'>
			<div id = 'user-description'>
				name_of_this_user<br>
				role_of_this_user<br>
			</div>
				<div id ="user-quick-menus">
					<img id="user-quick-menu-settings" class ='user-quick-menu' src = "resources/images/settings.png">
					<img id="user-quick-menu-logout" class ='user-quick-menu' src = "resources/images/logout.png">
					<img id="user-quick-menu-edit" class ='user-quick-menu' src = "resources/images/edit.png">
				</div>
			</div>
		</div>
	

	<ul class="bttns">
		<li id = 'nav-beacons'><a href="beacons">Beacons</a></li>
		<li id = 'nav-messages'><a href="messages">Messages</a></li>
		<li id = 'nav-locations'><a href="locations">Locations</a></li>
		<li id = 'nav-analytics'><a href="analytics">Analytics</a></li>
		<li id = 'nav-company'><a href="company">Company</a></li>
		<li id = 'nav-users'><a href="users">Users</a></li>

	</ul>
</div>
<div>
</div>
<link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:700" rel="stylesheet"><!--font-family: 'IBM Plex Sans', sans-serif;-->
<style type="text/css">
	#navigator-main{
		width: 100%;
		height: 100%;
		min-height: 100vh;
    	box-sizing: border-box; /*Required to make border-right to be inwards*/
		border-right: 3px groove rgba(203, 216, 224, 0.5);
	}

	#user-overview{
		width: 100%;
		height: 15vh;
		max-height: 100%;
		display: inline-flex;
		background-color: rgb(119,137,147);

    	box-sizing: border-box; /*Required to make border to be inwards*/
		border-top: 2px groove rgba(0, 0, 0, 0.2);
		border-bottom: 3px groove rgba(0, 0, 0, 0.2);
		z-index: -100;
	}

	#user-picture{
		text-align: center;
		width: 30%;
		height: 100%;
  display: flex;

  align-items: center; /* horizontal */
  justify-content: center; /* vertical */


	}
	#user-picture img {
		max-width:100%;
max-height:85%;


    border-radius: 50px;

-webkit-box-shadow: 0px 5px 2px 0px rgba(0,0,0,0.5);
-moz-box-shadow: 0px 5px 2px 0px rgba(0,0,0,0.5);
box-shadow: 0px 5px 2px 0px rgba(0,0,0,0.5);
;
	}
	#user-overview-right{

		width: 70%;
		height: 100%;

	}
	#user-description{
		width: 100%;
		height: 65%;
	}

	

	#user-quick-menus{
		width: 100%;
		height: 30%;

	}
	.user-quick-menus-shadow{
		-webkit-box-shadow: 0px 15px 22px 0px rgba(0,0,0,0.75);
-moz-box-shadow: 0px 15px 22px 0px rgba(0,0,0,0.75);
box-shadow: 0px 15px 22px 0px rgba(0,0,0,0.75);
	}

	.user-quick-menu{

		max-width:100%;
max-height:100%;



    border-radius: 50px;

-webkit-box-shadow: 0px 5px 2px 0px rgba(0,0,0,0.5);
-moz-box-shadow: 0px 5px 2px 0px rgba(0,0,0,0.5);
box-shadow: 0px 5px 2px 0px rgba(0,0,0,0.5);


	}
	#user-quick-menu-settings{
		float: left;
		margin-left: 10px;
	}
	#user-quick-menu-logout{
		float: left;
		margin-left: 5px;
	}
	#user-quick-menu-edit{
		float: right;
		margin-right: 10px;
	}
	.bttns{
		width:100%;
	    list-style-type: none;
	    list-style: none;
	    margin: 0;
	    padding: 0;
    	box-sizing: border-box; /*Required to make border-right to be inwards*/


		color: rgb(198,225,242);
		font-family: 'IBM Plex Sans', sans-serif;
		text-decoration: none;

	}
	li{
		width: 100%;
		height: 10vh;
	}
	#nav-selectedIcon{
		top:50%;
		left: 25vw;
	}

	#diamond-indent{
	}

	#diamond {
		width: 0;
		height: 0;
		border: 6px solid transparent;
		border-bottom-color: rgb(156,187,206);
		position: relative;
		top: -12px;

		left: -8px;
	}
	#diamond:after {
		content: '';
		position: absolute;
		left: -6px;
		top: 6px;
		width: 0;
		height: 0;
		border: 6px solid transparent;
		border-top-color: rgb(156,187,206);
	}

	#diamond-black {
		width: 0;
		height: 0;
		border: 6px solid transparent;
		border-bottom-color: rgb(56,67,73);
		position: relative;
		top: -8px;
		left: -8px;
		position: absolute; 
		z-index: -1;
	}
	#diamond-black:after {
		content: '';
		position: absolute;
		left: -6px;
		top: 6px;
		width: 0;
		height: 0;
		border: 6px solid transparent;
		border-top-color:  rgb(56,67,73);
	}

</style>
<script type="text/javascript">

	function selectNavigator(id) {
		var emptyString = "";
		var colorSelected = "rgba(80,165,219)";
		$("#nav-beacons").		css("background-color", emptyString);
		$("#nav-messages").		css("background-color", emptyString);
		$("#nav-locations").	css("background-color", emptyString);
		$("#nav-analytics").	css("background-color", emptyString);
		$("#nav-company").		css("background-color", emptyString);
		$("#nav-users").		css("background-color", emptyString);

		$("#nav-beacons").		css("border-right", emptyString);
		$("#nav-messages").		css("border-right", emptyString);
		$("#nav-locations").	css("border-right", emptyString);
		$("#nav-analytics").	css("border-right", emptyString);
		$("#nav-company").		css("border-right", emptyString);
		$("#nav-users").		css("border-right", emptyString);

		$(id).css("background-color", colorSelected);
		$(id).css("border-right", " 3px groove rgba(230, 230, 255,0.5)");
		$("#nav-selectedIcon").appendTo(id);
	}
	function fitNavigator(){
        textFit(document.getElementById('user-description'),{alignVert: true, alignHoriz: true});
        textFit(document.getElementById('nav-beacons'),{alignVert: true, alignHoriz: true});
        textFit(document.getElementById('nav-messages'),{alignVert: true, alignHoriz: true});
        textFit(document.getElementById('nav-locations'),{alignVert: true, alignHoriz: true});
        textFit(document.getElementById('nav-analytics'),{alignVert: true, alignHoriz: true});
        textFit(document.getElementById('nav-company'),{alignVert: true, alignHoriz: true});
        textFit(document.getElementById('nav-users'),{alignVert: true, alignHoriz: true});
	}

	$(document).ready( 
		function(){
			fitNavigator();
			selectNavigator("#nav-beacons");
		}
	);
	$(window).on('resize', fitNavigator);
	document.getElementById('nav-beacons').addEventListener("click", function(){selectNavigator('#nav-beacons');});
	document.getElementById('nav-analytics').addEventListener("click", function(){selectNavigator('#nav-analytics');});
	document.getElementById('nav-users').addEventListener("click", function(){selectNavigator('#nav-users');});
	document.getElementById('nav-company').addEventListener("click", function(){selectNavigator('#nav-company');});
	document.getElementById('nav-messages').addEventListener("click", function(){selectNavigator('#nav-messages');});
	document.getElementById('nav-locations').addEventListener("click", function(){selectNavigator('#nav-locations');});
</script>