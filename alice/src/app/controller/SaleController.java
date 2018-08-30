package app.controller;

import java.io.ByteArrayOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.model.MessageTransaction;
import app.model.Ventas;
import app.service.SaleService;
import app.utils.Utilities;

@Controller
public class SaleController {

    @Autowired
    private SaleService saleService;	
    
    @RequestMapping(value = "/sales/sales")
    public ModelAndView getSales() {
      	return new ModelAndView("sales/sale");
    }
    
    @RequestMapping(value = "/sales/refund")
    public ModelAndView getRefund() {

      	return new ModelAndView("sales/refundProduct");
    }
    
    @RequestMapping(value = "/sales/cancel")
    public ModelAndView getCancel() {

      	return new ModelAndView("sales/cancelSale");
    }
    /*@RequestMapping(value = "/sales/sale", method = RequestMethod.POST)
    public void saveSale(@RequestBody Ventas sale, HttpServletResponse response,HttpServletRequest request) throws Exception {
    		response.setContentType("application/json");
    		JSONObject json = new JSONObject();
    		MessageTransaction message= new MessageTransaction();
    		
    		try {*/
//    			System.out.println("RequestBody [producto]: " + sale);

//    			message= saleService.save(sale);
//    			System.out.println("Mensaje"+message.getMessage());
//    			System.out.println("ID"+message.getIdResult());
//    			System.out.println("error"+message.getErrorNumber());
    			
  /*  			json.put("success", true);
	    			json.put("msj", message.getMessage());
	    			json.put("id", message.getIdResult());
    		}catch(Exception e) {
    			e.printStackTrace();
    			json.put("success", false);
    			json.put("msj", "Error inesperado");
    		}
    }
    
    
    
    @RequestMapping(value = "/sales/cancelSale", method = RequestMethod.POST)
    public void cancelSale(@RequestBody Ventas sale, HttpServletResponse response,HttpServletRequest request) throws Exception {
    		response.setContentType("application/json");
    		JSONObject json = new JSONObject();
    		MessageTransaction message= new MessageTransaction();
    		
    		try {

    			System.out.println("id "+sale.getId());
    			message= saleService.delete(sale);
    			json.put("success", true);
    			json.put("msj", message.getMessage());
    			json.put("id", message.getIdResult());

    			System.out.println("message :"+ message.getMessage());
    			System.out.println("id :"+ message.getErrorNumber());

    		}catch(Exception e) {
    			e.printStackTrace();
    			json.put("success", false);
    			json.put("msj", "Error inesperado");
    		}
    }
    
    
    @RequestMapping(value = "/sales/refundProduct", method = RequestMethod.POST)
    public void refundByProduct(@RequestBody Ventas sale, HttpServletResponse response,HttpServletRequest request) throws Exception {
    		response.setContentType("application/json");
    		JSONObject json = new JSONObject();
    		MessageTransaction message= new MessageTransaction();    		
    		try {
    			message= saleService.refundByProduct(sale);
    			json.put("success", true);
    			json.put("msj", message.getMessage());
    			json.put("id", message.getIdResult());
    		}catch(Exception e) {
    			e.printStackTrace();
    			json.put("success", false);
    			json.put("msj", "Error inesperado");
    		}
    }*/
    /*
     * Metodo: Encargado de obtener el reporte de venta
     *  
     * */
   /* @RequestMapping(value = "/sales/getReport", method = RequestMethod.GET)
    public ModelAndView  getReport(HttpServletResponse response,HttpServletRequest request) throws Exception {
    			String name=request.getParameter("nombreReporte");
    			Ventas sale= new Ventas();
    	        try {
    	        	//Se crea el archivo pdf
    	        	//sale.setId(request.getParameter("folio"));
    	        	//sale.setNombreSucursal(request.getParameter("nombreSucursal"));    
    	        	//sale.setNombreUsuario(request.getParameter("nombreUsuario"));    
    	        	
    	        	ByteArrayOutputStream byteOutStream = saleService.reportSale(name,request);
    	        	response.addHeader("Content-Disposition", "inline; filename="+name+".pdf");
    	            response.setContentType("application/pdf");
    	            byte[] bytes = byteOutStream.toByteArray();
    	            response.getOutputStream().write(bytes, 0, bytes.length);
    	            response.getOutputStream().flush();
    	            response.getOutputStream().close();
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	        }    	 
    	 

        return null;
    
    }
    
	
	@RequestMapping(value = "/sales/sales")
	public ModelAndView getSales() {
		return new ModelAndView("/sales/sale");
	}

	@RequestMapping(value = "/sales/refund")
	public ModelAndView getRefund() {

		return new ModelAndView("/sales/refundProduct");
	}

	@RequestMapping(value = "/sales/cancel")
	public ModelAndView getCancel() {

		return new ModelAndView("/sales/cancelSale");
	}
*/
	@RequestMapping(value = "/sales/sale", method = RequestMethod.POST)
	public void saveSale(@RequestBody Ventas sale, HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		response.setContentType("application/json");
		JSONObject json = new JSONObject();
		MessageTransaction message = new MessageTransaction();

		try {
			System.out.println("RequestBody [producto]: " + sale);

			message = saleService.save(sale);
			System.out.println("Mensaje" + message.getMessage());
			System.out.println("ID" + message.getIdResult());
			System.out.println("error" + message.getErrorNumber());

			json.put("success",true);
			json.put("msj", message.getMessage());
			json.put("error", message.getErrorNumber());
			json.put("id", message.getIdResult());
			
		} catch (Exception e) {
			e.printStackTrace();
			
			json.put("success", false);
			json.put("msj", "Error Inesperado");
			json.put("error", "0");
		}

		response.getWriter().print(Utilities.getJSON(json));
	}

	@RequestMapping(value = "/sales/cancelSale", method = RequestMethod.POST)
	public void cancelSale(@RequestBody Ventas sale, HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		response.setContentType("application/json");
		JSONObject json = new JSONObject();
		MessageTransaction message = new MessageTransaction();

		try {

			System.out.println("id " + sale.getId());
			message = saleService.delete(sale);
			
			json.put("success",true);
			json.put("msj", message.getMessage());
			json.put("error", message.getErrorNumber());
			json.put("id", message.getIdResult());

			System.out.println("message :" + message.getMessage());
			System.out.println("id :" + message.getErrorNumber());

		} catch (Exception e) {
			e.printStackTrace();
			
			json.put("success", false);
			json.put("msj", "Error Inesperado");
			json.put("error", "0");
		}

		response.getWriter().print(Utilities.getJSON(json));
	}

	@RequestMapping(value = "/sales/refundProduct", method = RequestMethod.POST)
	public void refundByProduct(@RequestBody Ventas sale, HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		response.setContentType("application/json");
		JSONObject json = new JSONObject();
		MessageTransaction message = new MessageTransaction();
		try {
			message = saleService.refundByProduct(sale);
			
			json.put("success",true);
			json.put("msj", message.getMessage());
			json.put("error", message.getErrorNumber());
			json.put("id", message.getIdResult());
			
		} catch (Exception e) {
			e.printStackTrace();
			
			json.put("success", false);
			json.put("msj", "Error Inesperado");
			json.put("error", "0");
		}

		response.getWriter().print(Utilities.getJSON(json));
	}

	/*
	 * Metodo: Encargado de obtener el reporte de venta
	 * 
	 */
	@RequestMapping(value = "/sales/getReport", method = RequestMethod.GET)
	public ModelAndView getReport(HttpServletResponse response, HttpServletRequest request) throws Exception {
		String name = request.getParameter("nombreReporte");
		Ventas sale = new Ventas();
		try {
			// Se crea el archivo pdf
			// sale.setId(request.getParameter("folio"));
			// sale.setNombreSucursal(request.getParameter("nombreSucursal"));
			// sale.setNombreUsuario(request.getParameter("nombreUsuario"));

			ByteArrayOutputStream byteOutStream = saleService.reportSale(name, request);
			response.addHeader("Content-Disposition", "inline; filename=" + name + ".pdf");
			response.setContentType("application/pdf");
			byte[] bytes = byteOutStream.toByteArray();
			response.getOutputStream().write(bytes, 0, bytes.length);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/sales/sales/getSale")
	public Object getSales(@RequestParam(value = "id",required = true) long id) {
		Ventas sale = new Ventas();
		sale.setId(id);
		return saleService.getAll(sale);
	}

	@RequestMapping(value = "/sales/sales/listSales")
	public Object[] listSales(@RequestParam(value = "filter",required = true) String filter) {
		return saleService.listSales(filter);
	}

	@RequestMapping(value = "/sales/sales/listSalesByProduct")
	public Object listSaleByProduct(@RequestParam(value = "id",required = true) long id) {
		return saleService.listSalesWithProducts(id);
	}
}
