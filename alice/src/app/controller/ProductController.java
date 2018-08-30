package app.controller;

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
import app.model.Productos;
import app.service.ProductService;
import app.utils.Utilities;


@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/products/product", method=RequestMethod.GET)
	public ModelAndView getProducts() {
		return new ModelAndView("products/product");
	}
	
	@RequestMapping(value="/products/editProduct", method=RequestMethod.POST)
	public void  onSubmit (HttpServletResponse response, HttpServletRequest request, @RequestBody Productos pro) throws Exception {
		MessageTransaction message = new MessageTransaction();
		response.setContentType("application/json");
		JSONObject json = new JSONObject();
		
		try {
			System.out.println("RequestBody [producto]: " + pro);
			
			if( pro.getOper()!=null && pro.getOper().equals("add") ){
				System.out.println("add");
				
				message = productService.save(pro);
				
			} else {
				
				pro.setId( pro.getIdProductSelec() );
				System.out.println("[producto]: " + pro);
				
				message = productService.update(pro);				
			}
			
			json.put("success",true);
			json.put("msj", message.getMessage());
			json.put("error", message.getErrorNumber());
			
		} catch(Exception e) {
			e.printStackTrace();
			
			json.put("success", false);
			json.put("msj", "Error Inesperado");
			json.put("error", "0");
		}
		
		response.getWriter().print(Utilities.getJSON(json));
	}
	
	@RequestMapping(value="/products/editStock", method=RequestMethod.POST)
	public void updateStock(HttpServletResponse response, HttpServletRequest request, @RequestBody Productos stock) throws Exception {
		response.setContentType("application/json");
		
		JSONObject json = new JSONObject();
		MessageTransaction message = new MessageTransaction();
		
		try {
			System.out.println(stock);
			
			message = productService.updateInv(stock);
			
			json.put("success",true);
			json.put("msj", message.getMessage());
			json.put("error", message.getErrorNumber());
			
		} catch(Exception e) {
			e.printStackTrace();
			
			json.put("success", false);
			json.put("msj", "Error Inesperado");
			json.put("error", "0");
		}
		
		response.getWriter().print(Utilities.getJSON(json));
	}
	
	@RequestMapping(value="/products/product/getProduct", method=RequestMethod.GET)
	public Object getProduct( @RequestBody Productos productos) {
		return productService.getAll(productos);
	}

	@RequestMapping(value="/products/product/listProducts", method=RequestMethod.GET)
	public Object[] listProducts(@RequestParam(value = "filter",required = true) String filter,@RequestParam(value = "branch",required = true) int branch) {
		return productService.listProducts(filter, branch);
	}

	@RequestMapping(value="/products/product/catalogs", method=RequestMethod.GET)
	public Object[] comboBox(@RequestParam(value = "type",required = true) int type){
		return productService.comboBoxCat(type);
	}
	
	@RequestMapping(value="/products/product/listBranchs", method=RequestMethod.GET)
	public Object[] listSucByProduct(@RequestParam(value = "id",required = true) int id){
		return productService.lstSucursalesProducto(id);
	}
}
