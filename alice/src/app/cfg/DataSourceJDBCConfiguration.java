package app.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import app.dao.*;
import app.dao.impl.*;

import javax.sql.DataSource;

@Configuration
public class DataSourceJDBCConfiguration {

	@Bean 
	public DataSource dataSource(){
		
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
		 //MySQL database
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/tienda");//change url
        dataSource.setUsername("root");//change userid
        dataSource.setPassword("root");//change pwd
        
        return dataSource;
	}
	/*
 	@Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
 	
 	@Bean
    public UserDAO userDAO(){
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.setJdbcTemplate(jdbcTemplate());
        return userDao;
    }

 	
 	@Bean
    public BranchDao branchDao(){
 		BranchDaoImpl branchDao = new BranchDaoImpl();
        branchDao.setJdbcTemplate(jdbcTemplate());
        return branchDao;
    }
 	@Bean
    public EmployeeDao employeeDao(){
        EmployeeDaoImpl empDao = new EmployeeDaoImpl();
        empDao.setJdbcTemplate(jdbcTemplate());
        return empDao;
    }
 	@Bean
    public ProductDao productDao(){
        ProductDaoImpl productDao = new ProductDaoImpl();
        productDao.setJdbcTemplate(jdbcTemplate());
        return productDao;
    }
 	@Bean
    public SaleDao saleDao(){
        SaleDaoImpl saleDao = new SaleDaoImpl();
        saleDao.setJdbcTemplate(jdbcTemplate());
        return saleDao;
    } */	
}
