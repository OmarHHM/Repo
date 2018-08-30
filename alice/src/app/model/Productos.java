package app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

public class Productos implements Serializable {

	private static final long serialVersionUID = -1463859897921587424L;
	private long id;
    private String clave;
    private String codigoBarras;
    private String nombre;
    private String descripcion;
    private BigDecimal costo;
    private BigDecimal precioUnitario;
    private BigDecimal precioMayoreo;
    private BigDecimal descuento;
 
    private int cantidad;
    private int catMarcasID;
    private int catUnidadesID;
    private String observaciones;
    private Integer[] sucursalID;
    private int noSucursales;
    private int clasificacionId;
    
    private String fechaAlta;
    private String fechaModificacion;
    private String estatus;
    private String oper;
    private int tipoActInv;
    private Integer[] noExistencias;
    
    // actualizar stock
    private int idProductSelec;
    private int sucursalDisponible;
    private int noNuevasUnidades;
    
    
    /** Default constructor. */
    public Productos() {
        super();
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getPrecioMayoreo() {
		return precioMayoreo;
	}

	public void setPrecioMayoreo(BigDecimal precioMayoreo) {
		this.precioMayoreo = precioMayoreo;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCatMarcasID() {
		return catMarcasID;
	}

	public void setCatMarcasID(int catMarcasID) {
		this.catMarcasID = catMarcasID;
	}

	public int getCatUnidadesID() {
		return catUnidadesID;
	}

	public void setCatUnidadesID(int catUnidadesID) {
		this.catUnidadesID = catUnidadesID;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer[] getSucursalID() {
		return sucursalID;
	}

	public void setSucursalID(Integer[] sucursalID) {
		this.sucursalID = sucursalID;
	}

	public int getNoSucursales() {
		return noSucursales;
	}

	public void setNoSucursales(int noSucursales) {
		this.noSucursales = noSucursales;
	}

	public int getClasificacionId() {
		return clasificacionId;
	}

	public void setClasificacionId(int clasificacionId) {
		this.clasificacionId = clasificacionId;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public int getTipoActInv() {
		return tipoActInv;
	}

	public void setTipoActInv(int tipoActInv) {
		this.tipoActInv = tipoActInv;
	}

	public Integer[] getNoExistencias() {
		return noExistencias;
	}

	public void setNoExistencias(Integer[] noExistencias) {
		this.noExistencias = noExistencias;
	}

	public int getIdProductSelec() {
		return idProductSelec;
	}

	public void setIdProductSelec(int idProductSelec) {
		this.idProductSelec = idProductSelec;
	}

	public int getSucursalDisponible() {
		return sucursalDisponible;
	}

	public void setSucursalDisponible(int sucursalDisponible) {
		this.sucursalDisponible = sucursalDisponible;
	}

	public int getNoNuevasUnidades() {
		return noNuevasUnidades;
	}

	public void setNoNuevasUnidades(int noNuevasUnidades) {
		this.noNuevasUnidades = noNuevasUnidades;
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", clave=" + clave + ", codigoBarras=" + codigoBarras + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", costo=" + costo + ", precioUnitario=" + precioUnitario
				+ ", precioMayoreo=" + precioMayoreo + ", descuento=" + descuento + ", cantidad=" + cantidad
				+ ", catMarcasID=" + catMarcasID + ", catUnidadesID=" + catUnidadesID + ", observaciones="
				+ observaciones + ", sucursalID=" + Arrays.toString(sucursalID) + ", noSucursales=" + noSucursales
				+ ", clasificacionId=" + clasificacionId + ", fechaAlta=" + fechaAlta + ", fechaModificacion="
				+ fechaModificacion + ", estatus=" + estatus + ", oper=" + oper + ", tipoActInv=" + tipoActInv
				+ ", noExistencias=" + Arrays.toString(noExistencias) + ", idProductSelec=" + idProductSelec
				+ ", sucursalDisponible=" + sucursalDisponible + ", noNuevasUnidades=" + noNuevasUnidades + "]";
	}

}
