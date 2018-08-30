package app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.security.authentication.encoding.PasswordEncoder;

import com.google.gson.Gson;

public class Utilities {

	  public PasswordEncoder passwordEncoder;
	/**
	 * Clase que genera un objeto JSON a partir de un objero Java
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String getJSON(Object obj) throws Exception {
		try {
			
			Gson gson = new Gson();
			return gson.toJson(obj);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	
	//Metodo para convertir fecha
	public static String convertStringToDate(String dateToConvert){			 
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 SimpleDateFormat parse = new SimpleDateFormat("yyy-MM-dd");
		 Date date= null;
		 String dateConverted="1900-01-01";
		try {
			date = formatter.parse(dateToConvert);
			dateConverted=parse.format(date);
		} catch (ParseException e) {
			System.out.println("Error al convertir fecha");
			e.printStackTrace();
		}		
		return dateConverted;
	}
	
	/*
	 * Metodo para codificar pwd
	 * return String*/
	public   String pwdEncoding(String username){
		 String pwd= passwordEncoder.encodePassword(username,null);
		 System.out.println(pwd);
		 return pwd;
	}
	
   public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
      }
}
