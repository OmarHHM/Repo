$(document).ready(function() {
	pageSetUp();
	loadEmployee("");
	$('input[type=search]').keyup(function(event){
			loadEmployee(event);
	});
	
	 // Al menu superior le agrego id's para poder operar con el
	 $('.jarviswidget-ctrls').css('display', 'none');

	 //El menu consta de dos elementos
	 var ctrls = $('.jarviswidget-ctrls').find("a");	 
	 //collapse
	 $(ctrls[1]).attr("id","botonCollapseTable");
	 $(ctrls[5]).attr("id","botonCollapseForm");
	 
	 // se agrega un id a la capa que contiene la tabla y se muestra
	 $('#wid-id-1').find("[role='content']").attr('id','cntColapsarT');	
	 $('#cntColapsarT').slideDown();
	 
	 // se agrega un id a la capata que contiene el formulario y se oculta
	 $('#wid-id-2').find("[role='content']").attr('id','cntColapsarF');	
	 $('#cntColapsarF').slideUp();
	 
	 // se oculta el icono del formulario
	 $('#cTitF').css('display', 'none');
	
	/* TABLETOOLS */
	var pagefunction = function() {
		$('#datatable_tabletools').dataTable({
	
			"sDom" : "<'dt-toolbar'<'col-xs-12 col-sm-6'f><'col-xs-12 col-sm-6'lT>r>t<'dt-toolbar-footer'<'#datatable_tabletools_info.col-xs-12 col-sm-6 btn-group'i><'col-xs-12 col-sm-6'p>>",

		"oLanguage": {
	        "sProcessing":     'Procesando...',
	        "sZeroRecords":    'No se encontraron resultados',
	        "sEmptyTable":     'Ningún dato disponible en esta tabla',
	        "sInfo":           'Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros',
	        "sInfoEmpty":      'Mostrando registros del 0 al 0 de un total de 0 registros',
	        "sLoadingRecords": 'Cargando...',
	        "oPaginate": {
	            "sFirst":    'Primero',
	            "sLast":     'Último',
	            "sNext":     'Siguiente',
	            "sPrevious": 'Anterior'
	        	}
    		},
    		"oTableTools": {
	        	 "aButtons": [
	                {
	                    "sExtends": "xls",
	                    "sPdfSize": "letter",
	                    "oSelectorOpts": { filter: 'applied', order: 'current' }, 
	                    "sFileName" : "empleados.xls"
	                },
	                {
	                    "sExtends": "pdf",
	                    "sTitle": 'Exportar a PDF',
	                    "sPdfMessage": 'Exportar a PDF',
	                    "sPdfSize": "letter",
	                    "oSelectorOpts": { filter: 'applied', order: 'current' }, 
	                    
	                }
	             ],
		            "sSwfPath": "/morrito/resources/js/plugin/datatables/swf/copy_csv_xls_pdf.swf"
		        }
		});
		
		// adds elements on the fotter of the datatable
		$('#datatable_tabletools_info').html(
			'<a id="btnAdd" class="btn btn-default" title="Nuevo" onclick="addEmployee() "><span><i class="fa fa-check"></i> Nuevo</span></a>'
		);
		
	};

	// load related plugins
	loadScript($('#contextpath').val() + "/resources/js/plugin/datatables/jquery.dataTables.min.js", function() {
		loadScript($('#contextpath').val() + "/resources/js/plugin/datatables/dataTables.colVis.min.js", function() {
			loadScript($('#contextpath').val() + "/resources/js/plugin/datatables/dataTables.tableTools.min.js", function() {
				loadScript($('#contextpath').val() + "/resources/js/plugin/datatables/dataTables.bootstrap.min.js", pagefunction);
			});
		});
	});
	
	// estilos para el formulario del wizard
	jQuery('fieldset[name=wizardFields]').each(function() {
		$(this).find('div.col-sm-3').addClass("wizard-col-3");
	});
	jQuery('fieldset[name=wizardFields]').each(function() {
		$(this).find('div.col-sm-4').addClass("wizard-col-4");
	});
	jQuery('fieldset[name=wizardFields]').each(function() {
		$(this).find('div.col-sm-6').addClass("wizard-col-6");
	});
	jQuery('fieldset[name=wizardFields]').each(function() {
		$(this).find('div.col-sm-9').addClass("wizard-col-9");
	});
	
	// se habilita el datepicker para los campos tipo fecha
	$('#fecha').click(function() {
		$('#ui-datepicker-div').css('z-index', '2');
	});
	
	//oculta los botoenes de edición
	$('#btnEdit').hide();
	$('#btnDel').hide();
	
	// se inicializa el wizard
	$('#frmEmployee').wizard();
	
	
	
	// se carga el catálogo de sucursales
	loadOffices();
	
	// se carga la información del datatable
	loadUsers('');
	loadPerfils();
	// función para convertir a mayúsculas
	changeToUppercase();
	
});

function addEmployee() {
	hideTable();
	
	// se muestra el formulario y se ajusta el texto
	$('#cntColapsarF').slideDown();
	$('#cTitF').css('display', 'block');
	$('#titF').html('Nuevo Empleado');
	$('#titF').css('display', '');

	$('#clave').attr("disabled",false);
	$('#numeroEmpleado').attr("disabled",false);
	$('#sucursalID').attr("disabled",false);
	
	
}

function cancel() {
	clearForm();
	// se oculta el formulario y los textos
	$('#cntColapsarF').slideUp();
	$('#cTitF').css('display', 'none');
	$('#titF').css('display', 'none');
	// se muestra la tabla y los textos
	$('#cntColapsarT').slideDown();
	$('#cTitT').css('display', 'block');
	$('#titT').css('display', '');
	// oculta los botones del formulario
	$('#btnEdit').hide();
	$('#btnDel').hide();
	$('#numeroEmpleado').attr("disabled",false);
	$('#sucursalID').attr("disabled",false);
	$('#clave').attr("disabled",false);
	loadUsers("");
}

/**
 * Crea el abjeto con el formato requerido para ser enviado por el ajax
 */
$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

/**
 * Función que agrega un nuevo empleado
 * @returns
 */
function onSubmited(oper) {
	// se establece la operación
	$('#operation').val(oper);
	
	$('#frmUser').valid();
	
	var form = $('#frmUser');
	var formData = $(form).serializeObject();
	
	$.ajax({
		type: 'POST',
		url: CONTEXT_PATH + '/administration/editUser',
		data: JSON.stringify(formData),
	    processData: false,
        contentType: "application/json",
		
		success: function(data) {
			if( data != null && data.error != null && data != undefined ) {
					showError(data.msj, 3000);		
			} else if(data != null && data != undefined) {	
				if(data.id!=null&&data.id>0){
					showSuccess(data.msj, 3000);
					cancel();
				}else{
					showError(data.msj, 3000);
					//cancel();
				}
				
			}
		}
	});
	
}

/**
 * Función que edita los datos del empleado
 * @returns
 */
function edit() {
	var noUser = $('#noUserSelec').val();
	
	// consulta los datos del empleado y llena el formulario
	getEmployeeById(noUser)
}




//función encargada de validar el paso 1 del wizard
//function basicDataValidator() {
	$('#frmUser').validate({
		rules: {
			clave: {
				required: true
			},
			password:{
				required:true,
				maxlength:8
			},
			usuario:{
				required:true
			}
		},
		
		messages: {
			clave: {
				required: 'Debe introducir una clave'
			},
			password:{
				required: "Debe de ingresar su contraseña",
				maxlength:"La Contraseña debe de ser máximo 8 caracteres"
			},
			usuario:{
				required:"Debe de ingresar el nombre de usuario"
			}
			
		}
	});

// limpia los valores del formulario
function clearForm() {
	$('#clave').val("");
	$('#usuario').val("");
	$('#password').val("");	
	$("#numeroEmpleado").val("0").change();
	$('input[type=search]').val("");
}

function loadUsers(param){
	var tds='';
	
	userService.listUser(param,function(users){
		if (users != null || !users.isEmpty()){
			dwr.util.removeAllRows('datatable_users');
			dwr.util.addRows("datatable_users",users, cellFuncs, { escapeHtml:false });
			$('input[type=search]').val("");
		}
	});
	var cellFuncs = [
		function(users) { return users.clave ; },
		function(users) {
			var nombreEmpleado="";
				if(users.nombreEmp!=null&&users.nombreEmp!=""){
					nombreEmpleado=users.nombreEmp+" "+users.apellidoPEmp+" "+users.apellidoMEmp;
				}else{
					nombreEmpleado=users.usuario;
				}
			return nombreEmpleado;
		},		
		function(users) { return users.descripcionPerfil;}
		];	
	//se invoca a la función para agregar el evento onClick
	addEventDatatable('#datatable_tabletools tbody');
}


function getEmployeeById(clave){
	var bean= {
			"id":0,
			"clave":clave
	}	
	userService.getAll(bean,function(user){
		if(user!=null){
			dwr.util.setValues(user);
		}
	});
}

/**
 * Función que agrega evento onClick a todos los tr de la tabla
 * y asigna el valor en un hidden para enviarlo
 * @param element str con el nombre del datatable
 * @returns
 */
function addEventDatatable(element) {
	$('#noUserSelec').val('');
	
	$(element).on('click', 'tr', function(e){
		var currentTr = $(this)[0];
		var td = currentTr.getElementsByTagName('td')[0];
		var numUser = $(td).text();
		
		console.log( numUser )
		
		//manda el número de empleado al hidden
		$('#noUserSelec').val(numUser);
		
		hideTable();
		
		//muestra el formulario y habilita los botones
		$('#cntColapsarF').slideDown();
		$('#cTitF').css('display', 'block');
		$('#titF').html('Editar Usuario');
		$('#titF').css('display', '');
		
		$('#btnEdit').show();
		$('#btnDel').show();
		$('#btnSave').hide();
		
	    //se oculta el resto del wizard
		$('#myWizard').hide();
		$('#titStepOne').hide();
		$('#numeroEmpleado').attr("disabled",true);
		$('#sucursalID').attr("disabled",true);

		$('#clave').attr("disabled",true);
		
		// invoca al método editar
		edit();
		
	});
}

function hideTable() {
	// se colapsa la tabla y se oculta el titulo
	$('#cntColapsarT').slideUp();
	$('#cTitT').css('display', 'none');
	$('#titT').css('display', 'none');
}

function loadPerfils() {
	userService.comboPerfil("", function(data){
		dwr.util.addOptions("perfilID", data, "id","nombre");
	});
}

function loadEmployee(param){
	employeeService.listEmployee(param,function(emp){
		if (emp != null || !emp.isEmpty()){
			dwr.util.removeAllOptions('numeroEmpleado'); 
			dwr.util.addOptions('numeroEmpleado',{'0':'SELECCIONAR'});
			dwr.util.addOptions("numeroEmpleado", emp, "numeroEmpleado","nombre");
			$("#numeroEmpleado").val("0").change();
		}
	});
		
}


