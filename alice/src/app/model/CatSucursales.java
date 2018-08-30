package app.model;

import java.io.Serializable;
import java.sql.Timestamp;


public class CatSucursales implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8930686953416971585L;
	private int id;
    private String clave;
    private String nombre;
    private String descripcion;
    private String direccion;
    private String telefono;
    private Timestamp fechaAlta;
    private Timestamp fechaModificacion;
    private String estatus;

    
    /** Default constructor. */
    public CatSucursales() {
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
     * Access method for clave.
     *
     * @return the current value of clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * Setter method for clave.
     *
     * @param aClave the new value for clave
     */
    public void setClave(String aClave) {
        clave = aClave;
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
     * Access method for direccion.
     *
     * @return the current value of direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Setter method for direccion.
     *
     * @param aDireccion the new value for direccion
     */
    public void setDireccion(String aDireccion) {
        direccion = aDireccion;
    }

    /**
     * Access method for telefono.
     *
     * @return the current value of telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Setter method for telefono.
     *
     * @param aTelefono the new value for telefono
     */
    public void setTelefono(String aTelefono) {
        telefono = aTelefono;
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
     * Access method for fechaModificacion.
     *
     * @return the current value of fechaModificacion
     */
    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    /**
     * Setter method for fechaModificacion.
     *
     * @param aFechaModificacion the new value for fechaModificacion
     */
    public void setFechaModificacion(Timestamp aFechaModificacion) {
        fechaModificacion = aFechaModificacion;
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

	@Override
	public String toString() {
		return "CatSucursales [id=" + id + ", clave=" + clave + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", fechaAlta=" + fechaAlta
				+ ", fechaModificacion=" + fechaModificacion + ", estatus=" + estatus + "]";
	}

   

}
