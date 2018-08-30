package app.cfg;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer  implements WebApplicationInitializer {

	
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	
    	 servletContext.addListener(new HttpSessionEventPublisher());
    	 AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
         ctx.register(ConfiguracionMVC.class);
         ctx.setServletContext(servletContext);
         ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(ctx));      
         dispatcher.setLoadOnStartup(1);
       
         dispatcher.addMapping("/");
        
        servletContext.addFilter("springSecurityFilterChain", 
        		new DelegatingFilterProxy("springSecurityFilterChain"))
        			.addMappingForUrlPatterns(null, false, "/*");
        
        
    }
         
}