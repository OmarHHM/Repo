<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<i class="fa-fw fa fa-th"></i>Ventas
		</h1>
	</div>
</div>
<!-- widget grid -->
<section id="widget-grid" class="">
	<input type="hidden" id="contextpath" value="${pageContext.request.contextPath}">	
	<div class="row">
		<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="jarviswidget jarviswidget-color-blueDark" id="wid-id-2" data-widget-editbutton="false" data-widget-deletebutton="false" data-widget-togglebutton="false"
			data-widget-colorbutton="false">
				<header>
					<div id="cTitF">
						<span class="widget-icon widget-icon-margin">
							<i class="fa fa-edit"></i>
						</span>
						<h2 id="titF">Venta</h2>
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
					<div id="ventas" class="widget-body no-padding">
					
						<form id="frmSales" class="smart-form cmxform" method="POST"  target="content">
							<input id="operation" name="operation" type="hidden" value=""/>
						<!--	<input id="noProd" name="noProd" type="hidden" value=""/>
							<input id="noSucursales" name="noSucursales" type="hidden" value="" />
							-->
							<header>
								Datos de la venta
							</header>
							
							<fieldset>		
								<section class="col col-12 form-group">
									<div class="row">
										<section class="col col-4 form-group">
											<label class="label">Vendedor</label>
											<label class="input"><i class="icon-append glyphicon glyphicon-user"></i> 
												<input id="vendedor" name="vendedor" class="form-control" type="text" readOnly="readonly" >
											</label>
										</section>
										<section class="col col-4 form-group">
											<label class="label">Sucursal</label>
											<label class="input"><i class="icon-append fa fa-building"></i> 
												<input id="nombreSucursal" name="nombreSucursal" class="form-control" type="text" readOnly="readonly" >
											</label>
										</section>
									</div>
								
									<div class="row">
										<section class="col col-6 form-group">
											<label class="label">Concepto</label>
											<label class="input"><i class="icon-append fa fa-edit"></i> 
												<input id="conceptoVenta" name="conceptoVenta" class="form-control" style="text-transform:uppercase;" type="text" maxlength="100" >
											</label>
										</section>
									</div>
									
									<div class="row">
										<section class="col col-3 form-group">
											<label class="label">Cliente</label>
											<label class="input"><i class="icon-append glyphicon glyphicon-user"></i> 
												<input id="nombreCliente" style="text-transform:uppercase;" name="nombreCliente" class="form-control" type="text" maxlength="200" >
											</label>
										</section>
										
										<section class="col col-3 form-group">
											<label class="label">RFC </label>
											<label class="input"><i class="icon-append fa fa-slack"></i> 
												<input id="rfcliente" style="text-transform:uppercase;" name="rfcliente" class="form-control" type="text" maxlength="13" >
											</label>
										</section>
										<section class="col col-6 form-group">
											<label class="label">Dirección</label>
											<label class="input"><i class="icon-append glyphicon glyphicon-home"></i> 
												<input id="direccionCliente" style="text-transform:uppercase;" name="direccionCliente" class="form-control" type="text" maxlength="200" >
											</label>
										</section>
									</div>
									
									<div class="row">
										<section class="col col-3 form-group">
											<label class="label">Entrega a Domicilio</label>
											<label class="select">
												<select id="entrega"  name="entrega" class="form-control">
													<option value="N">NO</option>
													<option value="S">SI</option>
												</select>
												<i></i>
											</label>
										</section>
										<section id="dirEn" class="col col-8 form-group" style="display: none;">
											<label class="label">Dirección Entrega </label>
											<label class="input"><i class="icon-append glyphicon glyphicon-home"></i> 
												<input id="direcEntrega" style="text-transform:uppercase;"  name="direcEntrega" class="form-control" type="text" maxlength="200" >
											</label>
										</section>
									</div>
									
									
									<div class="row">
										<section class="col col-3 form-group">
											<label class="label">Teléfono Cliente</label>
											<label class="input"><i class="icon-append fa fa-phone-square"></i> 
												<input id="telefonoCliente" name="telefonoCliente" class="form-control" type="text" maxlength="10" >
											</label>
										</section>
											<section class="col col-3 form-group">
											<label class="label">Forma Pago</label>
											<label class="select">
												<select id="formaPago"  name="formaPago" class="form-control">
													<option value="E">EFECTIVO</option>
													<option value="C">CHEQUE</option>
												</select>
												<i></i>
											</label>
										</section>
									</div>
									
									<div class="row">
										<section class="col col-3 form-group">
											<label class="label">Código Producto</label>
											<label class="input"><i class="icon-append fa fa-barcode"></i> 
												<input id="codigoBarras" name="codigoBarras" class="form-control" type="text" maxlength="100" >
											</label>
										</section>
										
										<section class="col col-3 form-group">
											<label class="label">Cantidad </label>
											<label class="input"><i class="icon-append fa fa-slack"></i> 
												<input id="cantidad" name="cantidad" class="form-control" type="text" maxlength="10" >
											</label>
										</section>
										<section class="col col-3 form-group">
											<button type="button" id="buttonAdd" class="btn btn-success txt-color-white delete-office">
													<i class="fa-check"></i>&nbsp;&nbsp; Agregar Producto
											</button>
											
										<!--  
											<label></label>
											<a id="buttonAdd" class="btn btn-default btn-circle btn-lg">
											<i class="glyphicon glyphicon-plus"></i></a>		
										-->
										
										</section>							
									</div>
								
									<div class="row">
										<section class="col col-8 form-group">
											<label class="label">Comentarios</label>
											<label class="input"><i class="icon-append fa fa-comment"></i> 
												<textarea rows="3" id="comentarios" style="text-transform:uppercase;" name="comentarios" class="form-control" maxlength="200">
												</textarea>
											</label>
										</section>
								</div>
								
								<div class="row">
										<table id="datatable_tabletools" class="table table-striped table-hover">
											<thead>
												<tr>
													<th>No.Producto</th>
													<th>Descripción</th>
													<th>Cantidad</th>
													<th>Precio Unitario</th>
													<th>Descuento</th>
													<th>Importe Total</th>
												</tr>
											</thead>
											<tbody id="datatable_product">
											</tbody>
											<tfoot>
												<tr>
													<th></th>
													<th></th>
													<th></th>
													<th></th>
													<th>SubTotal</th>
													<td align="right">
														<input style="text-align:right" id="subtotal" name="subtotal" class="form-control" type="text"  size="20" readOnly="readOnly" >
													</td>
												</tr>
												<tr align="left">
													<th></th>
													<th></th>
													<th></th>
													<th></th>
													<th >IVA</th>
													<td align="right">
														<input style="text-align:right" id="importeIva" name="importeIva" class="form-control" type="text"  readOnly="readOnly"  size="20"  >
													</td>
												</tr>
												<tr align="left">
													<th></th>
													<th></th>
													<th></th>
													<th></th>
													<th>Total</th>
													<td align="right">
														<input style="text-align:right"id="importeTotal" name="importeTotal" class="form-control" type="text" readOnly="readOnly"  size="20" >
													</td>
												</tr>
											</tfoot>
										</table>
								</div>
								</section>
							</fieldset>
							
							<footer>
								<a id="ligaGenerar" href="sales/getReport" target="_blank" >  	
									<button    type="button" class="btn btn-primary"  id="print" onclick="printReport()"><i class="glyphicon glyphicon-print"></i>&nbsp;&nbsp; Imprimir</button>
								</a>
								<button type="button" class="btn btn-primary"  id="btnSave" onclick="onSubmited('add')"><i class="fa fa-save"></i>&nbsp;&nbsp; Guardar</button>
								<!-- <button type="button" class="btn btn-default" onclick="cancel()" id="btnCancelar"><i class="fa fa-times"></i>&nbsp;&nbsp; Cancelar</button>-->
								<input type="hidden" id="cantidadArticulos" name="cantidadArticulos"/>
								<input type="hidden" id="sucursalID" name="sucursalID"/>
								<input type="hidden" id="usuarioID" name="usuarioID"/>
								<input type="hidden" id="productoID" name="productoID"/>
								<input type="hidden" id="existencias" name="existencias"/>
							</footer>
						</form>
					</div>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/sales/sale.js"></script>

