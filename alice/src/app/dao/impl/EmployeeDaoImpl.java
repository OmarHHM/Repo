package app.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.dao.EmployeeDao;
import app.model.ContactosEmpleado;
import app.model.DireccionesEmpleado;
import app.model.Empleados;
import app.model.MessageTransaction;
import app.model.Telefonos;
import app.model.Usuarios;
import app.utils.Utilities;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
//	private JdbcTemplate jdbcTemplate;
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
    
    @Transactional(propagation = Propagation.MANDATORY)
	public MessageTransaction update(Empleados emp) {
    	MessageTransaction tx= new MessageTransaction();
		try{
			tx=(MessageTransaction)jdbcTemplate.execute(
			 new CallableStatementCreator() { 
	            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
	            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
	                        "call ACTUALIZA_EMPLEADO (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)"); 
	            	ps.setString(1,emp.getNumeroEmpleado());
	                ps.setString(2,emp.getNombre());
	                ps.setString(3,emp.getApellidoPaterno());
	                ps.setString(4,emp.getApellidoMaterno());
	                ps.setString(5,Utilities.convertStringToDate(emp.getFechaNacimiento()));
	                ps.setString(6,emp.getNss());
	                ps.setString(7,emp.getCurp());
	                ps.setString(8,emp.getRfc());
	                ps.setString(9,emp.getTipoPersona());
	                ps.setString(10, emp.getEmail());
	                ps.setString(11, emp.getOper());
	                ps.registerOutParameter(12,Types.INTEGER);
	                ps.registerOutParameter(13,Types.INTEGER);  
	                ps.registerOutParameter(14,(short) Types.VARCHAR);
	                return ps;
	            	} 
	        }, new CallableStatementCallback(){
				public Object doInCallableStatement(CallableStatement ps)
						throws SQLException, DataAccessException {
					MessageTransaction ms= new MessageTransaction();
					ps.execute();	
					ms.setIdResult(ps.getInt(12));
					ms.setErrorNumber(ps.getInt(13));
					ms.setMessage(ps.getString(14));
					return ms;
				}
	        });
		}catch(Exception e){
			System.out.println("Error en Modificacion de empleado "+e);
		}
		return tx;
	}

    
    @Transactional(propagation = Propagation.MANDATORY)
	public  MessageTransaction saveEmp(Empleados emp){
		MessageTransaction tx= new MessageTransaction();
		try{
			tx=(MessageTransaction)jdbcTemplate.execute(
			 new CallableStatementCreator() { 
	            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
	            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
	                        "call REGISTRA_EMPLEADOS (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)"); 
	                ps.setString(1,emp.getNombre());
	                ps.setString(2,emp.getApellidoPaterno());
	                ps.setString(3,emp.getApellidoMaterno());
	                ps.setString(4,Utilities.convertStringToDate(emp.getFechaNacimiento()));
	                ps.setString(5,emp.getNss());
	                ps.setString(6,emp.getCurp());
	                ps.setString(7,emp.getRfc());
	                ps.setString(8, Utilities.convertStringToDate(emp.getFchIngreso()));
	                ps.setString(9,emp.getTipoPersona());
	                ps.setInt(10,emp.getSucursalID());
	                ps.setString(11, emp.getEmail());
	                ps.registerOutParameter(12,Types.INTEGER);
	                ps.registerOutParameter(13,Types.INTEGER);  
	                ps.registerOutParameter(14,(short) Types.VARCHAR);
	                return ps;
	            	} 
	        }, new CallableStatementCallback(){
				public Object doInCallableStatement(CallableStatement ps)
						throws SQLException, DataAccessException {
					MessageTransaction ms= new MessageTransaction();
					ps.execute();	
					ms.setMessage(ps.getString(14));
					ms.setErrorNumber(ps.getInt(13));
					ms.setIdResult(ps.getInt(12));
					return ms;
				}
	        });
		}catch(Exception e){
			System.out.println("Error en alta de empleados "+e);
		}
		return tx;
	}

    @Transactional(propagation = Propagation.MANDATORY)
	public  MessageTransaction saveAddress(DireccionesEmpleado address) {
		MessageTransaction tx= new MessageTransaction();
		try{
			tx=(MessageTransaction)jdbcTemplate.execute(
			 new CallableStatementCreator() { 
	            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
	            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
	                        "call REGISTRA_DIRECCIONES_EMP (?,?,?,?,?, ?,?,?,?,? ,?,?,?)"); 
	                ps.setString(1,address.getCalle());
	                ps.setString(2,address.getColonia());
	                ps.setString(3,address.getDelegacion());
	                
	                ps.setString(4,address.getEstado());
	                ps.setString(5,address.getPais());
	                ps.setString(6,address.getNumExt());
	                
	                ps.setString(7,address.getNumInt());
	                ps.setString(8,address.getReferencia());
	                ps.setString(9,address.getCodigoPostal());
	                
	                ps.setString(10,address.getNumeroEmpleado());
	                
	                ps.registerOutParameter(11,Types.INTEGER);
	                ps.registerOutParameter(12,Types.INTEGER);  
	                ps.registerOutParameter(13,(short) Types.VARCHAR);
	                return ps;
	            	} 
	        }, new CallableStatementCallback(){
				public Object doInCallableStatement(CallableStatement ps)
						throws SQLException, DataAccessException {
					MessageTransaction ms= new MessageTransaction();
					ps.execute();	
					ms.setMessage(ps.getString(13));
					ms.setErrorNumber(ps.getInt(12));
					ms.setIdResult(ps.getInt(11));
					return ms;
				}
	        });
		}catch(Exception e ){
			System.out.println("Error en alta de Direcciones. "+ e);
		}
		return tx;
		
	}

    @Transactional(propagation = Propagation.MANDATORY)
    public  MessageTransaction saveContacts(ContactosEmpleado cont) {
	
		MessageTransaction tx= new MessageTransaction();
		try{
			tx=(MessageTransaction)jdbcTemplate.execute(
			 new CallableStatementCreator() { 
	            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
	            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
	                        "call REGISTRA_CONTACTOS_EMP (?,?,?,?,?, ?,?,?,?)"); 
	                ps.setString(1,cont.getNombre());
	                ps.setString(2,cont.getApellidoPaterno());
	                ps.setString(3,cont.getApellidoMaterno());
	                
	                ps.setString(4,cont.getParentesco());
	                ps.setString(5,cont.getPrioridad());
	                ps.setString(6,cont.getNumeroEmpleado());
	             
	                ps.registerOutParameter(7,Types.INTEGER);
	                ps.registerOutParameter(8,Types.INTEGER);  
	                ps.registerOutParameter(9,(short) Types.VARCHAR);
	                return ps;
	            	} 
	        }, new CallableStatementCallback(){
				public Object doInCallableStatement(CallableStatement ps)
						throws SQLException, DataAccessException {
					MessageTransaction ms= new MessageTransaction();
					ps.execute();	
					ms.setMessage(ps.getString(9));
					ms.setErrorNumber(ps.getInt(8));
					ms.setIdResult(ps.getInt(7));
					return ms;
				}
	        });
		}catch(Exception e){
			System.out.println("Error en alta de contactos. "+ e);
		}
		return tx;
	}

    @Transactional(propagation = Propagation.MANDATORY)
	public  MessageTransaction saveTelephone(Telefonos tel) {
		
		MessageTransaction tx= new MessageTransaction();
		try{
			tx=(MessageTransaction)jdbcTemplate.execute(
			 new CallableStatementCreator() { 
	            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
	            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
	                        "call REGISTRA_TELEFONOS (?,?,?,?,?, ?,?)"); 
	                ps.setLong(1,tel.getIdPersona());
	                ps.setLong(2,tel.getIdTipoTelefono());
	                ps.setString(3,tel.getReferenciado());
	                ps.setString(4,tel.getNumeroTel());
	                ps.registerOutParameter(5,Types.INTEGER);
	                ps.registerOutParameter(6,Types.INTEGER);  
	                ps.registerOutParameter(7,(short) Types.VARCHAR);
	                return ps;
	            	} 
	        }, new CallableStatementCallback(){
				public Object doInCallableStatement(CallableStatement ps)
						throws SQLException, DataAccessException {
					MessageTransaction ms= new MessageTransaction();
					ps.execute();	
					ms.setMessage(ps.getString(7));
					ms.setErrorNumber(ps.getInt(6));
					ms.setIdResult(ps.getInt(5));
					return ms;
				}
	        });
		}catch(Exception e){
			System.out.println("Error en alta de telefonos. " +e);
		}
		return tx;
	}
	
	
	/*
	 * Lista de recuperacion de empleados  por un filtro*/
	public Object[] listEmployee(String filtred) {
	      String query = "call LISTA_EMPLEADOS (?);";
	      System.out.println(filtred);
	      Object[] parametros = { filtred};
	      
	      List<Empleados> list = dummy();/*jdbcTemplate.query(query, parametros,new RowMapper<Empleados>() {
	    		public Empleados mapRow(ResultSet rs, int rowNum) throws SQLException {
		    		Empleados employee= new Empleados();
		    		employee.setId(rs.getInt("ID"));
		    		employee.setNumeroEmpleado(rs.getString("NUMERO_EMPLEADO"));
		    		employee.setNombre(rs.getString("NOMBRE"));
		    		employee.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
		    		employee.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
		    		employee.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
		    		employee.setEmail(rs.getString("EMAIL"));
		    		return 	employee;
	    		}
	      });		    
	   */
	  return list.toArray();		
	}
	

	
	public Empleados getAll(Empleados emp) {
		 String query = "call CONSULTA_EMPLEADO (?);";
	      Object[] parametros = {emp.getNumeroEmpleado() 
	    		       };
		      List<Empleados> row= dummy();/*jdbcTemplate.query(query, parametros,new RowMapper<Empleados>() {
		    		public Empleados mapRow(ResultSet rs, int rowNum) throws SQLException {
		    			Empleados pro = new Empleados();
		    			pro.setId(rs.getInt("ID"));
		    			pro.setNumeroEmpleado(rs.getString("NUMERO_EMPLEADO"));
		    			pro.setNombre(rs.getString("NOMBRE"));
		    			pro.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
		    			pro.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
		    			pro.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
		    			pro.setNss(rs.getString("NSS"));
		    			pro.setCurp(rs.getString("CURP"));
		    			pro.setRfc(rs.getString("RFC"));
		    			pro.setFchIngreso(rs.getString("FECHA_INGRESO"));
		    			pro.setTipoPersona(rs.getString("TIPO_PERSONA"));
		    			pro.setSucursalID(rs.getInt("ID_CAT_SUCURSALES"));
		    			pro.setEstatus(rs.getString("ESTATUS"));
		    			pro.setEmail(rs.getString("EMAIL"));
		    			pro.setTelefonoCasaEmp(rs.getString("telCasa"));
		    			pro.setTelefonoCelEmp(rs.getString("telCel"));
		    			
		    			return 	pro;
		    		}
		      });*/
	        return row.size() > 0 ? (Empleados)row.get(0) : null;
	}


    @Transactional(propagation = Propagation.MANDATORY)
	public MessageTransaction updateTelephone(Telefonos tel) {
		MessageTransaction tx= new MessageTransaction();
		try{
			tx=(MessageTransaction)jdbcTemplate.execute(
			 new CallableStatementCreator() { 
	            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
	            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
	                        "call ACTUALIZA_TELEFONO (?,?,?,?,?, ?,?)"); 
	                ps.setLong(1,tel.getIdPersona());
	                ps.setString(2,tel.getReferenciado());
	                ps.setString(3,tel.getNumeroTel());
	                ps.setLong(4,tel.getIdTipoTelefono());
	                ps.registerOutParameter(5,Types.INTEGER);
	                ps.registerOutParameter(6,Types.INTEGER);  
	                ps.registerOutParameter(7,(short) Types.VARCHAR);
	                return ps;
	            	} 
	        }, new CallableStatementCallback(){
				public Object doInCallableStatement(CallableStatement ps)
						throws SQLException, DataAccessException {
					MessageTransaction ms= new MessageTransaction();
					ps.execute();	
					ms.setIdResult(ps.getInt(5));
					ms.setErrorNumber(ps.getInt(6));
					ms.setMessage(ps.getString(7));
					return ms;
				}
	        });
		}catch(Exception e){
			System.out.println("Error en alta de telefonos. " +e);
		}
		return tx;
	}
    
    
    private List<Empleados> dummy(){
		List<Empleados> listEmp = new ArrayList<Empleados>();
		Empleados emp = new Empleados();
		
		emp.setId(1);
		emp.setNumeroEmpleado("1001");
		emp.setNombre("OMAR");
		emp.setApellidoPaterno("HERNANDEZ");
		emp.setApellidoMaterno("HERNANDEZ");
		emp.setFechaNacimiento("2019-01-01");
		emp.setNss("101010101");
		emp.setCurp("CURP");
		emp.setRfc("RFC");
		emp.setFchIngreso("2019-01-01");
		emp.setTipoPersona("F");
		emp.setSucursalID(1);
		emp.setEstatus("A");
		emp.setEmail("EMIL");
		emp.setTelefonoCasaEmp("");
		emp.setTelefonoCelEmp("");
		return listEmp;
    }
    
    
    
}
