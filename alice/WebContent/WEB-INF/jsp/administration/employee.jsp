<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<i class="fa-fw fa fa-th"></i>Administraci&oacute;n<span> &gt; Personal</span>
		</h1>
	</div>
</div>

<!-- widget grid -->
<section id="widget-grid" class="">
	<input type="hidden" id="contextpath" value="${pageContext.request.contextPath}">
	
	<!-- row -->
	<div class="row" >
		<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="jarviswidget jarviswidget-color-blueDark" id="wid-id-1" data-widget-colorbutton="false" data-widget-sortable="false">
				<!-- widget options:
				usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">
				data-widget-colorbutton="false"
				data-widget-editbutton="false"
				data-widget-togglebutton="false"
				data-widget-deletebutton="false"
				data-widget-fullscreenbutton="false"
				data-widget-custombutton="false"
				data-widget-collapsed="true"
				data-widget-sortable="false"
				-->
				<header>
					<div id="cTitT">
						<span class="widget-icon widget-icon-margin">
							<i class="fa fa-table"></i>
						</span>
						<h2 id="titT">Empleados</h2>
					</div>
				</header>
				
				<!-- widget div-->
				<div>
				
					<!-- widget edit box -->
					<div class="jarviswidget-editbox">
						<!-- This area used as dropdown edit box -->
					</div>
					<!-- end widget edit box -->
					
					<!-- widget content -->
					<div class="widget-body no-padding">
					
						<table id="datatable_tabletools" class="table table-striped table-hover">
							<thead>
								<tr>
									<th>No. Empleado</th>
									<th>Nombre</th>
									<th>Apellidos</th>
									<th>Email</th>
								</tr>
							</thead>
							
							<tbody id="datatable_employees">
								
							</tbody>
						</table>
						
					</div>
					<!-- end widget content -->
					
				</div>
				<!-- end widget div -->
				
			</div>
			<!-- end widget -->

		</article>
		<!-- WIDGET END -->

	</div>
	<!-- end row -->


	<!-- row -->
	<div class="row">
		<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="jarviswidget jarviswidget-color-blueDark" id="wid-id-2" data-widget-colorbutton="false"
				data-widget-sortable="false" >
				<!-- widget options:
				usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">
				data-widget-colorbutton="false"
				data-widget-editbutton="false"
				data-widget-togglebutton="false"
				data-widget-deletebutton="false"
				data-widget-fullscreenbutton="false"
				data-widget-custombutton="false"
				data-widget-collapsed="true"
				data-widget-sortable="false"
				-->
				
				<header>
					<div id="cTitF">
						<span class="widget-icon widget-icon-margin">
							<i class="fa fa-edit"></i>
						</span>
						<h2 id="titF">Empleados</h2>
					</div>
				</header>
				
				<!-- widget div-->
				<div>
					<!-- widget edit box -->
					<div class="jarviswidget-editbox">
						<!-- This area used as dropdown edit box -->

					</div>
					<!-- end widget edit box -->

					<!-- widget content -->
					<div class="widget-body fuelux">

						<div class="wizard" data-initialize="wizard" id="myWizard">
							<ul class="steps">
								<li data-target="#step1" class="active">
									<span class="badge badge-info">1</span>Paso 1<span class="chevron"></span>
								</li>
								<li data-target="#step2">
									<span class="badge">2</span>Paso 2<span class="chevron"></span>
								</li>
								<li data-target="#step3">
									<span class="badge">3</span>Paso 3<span class="chevron"></span>
								</li>
							</ul>
							<div class="actions">
								<button id="prev" type="button" class="btn btn-sm btn-primary btn-prev" onclick="previous()">
									<i class="fa fa-arrow-left"></i>Anterior
								</button>
								<button id="next" type="button" class="btn btn-sm btn-success btn-next" data-last="Terminar" onclick="next()">
									Siguiente<i class="fa fa-arrow-right"></i>
								</button>
							</div>
						</div>
						<div class="step-content">
							<form id="frmEmployee" class="form-horizontal" method="post" action="">
								<input id="oper" name="oper" type="hidden" value=""/>
								<input id="noEmpSelec" name="noEmpSelec" type="hidden" value=""/>
							
								<!-- PASO 1 -->
								<div class="step-pane active" id="step1">
									<h3 id="titStepOne"><strong>Paso 1 </strong> - Datos del empleado</h3>
									<jsp:include page="employeeBasicData.jsp"></jsp:include>
								</div>
								
								<!-- PASO 2 -->
								<div class="step-pane" id="step2">
									<h3><strong>Paso 2 </strong> - Direcci&oacute;n</h3>
									<jsp:include page="employeeAddress.jsp"></jsp:include>
								</div>

								<!-- PASO 3 -->
								<div class="step-pane" id="step3">
									<h3><strong>Paso 3 </strong> - Personas de contacto</h3>
									<jsp:include page="employeeContact.jsp"></jsp:include>
								</div>
								
								<footer>
									<button id="btnCancel" class="btn btn-info employee-btn-cancel" type="button" onclick="cancel()"><i class="fa fa-reply"></i> Cancelar</button>
									<button id="btnDel" class="btn btn-info employee-btn-cancel" type="button" onclick="save('del')"><i class="fa fa-times"></i> Eliminar</button>
									<button id="btnEdit" class="btn btn-info employee-btn-cancel" type="button" onclick="save('edit')"><i class="fa fa-pencil"></i> Editar</button>
								</footer>
							</form>
						</div>

					</div>
					<!-- end widget content -->

				</div>
				<!-- end widget div -->
				
			</div>
			<!-- end widget -->
		</article>
	</div>

</section>
<!-- end widget grid -->

<!--  <script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/employeeService.js"></script>-->
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/multi-select.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugin/multi-select/jquery.multi-select.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/administration/employee.js"></script>

