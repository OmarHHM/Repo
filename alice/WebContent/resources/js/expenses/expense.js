$(document).ready(function() {
	pageSetUp();

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
	listProducts();
	
	// se carga el catálogo de sucursales
	loadOffices();
	
	// se carga los catálogos
	loadCat();
	/*
	$('#clave').blur(function(){
		getAll($('#clave').val());
	});*/
	
	// se llama el validator del form
	formValidator();
	
	// se oculta el header y el form de sucursales
	$('#headerOffice').hide();
	$('div [name=office_1]').hide();
	
	// se inhabilita el campo id
	$('#id').attr('disabled', 'disabled');

});

/**
 * Eventos para mostrar el formulario
 * @returns
 */
function addProduct() {
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
 * Función encargada de consultar catalogos
 * @returns
 */
function loadCat() {
	productsService.comboBoxCat(1, function(data){
		dwr.util.addOptions("catMarcasID", data, "id","nombre");
	});

	productsService.comboBoxCat(2, function(data){
		dwr.util.addOptions("catUnidadesID", data, "id","nombre");
	});

	productsService.comboBoxCat(3, function(data){
		dwr.util.addOptions("clasificacionId", data, "id","nombre");
	});
}

/**
 * Función encargada de poblar el datatable
 * @returns
 */
function listProducts(){	
	var tds='';
	
	productsService.listProducts("",1,function(products){
		if (products != null || !products.isEmpty()){
			dwr.util.addRows("datatable_product",products, cellFuncs, { escapeHtml:false });
		}
	});
	var cellFuncs = [
		function(products) { return products.clave ; },
		function(products) { return products.codigoBarras;},
		function(products) { return products.nombre;},
		function(products) { return products.precioUnitario;},
		function(products) { return products.precioMayoreo;},
		function(products) { return products.cantidad;}
		];		
}

function getAll(id){
	var bean= {
			"codigoBarras":id,
			"sucursalID":1
	}	
	productsService.getAll(bean,function(products){
		if(products!=null){
			dwr.util.setValues(products);
		}
	});
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
	var validator = $("#frmProduct").validate();
	validator.resetForm();
	
	$('#frmProduct').find('.form-group').removeClass('has-error');
	$('#frmProduct').find('.input').removeClass('has-error');
	$('#frmProduct').find('.select').removeClass('has-error');
}


function hideTable() {
	// se colapsa la tabla y se oculta el titulo
	$('#cntColapsarT').slideUp();
	$('#cTitT').css('display', 'none');
	$('#titT').css('display', 'none');
}

//función encargada de validar
function formValidator() {
	$('#frmProduct').validate({
		rules: {
			clave: {
				required:  function() {
					return $('#codigoBarras').val()== '';
				}
			},
			nombre: {
				required: true
			},
			costo: {
				digits: true
			},
			precioUnitario: {
				required: true,
				digits: true
			},
			precioMayoreo: {
				digits: true
			},
			descuento: {
				digits: true
			},
			sucursalID: {
				required: true
			},
			codigoBarras:{
				required:  function() {
					return $('#clave').val()== '';
				},
				digits: true
			}
		},
		
		messages: {
			nombre: {
				required: 'Debe ingresar un Nombre'
			},
			costo: {
				digits: 'Debe ingrear un valor númerico'
			},
			precioUnitario: {
				required: 'Debe ingresar el precio de venta',
				digits: 'Debe ingresar un valor númerico'
			},
			precioMayoreo: {
				digits: 'Debe ingresar un valor númerico'
			},
			descuento: {
				digits: 'Debe ingresar un valor númerio'
			},
			clave: {
				required: 'Debe ingresar una clave'
			},
			sucursalID: {
				required: 'Debe seleccionar una Sucursal'
			},
			codigoBarras: {
				number: 'Debe ingresar un valor númerico',
				required:'Debe de ingresar el código del producto.'
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
	$('#operation').val(oper);
	var form = $('#frmProduct');
	var formData = $(form).serializeObject(); //Serializacion como objeto
	
	$.ajax({
		type: 'POST',
		url: CONTEXT_PATH + '/products/editProduct',
		data: JSON.stringify(formData),
	    processData: false,
        contentType: "application/json",
		
        success: function(data) {
			if( data != null && data.error != null && data != undefined ) {
				showError(data.msj, 3000);
							
			} else if(data != null && data != undefined) {	
				showSuccess(data.msj, 3000);
				cancel();
				
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
