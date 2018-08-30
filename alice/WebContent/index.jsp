<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title> Morrito Front </title>
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
		<!-- #CSS Links -->
		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">

		<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
		<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/smartadmin-production.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/smartadmin-skins.min.css">

		<!-- SmartAdmin RTL Support is under construction
			 This RTL CSS will be released in version 1.5
		<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/smartadmin-rtl.min.css"> -->
	
		<!-- MORRITO'S APP STYLE -->
		<!-- We recommend you use "your_style.css" to override SmartAdmin specific styles this will also ensure you retrain your customization with each SmartAdmin update. -->
		<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/morrito.css">

		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
<%-- 		<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/demo.min.css"> --%>

		<!-- #FAVICONS -->
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon/favicon.ico" type="image/x-icon">
		<link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon/favicon.ico" type="image/x-icon">

		<!-- #GOOGLE FONT -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

		<!-- #APP SCREEN / ICONS -->
		<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
		<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/resources/img/splash/sptouch-icon-iphone.png">
		<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/img/splash/touch-icon-ipad.png">
		<link rel="apple-touch-icon" sizes="120x120" href="${pageContext.request.contextPath}/resources/img/splash/touch-icon-iphone-retina.png">
		<link rel="apple-touch-icon" sizes="152x152" href="${pageContext.request.contextPath}/resources/img/splash/touch-icon-ipad-retina.png">
		
		<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		<!-- Startup image for web apps -->
		<link rel="apple-touch-startup-image" href="${pageContext.request.contextPath}/resources/img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
		<link rel="apple-touch-startup-image" href="${pageContext.request.contextPath}/resources/img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
		<link rel="apple-touch-startup-image" href="${pageContext.request.contextPath}/resources/img/splash/iphone.png" media="screen and (max-device-width: 320px)">

		<script>
			var CONTEXT_PATH = '${pageContext.request.contextPath}';
			var LOCALE_LANGUAGE = '${pageContext.response.locale.language}';
			var claveUser='request.getUserPrincipal().getName()';
		</script>		
	</head>

	<!--

	TABLE OF CONTENTS.
	
	Use search to find needed section.
	
	===================================================================
	
	|  01. #CSS Links                |  all CSS links and file paths  |
	|  02. #FAVICONS                 |  Favicon links and file paths  |
	|  03. #GOOGLE FONT              |  Google font link              |
	|  04. #APP SCREEN / ICONS       |  app icons, screen backdrops   |
	|  05. #BODY                     |  body tag                      |
	|  06. #HEADER                   |  header tag                    |
	|  07. #PROJECTS                 |  project lists                 |
	|  08. #TOGGLE LAYOUT BUTTONS    |  layout buttons and actions    |
	|  09. #MOBILE                   |  mobile view dropdown          |
	|  10. #SEARCH                   |  search field                  |
	|  11. #NAVIGATION               |  left panel & navigation       |
	|  12. #MAIN PANEL               |  main panel                    |
	|  13. #MAIN CONTENT             |  content holder                |
	|  14. #PAGE FOOTER              |  page footer                   |
	|  15. #SHORTCUT AREA            |  dropdown shortcuts area       |
	|  16. #PLUGINS                  |  all scripts and plugins       |
	
	===================================================================
	
	-->
	
	<!-- #BODY -->
	<!-- Possible Classes

		* 'smart-skin-{SKIN#}'
		* 'smart-rtl'         - Switch theme mode to RTL (will be avilable from version SmartAdmin 1.5)
		* 'menu-on-top'       - Switch to top navigation (no DOM change required)
		* 'hidden-menu'       - Hides the main menu but still accessable by hovering over left edge
		* 'fixed-header'      - Fixes the header
		* 'fixed-navigation'  - Fixes the main menu
		* 'fixed-ribbon'      - Fixes breadcrumb
		* 'fixed-footer'      - Fixes footer
		* 'container'         - boxed layout mode (non-responsive: will not work with fixed-navigation & fixed-ribbon)
	-->
	<body class="">

		<!-- #HEADER -->
		<header id="header">
			<div id="logo-group">

				<!-- PLACE YOUR LOGO HERE -->
				<span id="logo"> <img src="${pageContext.request.contextPath}/resources/img/logo.png"> </span>
				<!-- END LOGO PLACEHOLDER -->

				<!-- Note: The activity badge color changes when clicked and resets the number to 0
					 Suggestion: You may want to set a flag when this happens to tick off all checked messages / notifications -->
<!-- 				<span id="activity" class="activity-dropdown"> <i class="fa fa-user"></i> <b class="badge"> 21 </b> </span> -->

				<!-- AJAX-DROPDOWN : control this dropdown height, look and feel from the LESS variable file -->
<!-- 				<div class="ajax-dropdown"> -->

<!-- 					the ID links are fetched via AJAX to the ajax container "ajax-notifications" -->
<!-- 					<div class="btn-group btn-group-justified" data-toggle="buttons"> -->
<!-- 						<label class="btn btn-default"> -->
<!-- 							<input type="radio" name="activity" id="ajax/notify/mail.html"> -->
<!-- 							Msgs (14) </label> -->
<!-- 						<label class="btn btn-default"> -->
<!-- 							<input type="radio" name="activity" id="ajax/notify/notifications.html"> -->
<!-- 							notify (3) </label> -->
<!-- 						<label class="btn btn-default"> -->
<!-- 							<input type="radio" name="activity" id="ajax/notify/tasks.html"> -->
<!-- 							Tasks (4) </label> -->
<!-- 					</div> -->

<!-- 					notification content -->
<!-- 					<div class="ajax-notifications custom-scroll"> -->

<!-- 						<div class="alert alert-transparent"> -->
<!-- 							<h4>Click a button to show messages here</h4> -->
<!-- 							This blank page message helps protect your privacy, or you can show the first message here automatically. -->
<!-- 						</div> -->

<!-- 						<i class="fa fa-lock fa-4x fa-border"></i> -->

<!-- 					</div> -->
<!-- 					end notification content -->

<!-- 					footer: refresh area -->
<!-- 					<span> Last updated on: 12/12/2013 9:43AM -->
<%-- 						<button type="button" data-loading-text="<i class='fa fa-refresh fa-spin'></i> Loading..." class="btn btn-xs btn-default pull-right"> --%>
<!-- 							<i class="fa fa-refresh"></i> -->
<!-- 						</button> </span> -->
<!-- 					end footer -->

<!-- 				</div> -->
				<!-- END AJAX-DROPDOWN -->
			</div>

			<!-- #PROJECTS: projects dropdown -->
			<div class="project-context hidden-xs">
			<sec:authentication property="principal.username" var="nombreUs"></sec:authentication>
				
				
				<!-- CHANGE TEXT -->
				<!--	<span class="label">Proyectos: </span>
-->
				<!-- Suggestion: populate this list with fetch and push technique -->
				<!--<span class="project-selector dropdown-toggle" data-toggle="dropdown">Proyecto uno<i class="fa fa-angle-down"></i></span>
				<ul class="dropdown-menu">
					<li>
						<a href="javascript:void(0);">Proyecto dos</a>
					</li>
				</ul>-->
<%-- 				<sec:authorize access="isAuthenticated()"> --%>
<%-- 					<sec:authentication var="user" property="principal" /> --%>
					
<%-- 					<span class="project-selector dropdown-toggle" data-toggle="dropdown">${user.proyectoActivo.pryProyectoNombre} <i class="fa fa-angle-down"></i></span> --%>
					
<!-- 					<ul class="dropdown-menu"> -->
<%-- 						<c:forEach var="project" items="${user.proyectos}"> --%>
<%-- 							<li ${user.proyectoActivo.idPRY_PROYECTO == project.idPRY_PROYECTO ? 'class="active"' : ''}> --%>
<%-- 								<a href="javascript:changeActiveProject(${project.idPRY_PROYECTO});">${project.pryProyectoNombre}</a> --%>
<!-- 							</li> -->
<%-- 						</c:forEach> --%>
<!-- 					</ul> -->
<%-- 				</sec:authorize> --%>
				<!-- end dropdown-menu-->

			</div>
			<!-- end projects dropdown -->
			
			<!-- #TOGGLE LAYOUT BUTTONS -->
			<!-- pulled right: nav area -->
			<div class="pull-right">
				
				<!-- collapse menu button -->
				<div id="hide-menu" class="btn-header pull-right">
					<span> <a href="javascript:void(0);" data-action="toggleMenu" title="Cerrar menú"><i class="fa fa-reorder"></i></a> </span>
				</div>
				<!-- end collapse menu -->

				<!-- logout button -->
					<div id="logout" class="btn-header transparent pull-right">
						<span> <a  href="<c:url value="/logout" />" title="Cerrar sesión" >
								<button class="fa fa-sign-out" ></button>
								</a>								
						 </span>
					</div>
				
				<!-- end logout button -->

				<!-- search mobile button (this is hidden till mobile view port) -->
				<div id="search-mobile" class="btn-header transparent pull-right">
					<span> <a href="javascript:void(0)" title="Search"><i class="fa fa-search"></i></a> </span>
				</div>
				<!-- end search mobile button -->
				
				<!-- #SEARCH -->
				<!-- input: search field -->
<!-- 				<form action="#ajax/search.html" class="header-search pull-right"> -->
<!-- 					<input id="search-fld"  type="text" name="param" placeholder="Find reports and more" data-autocomplete='[ -->
<!-- 					"ActionScript", -->
<!-- 					"AppleScript", -->
<!-- 					"Asp", -->
<!-- 					"BASIC", -->
<!-- 					"C", -->
<!-- 					"C++", -->
<!-- 					"Clojure", -->
<!-- 					"COBOL", -->
<!-- 					"ColdFusion", -->
<!-- 					"Erlang", -->
<!-- 					"Fortran", -->
<!-- 					"Groovy", -->
<!-- 					"Haskell", -->
<!-- 					"Java", -->
<!-- 					"JavaScript", -->
<!-- 					"Lisp", -->
<!-- 					"Perl", -->
<!-- 					"PHP", -->
<!-- 					"Python", -->
<!-- 					"Ruby", -->
<!-- 					"Scala", -->
<!-- 					"Scheme"]'> -->
<!-- 					<button type="submit"> -->
<!-- 						<i class="fa fa-search"></i> -->
<!-- 					</button> -->
<!-- 					<a href="javascript:void(0);" id="cancel-search-js" title="Cancel Search"><i class="fa fa-times"></i></a> -->
<!-- 				</form> -->
				<!-- end input: search field -->

				<!-- fullscreen button -->
				<div id="fullscreen" class="btn-header transparent pull-right">
					<span> <a href="javascript:void(0);" data-action="launchFullscreen" title="Pantalla completa"><i class="fa fa-arrows-alt"></i></a> </span>
				</div>
				<!-- end fullscreen button -->

				<!-- multiple lang dropdown : find all flags in the flags page -->
				<ul class="header-dropdown-list hidden-xs">
					<li>
						<c:set var="localeCode" value="${pageContext.response.locale}" />
						<c:choose>
							<c:when test="${localeCode == 'es_MX'}">
								<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"> <img src="${pageContext.request.contextPath}/resources/img/blank.gif" class="flag flag-mx" alt="Español"> <span> MX </span> <i class="fa fa-angle-down"></i> </a>
							</c:when>
							<c:when test="${localeCode == 'en_US'}">
								<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"> <img src="${pageContext.request.contextPath}/resources/img/blank.gif" class="flag flag-us" alt="Inglés"> <span> EN </span> <i class="fa fa-angle-down"></i> </a>
							</c:when>
						</c:choose>
						<ul class="dropdown-menu pull-right">
							<li ${localeCode == 'es_MX' ? 'class="active"' : ''}>
								<a href="javascript:changeLanguage('es_MX')" onclick=""><img src="${pageContext.request.contextPath}/resources/img/blank.gif" class="flag flag-mx" alt="Español"> Español</a>
							</li>
							<li ${localeCode == 'en_US' ? 'class="active"' : ''}>
								<a href="javascript:changeLanguage('en_US')"><img src="${pageContext.request.contextPath}/resources/img/blank.gif" class="flag flag-us" alt="Inglés"> Inglés</a>
							</li>
						</ul>
					</li>
				</ul>
				<!-- end multiple lang -->

			</div>
			<!-- end pulled right: nav area -->

		</header>
		<!-- END HEADER -->

		<!-- #NAVIGATION -->
		<!-- Left panel : Navigation area -->
		<!-- Note: This width of the aside area can be adjusted through LESS variables -->
		<aside id="left-panel">

			<!-- User info -->
			<div class="login-info">
				<span> <!-- User image size is adjusted inside CSS, it should stay as is --> 
					
					<a href="javascript:void(0);" id="show-shortcut">
						<img class="online" /> 
						<span id="nombreUsuario" >
							
				
							
							<!-- RECUPERAR LOS DATOS DEL USUARIO FIRMADO -->
							
						</span>
						<i class="fa fa-angle-down"></i>
					</a> 
					
				</span>
				<input type="hidden" id="sucursal" />
				<input type="hidden" id="idUsuario" />
				<input type="hidden" id="idSucursal" />
			</div>
			<!-- end user info -->

			<!-- NAVIGATION : This navigation is also responsive

			To make this navigation dynamic please make sure to link the node
			(the reference to the nav > ul) after page load. Or the navigation
			will not initialize.
			-->
			<nav>
				<!-- 
				NOTE: Notice the gaps after each icon usage <i></i>..
				Please note that these links work a bit different than
				traditional href="" links. See documentation for details.
				-->
				<!-- AGREGAR TAGS DE SPRING SECURITY -->
							
				<ul>
					<li>
						<a href="dashboard"><i class="fa fa-lg fa-fw fa-tachometer"></i> <span class="menu-item-parent">Dashboard</span></a>
					</li>			
					<li>
						<a href="#"><i class="fa fa-lg fa-fw fa-cogs"></i><span class="menu-item-parent">Administración</span></a>
						<ul>
							<li>
								<a href="administration/users">Usuarios
								</a>
							</li>
							<li>
								<a href="administration/personnel">Personal
								</a>	
							</li>
							<li>
								<a href="administration/addressPersonnel">Domicilio del Personal</a>
							</li>
							<li>
								<a href="<c:url value='/administration/contactPersonnel'/>" >Contactos del personal</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="<c:url value='/products/product'/>" ><i class ="glyphicon glyphicon-list-alt"></i><span>Productos</span></a>
					</li>
					<li>
						<a href="#"><i class="glyphicon glyphicon-shopping-cart"></i><span class="menu-item-parent">Ventas</span></a>
						<ul>
							<li>
								<a href="<c:url value='/sales/sales'/>" >Venta
								</a>
							</li>
							<li>
								<a href="<c:url value='/sales/cancel'/>" >Cancelar Venta</a>
							</li>
							<li>
								<a href="<c:url value='/sales/refund'/>" >Devolución de productos</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="<c:url value='/expenses/expense'/>"><i class="glyphicon glyphicon-usd"></i><span>Gastos</span></a>
					</li>
				</ul>
			</nav>
			<span class="minifyme" data-action="minifyMenu"> <i class="fa fa-arrow-circle-left hit"></i> </span>

		</aside>
		<!-- END NAVIGATION -->

		<!-- #MAIN PANEL -->
		<div id="main" role="main">

			<!-- RIBBON -->
			<div id="ribbon">
<!--  
				<span class="ribbon-button-alignment"> 
					<span id="refresh" class="btn btn-ribbon" data-action="resetWidgets" data-title="refresh" rel="tooltip" data-placement="bottom" data-original-title="<i class='text-warning fa fa-warning'></i> ¡Advertencia! Esto restablecerá todos los ajustes de los widgets." data-html="true" data-reset-msg="¿Desea restablecer todos los widgets guardados y limpiar el almacenamiento local?">
						<i class="fa fa-refresh"></i>
					</span> 
				</span>
-->
				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<!-- This is auto generated -->
				</ol>
				<!-- end breadcrumb -->

				<!-- You can also add more buttons to the
				ribbon for further usability

				Example below:

				<span class="ribbon-button-alignment pull-right">
				<span id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa-grid"></i> Change Grid</span>
				<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa-plus"></i> Add</span>
				<span id="search" class="btn btn-ribbon" data-title="search"><i class="fa-search"></i> <span class="hidden-mobile">Search</span></span>
				</span> -->

			</div>
			<!-- END RIBBON -->

			<!-- #MAIN CONTENT -->
			<div id="content">

			</div>
			
			<!-- END #MAIN CONTENT -->

		</div>
		<!-- END #MAIN PANEL -->

		<!-- #PAGE FOOTER -->
		<div class="page-footer">
			<div class="row">
				<div class="col-xs-12 col-sm-6">
					<span class="txt-color-white">Morrito © 2017</span>
				</div>
				<!-- end col -->
			</div>
			<!-- end row -->
		</div>
		<!-- END FOOTER -->

		<!--================================================== -->

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)
		<script data-pace-options='{ "restartOnRequestAfter": true }' src="${pageContext.request.contextPath}/resources/js/plugin/pace/pace.min.js"></script>-->
		
		<!-- #PLUGINS -->
		<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script>
			if (!window.jQuery) {
				document.write('<script src="${pageContext.request.contextPath}/resources/js/libs/jquery-2.0.2.min.js"><\/script>');
			}
		</script>

<!-- 		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script> -->
		<script>
			if (!window.jQuery.ui) {
				document.write('<script src="${pageContext.request.contextPath}/resources/js/libs/jquery-ui-1.10.3.min.js"><\/script>');
			}
		</script>
		<script>
			if (window.jQuery.ui) {
				document.write('<script src="${pageContext.request.contextPath}/resources/js/libs/i18n/jquery.ui.datepicker-es.js" charset="UTF-8"><\/script>');
			}
		</script>

		<!-- MOMENT -->
		<script src="${pageContext.request.contextPath}/resources/js/plugin/x-editable/moment.min.js"></script> 
		
		<!-- BOOTSTRAP JS -->
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>

		<!-- CUSTOM NOTIFICATION -->
		<script src="${pageContext.request.contextPath}/resources/js/notification/SmartNotification.min.js"></script>

		<!-- JARVIS WIDGETS -->
		<script src="${pageContext.request.contextPath}/resources/js/smartwidgets/jarvis.widget.js"></script>

		<!-- EASY PIE CHARTS -->
		<script src="${pageContext.request.contextPath}/resources/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

		<!-- SPARKLINES -->
		<script src="${pageContext.request.contextPath}/resources/js/plugin/sparkline/jquery.sparkline.min.js"></script>

		<!-- JQUERY VALIDATE -->
		<script src="${pageContext.request.contextPath}/resources/js/plugin/jquery-validate/jquery.validate.min.js"></script>

		<!-- JQUERY MASKED INPUT -->
		<script src="${pageContext.request.contextPath}/resources/js/plugin/masked-input/jquery.maskedinput.min.js"></script>

		<!-- JQUERY SELECT2 INPUT -->
		<script src="${pageContext.request.contextPath}/resources/js/plugin/select2/select2.min.js"></script>

		<!-- JQUERY UI + Bootstrap Slider -->
		<script src="${pageContext.request.contextPath}/resources/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

		<!-- browser msie issue fix -->
		<script src="${pageContext.request.contextPath}/resources/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

		<!-- FastClick: For mobile devices: you can disable this in app.js -->
		<script src="${pageContext.request.contextPath}/resources/js/plugin/fastclick/fastclick.min.js"></script>

		<!-- WIZARD FUELUX -->
		<script src="${pageContext.request.contextPath}/resources/js/plugin/fuelux/wizard/wizard.min.js"></script>

		<!--[if IE 8]>
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
		<![endif]-->

		<!-- Demo purpose only -->
<%-- 		<script src="${pageContext.request.contextPath}/resources/js/demo.min.js"></script> --%>

		<!-- MAIN APP JS FILE -->
		<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
		
		<!-- DWR -->
		<!-- 	<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/engine.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/util.js'></script>
		
		
	 
		<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/interface/branchService.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/interface/userService.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/interface/employeeService.js'></script>  -->

		<!-- COMMON JS FILE -->
		<script src="${pageContext.request.contextPath}/resources/js/common.js" charset="ISO-8859-1"></script>
		
		<script type="text/javascript">
			// overrides sound path from SmartNotification.min.js 
			$.sound_path = '${pageContext.request.contextPath}/resources/sound/';
		</script>

		<!-- JS GRAHPS MORRIS -->
		<script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<!--  		<script src="http://cdn.oesmith.co.uk/morris-0.4.1.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
	-->	<script src="${pageContext.request.contextPath}/resources/js/graph/morris-0.4.1.min.js"></script>
		
		
		<!-- Your GOOGLE ANALYTICS CODE Below -->
		<script type="text/javascript">
		
		  var _gaq = _gaq || [];
		  _gaq.push(['_setAccount', 'UA-XXXXXXXX-X']);
		  _gaq.push(['_trackPageview']);
		
		  (function() {
		    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		  })();
		
		</script>
		<!--  
		<script type="text/javascript">
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
					$('#idUsuario').val(data.id);
					if(data.numeroEmpleado!=null && data.numeroEmpleado==""){
						$('#nombreUsuario').html(data.usuario);	
						var userName =data.usuario;
						
					}else{
						employeeService.getAll(emp, function(dataEmp){
							$('#nombreUsuario').html(dataEmp.nombre+" "+dataEmp.apellidoPaterno+" "+dataEmp.apellidoMaterno);
							var nombreUsuario =dataEmp.nombre+" "+dataEmp.apellidoPaterno+" "+dataEmp.apellidoMaterno;
						});
					}	
					
					$('#idSucursal').val(data.sucursalID);
					
					var userBranch={
							"id":data.sucursalID
					}
					
					branchService.getAll(userBranch,function(data){
						$('#sucursal').val(data.nombre);
					});
				}
			});
			
		</script>-->
	</body>
</html>