package app.service.impl;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.EmployeeDao;
import app.model.ContactosEmpleado;
import app.model.DireccionesEmpleado;
import app.model.Empleados;
import app.model.MessageTransaction;
import app.model.Telefonos;
import app.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	
    @Transactional(rollbackFor=Exception.class)
	public MessageTransaction save(Empleados emp) {
		MessageTransaction message=new MessageTransaction(); 
    	DireccionesEmpleado direcEmp= new DireccionesEmpleado();
    	ContactosEmpleado contact= new ContactosEmpleado();
    	Telefonos telephone= new Telefonos();
    	try{
    		message= employeeDao.saveEmp(emp);        		
    		emp.setNumeroEmpleado(String.valueOf(message.getIdResult()));
    		emp.setId(message.getErrorNumber());
    		telephone.setReferenciado("EMPLEADOS");     		
    		telephone.setIdPersona(emp.getId());
    		if(emp.getTelefonoCasaEmp()!=null&&	!emp.getTelefonoCasaEmp().equals("")){
        		telephone.setIdTipoTelefono(1);
        		telephone.setNumeroTel(emp.getTelefonoCasaEmp());
        		message=saveTelephone(telephone);
    		}

    		if(emp.getTelefonoCelEmp()!=null&&	!emp.getTelefonoCelEmp().equals("")){
    			telephone.setIdTipoTelefono(2);
        		telephone.setNumeroTel(emp.getTelefonoCelEmp());
        		message=saveTelephone(telephone);
    		}
    		
    		//Direcciones
    		direcEmp.setCalle(emp.getCalle());
    		direcEmp.setCodigoPostal(emp.getCodigoPostal());
    		direcEmp.setColonia(emp.getColonia());
    		direcEmp.setDelegacion(emp.getDelegacion());
    		direcEmp.setEstado(emp.getEstado());
    		direcEmp.setNumExt(emp.getNumExt());
    		direcEmp.setNumInt(emp.getNumInt());
    		direcEmp.setPais(emp.getPais());
    		direcEmp.setReferencia(emp.getReferencia());
    		direcEmp.setNumeroEmpleado(emp.getNumeroEmpleado());
    		//Contactos
    		contact.setApellidoMaterno(emp.getApellidoMContacto());
    		contact.setApellidoPaterno(emp.getApellidoPContacto());
    		contact.setNombre(emp.getNombreContacto());
    		contact.setNumeroEmpleado(emp.getNumeroEmpleado());
    		contact.setParentesco(emp.getParentesco());
    		contact.setPrioridad(emp.getPrioridadContacto());
   
    		if((direcEmp.getCalle()!=null &&! direcEmp.getCalle().equals(""))
    			&&(direcEmp.getCodigoPostal()!=null &&! direcEmp.getCodigoPostal().equals(""))
    			&&(direcEmp.getEstado()!=null &&! direcEmp.getEstado().equals(""))
    			&&(direcEmp.getPais()!=null &&! direcEmp.getPais().equals(""))
    			&&(direcEmp.getDelegacion()!=null &&! direcEmp.getDelegacion().equals(""))
    		){
    			
    			message=saveAddress(direcEmp);    		
    		}

    		if((contact.getNombre()!=null && !contact.getNombre().equals(""))
    				&&(contact.getPrioridad()!=null && !contact.getPrioridad().equals(""))){
    			message=saveContacts(contact);
    		}
    		
    		if(emp.getTelContactoCasa()!=null&&	!emp.getTelContactoCasa().equals("")){
        		telephone.setReferenciado("CONTACTOS_EMPLEADO");     		
        		telephone.setIdPersona(emp.getId());
        		telephone.setIdTipoTelefono(1);
        		telephone.setNumeroTel(emp.getTelContactoCasa());
        		saveTelephone(telephone);
    		}
    		
    		if(emp.getTelContactoCel()!=null&&	!emp.getTelContactoCel().equals("")){
    			telephone.setIdTipoTelefono(2);
    			telephone.setNumeroTel(emp.getTelContactoCel());
        		saveTelephone(telephone);
    		}	
    	}catch(Exception e){
    		message.setErrorNumber(999);
    		message.setIdResult(0);
    		message.setMessage("Error alta empleado");
    	}
    	return 	message;
	}

    @Transactional(rollbackFor=Exception.class)
	public MessageTransaction update(Empleados emp) {
    	Telefonos telephone= new Telefonos();
    	MessageTransaction message = new MessageTransaction();
		message=employeeDao.update(emp);
		
		telephone.setReferenciado("EMPLEADOS");     		
		telephone.setIdPersona(message.getIdResult());
		
		if(emp.getTelefonoCasaEmp()!=null&&!emp.getTelefonoCasaEmp().equals("")){
    		telephone.setIdTipoTelefono(1);
    		telephone.setNumeroTel(emp.getTelefonoCasaEmp());
			employeeDao.updateTelephone(telephone);
		}
		
		if(emp.getTelefonoCelEmp()!=null&&emp.getTelefonoCelEmp().equals("")){
			telephone.setIdTipoTelefono(2);
    		telephone.setNumeroTel(emp.getTelefonoCelEmp());
			employeeDao.updateTelephone(telephone);
		}
		return message;
	}
	
	public Empleados getAll(Empleados emp) {
		return employeeDao.getAll(emp);
	}

	public Object[] listEmployee(String filtrado) {
		return employeeDao.listEmployee(filtrado);
		
	}
	
    @Transactional(rollbackFor=Exception.class)
	public MessageTransaction saveAddress(DireccionesEmpleado address){
		return employeeDao.saveAddress(address);
	}
    
    @Transactional(rollbackFor=Exception.class)
	public MessageTransaction saveContacts(ContactosEmpleado cont){
		return employeeDao.saveContacts(cont);
	}
    
    @Transactional(rollbackFor=Exception.class)
	public MessageTransaction saveTelephone(Telefonos tel){
		return employeeDao.saveTelephone(tel);
	}	

}