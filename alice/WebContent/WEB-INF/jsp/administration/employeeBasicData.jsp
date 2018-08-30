<fieldset name="wizardFields">
	<div class="col-sm-12">
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">No. de empleado</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-key"></i></span>
					<input id="numeroEmpleado" name="numeroEmpleado" class="form-control" readonly="readonly" type="text" maxlength="30" >
				</div>
			</section>
		</div>
	</div>
	
	<div class="col-sm-12">
		<div class="col-sm-4">
			<section class="form-group">
				<label class="control-label">Nombre(s)</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-user"></i></span>
					<input id="nombre" name="nombre" style="text-transform:uppercase;" text-style="upper" class="form-control" type="text" required maxlength="50" >
				</div>
			</section>
		</div>
		<div class="col-sm-4">
			<section class="form-group">
				<label class="control-label">Apellido Paterno</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-user"></i></span>
					<input id="apellidoPaterno" name="apellidoPaterno" style="text-transform:uppercase;" text-style="upper" class="form-control" type="text" required maxlength="100" >
				</div>
			</section>
		</div>
		<div class="col-sm-4">
			<section class="form-group">
				<label class="control-label">Apellido Materno</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-user"></i></span>
					<input id="apellidoMaterno" name="apellidoMaterno" style="text-transform:uppercase;" text-style="upper" class="form-control" type="text" maxlength="100" >
				</div>
			</section>
		</div>
	</div>
	
	<div class="col-sm-12">
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">Fecha de Nacimiento</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-calendar"></i></span>
					<input id="fechaNacimiento" name="fechaNacimiento" class="form-control datepicker" placeholder="" type="text" maxlength="20" data-dateformat="dd/mm/yy">
				</div>
			</section>
		</div>
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">NSS</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-medkit"></i></span>
					<input id="nss" name="nss" class="form-control" maxlength="20" >
				</div>
			</section>
		</div>
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">CURP</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-pencil"></i></span>
					<input id="curp" name="curp" class="form-control" style="text-transform:uppercase;" type="text" maxlength="20" >
				</div>
			</section>
		</div>
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">RFC</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-pencil"></i></span>
					<input id="rfc" name="rfc" class="form-control" style="text-transform:uppercase;"type="text" maxlength="13" >
				</div>
			</section>
		</div>
	</div>
	
	<div class="col-sm-12">
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">Tipo persona</label>
				<div class="input-group">
					<label class="select">
						<select id="tipoPersona"  name="tipoPersona" class="form-control">
						   	<option value="F">${F}</option>
                           	<option value="M">${M}</option>
						</select>
						<i></i>
					</label>
				</div>
			</section>
		</div>
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">Fecha de ingreso</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-calendar"></i></span>
					<input id="fchIngreso" name="fchIngreso" class="form-control datepicker" placeholder="" type="text" required maxlength="20" data-dateformat="dd/mm/yy">
				</div>
			</section>
		</div>
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">Correo electr&oacute;nico</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-envelope-o"></i></span>
					<input id="email" name="email" class="form-control" style="text-transform:uppercase;" type="email" maxlength="50">
				</div>
			</section>
		</div>
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">Sucursal</label>
				<div class="input-group">
					<label class="select">
						<select id="sucursalID"  name="sucursalID" required class="form-control">
						</select>
						<i></i>
					</label>
				</div>
			</section>
		</div>
	</div>
	
	<div class="col-sm-12">
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">Tel&eacute;fono Casa</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-phone"></i></span>
					<input id="telefonoCasaEmp" name="telefonoCasaEmp"class="form-control" type="text" maxlength="10" >
				</div>
			</section>
		</div>
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">Tel&eacute;fono Celular</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-mobile-phone"></i></span>
					<input id="telefonoCelEmp" name="telefonoCelEmp" class="form-control" type="text" min="0" maxlength="10">
				</div>
			</section>
		</div>
	</div>
</fieldset>