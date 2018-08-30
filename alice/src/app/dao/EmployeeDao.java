package app.dao;

import app.model.*;

public interface EmployeeDao {

	public MessageTransaction update(Empleados emp);
	public Empleados getAll(Empleados emp);
	public Object[] listEmployee(String filtrado);
	public MessageTransaction saveEmp(Empleados emp);
	public MessageTransaction saveAddress(DireccionesEmpleado address);
	public MessageTransaction saveContacts(ContactosEmpleado cont);
	public MessageTransaction saveTelephone(Telefonos tel);
	public MessageTransaction updateTelephone(Telefonos tel);
	
}
