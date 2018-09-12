<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:700" rel="stylesheet"><!--font-family: 'IBM Plex Sans', sans-serif;-->
<div>

<table id = "tableMessage" style="width:100%">
  <tr>
    <th>Picture</th>
    <th>ID</th> 
    <th>Date</th>
    <th>Type</th>
    <th>Content</th>
    <th>Active</th>
    <th>Expiration</th>
    <th>Group</th>
  </tr>
  <tr id = "item_1" class = "item" >
  	<td class = "picture"><img src = "person0.png"> </td>
    <td class = "id" >1234</td>
    <td class = "date">01:00<br>01/02/2018</td> 
    <td class = "type">Emergency</td>
    <td class = "content">Help</td>
    <td class = "active">
    	<label class="switch">
		  <input type="checkbox">
		  <span class="slider"></span>
		</label>	
    </td>
    <td class = "expiration">02:34<br>01/02/3018</td>
    <td class = "group">User</td>
  </tr>

  <tr id = "item_2" class = "item" >
  	<td class = "picture"><img src = "person1.png"> </td>
    <td class = "id" >1234</td>
    <td class = "date">01:00<br>01/02/2018</td> 
    <td class = "type">Emergency</td>
    <td class = "content">Help</td>
    <td class = "active">
    	<label class="switch">
		  <input type="checkbox">
		  <span class="slider"></span>
		</label>	
    </td>
    <td class = "expiration">02:34<br>01/02/3018</td>
    <td class = "group">User</td>
  </tr>


  <tr id = "item_3" class = "item" >
  	<td class = "picture"><img src = "person2.png"> </td>
    <td class = "id" >1234</td>
    <td class = "date">01:00<br>01/02/2018</td> 
    <td class = "type">Emergency</td>
    <td class = "content">Help</td>
    <td class = "active">
    	<label class="switch">
		  <input type="checkbox">
		  <span class="slider"></span>
		</label>	
    </td>
    <td class = "expiration">02:34<br>01/02/3018</td>
    <td class = "group">User</td>
  </tr>


  <tr id = "item_4" class = "item" >
  	<td class = "picture"><img src = "person3.png"> </td>
    <td class = "id" >1234</td>
    <td class = "date">01:00<br>01/02/2018</td> 
    <td class = "type">Emergency</td>
    <td class = "content">Help</td>
    <td class = "active">
    	<label class="switch">
		  <input type="checkbox">
		  <span class="slider"></span>
		</label>	
    </td>
    <td class = "expiration">02:34<br>01/02/3018</td>
    <td class = "group">User</td>
  </tr>


  <tr id = "item_5" class = "item" >
  	<td class = "picture"><img src = "person4.png"> </td>
    <td class = "id" >1234</td>
    <td class = "date">01:00<br>01/02/2018</td> 
    <td class = "type">Emergency</td>
    <td class = "content">Help</td>
    <td class = "active">
    	<label class="switch">
		  <input type="checkbox">
		  <span class="slider"></span>
		</label>	
    </td>
    <td class = "expiration">02:34<br>01/02/3018</td>
    <td class = "group">User</td>
  </tr>


  <tr id = "item_6" class = "item" >
  	<td class = "picture"><img src = "person5.png"> </td>
    <td class = "id" >1234</td>
    <td class = "date">01:00<br>01/02/2018</td> 
    <td class = "type">Emergency</td>
    <td class = "content">Help</td>
    <td class = "active">
    	<label class="switch">
		  <input type="checkbox">
		  <span class="slider"></span>
		</label>	
    </td>
    <td class = "expiration">02:34<br>01/02/3018</td>
    <td class = "group">User</td>
  </tr>


  <tr id = "item_7" class = "item" >
  	<td class = "picture"><img src = "person6.png"> </td>
    <td class = "id" >1234</td>
    <td class = "date">01:00<br>01/02/2018</td> 
    <td class = "type">Emergency</td>
    <td class = "content">Help</td>
    <td class = "active">
    	<label class="switch">
		  <input type="checkbox">
		  <span class="slider"></span>
		</label>	
    </td>
    <td class = "expiration">02:34<br>01/02/3018</td>
    <td class = "group">User</td>
  </tr>


  <tr id = "item_8" class = "item" >
  	<td class = "picture"><img src = "person7.png"> </td>
    <td class = "id" >1234</td>
    <td class = "date">01:00<br>01/02/2018</td> 
    <td class = "type">Emergency</td>
    <td class = "content">Help</td>
    <td class = "active">
    	<label class="switch">
		  <input type="checkbox">
		  <span class="slider"></span>
		</label>	
    </td>
    <td class = "expiration">02:34<br>01/02/3018</td>
    <td class = "group">User</td>
  </tr>


  <tr id = "item_9" class = "item" >
  	<td class = "picture"><img src = "person8.png"> </td>
    <td class = "id" >1234</td>
    <td class = "date">01:00<br>01/02/2018</td> 
    <td class = "type">Emergency</td>
    <td class = "content">Help</td>
    <td class = "active">
    	<label class="switch">
		  <input type="checkbox">
		  <span class="slider"></span>
		</label>	
    </td>
    <td class = "expiration">02:34<br>01/02/3018</td>
    <td class = "group">User</td>
  </tr>



</table>








<style type="text/css">




/* The switch - the box around the slider */
.switch {
  position: relative;
  display: inline-block;
  width: 60px;
  height: 34px;
}

/* Hide default HTML checkbox */
.switch input {display:none;}

/* The slider */
.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 26px;
  width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
  background-color: #2196F3;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}


 #tableMessage{

	font-family: 'IBM Plex Sans', sans-serif;
    border-collapse:collapse;/*This property collapses borders together*/
 }
 #tableMessage .item {
 	border-top: solid;
 	border-width: 3px;
 	border-color: rgb(200,200,200);

 }
 .picture{
 	width: 10%;

 }
 .item img {
 	width: 100%;
 	margin-top:5px;
 }


        </style>