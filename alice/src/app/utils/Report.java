package app.utils;

import java.util.Date;
import java.util.HashMap;

/**
 * Generates a report in the following scenario:
 * <ol>
 * <li>The report definition file is a .prpt file which will be loaded and parsed
 * <li>The data factory is a simple JDBC data factory using HSQLDB
 * <li>There are no runtime report parameters used
 * </ol>
 */
public class Report
{
  HashMap parametros;
  
  public Report()
  {
    parametros = new HashMap();
  }
  
  public void agregaParametro(String nombre, String valor) {
    parametros.put(nombre, valor);
  }
  
  public void agregaParametro(String nombre, int valor) {
    parametros.put(nombre, Integer.valueOf(valor));
  }
  
  public void agregaParametro(String nombre, long valor) {
    parametros.put(nombre, Long.valueOf(valor));
  }
  
  public void agregaParametro(String nombre, Date valor) {
    parametros.put(nombre, valor);
  }
  
  public void agregaParametro(String nombre, float valor) {
    parametros.put(nombre, Float.valueOf(valor));
  }
  
  public void agregaParametro(String nombre, double valor) { parametros.put(nombre, Double.valueOf(valor)); }
  

  public HashMap getParametros()
  {
    return parametros;
  }
}