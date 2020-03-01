/**
 * 
 */
function initChart(sid) {
	//
	var url = "demo2?sid=" + sid;
	$.get(url, function(result) {
		// 返回结果
		var xData = result.times;
		var yData1 = result.nbas;
		var yData2 = result.ndas;
		// 使用刚指定的配置项和数据显示图表。
		var myChart = echarts.init(document.getElementById('main'));
		// 指定图表的配置项和数据
		var option = {
			title : {
				text : '站点ID:' + sid
			},
			tooltip : {},
			legend : {
				data:['可用车数量','可用桩数量']
			},
			xAxis : {
				data : xData
			},
			yAxis : {},
			series : [ {
				name : '可用车数量',
				type : 'line',
				data : yData1
			}, {
				name : '可用桩数量',
				type : 'line',
				data : yData2
			} ]
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	});

}

var bigBikeIconArr = [];// 存放所有大图标

var smallIconArr = [];// 存放所有小图标
function initIcon() {
	for (var index = 0; index < 5; index++) {
		var iconOpts = {
			anchor : new BMap.Size(21, 50),
			imageSize : new BMap.Size(42, 50)
		}
		// 创建应用小图标的Icon对象
		var myIcon1 = new BMap.Icon("img/bi_" + index + ".png", new BMap.Size(
				42, 50), iconOpts);
		bigBikeIconArr[index] = myIcon1;

		// 声明Icon的配置，其中使用小图标对应的配置
		var iconOpts = {
			anchor : new BMap.Size(5, 10),
			imageSize : new BMap.Size(10, 10)
		}
		// 创建应用小图标的Icon对象
		var myIcon2 = new BMap.Icon("img/si_" + index + ".png", new BMap.Size(
				10, 10), iconOpts);
		smallIconArr[index] = myIcon2;
	}
}
function getBikeLeval(nba, nda) {
	if (nba == 0 || nba + nda == 0) {
		return 0;
	}
	if (nba < 8) {
		return 1;
	}
	var abi = nba / (nba + nda);
	if (abi < 0.5) {
		return 2;
	}
	if (abi < 1) {
		return 3;
	}
	if (abi == 1) {
		return 4;
	}
}

/*
 * function getMarkerInfo(name,nba,nda,short_name){ }
 */
function getInfoWindow(infoItem) {
	// console.log("1="+infoItem.nba+"12="+infoItem.nda);
	var sContent = "<div id='main'></div>";
	var infoWindow = new BMap.InfoWindow(sContent); // 创建信息窗口对象
	return infoWindow;
}

function addMarker(lon, lat, bikeLevel, infoItem) {
	var iconOpts = {
		anchor : new BMap.Size(18, 36),
		imageSize : new BMap.Size(36, 36)
	}

	var myIcon = new BMap.Icon("img/bi_" + bikeLevel + ".png", new BMap.Size(
			36, 36), iconOpts);
	// console.log(myIcon);

	var point = new BMap.Point(lon, lat);
	// 添加mark标注
	var marker = new BMap.Marker(point, {
		icon : myIcon
	});

	var infoWindow = getInfoWindow(infoItem); // 创建信息窗口对象
	marker.addEventListener("click", function() {
		initChart(infoItem.sid);
		this.openInfoWindow(infoWindow);

	});
	marker.bikeLevel = bikeLevel;
	// 将marker放入MarkerArray数组中
	markerArray.push(marker);
	// 控价配置显示在地图上
	map.addOverlay(marker);
}

function switchIcon(isBTS) {
	if (isBTS) {
		// 大变小
		for ( var index in markerArray) {
			var bikeLevel = markerArray[index].bikeLevel;

			// 将新创建的Icon对象添加到marker上，替换掉旧的Icon
			markerArray[index].setIcon(smallIconArr[bikeLevel]);
		}
	} else {// 小变大
		for ( var index in markerArray) {
			// 从marker对象上获取它对应的bikeLevel
			var bikeLevel = markerArray[index].bikeLevel;

			// 将新创建的Icon对象添加到marker上，替换掉旧的Icon
			markerArray[index].setIcon(bigBikeIconArr[bikeLevel]);

		}
	}
}
