package app.service;

import app.model.Empleados;
import app.model.MessageTransaction;

public interface EmployeeService {


	public MessageTransaction save(Empleados emp);
	public MessageTransaction update(Empleados emp);
	public Empleados getAll(Empleados emp);
	public Object[] listEmployee(String filtrado);
}
