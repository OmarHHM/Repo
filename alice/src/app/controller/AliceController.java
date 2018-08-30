package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AliceController {
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error",required = false) String error) {
			ModelAndView model = new ModelAndView();
		
			if(error!=null){
				model.addObject("error","El usuario y la contraseña no coinciden.");
			}
			
			model.setViewName("login");
		return model;
	}
	
	
	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public ModelAndView logout() {
	return new ModelAndView("login");
	}
	
	@RequestMapping(value="/dashboard",method = RequestMethod.GET)
	public ModelAndView dashboard() {
	return new ModelAndView("/administration/dashboard");
	}
}
