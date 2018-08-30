package app.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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

import app.dao.SaleDao;
import app.model.*;
@Repository
public class SaleDaoImpl implements SaleDao {
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
//	private JdbcTemplate jdbcTemplate;
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
    
    @Transactional(propagation = Propagation.MANDATORY)
	public MessageTransaction save(Ventas sales) {
    	MessageTransaction tx= new MessageTransaction();
		tx=(MessageTransaction)jdbcTemplate.execute(
		 new CallableStatementCreator() { 
            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
                        "call REGISTRA_VENTAS (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)"); 
                ps.setInt(1,sales.getSucursalID());
                ps.setInt(2,sales.getUsuarioID());
                ps.setString(3,sales.getConceptoVenta());
                ps.setString(4,sales.getComentarios());
                ps.setString(5,sales.getDireccionEntrega());
                ps.setInt(6,sales.getCantidadArticulos());
                ps.setString(7,sales.getFormaPago());
                ps.setFloat(8, sales.getImporteTotal());
                ps.setFloat(9,sales.getImporteIva());
                ps.setString(10,sales.getNombreCliente());
                ps.setString(11,sales.getDireccionCliente());
                ps.setString(12,sales.getRfcCliente());
                ps.setString(13,sales.getTelefonoCliente());
                
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
				ms.setErrorNumber(ps.getInt(15));
				ms.setMessage(ps.getString(16));
				ms.setIdResult(ps.getInt(14));
				return ms;
			}
        });
		return tx;
	}

    @Transactional(propagation = Propagation.MANDATORY)
	public MessageTransaction update(Ventas sales) {
		// TODO Auto-generated method stub
		return null;
	}


    @Transactional(propagation = Propagation.MANDATORY)
	public MessageTransaction saveSoldProducts(ArticulosVendidos soldProducts, long idVenta) {
		soldProducts.setEstatusVenta("A");
		MessageTransaction tx= new MessageTransaction();
		tx=(MessageTransaction)jdbcTemplate.execute(
		 new CallableStatementCreator() { 
            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
                        "call REGISTRA_ARTICULOS_VENDIDOS (?,?,?,?,?, ?,?,?)"); 
                ps.setLong(1,idVenta);
                ps.setLong(2,soldProducts.getProductID());
                ps.setInt(3,soldProducts.getSucursalID());
                ps.setString(4,soldProducts.getEstatusVenta());
                ps.setInt(5,soldProducts.getUnidadesVendidas());                
                ps.registerOutParameter(6,Types.INTEGER);
                ps.registerOutParameter(7,Types.INTEGER);      
                ps.registerOutParameter(8,(short) Types.VARCHAR);
                return ps;
            	} 
        }, new CallableStatementCallback(){
			public Object doInCallableStatement(CallableStatement ps)
					throws SQLException, DataAccessException {
				MessageTransaction ms= new MessageTransaction();
				ps.execute();	
				ms.setIdResult(ps.getInt(6));
				ms.setErrorNumber(ps.getInt(7));
				ms.setMessage(ps.getString(8));
				return ms;
			}
        });
		return tx;
	}

    @Transactional(propagation = Propagation.MANDATORY)
	public MessageTransaction delete(Ventas sales) {
		System.out.println("id dar"+sales.getId());

		MessageTransaction tx= new MessageTransaction();
		tx=(MessageTransaction)jdbcTemplate.execute(
		 new CallableStatementCreator() { 
            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
                        "call CANCELA_VENTA (?,?,?,?)"); 
                ps.setLong(1,sales.getId());     
                ps.registerOutParameter(2,Types.INTEGER);
                ps.registerOutParameter(3,Types.INTEGER);      
                ps.registerOutParameter(4,(short) Types.VARCHAR);
                return ps;
            	} 
        }, new CallableStatementCallback(){
			public Object doInCallableStatement(CallableStatement ps)
					throws SQLException, DataAccessException {
				MessageTransaction ms= new MessageTransaction();
				ps.execute();	
				ms.setErrorNumber(ps.getInt(3));
				ms.setMessage(ps.getString(4));
				ms.setIdResult(ps.getInt(2));
				return ms;
			}
        });
		return tx;
	}

    @Transactional(propagation = Propagation.MANDATORY)
	public MessageTransaction refundByProduct(ArticulosVendidos art, long idVenta) {
		MessageTransaction tx= new MessageTransaction();
		tx=(MessageTransaction)jdbcTemplate.execute(
		 new CallableStatementCreator() { 
            public CallableStatement  createCallableStatement(Connection connection) throws SQLException { 
            	CallableStatement ps = (CallableStatement) connection.prepareCall( 
                        "call DEVOLUCION_PRODUCTOS (?,?,?,?,? ,?,?)"); 
                ps.setLong(1,art.getProductID());
                ps.setLong(2,idVenta);
                ps.setInt(3,art.getUnidadesVendidas());
                ps.setInt(4,art.getSucursalID());
                ps.registerOutParameter(5,Types.INTEGER);
                ps.registerOutParameter(6,(short) Types.VARCHAR);
                ps.registerOutParameter(7,Types.INTEGER);      
                return ps;
            	} 
        }, new CallableStatementCallback(){
			public Object doInCallableStatement(CallableStatement ps)
					throws SQLException, DataAccessException {
				MessageTransaction ms= new MessageTransaction();
				ps.execute();	
				ms.setErrorNumber(ps.getInt(5));
				ms.setMessage(ps.getString(6));
				ms.setIdResult(ps.getInt(7));
				return ms;
			}
        });
		return tx;
	}
    
	public Ventas getAll(Ventas sales) {
		 String query = "call CONSULTA_VENTA (?);";
	      Object[] parametros = {sales.getId()};
	      
		      List<Ventas> row= jdbcTemplate.query(query, parametros,new RowMapper<Ventas>() {
		    		public Ventas mapRow(ResultSet rs, int rowNum) throws SQLException {
		    			Ventas sale = new Ventas();
		    			sale.setId(rs.getInt("ID"));
		    			sale.setConceptoVenta(rs.getString("CONCEPTO_VENTA"));
		    			sale.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
		    			sale.setEstatusVenta(rs.getString("ESTATUS_VENTA"));
		    			return 	sale;
		    		}
		      });
	        return row.size() > 0 ? (Ventas)row.get(0) : null;
	}

    
    public Object[] listSales(String filter) {
    	  int EstatusAct=1;
    	  long id=0;
	      String query = "call LISTA_VENTAS (?,?,?);";
	      Object[] parametros = { filter,EstatusAct,id};	      
	      List<Ventas> list = jdbcTemplate.query(query, parametros,new RowMapper<Ventas>() {
	    		public Ventas mapRow(ResultSet rs, int rowNum) throws SQLException {
	    			Ventas sales= new Ventas();
	    			sales.setId(rs.getLong("ID"));
		    		sales.setConceptoVenta(rs.getString("CONCEPTO_VENTA"));
		    		sales.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
	    			return 	sales;
	    		}
	      });		    
	   
	  return list.toArray();		
	}
    
    public Object[] listSalesWithProducts(long idSale) {
  	  int EstatusByProduct=2;
	      String query = "call LISTA_VENTAS (?,?,?);";
	      Object[] parametros = { "",EstatusByProduct,idSale};	      
	      List<Productos> list = jdbcTemplate.query(query, parametros,new RowMapper<Productos>() {
	    		public Productos mapRow(ResultSet rs, int rowNum) throws SQLException {
	    			Productos sales= new Productos();
	    			sales.setId(rs.getLong("ID"));
	    			sales.setClave(rs.getString("CLAVE"));
		    		sales.setNombre(rs.getString("NOMBRE"));
		    		sales.setDescripcion(rs.getString("DESCRIPCION"));
		    		sales.setCantidad(rs.getInt("UNIDADES_VENDIDAS"));
	    			return 	sales;
	    		}
	      });		    
	   
	  return list.toArray();		
	}
    
    
    
}
