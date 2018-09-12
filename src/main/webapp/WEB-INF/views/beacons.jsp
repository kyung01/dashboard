<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:700" rel="stylesheet"><!--font-family: 'IBM Plex Sans', sans-serif;-->
<div id="body">
<a id = "bttn_registerNewBeacon" href="#" class="myButton">Register New Beacon</a>

<table id = "tableBeacons" style="width:100%">
  <tr>
    <th>Beacon Name</th>
    <th>Coordinate</th> 
    <th>Stability</th>
    <th>Power</th>
    <th>Online/Offline</th>
  </tr>
  <tr id = "beacon_1" class = "beaconInfo" >
    <td class = "beaconName" >Beacon Name One</td>
    <td class = "beaconCoordinate">12.3456,78.0123</td> 
    <td class = "beaconStability">Stable</td>
    <td class = "beaconPower">
    	<label class="switch">
		  <input type="checkbox">
		  <span class="slider"></span>
		</label>	
	</td>
    <td class = "BeaconOfflineOnline">
    	<form action="">
			<input type="radio" checked="checked" value="offlineMode" name="offlineMode">Offline Mode
    	</form>
    </td>
  </tr>
</table>
</div>