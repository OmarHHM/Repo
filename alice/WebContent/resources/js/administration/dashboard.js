
$(document).ready(function() {
//	//Carga las graficas
//	window.onload = showDashboard();
//	
//	
//	function showDashboard(){
//		loadSale();
//		loadProducts();
//		loadExpenses();
//		loadIncomes();
//	}
//	
//	function loadSale(){
//		var chart = new CanvasJS.Chart("ventas", {
//			animationEnabled: true,
//		   backgroundColor:"#F8F9F9" ,	
//		   title:{
//		        text: "Ventas", 
//		        fontWeight: "normal",
//		        fontColor: "#008B8B",
//		        fontFamily: "tahoma",              
//		        fontSize: 20,
//		        padding: 10        
//		      },
//		      /*
//		    axisY:{
//		    	valueFormatString: "$###,###,###,#0", 
//		    },*/
//			data: [{
//			    bevelEnabled: true,
//			    type: "column",
//				
//			    dataPoints: [
//					{ y: 23000, label: "Enero" },
//					{ y: 45000, label: "Febrero" },
//					{ y: 65738, label: "Marzo" },
//					{ y: 1982, label: "Abril"},
//					{ y: 19000, label: "Mayo"},
//					{ y: 198000, label: "Junio"},
//					{ y: 28789, label: "Julio"},
//					{ y: 50000, label: "Agosto"},
//					{ y: 60000, label: "Septiembre"},
//					{ y: 7892, label: "Octubre"},
//					{ y: 180000, label: "Nobiembre"},
//					{ y: 10298, label: "Diciembre"}
//				]
//			}]
//		});
//		chart.render();
//	}
//	
//	
//	function loadProducts(){
//		var chartp = new CanvasJS.Chart("productos", {
//			exportEnabled: true,
//			animationEnabled: true,
//  		    backgroundColor:"#F8F9F9" ,	
//			title:{
//				  text: "Mejores Productos", 
//			        fontWeight: "normal",
//			        fontColor: "#008B8B",
//			        fontFamily: "tahoma",              
//			        fontSize: 20,
//			        padding: 10        
//			},
//			data: [
//			       {
//			         type: "bar",
//			         showInLegend: true,
//			         legendText: "LLANTAS-I-LINK MEDIDAS(225 70 15C)",
//			         color: "gold",
//			         dataPoints: [
//			         { y: 198, label: "Nissan"},
//			         { y: 201, label: "Chevrolet"},
//			         { y: 202, label: "Ford"},
//			         { y: 236, label: "Ferrari"},
//			         { y: 395, label: "Corvet"},
//			         { y: 957, label: "Audi"}
//			         ]
//			       },
//			       {
//			         type: "bar",
//			         showInLegend: true,
//			         legendText: "BATERIA DE CHEVROLET, FORD, NISSAN",
//			         color: "red",
//			         dataPoints: [
//                     { y: 166, label: "Nissan"},
// 			         { y: 144, label: "Chevrolet"},
// 			         { y: 223, label: "Ford"},
// 			         { y: 272, label: "Ferrari"},
// 			         { y: 319, label: "Corvet"},
// 			         { y: 759, label: "Audi"}             
//			         ]
//			       },
//			       {
//			         type: "bar",
//			         showInLegend: true,
//			         legendText: "SUSPENSION BRAZO AUXILIAR",
//			         color: "blue",
//			         dataPoints: [
//                     { y: 185, label: "Nissan"},
//  			         { y: 128, label: "Chevrolet"},
//  			         { y: 246, label: "Ford"},
//  			         { y: 272, label: "Ferrari"},
//  			         { y: 296, label: "Corvet"},
//  			         { y: 666, label: "Audi"}                 
//			         ]
//			       },
//			       {
//				         type: "bar",
//				         showInLegend: true,
//				         legendText: "ACEITE MULTIGRADO PARA MOTORES A GASOLINA ",
//				         color: "#F5B041",
//				         dataPoints: [
//				                      
//	                     { y: 185, label: "Nissan"},
//	   			         { y: 238, label: "Chevrolet"},
//	   			         { y: 111, label: "Ford"},
//	   			         { y: 245, label: "Ferrari"},
//	   			         { y: 203, label: "Corvet"},
//	   			         { y: 555, label: "Audi"}         
//				         ]
//				       }
//			       ]
//		});
//		chartp.render();
//	}
//	function loadExpenses(){
//		var chartG = new CanvasJS.Chart("gastos", {
//			animationEnabled: true,
//			backgroundColor:"#F8F9F9" ,	
//			title:{
//				text: "Gastos",
//				horizontalAlign: "left"
//			},
//			data: [{
//				type: "doughnut",
//				startAngle: 60,
//				//innerRadius: 60,
//				indexLabelFontSize: 17,
//				indexLabel: "{label} - #percent%",
//				toolTipContent: "<b>{label}:</b> {y} (#percent%)",
//				dataPoints: [
//					{ y: 200, label: "Enero" },
//					{ y: 1000, label: "Febrero" },
//					{ y: 100, label: "Marzo" },
//					{ y: 2, label: "Abril"},
//					{ y: 89, label: "Mayo"},
//					{ y: 12, label: "Junio"}
//				]
//			}]
//		});
//		chartG.render();
//	}
//	
//	function loadIncomes(){
//		var chartGa = new CanvasJS.Chart("ganancias", {
//			animationEnabled: true,
//			backgroundColor:"#F8F9F9" ,	
//			title:{
//				text: "Ganancias obtenidas",
//				horizontalAlign: "left"
//			},
//			data: [{
//				type: "doughnut",
//				startAngle: 60,
//				//innerRadius: 60,
//				indexLabelFontSize: 17,
//				indexLabel: "{label} - #percent%",
//				toolTipContent: "<b>{label}:</b> {y} (#percent%)",
//				dataPoints: [
//					{ y: 200, label: "Enero" },
//					{ y: 1000, label: "Febrero" },
//					{ y: 100, label: "Marzo" },
//					{ y: 2, label: "Abril"},
//					{ y: 89, label: "Mayo"},
//					{ y: 12, label: "Junio"}
//				]
//			}]
//		});
//		chartGa.render();
//	}
//	
//	
//	function explodePie (e) {
//		if(typeof (e.dataSeries.dataPoints[e.dataPointIndex].exploded) === "undefined" || !e.dataSeries.dataPoints[e.dataPointIndex].exploded) {
//			e.dataSeries.dataPoints[e.dataPointIndex].exploded = true;
//		} else {
//			e.dataSeries.dataPoints[e.dataPointIndex].exploded = false;
//		}
//		e.chartp.render();
//	}
	loadGraphs();
	
	function loadGraphs(){
	var data = [
	            { y: 'ENERO', a: 23000, b: 12000},
	            { y: 'FEBRERO', a: 12892,  b: 9828},
	            { y: 'MARZO', a: 109290,  b: 9222},
	            { y: 'ABRIL', a: 12928,  b: 1282},
	            { y: 'MAYO', a: 2939,  b: 28282},
	            { y: 'JUNIO', a: 29832,  b: 23333},
	            { y: 'JULIO', a: 328999, b:47482 },
	            { y: 'AGOSTO', a: 273892, b: 28373},
	            { y: 'SEPTIEMBRE', a: 298383, b: 28373},
	            { y: 'OCTUBRE', a: 187378, b: 28282},
	            { y: 'NOVIEMBRE', a: 160000, b: 2222},
	            { y: 'DICIEMBRE', a: 129329, b: 2222}
	            
	          ],
	          config = {
	            data: data,
	            xkey: 'y',
	            ykeys: ['a', 'b'],
	            labels: ['Total Ingresos', 'Total Egresos'],
	            fillOpacity: 0.6,
	            hideHover: 'auto',
	            behaveLikeLine: true,
	            resize: true,
	            pointFillColors:['#ffffff'],
	            pointStrokeColors: ['black'],
	            lineColors:['gray','red']
	        };
//	      config.element = 'area-chart';
//	      Morris.Area(config);
//	      config.element = 'line-chart';
//	      Morris.Line(config);
	      config.element = 'bar-chart';
	      Morris.Bar(config);
//	      config.element = 'stacked';
//	      config.stacked = true;
//	      Morris.Bar(config);
	      Morris.Donut({
	        element: 'pie-chart',
	        data: [
	          {label: "GANANCIAS", value: 50000},
	          {label: "VENTAS", value: 150000},
	          {label: "GASTOS", value: 45000},
	          {label: "TOTAL ACTIVO", value: 1100000}
	        ]
	      });
	}
});



var datetime = null,
date = null;

var update = function() {
date = moment(new Date())
datetime.html(date.format('dddd<br>MMMM Do, YYYY<br>h:mm:ss A'));
};

$(document).ready(function() {
	datetime = $('#datetime')
	update();
	setInterval(update, 1000);
});
