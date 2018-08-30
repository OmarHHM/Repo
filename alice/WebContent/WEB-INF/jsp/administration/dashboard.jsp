<!DOCTYPE HTML>
<html>
<head>

</head>

<body>

<!--  
	<table>
		<tr>
			<td ROWSPAN=4> 
				<div id="ventas" style="height: 270px; width: 100%;" ></div>
			</td>
			<td>
				<div id="gastos" style="height: 100px; width: 100%;" ></div>
			</td>
		
		<tr>	
		<tr>
			<td>
				<div id="productos" style="height: 100px; width: 100%;" ></div>
			</td>
		</tr>
		<tr>
			<td>
				<div id="ganancias" style="height: 100px; width: 100%;" ></div>
			</td>
			
		</tr>
	</table>-->
	
  <h3 class="text-primary text-center">
    DASHBOARD
  </h3>
	  <div class="row">
			
	      	<div class="col-lg-12">
				<div  class="col-sm-9 text-center"  style="height: 420px">
	    			<label class="label label-success">TOTAL DE INGRESOS Y EGRESOS</label>
	   				<div id="bar-chart" ></div>
	 			</div>
		 		<div class="col-sm-3 text-center">
		   			 <label class="label label-success">TOTAL ANUAL</label>
		   			<div id="pie-chart" ></div>
		 		</div>	
			</div>
   
	<!-- 		<div class="col-lg-3">
    	    	<div class="tile tile-img tile-time afternoon" style="height: 200px">
                	<p class="time-widget">
                    	<span class="time-widget-heading">Hoy es</span>
                        	<br>
                        <strong>
                             <span id="datetime"></span>
                        </strong>
                    </p>
                </div>
			</div>-->
  		</div>

<script src="${pageContext.request.contextPath}/resources/js/canvasjs.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/administration/dashboard.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugin/morris/moment.js"></script>

</body>
</html>