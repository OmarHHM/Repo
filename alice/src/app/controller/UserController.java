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

import app.model.MessageTransaction;
import app.model.Usuarios;
import app.service.*;
import app.utils.Utilities;


@Controller
public class UserController {
	
    @Autowired
	private UserService userService;
  
    @RequestMapping(value = "/administration/users",method = RequestMethod.GET)
    public ModelAndView getUser() {
    	ModelAndView mav=new ModelAndView();
		mav.setViewName("/administration/user");
      	return mav;

    }
	 
    @RequestMapping(value = "/administration/editUser", method = RequestMethod.POST)
    public void editUser(@RequestBody Usuarios user, HttpServletResponse response,HttpServletRequest request) throws Exception {
    		response.setContentType("application/json");
    		JSONObject json = new JSONObject();
    		MessageTransaction message= new MessageTransaction();
    		
		    try{
		    	if(user.getOperation()!=null&&user.getOperation().equals("add")){
			    	message=userService.save(user);
		    	}else{
		    		message=userService.update(user);
		    	}
		    	json.put("success", true);
    			json.put("msj", message.getMessage());
    			json.put("id", message.getIdResult());
		    	
		    } catch(Exception e) {
				e.printStackTrace();
				json.put("Error", false);
				json.put("msj", "Error Inesperado");
			}
			
			response.getWriter().print(Utilities.getJSON(json));
	}  	

    @RequestMapping(value = "/administration/users/getUser",method = RequestMethod.GET)
    public Usuarios getUserByClave(@RequestParam(value ="clave",required = true) String clave){
    	return userService.consultaPorClave(clave);
    }
    
    @RequestMapping(value = "/administration/users/listUsers",method = RequestMethod.GET)
    public Object[] listUser(@RequestParam(value ="filter",required = true) String filter){
    	return userService.listUser(filter);
    }
    @RequestMapping(value = "/administration/users/getProfile",method = RequestMethod.GET)
    public Object[] getProfile(@RequestParam(value ="filter",required = true) String filter){
    	return userService.comboPerfil(filter);
    }
}
