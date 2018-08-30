package app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.UserDAO;
import app.model.MessageTransaction;
import app.model.Usuarios;
import app.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {	
	
	@Autowired
	private UserDAO userDao;
	
	@Override
	public Usuarios consultaPorClave(String clave) {
		
	/*	Usuarios usuario= new Usuarios();
		 usuario.setClave("ADMIN");
		 usuario.setEstatus("A");
		 usuario.setCodigoPerfil("ADMIN");
		 usuario.setPassword("123");
		*/
		return userDao.consultaPorClave(clave);	
	}
	
	@Transactional
	public MessageTransaction save(Usuarios user) {
		MessageTransaction mess= new MessageTransaction();
			if(user.getNumeroEmpleado().equals("0")){
				user.setNumeroEmpleado("");
			}
			mess=userDao.save(user);
		return mess;
	}

	@Transactional
	public MessageTransaction update(Usuarios user) {
		MessageTransaction mess= new MessageTransaction();
		mess=userDao.update(user);
		return mess;
	}
	
	public Usuarios getAll(Usuarios user) {	
		return userDao.getAll(user);
	}
	
	public Object[] listUser(String filter) {	
		return userDao.listUser(filter);
	}
		
	public Object[] comboPerfil(String filter){
		return userDao.listPerfil(filter);
	}

}
