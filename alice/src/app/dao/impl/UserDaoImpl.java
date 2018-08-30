package app.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.dao.*;
import app.model.*;

@Repository
public class UserDaoImpl implements UserDAO{

//	private JdbcTemplate jdbcTemplate;
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	private PasswordEncoder passwordEncoder;
	
	public Usuarios consultaPorClave(String clave) {
		 String query = "call CONSULTA_USUARIO(?,?,?);";
	      Object[] parametros = {0,2,clave};
		      List<Usuarios> row= dummy();/*jdbcTemplate.query(query, parametros,new RowMapper<Usuarios>() {
		    		public Usuarios mapRow(ResultSet rs, int rowNum) throws SQLException {
		    			Usuarios user = new Usuarios();
		    			
		    			user.setId(rs.getLong("ID"));
		    			user.setPerfilID(rs.getInt("ID_CAT_PERFIL"));
		    			user.setClave(rs.getString("CLAVE"));
		    			user.setUsuario(rs.getString("USUARIO"));
		    			user.setPassword(rs.getString("PASSWORD"));
		    			user.setFechaAlta(rs.getString("FECHA_ALTA"));
		    			user.setEstatus(rs.getString("ESTATUS"));
		    			user.setNumeroEmpleado(rs.getString("NUMERO_EMPLEADO"));
		    			user.setSucursalID(rs.getInt("SUCURSAL_ID"));
		    			user.setCodigoPerfil(rs.getString("CODIGO"));
		    			return 	user;
		    		}
		      });*/
	        return row.size() > 0 ? (Usuarios)row.get(0) : null;
	}


    @Transactional(propagation = Propagation.MANDATORY)
	public MessageTransaction save(Usuarios user) {
		MessageTransaction tx= new MessageTransaction();
		try{
			tx=(MessageTransaction)jdbcTemplate.execute(
			 new CallableStatementCreator() { 
	            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
	            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
	                        "call REGISTRA_USUARIOS (?,?,?,?,?, ?,?,?,?)"); 
	            	ps.setInt(1,user.getPerfilID());
	                ps.setString(2,user.getClave());
	                ps.setString(3,user.getUsuario());
	                ps.setString(4,passwordEncoder.encodePassword(user.getPassword(), null));
	                ps.setString(5,user.getNumeroEmpleado());
	                ps.setInt(6,user.getSucursalID());
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
					ms.setIdResult(ps.getInt(7));
					ms.setErrorNumber(ps.getInt(8));
					ms.setMessage(ps.getString(9));
					return ms;
				}
	        });
		}catch(Exception e){
			System.out.println("Error en alta de usuarios "+e);
		}
		return tx;
	}


    @Transactional(propagation = Propagation.MANDATORY)
	public MessageTransaction update(Usuarios user) {
		MessageTransaction tx= new MessageTransaction();
		try{
			tx=(MessageTransaction)jdbcTemplate.execute(
			 new CallableStatementCreator() { 
	            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
	            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
	                        "call ACTUALIZA_USUARIO (?,?,?,?,?, ?,?)"); 
	            	ps.setString(1, user.getOperation());
	            	ps.setLong(2, user.getId());
	            	ps.setInt(3,user.getPerfilID());
	                ps.setString(4,passwordEncoder.encodePassword(user.getPassword(), null));

	            	System.out.println(user.getOperation());
	            	System.out.println(user.getId());
	            	System.out.println(user.getPerfilID());
	            	System.out.println(user.getPassword());
	            	System.out.println("pwd"+ passwordEncoder.encodePassword(user.getPassword(), null));
		  
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
			System.out.println("Error en modificación de usuarios "+e);
		}
		return tx;
	}

	public Usuarios getAll(Usuarios user) {
		 String query = "call CONSULTA_USUARIO(?,?,?);";
	      Object[] parametros = {user.getId(),1,user.getClave()};
		      List<Usuarios> row= dummy();/*jdbcTemplate.query(query, parametros,new RowMapper<Usuarios>() {
		    		public Usuarios mapRow(ResultSet rs, int rowNum) throws SQLException {
		    			Usuarios user = new Usuarios();
		    			
		    			user.setId(rs.getLong("ID"));
		    			user.setPerfilID(rs.getInt("ID_CAT_PERFIL"));
		    			user.setClave(rs.getString("CLAVE"));
		    			user.setUsuario(rs.getString("USUARIO"));
		    			user.setFechaAlta(rs.getString("FECHA_ALTA"));
		    			user.setEstatus(rs.getString("ESTATUS"));
		    			user.setNumeroEmpleado(rs.getString("NUMERO_EMPLEADO"));
		    			user.setSucursalID(rs.getInt("SUCURSAL_ID"));
		    			
		    			return 	user;
		    		}
		      });*/
	        return row.size() > 0 ? (Usuarios)row.get(0) : null;
	}


	@Override
	public Object[] listUser(String filter) {
		 String query = "call LISTA_USUARIOS(?);";
	      Object[] parametros = {filter};
		      List<Usuarios> row= dummy();/*jdbcTemplate.query(query, parametros,new RowMapper<Usuarios>() {
		    		public Usuarios mapRow(ResultSet rs, int rowNum) throws SQLException {
		    			Usuarios user = new Usuarios();
		    			user.setId(rs.getLong("ID"));
		    			user.setPerfilID(rs.getInt("ID_CAT_PERFIL"));
		    			user.setClave(rs.getString("CLAVE"));
		    			user.setUsuario(rs.getString("USUARIO"));
		    			user.setFechaAlta(rs.getString("FECHA_ALTA"));
		    			user.setEstatus(rs.getString("ESTATUS"));
		    			user.setNumeroEmpleado(rs.getString("NUMERO_EMPLEADO"));
		    			user.setSucursalID(rs.getInt("SUCURSAL_ID"));
		    			user.setNombrePerfil(rs.getString("NOMBRE"));
		    			user.setCodigoPerfil(rs.getString("CODIGO"));
		    			user.setDescripcionPerfil(rs.getString("DESCRIPCION"));
		    			user.setNombreEmp(rs.getString("NOMBREEEMP"));
		    			user.setApellidoPEmp(rs.getString("APELLIDO_PATERNO"));
		    			user.setApellidoMEmp(rs.getString("APELLIDO_MATERNO"));
		    					    			
		    			return 	user;
		    		}
		      });*/
		      
		      
	        return row.toArray();
	}
	
	
	@Override
	public Object[] listPerfil(String filter) {
		 String query = "call LISTA_PERFILES(?);";
	      Object[] parametros = {filter};
		      List<CatPerfil> row= dummyPerfil();/*jdbcTemplate.query(query, parametros,new RowMapper<CatPerfil>() {
		    		public CatPerfil mapRow(ResultSet rs, int rowNum) throws SQLException {
		    			CatPerfil perfil = new CatPerfil();
		    			perfil.setId(rs.getInt("ID"));
		    			perfil.setCodigo(rs.getString("CODIGO"));
		    			perfil.setDescripcion(rs.getString("DESCRIPCION"));
		    			perfil.setNombre(rs.getString("NOMBRE"));
		    			return 	perfil;
		    		}
		      });*/
	        return row.toArray();
	}
	
	
	private List<Usuarios> dummy(){
		
		System.out.println("okokokokokokokkokssssssss");
		List<Usuarios> listUser = new ArrayList<Usuarios>();
		Usuarios user = new Usuarios();
		user.setApellidoMEmp("HERNANDEZ");
		user.setApellidoPEmp("HERNANDEZ");
		user.setClave("OHERNANDEZ");
		user.setCodigoPerfil("ADMIN");
		user.setDescripcionPerfil("ADMINISTRACION");
		user.setEstatus("A");
		user.setFechaAlta("2019-01-01");
		user.setId(1);
		user.setNombreEmp("OMAR");
		user.setNombrePerfil("ADMIN");
		user.setNumeroEmpleado("1001");
		user.setOperation("");
						  //$2a$10$LQafYOegrNC68zlmTn/hWuEu8DIofOKk6x83ZKQvaBoe21VKEPRKW
		user.setPassword("$2a$10$LQafYOegrNC68zlmTn/hWuEu8DIofOKk6x83ZKQvaBoe21VKEPRKW");
		user.setPerfilID(1);
		user.setSucursalID(1);
		user.setUsuario("OHERNANDEZ");
		listUser.add(user);
		return listUser;
	}
	
	
	private List<CatPerfil> dummyPerfil(){
		List<CatPerfil> listPerfil = new ArrayList<CatPerfil>();
		CatPerfil perfil = new CatPerfil();
		
		
		perfil.setCodigo("ADMIN");
		perfil.setDescripcion("ADMINISTRACION");
		perfil.setEstatus("A");
		perfil.setId(1);
		perfil.setNombre("ADMINISTRACION DEL SISTEMA");
		listPerfil.add(perfil);
		
		perfil.setCodigo("USER");
		perfil.setDescripcion("USUARIO");
		perfil.setEstatus("A");
		perfil.setId(1);
		perfil.setNombre("USUARIO DEL SISTEMA");
		listPerfil.add(perfil);
		
		return listPerfil;
	}
	
	
	

}
