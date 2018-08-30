package app.controller;

import java.util.List;

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

import app.model.Empleados;
import app.model.MessageTransaction;
import app.service.EmployeeService;
import app.utils.PersonType;
import app.utils.Utilities;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;	


    public ModelAndView save(Empleados emp){
	    	ModelAndView model = new ModelAndView();
	    	MessageTransaction mess= employeeService.save(emp);		
	    	model.addObject("message",mess.getMessage());
	    	
	    	return model;
    }
        
    @RequestMapping(value="/administration/personnel/getPersonnel",method = RequestMethod.GET)
    public Empleados getAll(@RequestBody Empleados emp){
    		return employeeService.getAll(emp);		
    }
    

    @RequestMapping(value = "/administration/personnel")
    public ModelAndView getEmployees() {
	    	ModelAndView model = new ModelAndView();
	    	
	    	model.addObject("F",PersonType.FISICA);
	    	model.addObject("M",PersonType.MORAL);
	    	model.setViewName("administration/employee");
    	
	    	return model;
    }
    
    
    @RequestMapping(value = "/administration/addressPersonnel")
    public ModelAndView getAddressPersonnel() {
   	    	return new ModelAndView("administration/employeeAddress");
    }
    
    @RequestMapping(value = "/administration/contactPersonnel")
    public ModelAndView getContactPersonnel() {
   	    	return new ModelAndView("administration/employeeContact");
    }
    

    @RequestMapping(value = "/administration/editPersonnel", method = RequestMethod.POST)
    public void editEmployee(@RequestBody Empleados emp, HttpServletResponse response,HttpServletRequest request) throws Exception {
    		response.setContentType("application/json");
    		JSONObject json = new JSONObject();
    		MessageTransaction message= new MessageTransaction();
    		
    		try {
    			String oper = emp.getOper();
    			
    			if ( oper != null && "add".equals(oper)) {
    				message = employeeService.save(emp);
    				
    			} else if ( oper != null && !oper.equals("") ) {
    				message = employeeService.update(emp);
    			}
    			

		    		json.put("success", true);
   	    			json.put("msj", message.getMessage());
   	    			json.put("id", message.getIdResult());
	    	
    		} catch(Exception e) {
    			e.printStackTrace();
    			json.put("success", false);
    			json.put("msj", "Error inesperado");
    		}
    		
    		response.getWriter().print(Utilities.getJSON(json));
    }
    
    @RequestMapping(value="/administration/personnel/listPersonnel",method = RequestMethod.GET)
    public Object[] listEmployee(@RequestParam(value = "filter",required = false) String filter){
    	return employeeService.listEmployee(filter);
    }
}
