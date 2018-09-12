<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:700" rel="stylesheet"><!--font-family: 'IBM Plex Sans', sans-serif;-->
<div>
<a id = "bttn_registerNewBeacon" href="#" class="myButton">ADD NEW USER</a>

<table id = "tableUsers">
  <tr>
    <th>User</th>
    <th>Group</th> 
    <th>Email</th>
    <th>Last Login</th>
    <th>Location</th>
  </tr>

  <tr id = "0" class = "userInfo" >
    <td class = "img"><img src = "resources/images/person0.png"> </td>
    <td class = "group">Company</td> 
    <td class = "email">myEmail@gmail.com</td>
    <td class = "lastLogin">Today 07:30 AM</td>
    <td class = "location">Cambridge, MA</td>
  </tr>
  <tr id = "1" class = "userInfo" >
    <td class = "img"><img src = "resources/images/person1.png"> </td>
    <td class = "group">Company</td> 
    <td class = "email">myEmail@gmail.com</td>
    <td class = "lastLogin">Today 07:30 AM</td>
    <td class = "location">Cambridge, MA</td>
  </tr>
  <tr id = "2" class = "userInfo" >
    <td class = "img"><img src = "resources/images/person2.png"> </td>
    <td class = "group">Company</td> 
    <td class = "email">myEmail@gmail.com</td>
    <td class = "lastLogin">Today 07:30 AM</td>
    <td class = "location">Cambridge, MA</td>
  </tr>

  <tr id = "3" class = "userInfo" >
    <td class = "img"><img src = "resources/images/person3.png"> </td>
    <td class = "group">Company</td> 
    <td class = "email">myEmail@gmail.com</td>
    <td class = "lastLogin">Today 07:30 AM</td>
    <td class = "location">Cambridge, MA</td>
  </tr>

  <tr id = "4" class = "userInfo" >
    <td class = "img"><img src = "resources/images/person4.png"> </td>
    <td class = "group">Company</td> 
    <td class = "email">myEmail@gmail.com</td>
    <td class = "lastLogin">Today 07:30 AM</td>
    <td class = "location">Cambridge, MA</td>
  </tr>

  <tr id = "5" class = "userInfo" >
    <td class = "img"><img src = "resources/images/person5.png"> </td>
    <td class = "group">Company</td> 
    <td class = "email">myEmail@gmail.com</td>
    <td class = "lastLogin">Today 07:30 AM</td>
    <td class = "location">Cambridge, MA</td>
  </tr>

  <tr id = "6" class = "userInfo" >
    <td class = "img"><img src = "resources/images/person6.png"> </td>
    <td class = "group">Company</td> 
    <td class = "email">myEmail@gmail.com</td>
    <td class = "lastLogin">Today 07:30 AM</td>
    <td class = "location">Cambridge, MA</td>
  </tr>
  
</table>








<style type="text/css">
	#bttn_registerNewBeacon{
		float: right;
		margin-top: 30px;
		margin-bottom: 30px;
		margin-right: 50px;

	}

.myButton {
	-moz-box-shadow:inset 0px -1px 34px 3px #2a94d1;
	-webkit-box-shadow:inset 0px -1px 34px 3px #2a94d1;
	box-shadow:inset 0px -1px 34px 3px #2a94d1;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #6dbeed), color-stop(1, #4495c4));
	background:-moz-linear-gradient(top, #6dbeed 5%, #4495c4 100%);
	background:-webkit-linear-gradient(top, #6dbeed 5%, #4495c4 100%);
	background:-o-linear-gradient(top, #6dbeed 5%, #4495c4 100%);
	background:-ms-linear-gradient(top, #6dbeed 5%, #4495c4 100%);
	background:linear-gradient(to bottom, #6dbeed 5%, #4495c4 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6dbeed', endColorstr='#4495c4',GradientType=0);
	background-color:#6dbeed;
	-moz-border-radius:17px;
	-webkit-border-radius:17px;
	border-radius:17px;
	border:1px solid #97b2c2;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family: 'IBM Plex Sans', sans-serif;
	font-size:45px;
	padding:9px 23px;
	text-decoration:none;
	text-shadow:0px 1px 18px #263666;
}
.myButton:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #4495c4), color-stop(1, #6dbeed));
	background:-moz-linear-gradient(top, #4495c4 5%, #6dbeed 100%);
	background:-webkit-linear-gradient(top, #4495c4 5%, #6dbeed 100%);
	background:-o-linear-gradient(top, #4495c4 5%, #6dbeed 100%);
	background:-ms-linear-gradient(top, #4495c4 5%, #6dbeed 100%);
	background:linear-gradient(to bottom, #4495c4 5%, #6dbeed 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#4495c4', endColorstr='#6dbeed',GradientType=0);
	background-color:#4495c4;
}
.myButton:active {
	position:relative;
	top:1px;
}



	 #tableUsers{
	 	width: 95%;

		font-family: 'IBM Plex Sans', sans-serif;
	    border-collapse:collapse;/*This property collapses borders together*/
	    margin-left: 1.5%;
	 }
	.userInfo{
		text-align: center;

	 	border-top: solid;
	 	border-width: 3px;
	 	border-color: rgb(200,200,200);

	}
	.img{
		width: 10%;
	}
	.img img{
 	width: 100%;
 	margin-top:5px;
	}


        </style>