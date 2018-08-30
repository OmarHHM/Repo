// Generated with WSg.

package app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

public class HistorialProductos implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 201522459331452318L;
	private long id;
    private String clave;
    private String nombre;
    private String descripcion;
    private String numeroSerie;
    private String codigoBarras;
    private BigDecimal costo;
    private BigDecimal precioUnitario;
    private BigDecimal precioMayoreo;
    private BigDecimal descuento;
    private Timestamp fechaAlta;
    private Timestamp fechaModificacion;
    private Productos productos;

    /** Default constructor. */
    public HistorialProductos() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(long aId) {
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
     * Access method for numeroSerie.
     *
     * @return the current value of numeroSerie
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Setter method for numeroSerie.
     *
     * @param aNumeroSerie the new value for numeroSerie
     */
    public void setNumeroSerie(String aNumeroSerie) {
        numeroSerie = aNumeroSerie;
    }

    /**
     * Access method for codigoBarras.
     *
     * @return the current value of codigoBarras
     */
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * Setter method for codigoBarras.
     *
     * @param aCodigoBarras the new value for codigoBarras
     */
    public void setCodigoBarras(String aCodigoBarras) {
        codigoBarras = aCodigoBarras;
    }

    /**
     * Access method for costo.
     *
     * @return the current value of costo
     */
    public BigDecimal getCosto() {
        return costo;
    }

    /**
     * Setter method for costo.
     *
     * @param aCosto the new value for costo
     */
    public void setCosto(BigDecimal aCosto) {
        costo = aCosto;
    }

    /**
     * Access method for precioUnitario.
     *
     * @return the current value of precioUnitario
     */
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Setter method for precioUnitario.
     *
     * @param aPrecioUnitario the new value for precioUnitario
     */
    public void setPrecioUnitario(BigDecimal aPrecioUnitario) {
        precioUnitario = aPrecioUnitario;
    }

    /**
     * Access method for precioMayoreo.
     *
     * @return the current value of precioMayoreo
     */
    public BigDecimal getPrecioMayoreo() {
        return precioMayoreo;
    }

    /**
     * Setter method for precioMayoreo.
     *
     * @param aPrecioMayoreo the new value for precioMayoreo
     */
    public void setPrecioMayoreo(BigDecimal aPrecioMayoreo) {
        precioMayoreo = aPrecioMayoreo;
    }

    /**
     * Access method for descuento.
     *
     * @return the current value of descuento
     */
    public BigDecimal getDescuento() {
        return descuento;
    }

    /**
     * Setter method for descuento.
     *
     * @param aDescuento the new value for descuento
     */
    public void setDescuento(BigDecimal aDescuento) {
        descuento = aDescuento;
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
     * Access method for productos.
     *
     * @return the current value of productos
     */
    public Productos getProductos() {
        return productos;
    }

    /**
     * Setter method for productos.
     *
     * @param aProductos the new value for productos
     */
    public void setProductos(Productos aProductos) {
        productos = aProductos;
    }

	@Override
	public String toString() {
		return "HistorialProductos [id=" + id + ", clave=" + clave + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", numeroSerie=" + numeroSerie + ", codigoBarras=" + codigoBarras + ", costo=" + costo
				+ ", precioUnitario=" + precioUnitario + ", precioMayoreo=" + precioMayoreo + ", descuento=" + descuento
				+ ", fechaAlta=" + fechaAlta + ", fechaModificacion=" + fechaModificacion + ", productos=" + productos
				+ "]";
	}


}
