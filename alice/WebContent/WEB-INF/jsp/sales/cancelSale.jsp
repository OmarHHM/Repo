<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<i class="fa-fw fa fa-th"></i>Ventas
		</h1>
	</div>
</div>

<!-- widget grid -->
<section id="widget-grid" class="">
	<input type="hidden" id="contextpath" value="${pageContext.request.contextPath}">

	<!-- row -->
	<div class="row">
		<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="jarviswidget jarviswidget-color-blueDark" id="wid-id-2" data-widget-editbutton="false" data-widget-deletebutton="false" data-widget-togglebutton="false">
				<header>
					<div id="cTitF">
						<span class="widget-icon widget-icon-margin">
							<i class="fa fa-edit"></i>
						</span>
						<h2 id="titF">Cancelación de Ventas</h2>
					</div>
				</header>
				
				<!-- widget div-->
				<div role="content">
				
					<!-- widget edit box -->
					<div class="jarviswidget-editbox">
						<!-- This area used as dropdown edit box -->
					</div>
					<!-- end widget edit box -->
				
					<!-- widget content -->
					<div id="productos" class="widget-body no-padding">
					
						<form id="frmSale" class="smart-form cmxform" method="POST"  target="content">
							<input id="operation" name="operation" type="hidden" value=""/>							
							<header>
								Cancelar Venta
							</header>
							
							<fieldset>		
								<section class="col col-12 form-group">
									<div class="row">
										<section class="col col-4 form-group">
											<label class="label">Folio de Venta</label>
											<label class="input"><i class="icon-append fa fa-slack"></i> 
												<input id="id" name="id" class="form-control" type="text" maxlength="30" >
											</label>
										</section>
									</div>
								</section>
							</fieldset>
							
							<footer>
								<button type="button" class="btn btn-primary"  id="btnSave" onclick="onSubmited('del')"><i class="fa fa-save"></i>&nbsp;&nbsp; Cancelar</button>
							</footer>
						</form>
					</div>
					
				</div>
			</div>
		</article>
	</div>
</section>

<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/multi-select.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugin/multi-select/jquery.multi-select.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/sales/cancelSale.js"></script>

