<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<i class="fa-fw fa fa-th"></i>Productos
		</h1>
	</div>
</div>

<!-- widget grid -->
<section id="widget-grid" class="">
	<input type="hidden" id="contextpath" value="${pageContext.request.contextPath}">
	
	<!-- row -->
	<div class="row" >
		<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="jarviswidget jarviswidget-color-blueDark" id="wid-id-1" data-widget-editbutton="false" data-widget-deletebutton="false" data-widget-togglebutton="false">
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
						<h2 id="titT">Productos</h2>
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
									<th>Clave</th>
									<th>C&oacute;digo</th>
									<th>Nombre</th>
									<th>Precio unitario</th>
									<th>Precio mayoreo</th>
									<th>Existencias</th>
								</tr>
							</thead>
							<tbody id="datatable_product">
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
			<div class="jarviswidget jarviswidget-color-blueDark" id="wid-id-2" data-widget-editbutton="false" data-widget-deletebutton="false" data-widget-togglebutton="false">
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
						<h2 id="titF">Productos</h2>
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
								Datos del producto
							</header>
							
							<fieldset>		
								<section class="col col-12 form-group">
									<div class="row">
										<section class="col col-4 form-group">
											<label class="label">No. de Producto</label>
											<label class="input"><i class="icon-append fa fa-slack"></i> 
												<input id="id" name="id" class="form-control" type="text" maxlength="30" >
											</label>
										</section>
										<section class="col col-4 form-group">
											<label class="label">Clave</label>
											<label class="input"><i class="icon-append fa fa-key"></i> 
												<input id="clave" name="clave" class="form-control" type="text" maxlength="100" >
											</label>
										</section>
										<section class="col col-4 form-group">
											<label class="label">C&oacute;digo</label>
											<label class="input"><i class="icon-append fa fa-barcode"></i> 
												<input id="codigoBarras" name="codigoBarras" class="form-control" type="text" maxlength="50" >
											</label>
										</section>
									</div>
								
									<div class="row">
										<section class="col col-6 form-group">
											<label class="label">Nombre</label>
											<label class="input"><i class="icon-append fa fa-pencil"></i> 
												<input id="nombre" name="nombre" class="form-control" type="text" maxlength="60" >
											</label>
										</section>
										<section class="col col-6 form-group">
											<label class="label">Descripci&oacute;n</label>
											<label class="input"><i class="icon-append fa fa-comment-o"></i> 
												<input id="descripcion" name="descripcion" class="form-control" type="text" maxlength="50" >
											</label>
										</section>
									</div>
									
									<div class="row">
										<section class="col col-3 form-group">
											<label class="label">Costo</label>
											<label class="input"><i class="icon-append fa fa-money"></i> 
												<input id="costo" name="costo" class="form-control" type="text" maxlength="100" >
											</label>
										</section>
										<section class="col col-3 form-group">
											<label class="label">Precio unitario</label>
											<label class="input"><i class="icon-append fa fa-money"></i> 
												<input id="precioUnitario" name="precioUnitario" class="form-control" type="text" maxlength="30" >
											</label>
										</section>
										<section class="col col-3 form-group">
											<label class="label">Precio mayoreo</label>
											<label class="input"><i class="icon-append fa fa-money"></i> 
												<input id="precioMayoreo" name="precioMayoreo" class="form-control" type="text" maxlength="30" >
											</label>
										</section>
										<section class="col col-3 form-group">
											<label class="label">Descuento</label>
											<label class="input"><i class="icon-append fa fa-money"></i> 
												<input id="descuento" name="descuento" class="form-control" type="text" maxlength="30" >
											</label>
										</section>
									</div>
									
									<div class="row">
										<section class="col col-3 form-group">
											<label class="label">Unidad de Medida</label>
											<label class="select">
												<select id="catUnidadesID"  name="catUnidadesID" class="form-control">
													<option value="" selected="selected"></option>
												</select>
												<i></i>
											</label>
										</section>
										<section class="col col-3 form-group">
											<label class="label">Marca</label>
											<label class="select">
												<select id="catMarcasID"  name="catMarcasID" class="form-control">
													<option value="" selected="selected"></option>
												</select>
												<i></i>
											</label>
										</section>
										<section class="col col-3 form-group">
											<label class="label">Clasificaci&oacute;n</label>
											<label class="select">
												<select id="clasificacionId"  name="clasificacionId" class="form-control">
													<option value="" selected="selected"></option>
												</select>
												<i></i>
											</label>
										</section>
									</div>
									
									<!-- SUCURSALES -->
									<div class="row">
										<section class="col col-3 form-group">
											<button type="button" id="btnAsignOffice" name="btnAsignOffice" style="padding:5px 7px;" class="btn bg-color-teal txt-color-white" onclick="showOfficeForm()">
												<i class="fa fa-arrow-right"></i>&nbsp;&nbsp; Asignar a Sucursal
											</button>
										</section>
									</div>
									
									<header id="headerOffice" class="offices">
										Sucursales
									</header>
									
									<div name="office_1" class="row">
										<section class="col col-3 form-group">
											<label class="label">Sucursal</label>
											<label class="select">
												<select id="sucursalID"  name="sucursalID" class="form-control">
													<option value="" selected="selected"></option>
												</select>
												<i></i>
											</label>
										</section>
										<section class="col col-3 form-group">
											<label class="label">No. Existencias</label>
											<label class="input"><i class="icon-append fa fa-th"></i> 
												<input id="noExistencias" name="noExistencias" class="form-control" type="text" maxlength="100" >
											</label>
										</section>
									</div>
									
								</section>
							</fieldset>
							
							<footer>
								<button type="button" class="btn btn-primary"  id="btnSave" onclick="onSubmited('add')"><i class="fa fa-save"></i>&nbsp;&nbsp; Guardar</button>
								<button type="button" class="btn btn-default" onclick="cancel()" id="btnCancelar"><i class="fa fa-times"></i>&nbsp;&nbsp; Cancelar</button>
							</footer>
<!-- 							<footer> -->
<!-- 								<button id="botonform" class="btn btn-primary" type="submit"><i class="fa fa-save"></i> Guardar</button> -->
<!-- 								<button class="btn btn-default" type="button" ><i class="fa fa-times"></i> Cancelar</button> -->
<!-- 							</footer> -->
						</form>
					</div>
					
						<div id="message"></div>
					<!-- end widget content -->

				</div>
				<!-- end widget div -->
			</div>
			<!-- end widget -->
		</article>
	</div>
</section>
<!-- end widget grid -->
<!--  
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/productsService.js"></script>-->
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/multi-select.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugin/multi-select/jquery.multi-select.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/products/product.js"></script>

