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
	function fitNavigator(){
        textFit(document.getElementById('nav-beacons'),{alignVert: true, alignHoriz: true});
        textFit(document.getElementById('nav-messages'),{alignVert: true, alignHoriz: true});
        textFit(document.getElementById('nav-locations'),{alignVert: true, alignHoriz: true});
        textFit(document.getElementById('nav-analytics'),{alignVert: true, alignHoriz: true});
        textFit(document.getElementById('nav-company'),{alignVert: true, alignHoriz: true});
        textFit(document.getElementById('nav-users'),{alignVert: true, alignHoriz: true});

	}