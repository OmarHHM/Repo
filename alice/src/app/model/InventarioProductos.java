
package app.model;

import java.io.Serializable;

public class InventarioProductos implements Serializable {

 
    /**
	 * 
	 */
	private static final long serialVersionUID = -6202565046649500542L;
	private long id;
    private int noExistencias;
    private String observaciones;
    private String fechaAlta;
    private String fechaModificacion;
    private String estatus;
    private long productID;
    private int sucursalID;
    private int tipoActInv;
    
    

    /** Default constructor. */
    public InventarioProductos() {
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

   

    public int getNoExistencias() {
		return noExistencias;
	}

	public void setNoExistencias(int noExistencias) {
		this.noExistencias = noExistencias;
	}

	/**
     * Access method for observaciones.
     *
     * @return the current value of observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Setter method for observaciones.
     *
     * @param aObservaciones the new value for observaciones
     */
    public void setObservaciones(String aObservaciones) {
        observaciones = aObservaciones;
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

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public int getSucursalID() {
		return sucursalID;
	}

	public void setSucursalID(int sucursalID) {
		this.sucursalID = sucursalID;
	}

	public int getTipoActInv() {
		return tipoActInv;
	}

	public void setTipoActInv(int tipoActInv) {
		this.tipoActInv = tipoActInv;
	}

    
}
