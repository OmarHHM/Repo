package app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.dao.BranchDao;
import app.model.CatSucursales;

@Repository
public class BranchDaoImpl implements BranchDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
       this.jdbcTemplate = new JdbcTemplate(dataSource);
 }
//	private JdbcTemplate jdbcTemplate;
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
	@Override
	public CatSucursales save(CatSucursales suc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CatSucursales update(CatSucursales suc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CatSucursales delete(CatSucursales suc) {
		// TODO Auto-generated method stub
		return null;
	}

	public CatSucursales getAll(CatSucursales suc) {

	      String query = "call CONSULTA_SUCURSAL (?);";
	      Object[] parametros = {suc.getId()};
	      
	      List<CatSucursales> list=dummy();
	      /*
	      List<CatSucursales> list = jdbcTemplate.query(query, parametros,new RowMapper<CatSucursales>() {
	    		public CatSucursales mapRow(ResultSet rs, int rowNum) throws SQLException {
	    			CatSucursales sucr= new CatSucursales();
	    			sucr.setId(rs.getInt("ID"));
					sucr.setClave(rs.getString("CLAVE"));
					sucr.setNombre(rs.getString("NOMBRE"));
					sucr.setDescripcion(rs.getString("DESCRIPCION"));
					sucr.setDireccion(rs.getString("DIRECCION"));
					sucr.setTelefono(rs.getString("TELEFONO"));
					return 	sucr;
	    		}
	      });*/		    
	   
	      return list.size() > 0 ? (CatSucursales)list.get(0) : null;
	}		
	

	public Object[] listBranchsAct(CatSucursales suc) {
		      String query = "call LISTA_SUCURSALES ();";
		      Object[] parametros = { };
		      List<CatSucursales> list=dummy();
		      /*
		          
		      List<CatSucursales> list = jdbcTemplate.query(query, parametros,new RowMapper<CatSucursales>() {
		    		public CatSucursales mapRow(ResultSet rs, int rowNum) throws SQLException {
		    			CatSucursales sucr= new CatSucursales();
		    			sucr.setId(rs.getInt("ID"));
     					sucr.setClave(rs.getString("CLAVE"));
     					sucr.setNombre(rs.getString("NOMBRE"));
     					sucr.setDescripcion(rs.getString("DESCRIPCION"));
     					sucr.setDireccion(rs.getString("DIRECCION"));
     					sucr.setTelefono(rs.getString("TELEFONO"));
     					return 	sucr;
		    		}
		      });		    
		   */
		      return list.toArray();
	}
	
	private List<CatSucursales> dummy(){
		List<CatSucursales> listCat = new ArrayList<CatSucursales>();
		CatSucursales cat = new CatSucursales();
		
		cat.setClave("01");
		cat.setDescripcion("Sucursal Centro");
		cat.setEstatus("A");
		cat.setFechaAlta(new Timestamp(System.currentTimeMillis()));
		cat.setFechaModificacion(new Timestamp(System.currentTimeMillis()));
		cat.setId(1);
		cat.setNombre("Sucursal Centro");
		cat.setTelefono("019890292929");
		listCat.add(cat);
		
		cat.setClave("02");
		cat.setDescripcion("Sucursal Norte");
		cat.setEstatus("A");
		cat.setFechaAlta(new Timestamp(System.currentTimeMillis()));
		cat.setFechaModificacion(new Timestamp(System.currentTimeMillis()));
		cat.setId(1);
		cat.setNombre("Sucursal Norte");
		cat.setTelefono("019890292929");
		listCat.add(cat);
		return listCat;
	}
	
	
	
}