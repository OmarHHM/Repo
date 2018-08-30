package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.model.CatSucursales;
import app.service.*;

@Controller
public class BranchController {
	
    @Autowired
    private BranchService branchService;		
    
    
    public CatSucursales save(CatSucursales suc){
    	
    	return branchService.save(suc);		
    }
    

    public CatSucursales update(CatSucursales suc){

    	return branchService.update(suc);
    }
    
    public CatSucursales getAll(CatSucursales suc){
   
       	return branchService.getAll(suc);		
    }
   
    public CatSucursales delete(CatSucursales suc){
    	
       	return branchService.delete(suc);		
    }
    /*
     * Method: Metodo que recupera la lista de sucursales activo
     */
    public Object[] list (CatSucursales suc) {
    		System.out.println("IN suc: {}" + suc);
    	
    		Object[] obj= branchService.listBranchsAct( suc);
    		
    		System.out.println("obj: {}" + obj);
    		return obj;
    }
	@RequestMapping("/expenses/expense")
	public ModelAndView expense() {
		return new ModelAndView("expenses/expense");
	}
}
