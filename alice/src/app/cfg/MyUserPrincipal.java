package app.cfg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import app.model.Usuarios;

public class MyUserPrincipal  implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuarios user;
 
    public MyUserPrincipal(Usuarios user) {
        this.user = user;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		List<Usuarios> privilege= new ArrayList<Usuarios>();
//		Usuarios u= new Usuarios();
//		privilege.add(user);
		
        //for ( privilege : user.getPrivileges()) {
            authorities.add(new SimpleGrantedAuthority(user.getCodigoPerfil()));
        //}
        
        return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getClave();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
 
}