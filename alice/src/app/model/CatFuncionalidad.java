// Generated with WSg.

package app.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

public class CatFuncionalidad implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 332650927494418250L;
	private int id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Timestamp fechaAlta;
    private String estatus;
    private Set<PerfilFuncionalidad> perfilFuncionalidad;

    /** Default constructor. */
    public CatFuncionalidad() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for codigo.
     *
     * @return the current value of codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Setter method for codigo.
     *
     * @param aCodigo the new value for codigo
     */
    public void setCodigo(String aCodigo) {
        codigo = aCodigo;
    }

    /**
     * Access method for nombre.
     *
     * @return the current value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter method for nombre.
     *
     * @param aNombre the new value for nombre
     */
    public void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * Access method for descripcion.
     *
     * @return the current value of descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter method for descripcion.
     *
     * @param aDescripcion the new value for descripcion
     */
    public void setDescripcion(String aDescripcion) {
        descripcion = aDescripcion;
    }

    /**
     * Access method for fechaAlta.
     *
     * @return the current value of fechaAlta
     */
    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Setter method for fechaAlta.
     *
     * @param aFechaAlta the new value for fechaAlta
     */
    public void setFechaAlta(Timestamp aFechaAlta) {
        fechaAlta = aFechaAlta;
    }

    /**
     * Access method for estatus.
     *
     * @return the current value of estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * Setter method for estatus.
     *
     * @param aEstatus the new value for estatus
     */
    public void setEstatus(String aEstatus) {
        estatus = aEstatus;
    }

    /**
     * Access method for perfilFuncionalidad.
     *
     * @return the current value of perfilFuncionalidad
     */
    public Set<PerfilFuncionalidad> getPerfilFuncionalidad() {
        return perfilFuncionalidad;
    }

    /**
     * Setter method for perfilFuncionalidad.
     *
     * @param aPerfilFuncionalidad the new value for perfilFuncionalidad
     */
    public void setPerfilFuncionalidad(Set<PerfilFuncionalidad> aPerfilFuncionalidad) {
        perfilFuncionalidad = aPerfilFuncionalidad;
    }



   

}
