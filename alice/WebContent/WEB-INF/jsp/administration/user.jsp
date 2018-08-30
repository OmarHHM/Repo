<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<i class="fa-fw fa fa-th"></i>Usuarios
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
				<header>
					<div id="cTitT">
						<span class="widget-icon widget-icon-margin">
							<i class="fa fa-table"></i>
						</span>
						<h2 id="titT">Usuarios</h2>
					</div>
				</header>
				<div>
					<div class="jarviswidget-editbox">
					</div>					
					<div class="widget-body no-padding">
						<table id="datatable_tabletools" class="table table-striped table-hover">
							<thead>
								<tr>
									<th>Clave</th>
									<th>Nombre</th>
									<th>Perfil</th>
								</tr>
							</thead>
							<tbody id="datatable_users">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</article>
	</div>
		<div class="row">
		<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="jarviswidget jarviswidget-color-blueDark" id="wid-id-2" data-widget-editbutton="false" data-widget-deletebutton="false" data-widget-togglebutton="false">
				<header>
					<div id="cTitF">
						<span class="widget-icon widget-icon-margin">
							<i class="fa fa-edit"></i>
						</span>
						<h2 id="titF">Usuarios</h2>
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
					
						<form id="frmUser" class="smart-form cmxform" method="POST"  target="content">
							<input id="operation" name="operation" type="hidden" value=""/>
							<input id="noUserSelec" name="noUserSelec" type="hidden" value=""/>
							
							<header>
								Datos del Usuario
							</header>
							
							<fieldset>		
								<section class="col col-12 form-group">
									<div class="row" style="display:none";>
										<section  class="col col-3 form-group">
											<label class="control-label">No. de Usuario</label>
											<label class="input"><i class="icon-append fa fa-key"></i> 
												<input id="id" name="id" class="form-control"  type="text">
											</label>
										</section>
									</div>
									<div class="row">
										<section class="col col-3 form-group">
											<label class="label">Clave</label>
											<label class="input"><i class="icon-append fa fa-slack"></i> 
												<input id="clave" name="clave" class="form-control" type="text" maxlength="15" required >
											</label>
										</section>
										<section class="col col-4 form-group">
											<label class="label">Nombre</label>
											<label class="input"><i class="icon-append fa fa-edit"></i> 
												<input id="usuario" name="usuario"  style="text-transform:uppercase;" class="form-control" type="text" maxlength="50" required >
											</label>
										</section>
										<section class="col col-4 form-group">
											<label class="label">Contraseña</label>
											<label class="input"><i class="icon-append glyphicon glyphicon-asterisk"></i> 
												<input id="password" name="password" class="form-control" type="password" maxlength="8" required>
											</label>
										</section>
									</div>
									
									<div class="row">
										<section class="col col-3 form-group">
											<label class="label">Perfil</label>
											<label class="select">
												<select id="perfilID"  name="perfilID" class="form-control">
												</select>
												<i></i>
											</label>
										</section>
										<section class="col col-4 form-group">
											<label class="label">Empleado</label>
											<label class="select">
												<select  id="numeroEmpleado" name="numeroEmpleado" style="width:100%" class="select2" >
												</select> 
											</label>
										</section>
										<section class="col col-3 form-group">
											<label class="label">Sucursal</label>
											<label class="select">
												<select id="sucursalID"  name="sucursalID" class="form-control">
												</select>
											</label>
										</section>
									</div>	
								</section>
							</fieldset>
							
							<footer>
								<button type="button" class="btn btn-primary"  id="btnSave" onclick="onSubmited('add')"><i class="fa fa-save"></i>&nbsp;&nbsp; Guardar</button>
								<button type="button" class="btn btn-primary"  id="btnEdit" onclick="onSubmited('edit')"><i class="glyphicon glyphicon-floppy-saved"></i>&nbsp;&nbsp; Modificar</button>
								<button type="button" class="btn btn-primary"  id="btnDel" onclick="onSubmited('del')"><i class="glyphicon glyphicon-floppy-remove"></i>&nbsp;&nbsp; Eliminar</button>
								<button type="button" class="btn btn-default" onclick="cancel()" id="btnCancelar"><i class="fa fa-times"></i>&nbsp;&nbsp; Cancelar</button>
							</footer>
 					</form>
					</div>
										
					<div id="cajaLista" style="display: none;">
						<div id="elementoLista">		
								<table id="tablaLista">
									<tr>
										<td>No.Empleado</td>
										<td>Nombre</td>
									</tr>
									<tbody id="datatable_emp">
									</tbody>
								</table>
						</div>
					</div>					<!-- end widget content -->

				</div>
				<!-- end widget div -->
			</div>
			<!-- end widget -->
		</article>
	</div>
</section>
<!-- end widget grid -->
<!--  
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/employeeService.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/userService.js"></script>-->
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/multi-select.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugin/multi-select/jquery.multi-select.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/administration/user.js"></script>

