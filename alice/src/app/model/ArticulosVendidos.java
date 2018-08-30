

package app.model;

import java.io.Serializable;

public class ArticulosVendidos implements Serializable {

  
    /**
	 * 
	 */
	private static final long serialVersionUID = 8354008436138249638L;
	private long id;
    private int unidadesVendidas;
    private String estatusVenta;
    private String fechaModificacion;
    private Long productID;
    private int sucursalID;
   

    /** Default constructor. */
    public ArticulosVendidos() {
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
     * Access method for unidadesVendidas.
     *
     * @return the current value of unidadesVendidas
     */
    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    /**
     * Setter method for unidadesVendidas.
     *
     * @param aUnidadesVendidas the new value for unidadesVendidas
     */
    public void setUnidadesVendidas(int aUnidadesVendidas) {
        unidadesVendidas = aUnidadesVendidas;
    }

    /**
     * Access method for estatusVenta.
     *
     * @return the current value of estatusVenta
     */
    public String getEstatusVenta() {
        return estatusVenta;
    }

    /**
     * Setter method for estatusVenta.
     *
     * @param aEstatusVenta the new value for estatusVenta
     */
    public void setEstatusVenta(String aEstatusVenta) {
        estatusVenta = aEstatusVenta;
    }

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}
	
	

	public int getSucursalID() {
		return sucursalID;
	}

	public void setSucursalID(int sucursalID) {
		this.sucursalID = sucursalID;
	}

	@Override
	public String toString() {
		return "ArticulosVendidos [id=" + id + ", unidadesVendidas=" + unidadesVendidas + ", estatusVenta="
				+ estatusVenta + ", fechaModificacion=" + fechaModificacion + ", productID=" + productID
				+ ", sucursalID=" + sucursalID + "]";
	}


   

}
