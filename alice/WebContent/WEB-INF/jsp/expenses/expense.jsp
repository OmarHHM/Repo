<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<i class="fa-fw fa fa-th"></i>Gastos
		</h1>
	</div>
</div>

<!-- widget grid -->
<section id="widget-grid" class="">
	<input type="hidden" id="contextpath" value="${pageContext.request.contextPath}">



	<!-- row -->
	<div class="row">
		<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="jarviswidget jarviswidget-color-blueDark" id="wid-id-2" data-widget-editbutton="false" data-widget-deletebutton="false" data-widget-togglebutton="false">
			
				<header>
					<div id="cTitF">
						<span class="widget-icon widget-icon-margin">
							<i class="fa fa-edit"></i>
						</span>
						<h2 id="titF">Alta de Gasto</h2>
					</div>
				</header>
				
				<!-- widget div-->
				<div role="content">
				
					<!-- widget edit box -->
					<div class="jarviswidget-editbox">
						<!-- This area used as dropdown edit box -->
					</div>
					<!-- end widget edit box -->
				
					<!-- widget content -->
					<div id="productos" class="widget-body no-padding">
					
						<form id="frmProduct" class="smart-form cmxform" method="POST"  target="content">
							<input id="operation" name="operation" type="hidden" value=""/>
							<input id="noProd" name="noProd" type="hidden" value=""/>
							<input id="noSucursales" name="noSucursales" type="hidden" value="" />
							
							<header>
								Datos del Gasto
							</header>
							
							<fieldset>		
								<section class="col col-12 form-group">
									<div class="row">
										<section class="col col-4 form-group">
											<label class="label">Concepto</label>
											<label class="input"><i class="icon-append fa fa-slack"></i> 
												<input id="concepto" name="concepto" class="form-control" type="text" maxlength="30" >
											</label>
										</section>
										<section class="col col-6 form-group">
											<label class="label">Descripci&oacute;n</label>
											<label class="input"><i class="icon-append fa fa-slack"></i> 
												<input id="descripcion" name="descripcion" class="form-control" type="text" maxlength="100" >
											</label>
										</section>
									</div>
									<div class="row">
										<section class="col col-4 form-group">
											<label class="label">Monto</label>
											<label class="input"><i class="icon-append fa fa-slack"></i> 
												<input id="monto" name="monto" class="form-control" type="text" maxlength="50" >
											</label>
										</section>
										<section class="col col-4 form-group">
											<label class="label">Fecha del Gasto</label>
											<label class="input"><i class="icon-append fa fa-calendar"></i> 
												<input id="fechaAlta" name="fechaAlta" class="form-control datepicker" placeholder="" type="text" maxlength="20" data-dateformat="dd/mm/yy">
											</label>
										</section>
									</div>
								</section>
							</fieldset>
							
							<footer>
								<button type="button" class="btn btn-primary"  id="btnSave" onclick="onSubmited('add')"><i class="fa fa-save"></i>&nbsp;&nbsp; Guardar</button>
								<button type="button" class="btn btn-default" onclick="cancel()" id="btnCancelar"><i class="fa fa-times"></i>&nbsp;&nbsp; Cancelar</button>
							</footer>
						</form>
					</div>
				</div>
			</div>
		</article>
	</div>
</section>
<!-- end widget grid -->

<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/multi-select.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugin/multi-select/jquery.multi-select.js"></script>

