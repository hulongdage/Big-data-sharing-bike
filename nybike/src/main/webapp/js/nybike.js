function zixingche(){
     //alert("hello");
     if(map.getZoom()<15){
			switchIcon(1);
     } 
     if(map.getZoom()>14){
			switchIcon(2);
     }
     flag = 0;
}
function chezhuang(){
	//alert("hello");
	if(map.getZoom()<15){
		switchIcon(3);
	} 
	if(map.getZoom()>14){
		switchIcon(4);
	}
	flag = 1;
}
function listen(){
	map.addEventListener("zoomend", function(){  
		if(this.getZoom()>14 && isBigIcon==false){//应该变大
			if(flag==0){
				switchIcon(2);
			}	
			if(flag==1){
				switchIcon(4);
			}
			isBigIcon=true;
		}
		if(this.getZoom()<15 && isBigIcon==true){//应该变小
			if(flag==0){
				switchIcon(1);
			}	
			if(flag==1){
				switchIcon(3);
			}
			isBigIcon=false;
		} 
	});
}
function switchIcon(flag){
	for(var index in markerArray){
    	var oldImageUrl=markerArray[index].getIcon().imageUrl;
    	if(flag==1)
    {
    	var newImageUrl=markerArray[index].bikeb;//变小
    	var iconOpts = {    
	        anchor: smallIconAnchor,
	        imageSize: smallIconSize
	    }
	    var myIcon = new BMap.Icon(newImageUrl, smallIconSize, iconOpts);      
    }
    	else if(flag==2)
    {
    		var newImageUrl=markerArray[index].bikeB;//变大
        	var iconOpts = {    
    			anchor: bigIconAnchor,
    	        imageSize: bigIconSize
    	    }
    	    var myIcon = new BMap.Icon(newImageUrl, bigIconSize, iconOpts);
    }else if(flag==3)
    	{
    	var newImageUrl=markerArray[index].dockb;//变小
    	var iconOpts = {    
	        anchor: smallIconAnchor,
	        imageSize: smallIconSize
	    }
	    var myIcon = new BMap.Icon(newImageUrl, smallIconSize, iconOpts); 
    	}else{
    		var newImageUrl=markerArray[index].dockB;//变大
        	var iconOpts = {    
    			anchor: bigIconAnchor,
    	        imageSize: bigIconSize
    	    }
    	    var myIcon = new BMap.Icon(newImageUrl, bigIconSize, iconOpts);
    	}
    	markerArray[index].setIcon(myIcon);
    }
}

function setPoint(){
	var url="https://gbfs.citibikenyc.com/gbfs/en/station_status.json";
	var url2="https://gbfs.citibikenyc.com/gbfs/en/station_information.json";
	//var url="../info"; // InfoServlet
	//var url2="../status"; // StatusServlet
	$.get(url,function(result){
		var station = result.data.stations;
		for(var index in station){
			var station_id = station[index].station_id;
			var nb = station[index].num_bikes_available;
			var nd = station[index].num_docks_available;
			level.set(station_id, getLevel(nb,nd));
			docklevel.set(station_id, 4-getLevel(nb,nd));
			var obj={};
			obj.nba=nb;
			obj.nda=nd;
			infoMap.set(station_id,obj);
		}
		$.get(url2,function(result){
					var stations = result.data.stations;
					for(var index in stations){
						var name = stations[index].name;
						var station_id = stations[index].station_id;
						
						var obj=infoMap.get(station_id);
						obj.name=name;
						obj.shortName=stations[index].short_name;
						
						
						var lat = stations[index].lat;
						var lon = stations[index].lon;
						var point = new BMap.Point(lon, lat);   
						var iconOpts =  { nchor: new BMap.Size(24, 50),
								imageSize:  new BMap.Size(48, 50)
							};
						var url="img/bi_"+level.get(station_id)+".png";
						var url2="img/si_"+level.get(station_id)+".png";
						var url3="img/bd_"+docklevel.get(station_id)+".png";
						var url4="img/si_"+docklevel.get(station_id)+".png";
					    var myIcon = new BMap.Icon(url, new BMap.Size(48, 50), iconOpts);
						var marker = new BMap.Marker(point, {icon: myIcon});
						
						marker.bikeB = url;
						marker.bikeb = url2;
						marker.dockB = url3;
						marker.dockb = url4;
						
						//console.log(obj.name);
						//console.log(marker.getIcon());
						//console.log(marker.bikeB+marker.bikeb+marker.dockB+marker.dockb);
						var infoWindow = getwindow(station_id);
						marker.infoWindow=infoWindow;
						marker.addEventListener("click", function(){          
							   this.openInfoWindow(this.infoWindow);
						});
					    markerArray.push(marker);
					    map.addOverlay(marker); 
					}
				});
			});

}
function getwindow(station_id){
	var obj=infoMap.get(station_id);
	var sContent="<div class='mapbox-content'>"+
		"<div class='mapbox-content-top'>"+
			"<span class='window_lastUpdate'>"+ "0 ms ago "+"</span> <span"+
				"class='window_info_button'></span>"+
		"</div>"+
		"<div class='mapbox-content-header'>"+
			"<h1 class='mapbox-content-header-stationName'>"+obj.name+"</h1>"+
		"</div>"+
		"<div class='mapbox-content-detail'>"+
			"<div class='mapbox-content-detail-bikes-available'>"+
				"<span class='mapbox-content-detail-bikes-available-val'>"+ obj.nba +"</span>"+
				"<span class='mapbox-content-detail-bikes-available-lbl'>"+"Bikes"+"</span>"+
			"</div>"+
			"<div class='mapbox-content-detail-docks-available'>"+
				"<span class='mapbox-content-detail-docks-available-val'>"+obj.nda+" </span> <span"+
					"class='mapbox-content-detail-docks-available-lbl'>"+"Docks"+"</span>"+
			"</div>"+
		"</div>"+
		"<div class='mapbox-content-footer'>"+
			"<span class='mapbox-content-footer-shortName'> "+"Bike station:"+
				+obj.shortName +"</span>"+
		"</div>"+
	"</div>"
	var infoWindow=new BMap.InfoWindow(sContent);
	return infoWindow;
	
}
function getLevel(nb,nd){
	if(nb==0||(nb+nd)==0) return 0;
	var abi=nb/(nb+nd);
	if(abi<=0.1 || nb<=5) return 1;
	if(abi<=0.5) return 2;
	if(abi<1) return 3;
	if(abi==1) return 4;	 
}