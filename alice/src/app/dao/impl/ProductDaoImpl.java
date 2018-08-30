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

import app.dao.ProductDao;
import app.model.*;

@Repository
public class ProductDaoImpl implements ProductDao {
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
//	private JdbcTemplate jdbcTemplate;
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
    
    @Transactional(propagation = Propagation.MANDATORY)
	public MessageTransaction save(Productos products) {		
		MessageTransaction tx= new MessageTransaction();
		tx=(MessageTransaction)jdbcTemplate.execute(
		 new CallableStatementCreator() { 
            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
                        "call REGISTRA_PRODUCTOS (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)"); 
                ps.setInt(1,products.getCatMarcasID());
                ps.setInt(2,products.getCatUnidadesID());
                ps.setString(3,products.getClave());
                ps.setString(4,products.getNombre());
                ps.setString(5,products.getDescripcion());
                ps.setString(6,products.getCodigoBarras());
                ps.setBigDecimal(7,products.getCosto());
                ps.setBigDecimal(8, products.getPrecioUnitario());
                ps.setBigDecimal(9, products.getPrecioMayoreo());
                ps.setBigDecimal(10,products.getDescuento());
                ps.registerOutParameter(11,Types.INTEGER);
                ps.registerOutParameter(12,(short) Types.VARCHAR);
                ps.registerOutParameter(13,Types.INTEGER);   
                ps.setLong(14,products.getClasificacionId());      
                return ps;
            	} 
        }, new CallableStatementCallback(){
			public Object doInCallableStatement(CallableStatement ps)
					throws SQLException, DataAccessException {
				MessageTransaction ms= new MessageTransaction();
				ps.execute();	
				ms.setErrorNumber(ps.getInt(11));
				ms.setMessage(ps.getString(12));
				ms.setIdResult(ps.getInt(13));
				return ms;
			}
        });
		return tx;
	}

	
	public MessageTransaction update(Productos products) {
		MessageTransaction tx= new MessageTransaction();
		tx=(MessageTransaction)jdbcTemplate.execute(
		 new CallableStatementCreator() { 
            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
                        "call ACTUALIZA_PRODUCTO (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?, ?,?)"); 
                ps.setLong(1, products.getId());
            	ps.setInt(2,products.getCatMarcasID());
                ps.setInt(3,products.getCatUnidadesID());
                ps.setString(4,products.getNombre());
                ps.setString(5,products.getDescripcion());
                
                ps.setBigDecimal(6,products.getCosto());
                ps.setBigDecimal(7, products.getPrecioUnitario());
                ps.setBigDecimal(8, products.getPrecioMayoreo());
                ps.setBigDecimal(9,products.getDescuento());
                ps.setString(10,products.getObservaciones());
                
             //   ps.setInt(11,products.getSucursal());
                ps.setLong(11,products.getClasificacionId());  
                ps.setString(12,products.getOper());
                ps.setInt(13, products.getCantidad());
                
                ps.registerOutParameter(14,Types.INTEGER);
                ps.registerOutParameter(15,Types.INTEGER);      
                ps.registerOutParameter(16,(short) Types.VARCHAR);
                    return ps;
            	} 
        }, new CallableStatementCallback(){
			public Object doInCallableStatement(CallableStatement ps)
					throws SQLException, DataAccessException {
				MessageTransaction ms= new MessageTransaction();
				ps.execute();	
				ms.setIdResult(ps.getInt(14));
				ms.setErrorNumber(ps.getInt(15));
				ms.setMessage(ps.getString(16));
				return ms;
			}
        });
		return tx;
	}

	public MessageTransaction saveInv(InventarioProductos products) {
		MessageTransaction tx= new MessageTransaction();
		tx=(MessageTransaction)jdbcTemplate.execute(
		 new CallableStatementCreator() { 
            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
                        "call REGISTRA_INVENTARIO_PRODUCTOS (?,?,?,?,?, ?,?)"); 
            	ps.setInt(1,products.getSucursalID());
            	ps.setLong(2,products.getProductID());
                ps.setInt(3, products.getNoExistencias());                
            	ps.setString(4,products.getObservaciones());
                
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
		return tx;	
	}
	
	
	
	public MessageTransaction updateInv(InventarioProductos products) {
		MessageTransaction tx= new MessageTransaction();
		
		tx=(MessageTransaction)jdbcTemplate.execute(
		 new CallableStatementCreator() { 
            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
                        "call ACTUALIZA_INVENTARIO (?,?,?,?,?, ?,?)"); 
                ps.setInt(1, products.getNoExistencias());                
            	ps.setInt(2,products.getTipoActInv());
                ps.setLong(3,products.getProductID());
                ps.setInt(4,products.getSucursalID());
                
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
		
		return tx;	
	}
	


	public Productos getAll(Productos producto) {
	      String query = "call CONSULTA_PRODUCTO (?,?,?);";
	      
	      System.out.println("cod "+producto.getCodigoBarras());
	      System.out.println("cod "+producto.getSucursalID()[0]);
	      System.out.println("cod "+producto.getId());
	      
	      Object[] parametros = { producto.getCodigoBarras(),producto.getSucursalID()[0],producto.getId() 
	    		       };
	      
		      List<Productos> row= jdbcTemplate.query(query, parametros,new RowMapper<Productos>() {
		    		public Productos mapRow(ResultSet rs, int rowNum) throws SQLException {
		    			Productos pro = new Productos();
		    			pro.setId(rs.getInt("ID"));
		    			pro.setCatMarcasID(rs.getInt("ID_CAT_MARCA"));
		    			pro.setCatUnidadesID(rs.getInt("ID_CAT_UNIDADES"));
		    			pro.setClave(rs.getString("CLAVE"));
		    			pro.setNombre(rs.getString("NOMBRE"));
		    			pro.setDescripcion(rs.getString("DESCRIPCION"));
		    			pro.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
		    			pro.setCosto(rs.getBigDecimal("COSTO"));
		    			pro.setPrecioUnitario(rs.getBigDecimal("PRECIO_UNITARIO"));
		    			pro.setPrecioMayoreo(rs.getBigDecimal("PRECIO_MAYOREO"));
		    			pro.setDescuento(rs.getBigDecimal("DESCUENTO"));
		    			pro.setClasificacionId(rs.getInt("CAT_CLASIFICACION_ID"));
		    			pro.setObservaciones(rs.getString("CLASIFICACION"));
		    			pro.setCantidad(rs.getInt("CANTIDAD"));
		    			return 	pro;
		    		}
		      });
	        return row.size() > 0 ? (Productos)row.get(0) : null;
	}	
	
	public Object[] listProducts(String filter,int sucursal) {
	      String query = "call LISTA_PRODUCTOS (?,?);";
	      Object[] parametros = { filter,sucursal};	      
	      List<Productos> list = jdbcTemplate.query(query, parametros,new RowMapper<Productos>() {
	    		public Productos mapRow(ResultSet rs, int rowNum) throws SQLException {
		    		Productos productos= new Productos();
		    		productos.setClave(rs.getString("CLAVE"));
		    		productos.setCantidad(rs.getInt("CANTIDAD"));
		    		productos.setNombre(rs.getString("NOMBRE"));
		    		productos.setDescripcion(rs.getString("DESCRIPCION"));
		    		productos.setPrecioMayoreo(rs.getBigDecimal("PRECIO_MAYOREO"));
		    		productos.setPrecioUnitario(rs.getBigDecimal("PRECIO_UNITARIO"));
		    		//productos.setSucursalID(rs.getInt("ID_SUCURSAL"));
		    		productos.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
		    		
	    			return 	productos;
	    		}
	      });		    
	   
	  return list.toArray();		
	}

	
	public Object[]	comboBoxCatUnid(int tipo){		
		  String query = "call CONSULTA_CATALOGOS (?);";
	      Object[] parametros = {tipo };	      
	      	List<CatUnidades>  row= jdbcTemplate.query(query, parametros,new RowMapper<CatUnidades>() {
		    		public CatUnidades mapRow(ResultSet rs, int rowNum) throws SQLException {
		    				CatUnidades cum= new CatUnidades();
		    				cum.setId(rs.getInt("ID"));
		    				cum.setNombre(rs.getString("Nombre"));
		    				return cum;
		    			
		    		}
		      });
	        return row.toArray();
	}
	
	public Object[]	comboBoxCatMarc(int tipo){		
		  String query = "call CONSULTA_CATALOGOS (?);";
	      Object[] parametros = {tipo };	      
	      	List<CatMarcas>  row= jdbcTemplate.query(query, parametros,new RowMapper<CatMarcas>() {
		    		public CatMarcas mapRow(ResultSet rs, int rowNum) throws SQLException {
		    				CatMarcas cm= new CatMarcas();
		    				cm.setId(rs.getInt("ID"));
		    				cm.setNombre(rs.getString("Nombre"));
		    				return cm;
		    		}
		      });
	        return row.toArray();
	}
	
	public Object[]	comboBoxCatCla(int tipo){		
		  String query = "call CONSULTA_CATALOGOS (?);";
	      Object[] parametros = {tipo };	      
	      	List<CatClasificaciones>  row= jdbcTemplate.query(query, parametros,new RowMapper<CatClasificaciones>() {
		    		public CatClasificaciones mapRow(ResultSet rs, int rowNum) throws SQLException {
		    			CatClasificaciones cm= new CatClasificaciones();
		    				cm.setId(rs.getInt("ID"));
		    				cm.setNombre(rs.getString("Nombre"));
		    				return cm;
		    		}
		      });
	        return row.toArray();
	}
	
	public Object[] listInv(int productID) {
	      String query = "call LISTA_INVENTARIOS (?);";
	      Object[] parametros = { productID};	      
	      List<InventarioProductos> list = jdbcTemplate.query(query, parametros,new RowMapper<InventarioProductos>() {
	    		public InventarioProductos mapRow(ResultSet rs, int rowNum) throws SQLException {
	    			InventarioProductos productos= new InventarioProductos();
		    		productos.setId(rs.getInt("ID"));
		    		productos.setNoExistencias(rs.getInt("CANTIDAD"));
		    		productos.setSucursalID(rs.getInt("ID_SUCURSAL"));
		    		productos.setProductID(rs.getInt("ID_PRODUCTO"));
		    		productos.setObservaciones(rs.getString("NOMBRE"));
	    			return 	productos;
	    		}
	      });		    
	   
	  return list.toArray();		
	}
	
	
	
}