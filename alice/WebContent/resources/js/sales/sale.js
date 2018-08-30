$(document).ready(function() {
	pageSetUp();
	
	$('#print').hide();
	$('#entrega').click(function(){
		if($('#entrega').val()=="S"){
			$('#dirEn').show();
		}else{
			$('#dirEn').hide();
		}
	});
	
	$('#entrega').blur(function(){
		if($('#entrega').val()=="S"){
			$('#dirEn').show();
		}else{
			$('#dirEn').hide();
		}
	});
	$('#buttonAdd').click(function(){
		if($('#codigoBarras').val()!=""&&$('#cantidad').val()!=""){
			addProducts($('#codigoBarras').val(),$('#cantidad').val());	
		}else{
			alert("Proporcione el código del producto y su cantidad");
		}
	});
	
	$('#vendedor').val(document.getElementById("nombreUsuario").innerHTML);
	$('#nombreSucursal').val($("#sucursal").val());
	
	$('#sucursalID').val($("#idSucursal").val());
	$('#usuarioID').val($("#idUsuario").val());
	
	
	// Al menu superior le agrego id's para poder operar con el
	$('.jarviswidget-ctrls').css('display', 'none');

	//El menu consta de dos elementos
	var ctrls = $('.jarviswidget-ctrls').find("a");	 
	//collapse
	$(ctrls[1]).attr("id","botonCollapseTable");
	$(ctrls[5]).attr("id","botonCollapseForm");
	 
	// se agrega un id a la capa que contiene la tabla y se muestra
	$('#wid-id-1').find("[role='content']").attr('id','cntColapsarT');	
//	$('#cntColapsarT').slideDown();
	 
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
		
	};

	// load related plugins
	loadScript($('#contextpath').val() + "/resources/js/plugin/datatables/jquery.dataTables.min.js", function() {
		loadScript($('#contextpath').val() + "/resources/js/plugin/datatables/dataTables.colVis.min.js", function() {
			loadScript($('#contextpath').val() + "/resources/js/plugin/datatables/dataTables.tableTools.min.js", function() {
				loadScript($('#contextpath').val() + "/resources/js/plugin/datatables/dataTables.bootstrap.min.js" /*pagefunction*/);
			});
		});
	});

	// se llama el validator del form
	formValidator();
	
	// se oculta el header y el form de sucursales
	$('#headerOffice').hide();
	$('div [name=office_1]').hide();
	
});

//function actualizaFormatoMoneda(idForma) {	
//	var jqForma = eval("'#" + idForma + "'");	
//	$(jqForma).find('input[esMoneda="true"]').each( 
//			function(){	    	
//				var child = $(this);  			
//				var jControl = eval("'#" + child.attr('id') + "'"); 
//				$(jControl).formatCurrency({positiveFormat: '%n', roundToDecimalPlace: 2});
//			});			
//}

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
/*
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
}*/

/**
 * Función encargada de poblar el datatable
 * @returns
 *//*
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
*/
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
	var validator = $("#frmSales").validate();
	validator.resetForm();
	
	$('#frmSales').find('.form-group').removeClass('has-error');
	$('#frmSales').find('.input').removeClass('has-error');
	$('#frmSales').find('.select').removeClass('has-error');
	
	$('#frmSales').find('input').each(function() {
		$(this).val('');
	});
	
	$('#frmSales').find('select').each(function() {
		$(this).prop('selectedIndex', 0);
	});
	
	$('#datatable_product').empty();
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
			importeTotal: {
				required:  true
			},
			
			importeIva: {
				required: true
			}
		},
		
		messages: {
			importeTotal: {
				required: 'Se necesita ingresar por lo menos un producto'
			},
			importeIva: {
				required: 'Se necesita ingresar por lo menos un producto'
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
	function addProducts(codigo,cantidad){
		var arrSucursal = new Array();
		arrSucursal.push($("#idSucursal").val());
		var bean={
				"codigoBarras":codigo,
				"sucursalID": arrSucursal,
				"id":0
		}
		
		productsService.getAll(bean,function(data){
			if(data!=null){
				var validacion="";
				var inventario=parseInt(validateCantidad(data.id,data.cantidad))+ parseInt(cantidad);
				if(parseInt(data.cantidad)>=parseInt(cantidad)){
						if(parseInt(data.cantidad) >= parseInt(inventario)){
						var td="";	
						td="<tr id='"+data.id+"' name='trs'>";
						td+=" <td id='productID' name='productID'>"+data.id+"</td>";
						td+=" <td>"+data.nombre+"</td>";
						td+=" <td id='existencia' name='existencia'>"+cantidad+"</td>";
						td+=" <td  style='text-align:right'>"+parseFloat(data.precioUnitario).toFixed(2)+"</td>";
						td+=" <td style='text-align:right'>"+parseFloat(data.descuento).toFixed(2)+"</td>";
						td+=" <td style='text-align:right' id='impTot'>"+parseFloat(cantidad*data.precioUnitario).toFixed(2)+"</td>";
						td+=" <td> ";
						td+=" <button type='button' name='btnDelOffice' class='btn bg-color-redLight txt-color-white delete-office' onclick= 'deleteElement(this)' >";
						td+=" <i class= 'fa fa-times'></i>&nbsp;&nbsp; Quitar";
						td+=" </button> ";
						td+=" </td> ";
						td+=" </tr>";
						$('#datatable_product').append(td);	
						$('#cantidad').val("");
						$('#codigoBarras').val("");	
						$('#comentarios').focus();	
						calcTotales();
						}else{
							alert("Existencia de producto agotado.");
						}				
				}else{
					alert("La cantidad excede a la existencia del producto. El producto solo tiene un total de: "+data.cantidad+" en existencia");
					$('#cantidad'),val("");
					$('#codigoBarras').val("");
					$('#codigoBarras').focus();
				}
			}else{
				alert("El producto proporcionado no existe");
				$('#cantidad'),val("");
				$('#codigoBarras').val("");
				$('#codigoBarras').focus();
			}
					
		});
	
	}

	function deleteElement(element) {
		$(element).parent().closest('tr').remove();
		$('#subtotal').val("0.00");
		$('#importeTotal').val("0.00");
		$('#importeIva').val("0.00");
	}

	function calcTotales(){
		var impTot=0;
		var sum=0;
		$('tr[name=trs]').each(function() {
			impTot=document.getElementById("impTot").innerHTML;
			sum= sum+parseFloat(impTot);
			$('#subtotal').val(parseFloat(sum).toFixed(2));
		//	$('#importeTotal').val(Math.round(parseFloat(sum)*1.16).toFixed(2));
		//	$('#importeIva').val(parseFloat($('#importeTotal').val())-parseFloat($('#subtotal').val()).toFixed(2));
			$('#importeTotal').val($('#subtotal').val());
			$('#importeIva').val("0.00");
		});

	}
	
	function validateCantidad(id){
		var suma=0;
		var sumatoria=0;
		$('tr[id='+"'"+id+"'"+']').each(function() {
			suma=document.getElementById("existencias").innerHTML;
			sumatoria=parseFloat(sumatoria)+parseFloat(suma);
		});
		return sumatoria;
	}
	
	function validaTabla(){
		var contador=0;
		$('tr[name=trs]').each(function() {
			contador++;
		});
		return contador;
	}
	
	function armaArray(formData){
		var arrP= new Array();
		var arrC= new Array();
		$('tr[name=trs]').each(function() {
			arrP.push(document.getElementById("productID").innerHTML);			
			arrC.push(document.getElementById("existencia").innerHTML);
			formData.productoID= arrP;
			formData.existencias=arrC;
		});
		return formData;
	}
	/*
function branch(){
	var id=userBranch;
	branchService.getBranch(id,function(data){
		$('#nombreSucursal').val(data.nombre);
	});
}*/

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

	
function onSubmited(oper) {
	$('#operation').val(oper);
	var form = $('#frmSales');
	var formData = $(form).serializeObject(); //Serializacion como objeto
	formData=armaArray(formData);
<<<<<<< HEAD

=======
	
>>>>>>> c1b13f963a7c75f20bdc61052d7df3dc63845110
	$.ajax({
		type: 'POST',
		url: CONTEXT_PATH + '/sales/sale',
		data: JSON.stringify(formData),
	    processData: false,
        contentType: "application/json",
		
        success: function(data) {
<<<<<<< HEAD
        	alert(data);
			if( data != null && data.error != null && data != undefined ) {
				showError(data.msj, 3000);
			} else if(data != null && data != undefined) {	
				showSuccess(data.msj, 3000);
				printReport(data.id);
			//	cancel();
			}
=======
        	if(data && data.error) {
        		showError(data.msj, 4000);
        		
        	} else {
        		showSuccess(data.msj, 3000);
        		printReport(data.id);
				cancel();
        	}
>>>>>>> c1b13f963a7c75f20bdc61052d7df3dc63845110
		}
	});
}



function printReport(folio){
		$('#ligaGenerar').attr('href','sales/getReport?nombreReporte=comprobante&$vendedor='+$('#vendedor').val()+'&sucursal='+$('#nombreSucursal').val()+
				'&folio='+folio);
}

function replaceData(formData) {
	if( formData.productoID instanceof Array ) {
		formData.productoID.unshift(-1);
		
	} else {
		var arr = new Array();
		arr.push(formData.productoID);
		formData.productoID = arr;
	}
	
	if( formData.existencias instanceof Array ) {
		formData.existencias.unshift(-1);
		
	} else {
		var arrs = new Array();
		arrs.push(formData.existencias);
		formData.existencias = arr;
	}
	
	return formData;
}



