package app.dao;

import app.model.*;

public interface UserDAO {

	public Usuarios consultaPorClave(String clave);
	public MessageTransaction save(Usuarios user);
	public MessageTransaction update(Usuarios user);
	public Usuarios getAll(Usuarios user);
	public Object[] listUser(String filter);
	public Object[] listPerfil(String filter);
}
