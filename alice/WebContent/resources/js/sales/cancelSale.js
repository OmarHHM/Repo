$(document).ready(function() {
	pageSetUp();
add();
	// Al menu superior le agrego id's para poder operar con el
	$('.jarviswidget-ctrls').css('display', 'none');

	//El menu consta de dos elementos
	var ctrls = $('.jarviswidget-ctrls').find("a");	 
	//collapse
	$(ctrls[1]).attr("id","botonCollapseTable");
	$(ctrls[5]).attr("id","botonCollapseForm");
	 
	// se agrega un id a la capa que contiene la tabla y se muestra
	$('#wid-id-1').find("[role='content']").attr('id','cntColapsarT');	
	$('#cntColapsarT').slideUp();
	 
	// se agrega un id a la capata que contiene el formulario y se oculta
	$('#wid-id-2').find("[role='content']").attr('id','cntColapsarF');	
	//$('#cntColapsarF').slideUp();
	 
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
	                    "sFileName" : "productos.xls"
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
			'<a id="btnAdd" class="btn btn-default" title="Nuevo" onclick="addProduct() "><span><i class="fa fa-check"></i> Nuevo</span></a>'
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
	
	// se carga el listado de productos
//	listProducts();
	
	// se carga el catálogo de sucursales
//	loadOffices();
	
	// se carga los catálogos
//	loadCat();
	/*
	$('#clave').blur(function(){
		getAll($('#clave').val());
	});*/
	
	// se llama el validator del form
	formValidator();
	
	// se oculta el header y el form de sucursales
	$('#headerOffice').hide();
	$('div [name=office_1]').hide();
	
	
});

/**
 * Eventos para mostrar el formulario
 * @returns
 */

function add() {
	hideTable();	
	// se muestra el formulario y se ajusta el texto
	$('#cntColapsarF').slideDown();
	$('#cTitF').css('display', 'block');
	$('#titF').html('Nuevo Producto');
	$('#titF').css('display', '');
	
	// se oculta el form de sucursales
	$('#headerOffice').hide();
	$('div [name=office_1]').hide();
}

/**
 * Función que oculta el form y muestra el datatable
 * @returns
 */
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
	
	// se oculta el formulario de sucursales
	$('#headerOffice').hide();
	$('div [name=office_1]').hide();
	
	// oculta los botones del formulario
//	$('#btnEdit').hide();
//	$('#btnDel').hide();
}


/**
 * 
 * @returns
 */
function showOfficeForm() {
	// se muestra el formulario de sucursales
	$('#headerOffice').show();
	$('div [name=office_1]').show();
}


// *********** FUNCIONES GENÉRICAS ***********

//limpia los valores del formulario
function clearForm() {
	var validator = $("#frmSale").validate();
	validator.resetForm();
	
	$('#frmSale').find('.form-group').removeClass('has-error');
	$('#frmSale').find('.input').removeClass('has-error');
	$('#frmSale').find('.select').removeClass('has-error');
}


function hideTable() {
	// se colapsa la tabla y se oculta el titulo
	$('#cntColapsarT').slideUp();
	$('#cTitT').css('display', 'none');
	$('#titT').css('display', 'none');
}

//función encargada de validar
function formValidator() {
	$('#frmSale').validate({
		rules: {
			id: {
				required: true
			}
		},
		
		messages: {
			id: {
				required: 'Debe ingresar folio de venta'
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


function onSubmited(oper) {
	$('#operation').val("");
	var form = $('#frmSale');
	var formData = $(form).serializeObject(); //Serializacion como objeto
	
	$.ajax({
		type: 'POST',
		url: CONTEXT_PATH + '/sales/cancelSale',
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
					showSuccess(data.msj, 3000);				
			}
		}
	});
	
}

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
