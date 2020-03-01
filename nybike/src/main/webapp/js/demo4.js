var bigBikeIconArr=[];//存放所有大图标

var smallIconArr=[];//存放所有小图标

function initChart(sid){
	// 发送AJAX请求，获取图表数据
	var url="demo2?sid="+sid;
	
	$.get(url,function(result){
		// 从返回结果中获取x轴和y轴数据
		var xData=result.times;
		var yData1=result.nbas;
		var yData2=result.ndas;
		
		// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '站点ID：'+sid
            },
            tooltip: {},
            legend: {
                data:['可用车数量','可用桩数量']
            },
            xAxis: {
                data: xData
            },
            yAxis: {},
            series: [{
                name: '可用车数量',
                type: 'line',
                data: yData1
            },{
                name: '可用桩数量',
                type: 'line',
                data: yData2
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
		
	});
}


function initIcon(){
	for(var index=0;index<5;index++){
		var iconOpts = {    
		        anchor: new BMap.Size(21, 50),
		        imageSize:new BMap.Size(42, 50)
		    }
		// 创建应用小图标的Icon对象
		var myIcon1 = new BMap.Icon("img/bd_"+index+".png"
				, new BMap.Size(42, 50), iconOpts);
		bigBikeIconArr[index]=myIcon1;
		
		// 声明Icon的配置，其中使用小图标对应的配置
		var iconOpts = {    
		        anchor: new BMap.Size(5, 10),
		        imageSize:new BMap.Size(10, 10)
		    }
		// 创建应用小图标的Icon对象
		var myIcon2 = new BMap.Icon("img/si_"+index+".png"
				, new BMap.Size(10, 10), iconOpts);
		smallIconArr[index]=myIcon2;
	}
}

function switchIcon(isBTS){
	if(isBTS){// 大图标切换小图标
		// 遍历所有的marker
		for(var index in markerArr){
			// 从marker对象上获取它对应的bikeLevel
			var bikeLevel = markerArr[index].bikeLevel;
			
			// 将新创建的Icon对象添加到marker上，替换掉旧的Icon
			markerArr[index].setIcon(smallIconArr[bikeLevel]);
		}
	}else{// 小图标切换大图标
		// 遍历所有的marker
		for(var index in markerArr){
			// 从marker对象上获取它对应的bikeLevel
			var bikeLevel = markerArr[index].bikeLevel;
			
			// 将新创建的Icon对象添加到marker上，替换掉旧的Icon
			markerArr[index].setIcon(bigBikeIconArr[bikeLevel]);
		}
	}
}



function getBikeLevel(nba,nda){
	if(nba==0||(nba+nda)==0){
		return 0;
	}
	if(nba<8) {
		return 1;
	}
	var abi=nba/(nba+nda);
	if(abi<0.5){
		return 2;
	}
	if(abi<1){
		return 3;
	}
	if(abi==1){
		return 4;
	}
}

function getInfoWindow(infoItem){
	var sContent="<div id='main'></div> ";
	// 创建信息窗口对象
	var infoWindow = new BMap.InfoWindow(sContent);

	return infoWindow;
}

function addMarker(lon,lat,bikeLevel,infoItem){
	var point = new BMap.Point(lon,lat);
	var marker = new BMap.Marker(point,{icon: bigBikeIconArr[bikeLevel]}); 
	// 将marker对应的bikeLevel添加到marker上
	marker.bikeLevel=bikeLevel;
	// 将创建好的marker对象添加到数组中
	markerArr.push(marker);
	
	// 调用方法，获取该Marker对应的infoWindow
	var infoWindow=getInfoWindow(infoItem);
	
	// 为marker添加点击事件，被点击时弹出信息窗
	marker.addEventListener("click", function(){ 
		initChart(infoItem.sid);
		this.openInfoWindow(infoWindow);
	});
	
	map.addOverlay(marker);  
}



