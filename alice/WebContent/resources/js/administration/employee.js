$(document).ready(function() {
	pageSetUp();
	
	$('#fchIngreso').change(function(){
		var Xfecha=$('#fchIngreso').val();
		if(esFechaValida(Xfecha)){
			if( mayor(Xfecha)){
				alert("La Fecha de Ingreso es Mayor a la Fecha Actual");
				$('#fchIngreso').val("");
			}
		}
	});
	
	$('#fechaNacimiento').change(function(){
		var Xfecha=$('#fechaNacimiento').val();
		if(esFechaValida(Xfecha)){
			if( mayor(Xfecha)){
				alert("La Fecha de nacimiento es Mayor a la Fecha Actual")	;
				$('#fechaNacimiento').val("");
				
			}
		}
	});
	
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
			// Tabletools options:
			// https://datatables.net/extensions/tabletools/button_options

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
	
	basicDataValidator();
	
	// se carga el catálogo de sucursales
	loadOffices();
	
	// se carga la información del datatable
	loadEmployee('');
	
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
	
}

function cancel() {
	// se oculta el formulario y los textos
	$('#cntColapsarF').slideUp();
	$('#cTitF').css('display', 'none');
	$('#titF').css('display', 'none');
	
	// se muestra la tabla y los textos
	$('#cntColapsarT').slideDown();
	$('#cTitT').css('display', 'block');
	$('#titT').css('display', '');
	
	// limpia los campos del formulario
	clearForm();
	
	// oculta los botones del formulario
	$('#btnEdit').hide();
	$('#btnDel').hide();
	
	// se muestra el wizard completo
	$('#myWizard').show();
	$('#titStepOne').show();
	loadEmployee("");
	$('input[type=search]').val("");
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
function save(oper) {
	// se establece la operación
	$('#oper').val(oper);
	
	var form = $('#frmEmployee');
	var formData = $(form).serializeObject();
	
	$.ajax({
		type: 'POST',
		url: CONTEXT_PATH + '/administration/editPersonnel',
		data: JSON.stringify(formData),
	    processData: false,
        contentType: "application/json",
		
		success: function(data) {
			if( data != null && data.error != null && data != undefined ) {
				if(data.id!=null&&data.id>0){
					showError(data.msj, 3000);
					cancel();
				}else{
					showError(data.msj, 3000);
				}
							
			} else if(data != null && data != undefined) {	
				if(data.id!=null&&data.id>0){
					showSuccess(data.msj, 3000);
					cancel();
				}else{
					showSuccess(data.msj, 3000);
				
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
	var noEmpleado = $('#noEmpSelec').val();
	
	// consulta los datos del empleado y llena el formulario
	getEmployeeById(noEmpleado)
}


function previous() {
	console.log('prev');
}

function next() {
	var currentStep = $('#myWizard').find('li.active');
	var currentStepName = $(currentStep).attr('data-target');
	
	console.log( currentStep );
//	alert( $(currentStep).attr('data-target') );
	
	if( currentStepName == '#step3' ) {
		console.log('FIN');
		save('add');
	}
	
	
	if( $('#frmEmployee').valid() ) {
		console.log('valid');
		
	} else {
		console.log('invalid');
		
		//se quita el estilo a todos los headers
		$('#myWizard').find('li.active').removeClass('active');
		$('#frmEmployee').find('div.active').removeClass('active');
		
		//se deja el div fallido
		$('#myWizard').find('li[data-target]')
	}
}

//función encargada de validar el paso 1 del wizard
function basicDataValidator() {
	$('#frmEmployee').validate({
		rules: {
			nombre: {
				required: true
			},
			apellidoPaterno: {
				required: true
			},
			fchIngreso: {
				required: true
			},
			sucursalID: {
				required: true
			},
			nss: {
				digits: true
			},
			email: {
				email: true
			},
			telefonoCasaEmp: {
				digits: true
			},
			telefonoCelEmp: {
				digits: true
			},
			codigoPostal: {
				digits: true
			},
			telContactoCasa: {
				digits: true
			},
			telContactoCel: {
				digits: true
			},
			fechaNacimiento:{
				required:true
			}
		},
		
		messages: {
			nombre: {
				required: 'Debe introducir un Nombre'
			},
			apellidoPaterno: {
				required: 'Debe introducir un Apellido Paterno'
			},
			fchIngreso: {
				required: 'Debe seleccionar la Fecha de ingreso'
			},
			sucursalID: {
				required: 'Debe seleccionar una Sucursal'
			},
			nss: {
				digits: 'Debe ingresar un valor númerico'
			},
			email: {
				email: 'Debe ingresar un correo'
			},
			telefonoCasaEmp: {
				digits: 'Debe ingresar un número telefónico'
			},
			telefonoCelEmp: {
				digits: 'Debe ingresar un número telefónico'
			},
			codigoPostal: {
				digits: 'Debe ingresar un valor númerico'
			},
			telContactoCasa: {
				digits: 'Debe ingresar un número telefónico'
			},
			telContactoCel: {
				digits: 'Debe ingresar un número telefónico'
			},
			fechaNacimiento:{
				required: "Seleccione la fecha de nacimiento"
			}
		},
		
		highlight : function(element) {
			$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
		},
		unhighlight : function(element) {
			$(element).closest('.form-group').removeClass('has-error');
		},
		errorElement : 'span',
		errorClass : 'help-block',
		errorPlacement : function(error, element) {
			if (element.parent('.input-group').length) {
				error.insertAfter(element.parent());
			} else {
				error.insertAfter(element);
			}
		}
	});
}

// limpia los valores del formulario
function clearForm() {
	var validator = $("#frmEmployee").validate();
	validator.resetForm();
	
	$('#frmEmployee').find('.form-group').removeClass('has-error');
	$('#frmEmployee').find('.input').removeClass('has-error');
	$('#frmEmployee').find('.select').removeClass('has-error');
	
	jQuery('fieldset[name=wizardFields]').each(function() {
		$(this).find('input').each(function() {
			$(this).val('');
		});
	});
	
	jQuery('fieldset[name=wizardFields]').each(function() {
		$(this).find('select').each(function() {
			$(this).prop('selectedIndex', 0);
		});
	});
	
	//reset wizard
	$('#myWizard').find('li.active').removeClass('active');
	$('#frmEmployee').find('div.active').removeClass('active');
	
	$('#myWizard').find('li[data-target=#step1]').addClass('active');
	$('#step1').addClass('active');
}


function loadEmployee(param){
	var tds='';
	
	employeeService.listEmployee(param,function(employees){
		if (employees != null || !employees.isEmpty()){
			dwr.util.removeAllRows('datatable_employees');
			dwr.util.addRows("datatable_employees",employees, cellFuncs, { escapeHtml:false });
			$('input[type=search]').val("");
		}
	});
	var cellFuncs = [
		function(employees) { return employees.numeroEmpleado ; },
		function(employees) { return employees.nombre;},
		function(employees) { return employees.apellidoPaterno+" "+employees.apellidoMaterno;},
		function(employees) { return employees.email;}
		];	
	
	//se invoca a la función para agregar el evento onClick
	addEventDatatable('#datatable_tabletools tbody');
}


function getEmployeeById(id){
	var bean= {
			"numeroEmpleado":id
	}	
	employeeService.getAll(bean,function(employee){
		if(employee!=null){
			dwr.util.setValues(employee);
			$('#fchIngreso').val(convertToDate("fchIngreso"));
			$('#fechaNacimiento').val(convertToDate("fechaNacimiento"));
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
	$('#noEmpSelec').val('');
	
	$(element).on('click', 'tr', function(e){
		var currentTr = $(this)[0];
		var td = currentTr.getElementsByTagName('td')[0];
		var numEmpleado = $(td).text();
		
		console.log( numEmpleado )
		
		//manda el número de empleado al hidden
		$('#noEmpSelec').val(numEmpleado);
		
		hideTable();
		
		//muestra el formulario y habilita los botones
		$('#cntColapsarF').slideDown();
		$('#cTitF').css('display', 'block');
		$('#titF').html('Editar Empleado');
		$('#titF').css('display', '');
		
		$('#btnEdit').show();
		$('#btnDel').show();
		
	    //se oculta el resto del wizard
		$('#myWizard').hide();
		$('#titStepOne').hide();
		
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



function convertToDate(id){
	if($('#'+id).val().length>10){
		$('#'+id).val($('#'+id).val().substring(0,10));
	}
	
	var newValue= $('#'+id).val().replace(/^(\d{4})-(\d{2})-(\d{2})$/g,'$3/$2/$1');
	return newValue;
}