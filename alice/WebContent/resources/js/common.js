/**
 * Función encargada de consultar el catálogo de sucursales
 * @returns
 */
function loadOffices() {
	var catSucursales = {};
	branchService.listBranchsAct(catSucursales, function(data){
		dwr.util.addOptions("sucursalID", data, "id","nombre");
	});
}

/**
 * Función encargada de mostrar mensaje de error en la aplicación
 * 
 * @param message
 * @param timeout
 */
function showError(message, timeout) {
	$.bigBox({
		title : 'Se ha producido un error',
		content : message,
		color : "#c46a69",
		timeout: timeout ? timeout : null,
		icon : "fa fa-warning shake animated",
		//number : "1"
	});
}

/**
 * Función encargada de mostrar mensaje de información en la aplicación
 * 
 * @param message
 * @param timeout
 */
function showInfo(message, timeout) {
	$.bigBox({
		title : 'Informaci&oacute;n',
		content : message,
		color : "#3276b1",
		timeout: timeout ? timeout : null,
		icon : "fa fa-bell swing animated",
		//number : "2"
	});
}

/**
 * Función encargada de mostrar mensaje de alerta en la aplicación
 * 
 * @param message
 * @param timeout
 */
function showWarning(message, timeout) {
	$.bigBox({
		title : 'Alerta',
		content : message,
		color : "#c79121",
		timeout: timeout ? timeout : null,
		icon : "fa fa-shield fadeInLeft animated",
		//number : "3"
	});
}

/**
 * Función encargada de mostrar mensaje de éxito en la aplicación
 * 
 * @param message
 * @param timeout
 */
function showSuccess(message, timeout) {
	$.bigBox({
		title : 'Operaci&oacute;n realizada con &eacute;xito',
		content : message,
		color : "#739e73",
		timeout: timeout ? timeout : null,
		icon : "fa fa-check",
		//number : "4"
	});
}

function showSmallSuccess(message, timeout) {
	$.smallBox({
		title : 'Se ha producido un error',
		content : message,
		color : "#A65858",
		iconSmall : "fa fa-times",
		timeout : timeout ? timeout : null,
	});
}

function showSmallError(message, timeout) {
	$.smallBox({
		title : 'Operaci&oacute;n realizada con &eacute;xito',
		content : message,
		color : "#739e73",
		iconSmall : "fa fa-check",
		timeout : timeout ? timeout : null,
	});
}

// función que se encarga de procesar las excepciones
function procesaExcepcion(codExcepcion) {
	if (codExcepcion != '') {
		showError(errores[codExcepcion]);
	}
}

/**
 * Función que convierte el texto en mayúsculas
 * se debe usar el tag text-style="upper" para que se aplique el formato
 * Ejemplo: <input id="ejm" name="ejm" text-style="upper" class="form-control" type="text" maxlength="100" >
 * @returns
 */
function changeToUppercase() {
	$('input[text-style=upper]').each(function(index, element) {
		$(element).on('blur', function() {
			$(this).css('text-transform', 'uppercase');
		});
	});
}


/*funcion valida fecha formato (dd-MM-yyyy)*/
function esFechaValida(fecha){
	if (fecha != undefined && fecha.value != "" ){
		var objRegExp = /^\d{2}\/\d{2}\/\d{4}$/;
		if (!objRegExp.test(fecha)){
			alert("formato de fecha no válido (dd/mm/yyyy)");
			return false;
		}

		var anio=  fecha.substring(6, 10)*1;
		var mes= fecha.substring(3, 5)*1;
		var dia= fecha.substring(0,2)*1;

		switch(mes){
		case 1: case 3:  case 5: case 7:
		case 8: case 10:
		case 12:
			numDias=31;
			break;
		case 4: case 6: case 9: case 11:
			numDias=30;
			break;
		case 2:
			if (comprobarSiBisisesto(anio)){ numDias=29 }else{ numDias=28};
			break;
		default:
			alert("Fecha introducida errónea");
		return false;
		}
		if (dia>numDias || dia==0){
			alert("Fecha introducida errónea");
			return false;
		}
		return true;
	}
}

//Identifica años bisiestos
function comprobarSiBisisesto(anio){
	if ( ( anio % 100 != 0) && ((anio % 4 == 0) || (anio % 400 == 0))) {
		return true;
	}
	else {
		return false;
	}
}	
	
//funcion para validar fecha que no sea mayor a la actual 	
function mayor(fecha){
	//0|1|2|3|4|5|6|7|8|9|
	//2 0 1 2 / 1 1 / 2 0
	//2 0 / 1 1 / 2 0 1 2
	var fecha2 = new Date();
	var dd = fecha2.getDate();
	var mm = fecha2.getMonth()+1; 
	var yyyy = fecha2.getFullYear();

	if(dd<10) {
	    dd='0'+dd
	} 

	if(mm<10) {
	    mm='0'+mm
	} 

	fecha2 = yyyy+'/'+mm+'/'+dd;

	
	var xMes=fecha.substring(3, 5);
	var xDia=fecha.substring(0, 2);
	var xAnio=fecha.substring(6,10);

	var yMes=fecha2.substring(5, 7);
	var yDia=fecha2.substring(8, 10);
	var yAnio=fecha2.substring(0,4);

	if (xAnio > yAnio){
		return true;
	}else{
		if (xAnio == yAnio){
			if (xMes > yMes){
				return true;
			}
			if (xMes == yMes){
				if (xDia > yDia){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false ;
		}
	} 
}

/*

function onSubmit(idForm,uri) {
	//Se compone la forma
	var form = $('#'+idForm);
	var ResultId=0;
	var formData = $(form).serializeObject(); //Serializacion como objeto
	$.ajax({
		type: 'POST',
		url:uri,
		data: JSON.stringify(formData),
	    processData: false,
        contentType: "application/json",
		
		success: function(data) {
			if( data != null && data.error != null && data != undefined ) {
				showError(data, 3000);
				ResultId=data.message.idResult
			} else if(data != null && data != undefined) {	
				showSuccess(data, 3000);
			}
			
		}
	});
	
	return ResultId;
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
*/

function convertToDate(id){
	if($('#'+id).val().length>10){
		$('#'+id).val($('#'+id).val().substring(0,10));
	}
	
	var newValue= $('#'+id).val().replace(/^(\d{4})-(\d{2})-(\d{2})$/g,'$3/$2/$1');
	return newValue;
}


/**
 * Función encargada de consultar información del usuario
 * @returns
 */


function loadUser() {
	var usuario = {
			"id":0,
			"clave":$('#claveUsuario').val()
	};
	var emp={
		"numeroEmpleado":$('#claveUsuario').val()
	}
	var nombreUsuario="";
	userService.getAll(usuario, function(data){
		if(data !=null){
			if(data.numeroEmpleado!=null && data.numeroEmpleado==""){
				$('#nombreUsuario').html(data.usuario);							
			}else{
				employeeService.getAll(emp, function(dataEmp){
					$('#nombreUsuario').html(dataEmp.nombre+" "+dataEmp.apellidoPaterno+" "+dataEmp.apellidoMaterno);
				});
			}					
		}
	});
}

loadUser();

/*
 * Funcion para formatear input con formato moneda 
 * */

function actualizaFormatoMoneda(idForma) {	
	var jqForma = eval("'#" + idForma + "'");	
	$(jqForma).find('input[esMoneda="true"]').each( 
			function(){	    	
				var child = $(this);  			
				var jControl = eval("'#" + child.attr('id') + "'"); 
				$(jControl).formatCurrency({positiveFormat: '%n', roundToDecimalPlace: 2});
			});			
}