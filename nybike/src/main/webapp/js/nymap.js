function switchIcon(isBTS){
	if(isBTS){
		for(var i = 0;i < markerArr.length;i++){
			var marker = markerArr[i];
			 var iconOpts={    
					   anchor: new BMap.Size(5, 10), 
					   imageSize: new BMap.Size(10, 10)
				    }
			 var newIcon = new BMap.Icon("img/si_"+marker.bikeLevel+".png", new BMap.Size(10, 10),iconOpts);  
			 marker.setIcon(newIcon);
		}
	}else{
		for(var i = 0;i < markerArr.length;i++){
			var marker = markerArr[i];
			 var iconOpts={    
					 anchor: new BMap.Size(21, 50), 
					   imageSize: new BMap.Size(42, 50)
				    }
			 var newIcon = new BMap.Icon("img/bi_"+marker.bikeLevel+".png", new BMap.Size(42, 50),iconOpts); 
			 marker.setIcon(newIcon);
		}
	}
	
}
function getBikeLevel(nba,nda){
	if(nba == 0 || (nba + nda) == 0){
		return 0 ;
	}
	if(nba < 8){
		return 1 ;
	}
	var abi = nba / (nba + nda);
	if(abi < 0.5){
		return 2 ;
	}
	if(abi < 1){
		return 3 ;
	}
	if(abi = 1){
		return 4 ;
	}
}
function getInfoWindow(infoItem){
	//百度地图API功能
	var sContent =
	"<div class='mapbox-content'>"+
	"<div class='mapbox-content-top'>"+
		"<span class='window_lastUpdate'> 0 ms ago </span> <span class='window_info_button'></span></div>"+
	"<div class='mapbox-content-header'>"+
		"<h1 class='mapbox-content-header-stationName'>"+infoItem.name+"</h1></div>"+
	"<div class='mapbox-content-detail'>"+
		"<div class='mapbox-content-detail-bikes-available'>"+
			"<span class='mapbox-content-detail-bikes-available-val'>"+ infoItem.nba + " </span>"+
			"<span class='mapbox-content-detail-bikes-available-lbl'>Bikes</span></div>"+
		"<div class='mapbox-content-detail-docks-available'>"+
			"<span class='mapbox-content-detail-docks-available-val'>"+ infoItem.nda +"</span> <span class='mapbox-content-detail-docks-available-lbl'>Docks</span></div></div>"+
	"<div class='mapbox-content-footer'>"+
		"<span class='mapbox-content-footer-shortName'> Bike station:"+ infoItem.shortName +"</span></div></div>";
	//创建信息窗口对象
	var infoWindow = new BMap.InfoWindow(sContent);  // 创建信息窗口对象
	return infoWindow;
}
function addMarker(lon,lat,bikeLevel,infoItem){
	var point = new BMap.Point(lon,lat); 
    var iconOpts={    
				   anchor: new BMap.Size(21, 50), 
				   imageSize: new BMap.Size(42, 50)
			    }
	var myIcon = new BMap.Icon("img/bi_"+bikeLevel+".png", new BMap.Size(42, 50),iconOpts);  
	// 创建标注对象并添加到地图   
	var marker = new BMap.Marker(point, {icon: myIcon}); 
	marker.bikeLevel = bikeLevel;
	markerArr.push(marker);
	var infoWindow = getInfoWindow(infoItem);
	marker.addEventListener("click", function(){          
	 	   this.openInfoWindow(infoWindow);
	 	});
    map.addOverlay(marker);   
    
}