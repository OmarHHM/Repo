package app.cfg;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User;

import app.model.Usuarios;
import app.service.impl.UserServiceImpl;

@Component(value = "userDetailService")
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 
		 Usuarios user=userServiceImpl.consultaPorClave(username);
		 if(user==null){
			 throw new UsernameNotFoundException("Usuario y password invalido.");
		 }
		 User usuario= new User(String.valueOf(user.getId()), user.getPassword(), getAuthority());
		 return  usuario;
		 
//		 MyUserPrincipal users= new MyUserPrincipal(user);
//		 System.out.println(users.getPassword());
//		 System.out.println(users.getUsername());
//		 System.out.println(users.getAuthorities().size());
//		 
//		 return users;
	}

	private List getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

}
