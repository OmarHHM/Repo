<fieldset name="wizardFields">
	<div class="col-sm-12">
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">Nombre(s)</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-user"></i></span>
					<input id="nombreContacto" name="nombreContacto" text-style="upper" class="form-control" type="text" maxlength="50" >
				</div>
			</section>
		</div>
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">Apellido Paterno</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-user"></i></span>
					<input id="apellidoPContacto" name="apellidoPContacto"  text-style="upper" class="form-control" type="text" maxlength="100" >
				</div>
			</section>
		</div>
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">Apellido Materno</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-user"></i></span>
					<input id="apellidoMContacto" name="apellidoMContacto" text-style="upper" class="form-control" type="text" maxlength="100" >
				</div>
			</section>
		</div>
		<div class="col-sm-3 ">
			<section class="form-group">
				<label class="control-label">Parentesco</label>
				<div class="input-group">
					<label class="select">
						<select id="parentesco"  name="parentesco" class="form-control select-col-sm-3">
							<option value="1">Padre</option>
							<option value="2">Madre</option>
							<option value="3">Hijo(a)</option>
							<option value="4">Esposo(a)</option>
							<option value="5">Hermano(a)</option>
							<option value="6">Amigo(a)</option>		
							<option value="7">Novio(a)</option>		
							<option value="8">Conocido</option>					
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
				<label class="control-label">Prioridad</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-flag"></i></span>
					<input id="prioridadContacto" name="prioridadContacto" class="form-control"  type="number" min="0" max="3" maxlength="1" >
				</div>
			</section>
		</div>
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">Tel&eacute;fono Casa</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-phone"></i></span>
					<input id="telContactoCasa" name="telContactoCasa" class="form-control"  maxlength="10" >
				</div>
			</section>
		</div>
		<div class="col-sm-3">
			<section class="form-group">
				<label class="control-label">Tel&eacute;fono Celular</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon-append fa fa-mobile"></i></span>
					<input id="telContactoCel" name="telContactoCel" class="form-control"  maxlength="10" >
				</div>
			</section>
		</div>
	</div>
</fieldset>