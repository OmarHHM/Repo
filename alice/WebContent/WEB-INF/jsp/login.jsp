<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html id="extr-page">
	<head>
		<meta charset="utf-8">
		<title> System </title>
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">


		<!-- #CSS Links -->
		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/resources/css/bootstrap.min.css'/>" >
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/resources/css/font-awesome.min.css'/>" >

		<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/resources/css/smartadmin-production.min.css'/>" >
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/resources/css/smartadmin-skins.min.css'/>" >

		<!-- We recommend you use "your_style.css" to override SmartAdmin specific styles this will also ensure you retrain your customization with each SmartAdmin update. -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/resources/css/login.css'/>" >

		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/resources/css/demo.min.css'/>" >

		<!-- #FAVICONS -->
		<link rel="shortcut icon" href="<c:url value='/resources/img/favicon/favicon.ico" type="image/x-icon'/>" >
		<link rel="icon" href="<c:url value='/resources/img/favicon/favicon.ico" type="image/x-icon'/>" >

		<!-- #GOOGLE FONT -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

		<!-- #APP SCREEN / ICONS -->
		<link rel="apple-touch-icon" href="<c:url value='/resources/img/splash/sptouch-icon-iphone.png'/>" >
		<link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/img/splash/touch-icon-ipad.png'/>" >
		<link rel="apple-touch-icon" sizes="120x120" href="<c:url value='/resources/img/splash/touch-icon-iphone-retina.png'/>" >
		<link rel="apple-touch-icon" sizes="152x152" href="<c:url value='/resources/img/splash/touch-icon-ipad-retina.png'/>" >
		
		<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		<!-- Startup image for web apps -->
		<link rel="apple-touch-startup-image" href="<c:url value='/resources/img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)'/>" >
		<link rel="apple-touch-startup-image" href="<c:url value='/resources/img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)'/>" >
		<link rel="apple-touch-startup-image" href="<c:url value='/resources/img/splash/iphone.png" media="screen and (max-device-width: 320px)'/>" >

	</head>
	
	<body class="animated fadeInDown">

		<header id="header">
			<div id="logo-group">
				<span id="logo"> 
					<img src="<c:url value='/resources/img/logo.png'/>" alt="System"/> 
				</span>
			</div>
		</header>

		<div id="main" role="main">

			<!-- MAIN CONTENT -->
			<div id="content" class="container">

				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
						<h1 class="txt-color-red login-header-big">System</h1>
						<div class="hero">
							<div class="pull-left login-desc-box-l">
							</div>
						</div>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
						<div class="well no-padding">
							<!-- VALIDAR EL ENVÍO DE LA INFORMACIÓN -->
							<!-- <form action="j_spring_security_check" id="login-form" class="smart-form client-form" method="post"> -->
							<form action="<c:url value=''/>" id="login-form" class="smart-form client-form" method="POST">
								<header>
									Iniciar sesión
								</header>

								<fieldset>
									
									<section>
										<label class="label">Correo electrónico</label>
										<label class="input"> <i class="icon-append fa fa-user"></i>
											<input type="text" name="username"
											value="${cookie.SPRING_SECURITY_LAST_USERNAME.value}" />
											<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> Introduzca su dirección de correo electrónico</b>
										</label>
									</section>

									<section>
										<label class="label">Contraseña</label>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<input type="password" name="password">
											<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i>Introduzca su contraseña</b>
										</label>
									</section>

									<c:if test="${not empty error}"><div>${error}</div></c:if>
									<c:if test="${not empty message}"><div>${message}</div></c:if>
									
									<section id="login-error">
										<i class="fa fa-warning"></i> La dirección de correo electrónico o la contraseña que has introducido no son correctas.
									</section>
								</fieldset>

								<footer>
									<button id="submit-button" type="submit" class="btn btn-primary">
										Iniciar sesión
									</button>
								</footer>
							</form>
						</div>
						
					</div>
				</div>
			</div>

		</div>

		<!--================================================== -->	

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script src="<c:url value='/resources/js/plugin/pace/pace.min.js'/> "></script>

	    <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
	    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script> if (!window.jQuery) { document.write('<script src="<c:url value='/resources/js/libs/jquery-2.0.2.min.js'/>" ><\/script>');} </script>

	    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
		<script> if (!window.jQuery.ui) { document.write('<script src="<c:url value='/resources/js/libs/jquery-ui-1.10.3.min.js'/>" ><\/script>');} </script>

		<!-- BOOTSTRAP JS -->		
		<script src="<c:url value='/resources/js/bootstrap/bootstrap.min.js'/>" >
		
		</script>

		<!-- JQUERY VALIDATE -->
		<script src="<c:url value='/resources/js/plugin/jquery-validate/jquery.validate.min.js'/>" >
		</script>
		
		<!-- JQUERY MASKED INPUT -->
		<script src="<c:url value='/resources/js/plugin/masked-input/jquery.maskedinput.min.js'/>">
		</script>
		
		<!--[if IE 8]>
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
		<![endif]-->

		<!-- MAIN APP JS FILE -->
		<script src="<c:url value='/resources/js/app.js'/> "></script>

		<!-- COMMON JS FILE -->
		<script src="<c:url value='/resources/js/common.js'/>" >
		</script>

		<!-- LOGIN JS FILE -->
		<script src="<c:url value='/resources/js/login/login.js'/>" >
		</script>

		<script type="text/javascript">
			runAllForms();
		</script>

	</body>
</html>