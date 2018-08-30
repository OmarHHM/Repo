package app.model;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SeguridadUsuarioDto extends User {

	private static final long serialVersionUID = -2829998721815629247L;
	private String salt;
	  
	public SeguridadUsuarioDto(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, List<GrantedAuthority> authorities, String salt){
	    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	    this.salt = salt;
	}
	  
	public String getSalt() {
	    return salt;
	}
	  
	public void setSalt(String salt) {
	    this.salt = salt;
	}
}