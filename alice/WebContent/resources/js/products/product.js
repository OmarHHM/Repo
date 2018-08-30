var clonedOffice;
var officeAux;
var totalOffices;
var stock;

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
	
	// se carga los catálogos
	loadCat();

	// se llama el validator del form
	formValidator();
	
	// se clona el sub formulario de sucursales y se cargan las sucursales
	loadOffices();
	clonedOffice = $('#office').clone();
	clonedOffice.attr('id', '');
	totalOffices = $('#sucursalID > option').length;
	
	officeAux = $('#office').clone();
	officeAux.attr('id', '');
	
	// se elimina el form
	$('#main-content').find('div').remove();
	
	// se oculta el encabezado de sucursales
	$('#headerOffice').hide();
	
	// se oculta el div de stock
	$('#sucursal-content').hide();
	
	// se inhabilita el campo id
	$('#id').attr('disabled', 'disabled');
	
	// se limpia el valor de sucursales
	$('#noSucursales').val('0');
	
	// función para convertir a mayúsculas
	changeToUppercase();
	
	//oculta los botoenes de edición
	$('#btnEdit').hide();
	$('#btnDel').hide();
	
	$('#btnSave').show();
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
	
	// se limpa el formulario
	clearForm();
}

/**
 * Función que consulta los datos del producto seleccionado
 * @returns
 */
function edit() {
	// se bloquea el guardado
	$('#btnSave').hide();
	
	// se muestran las existencias
	$('#sucursal-content').show();
	
	var noProducto = $('#noProductSelec').val();
	
	// consulta los datos del producto por id
	getProductById(noProducto);
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
	
	// se oculta div de stock
	$('#sucursal-content').hide();

	// se clona nuevamente un elemento del formulalrio de sucursales
	clonedOffice = officeAux;
	
	// se limpia el valor de sucursales
	$('#noSucursales').val('0');
	
	// se limpia el valor del id de producto
	$('#idProductSelec').val('0');
	
	// oculta los botones del formulario
	$('#btnEdit').hide();
	$('#btnDel').hide();
	
	// se muestra la sección de sucursales
	$('#btnAsignOffice').closest('div').show();
	$('#main-content').show();
	
	// se habilita el boton guardar
	$('#btnSave').show();
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
	
	// se invoca la función para el evento onClick
	addEventDatatable('#datatable_tabletools tbody');
}

/**
 * Función que consulta los datos de un producto por id
 * @param id
 * @returns
 */
function getProductById(id){
	var arrSucursal = new Array();
	arrSucursal.push(1);
	
	var bean= {
			"codigoBarras":id,
			"sucursalID":arrSucursal,
			"id": 0
		}
	
	productsService.getAll(bean,function(products){
		if(products!=null){
			dwr.util.setValues(products);
			
			// obtienen las sucursales en las que fue registrado el producto
			getBranchOfficeByProduct(products.id);
		}
	});
}

/**
 * Función que obtiene el listado de sucursales por id de producto
 * @param producto
 */
function getBranchOfficeByProduct(producto){
	stock = null;
	
	// se pasa el valor del idProducto
	$('#idProductSelec').val(producto);
	
	$('#sucursalDisponible').empty()
		.append('<option selected="selected" value=""></option>');
	
	productsService.lstSucursalesProducto(producto,function(data){
		stock = data;
		console.log(stock);
		
		data.forEach(function(item) {
			$('#sucursalDisponible').append( new Option(item.observaciones, item.sucursalID) );
		});
		
		$('#sucursalDisponible').on('change', getStock);
	});
}

/**
 * Función que muestra el formulario para asignar product
 * a sucursal
 * @returns
 */
function addOffice() {
	// se carga el catálogo de sucursales
	loadOffices();
	
	// se muestra el encabezado
	$('#headerOffice').show();
	
	$('#main-content').find('div[name=sucursalID]').each(function() {
		$(this).on('change', function() {
			
		});
	});
	
	var noSucursales = parseInt( document.getElementById("noSucursales").value|0 ) + 1;
	$('#noSucursales').val(noSucursales);
	console.log(noSucursales);
	
	if( parseInt(noSucursales) <= parseInt(totalOffices) ) {
		if( clonedOffice != null ) {
			$('#main-content').append(clonedOffice)
			$('#main-content div:last').attr('name', 'office_'+noSucursales);
			clonedOffice = null;
			
		} else  {
			var ele = $('#main-content div:last').clone();
			ele.find('input').val('');
			
			var nameEle = ele.attr('name').split('_');
			var next = parseInt(nameEle[1]) + 1;
			
			ele.attr('name', 'office_'+next);
			$('#main-content').append(ele)
		}
	
	} else {
		showInfo('Se han agregado todas las sucursales disponibles', 3000);
	}
	
}

/**
 * Función que elimina el sub formulario de sucursal
 * @param element
 * @returns
 */
function deleteOffice(element) {
	var noSucursales = parseInt( document.getElementById("noSucursales").value|0 ) - 1;
	$('#noSucursales').val(noSucursales);
	
	console.log('sucursales: ' + noSucursales);	
	$(element).parent().closest('div').remove();
}

// ************************ STOCK *******************************
/**
 * Función que obtiene el número de existencias de una sucursal
 */
function getStock(obj) {
	var selected = $(this).find('option:selected').text();
	var noExistencias = null;
	
	stock.forEach(function(item) {
		if(item.observaciones == selected) {
			noExistencias = item.noExistencias;
			return false;
		}
	});
	
	console.log(selected);
	console.log(noExistencias);
	
	$('#noExistenciasSucursal').val(noExistencias);
}

/**
 * Función que actualiza el inventario por producto-sucursal
 */
function updateStock() {
	var form = $('#frmProduct');
	var formData = $(form).serializeObject();

	$.ajax({
		type: 'POST',
		dataType: 'json',
		url: CONTEXT_PATH + '/products/editStock',
		data: JSON.stringify(formData),
	    processData: false,
        contentType: "application/json",
		
        success: function(data) {
        	console.log(data);
        	
        	if(data && data.error) {
        		showSmallError(data.msj, 4000);
        		
        	} else {
        		showSmallSuccess(data.msj, 3000);
        	}
		}
	});

}

// *********** FUNCIONES GENÉRICAS ***********

//limpia los valores del formulario
function clearForm() {
	// se limpia la operacion
	$('#oper').val('');
	
	var validator = $("#frmProduct").validate();
	validator.resetForm();
	
	$('#frmProduct').find('.form-group').removeClass('has-error');
	$('#frmProduct').find('.input').removeClass('has-error');
	$('#frmProduct').find('.select').removeClass('has-error');
	
	$('#frmProduct').find('input').each(function() {
		$(this).val('');
	});
	
	$('#frmProduct').find('select').each(function() {
		$(this).prop('selectedIndex', 0);
	});
	
	// se verifica si existen campos de sucursales para quitarlos
	$('#main-content').find('div').each(function() {
		$(this).remove();
	});
	
	// elimina las opciones del combo para stock
	$('#sucursalDisponible').empty()
		.append('<option selected="selected" value=""></option>');
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
				required: true
			},
			codigoBarras: {
				required: true
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
				required:  true,
				digits: true
			},
			noExistencias: {
				digits: true
			},
			noNuevasUnidades: {
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
				digits: 'Debe ingresar un valor númerico'
			},
			clave: {
				required: 'Debe ingresar una clave'
			},
			sucursalID: {
				required: 'Debe seleccionar una Sucursal'
			},
			codigoBarras: {
				digits: 'Debe ingresar un valor númerico',
				required:'Debe de ingresar el código del producto.'
			},
			noExistencias: {
				digits: 'Debe ingresar un valor númerico'
			},
			noNuevasUnidades: {
				digits: 'Debe ingresar un valor númerico'
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


function save(oper) {
	$('#oper').val(oper);
	var form = $('#frmProduct');
	
	$('#idProductSelec').val( $('#id').val() );
	
	var formData = $(form).serializeObject(); //Serializacion como objeto
	formData = replaceData(formData);
	
	if( $("#frmProduct").valid() ) {
		$.ajax({
			type: 'POST',
			dataType: 'json',
			url: CONTEXT_PATH + '/products/editProduct',
			data: JSON.stringify(formData),
		    processData: false,
	        contentType: "application/json",
			
	        success: function(data) {
	        	console.log(data);
	        	
	        	if(data && data.error) {
	        		showError(data.msj, 4000);
	        		
	        	} else {
	        		showSuccess(data.msj, 3000);
					cancel();
	        	}
			}
		});
	}
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

/**
 * Función que construye un arreglo para los campos sucursalID y noExistencias
 * @param formData
 * @returns
 */
function replaceData(formData) {
	if( formData.sucursalID instanceof Array ) {
		formData.sucursalID.unshift(-1);
		
	} else {
		var arr = new Array();
		arr.push(formData.sucursalID);
		
		formData.sucursalID = arr;
	}
	
	if( formData.noExistencias instanceof Array ) {
		formData.noExistencias.unshift(-1);
		
	} else {
		var arr = new Array();
		arr.push(formData.noExistencias);
		
		formData.noExistencias = arr;
	}
	
	return formData;
}

/**
 * Función que agrega evento onClick a todos los tr de la tabla
 * y asigna el valor en un hidden para enviarlo
 * @param element str con el nombre del datatable
 * @returns
 */
function addEventDatatable(element) {
	$('#noProductSelec').val('');
	
	$(element).on('click', 'tr', function(e){
		var currentTr = $(this)[0];
		var td = currentTr.getElementsByTagName('td')[1];
		var numProducto = $(td).text();
		
		//manda el número de producto al hidden
		$('#noProductSelec').val(numProducto);
		
		hideTable();
		
		//muestra el formulario y habilita los botones
		$('#cntColapsarF').slideDown();
		$('#cTitF').css('display', 'block');
		$('#titF').html('Editar Producto');
		$('#titF').css('display', '');
		
		$('#main-content').prev().hide();
		$('#main-content').hide();
		
		$('#btnEdit').show();
		$('#btnDel').show();
		
		// invoca al método editar
		edit();
	});
}




