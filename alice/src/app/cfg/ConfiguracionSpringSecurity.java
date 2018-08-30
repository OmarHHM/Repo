package app.cfg;
import java.util.Arrays;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import app.utils.HorarioVoter;


@Configuration
@EnableWebSecurity
public class ConfiguracionSpringSecurity extends WebSecurityConfigurerAdapter {
	
	
	@Resource(name = "userDetailService")
	private UserDetailsService userDetailsService;
	
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}	
	
	
	
	@Bean
	  public PasswordEncoder  passwordEncoder() {
	    return new BCryptPasswordEncoder(10);
	 };
	

	@Bean
	public UnanimousBased accessDecisionManager() throws Exception {
		UnanimousBased unanimousBased = new UnanimousBased(
				Arrays.asList(new AuthenticatedVoter(), 
						  new WebExpressionVoter(), 
						  new RoleVoter(),
						  new HorarioVoter() ) );
	//	unanimousBased.setAllowIfAllAbstainDecisions(false);
	//	unanimousBased.afterPropertiesSet();

		return unanimousBased;
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf()
				.requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login"))
			.and()
				.authorizeRequests()
				.antMatchers("/pages/*").hasRole("ADMIN")
			.and()
				.formLogin().defaultSuccessUrl("/pages/*")
				.loginPage("/login")
			.and()
				.logout().permitAll()
				.logoutSuccessUrl("/pages/desconectado.jsp")
				.deleteCookies("JSESSIONID")
			.and()
				.sessionManagement()
				.invalidSessionUrl("/pages/sesion-expirada.jsp")
				.maximumSessions(1)
				.maxSessionsPreventsLogin(true);
			
		
		
		
		/*
				
		http
		.formLogin()
			.loginPage("/login")
			.failureUrl("/login?error");
		http
		.logout()
			.logoutSuccessUrl("/pages/desconectado.jsp")
			.deleteCookies("JSESSIONID");
	
		http
			.csrf().disable();
		
		http
			.sessionManagement()
			.invalidSessionUrl("/pages/sesion-expirada.jsp")
			.maximumSessions(1)
			.maxSessionsPreventsLogin(true);*/
		
		http
		.exceptionHandling()
		.accessDeniedPage("/pages/acceso-denegado.jsp");
		
		http
		.authorizeRequests()
			//.accessDecisionManager(accessDecisionManager())
			.antMatchers("/pages/*").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/**").access("isAuthenticated()");
	}
}