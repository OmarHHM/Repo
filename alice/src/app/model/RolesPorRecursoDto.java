package app.model;
import java.util.HashMap;

public class RolesPorRecursoDto {

 HashMap rolesPorRecursoMapa = new HashMap();
 
 public RolesPorRecursoDto() {}
 
 public HashMap getRolesPorRecursoMapa() { return rolesPorRecursoMapa; }
 
 String listaRoles;
 public void setRolesPorRecursoMapa(HashMap rolesPorRecursoMapa) {
   this.rolesPorRecursoMapa = rolesPorRecursoMapa;
 }
 
 public String getListaRoles() {
   return listaRoles;
 }
 
 public void setListaRoles(String listaRoles) {
   this.listaRoles = listaRoles;
 }
}


