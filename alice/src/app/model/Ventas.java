package app.model;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Ventas implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = -5469207613988833561L;
	private long id;
    private String conceptoVenta;
    private String comentarios;
    private String direccionEntrega;
    private int numProductosVendidos;
    private String formaPago;
    private float importeTotal;
    private float importeIva;
    private String fechaVenta;
    private String nombreCliente;
    private String direccionCliente;
    private String rfcCliente;
    private String telefonoCliente;
    private String estatusVenta;
    private String fechaModificacion;
    private int cantidadArticulos;
    
    private int usuarioID;
    private int sucursalID;
    private List<ArticulosVendidos> articulosVendidos;
    private String operation;
    private Integer[] existencias;
    private Long[] productoID;
    
    
    /** Default constructor. */
    public Ventas() {
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
     * Access method for conceptoVenta.
     *
     * @return the current value of conceptoVenta
     */
    public String getConceptoVenta() {
        return conceptoVenta;
    }

    /**
     * Setter method for conceptoVenta.
     *
     * @param aConceptoVenta the new value for conceptoVenta
     */
    public void setConceptoVenta(String aConceptoVenta) {
        conceptoVenta = aConceptoVenta;
    }

    /**
     * Access method for comentarios.
     *
     * @return the current value of comentarios
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * Setter method for comentarios.
     *
     * @param aComentarios the new value for comentarios
     */
    public void setComentarios(String aComentarios) {
        comentarios = aComentarios;
    }

    /**
     * Access method for direccionEntrega.
     *
     * @return the current value of direccionEntrega
     */
    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    /**
     * Setter method for direccionEntrega.
     *
     * @param aDireccionEntrega the new value for direccionEntrega
     */
    public void setDireccionEntrega(String aDireccionEntrega) {
        direccionEntrega = aDireccionEntrega;
    }

    /**
     * Access method for numProductosVendidos.
     *
     * @return the current value of numProductosVendidos
     */
    public int getNumProductosVendidos() {
        return numProductosVendidos;
    }

    /**
     * Setter method for numProductosVendidos.
     *
     * @param aNumProductosVendidos the new value for numProductosVendidos
     */
    public void setNumProductosVendidos(int aNumProductosVendidos) {
        numProductosVendidos = aNumProductosVendidos;
    }

    /**
     * Access method for formaPago.
     *
     * @return the current value of formaPago
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Setter method for formaPago.
     *
     * @param aFormaPago the new value for formaPago
     */
    public void setFormaPago(String aFormaPago) {
        formaPago = aFormaPago;
    }

    /**
     * Access method for importeTotal.
     *
     * @return the current value of importeTotal
     */
    public float getImporteTotal() {
        return importeTotal;
    }

    /**
     * Setter method for importeTotal.
     *
     * @param aImporteTotal the new value for importeTotal
     */
    public void setImporteTotal(float aImporteTotal) {
        importeTotal = aImporteTotal;
    }

    /**
     * Access method for importeIva.
     *
     * @return the current value of importeIva
     */
    public float getImporteIva() {
        return importeIva;
    }

    /**
     * Setter method for importeIva.
     *
     * @param aImporteIva the new value for importeIva
     */
    public void setImporteIva(float aImporteIva) {
        importeIva = aImporteIva;
    }


    /**
     * Access method for nombreCliente.
     *
     * @return the current value of nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Setter method for nombreCliente.
     *
     * @param aNombreCliente the new value for nombreCliente
     */
    public void setNombreCliente(String aNombreCliente) {
        nombreCliente = aNombreCliente;
    }

    /**
     * Access method for direccionCliente.
     *
     * @return the current value of direccionCliente
     */
    public String getDireccionCliente() {
        return direccionCliente;
    }

    /**
     * Setter method for direccionCliente.
     *
     * @param aDireccionCliente the new value for direccionCliente
     */
    public void setDireccionCliente(String aDireccionCliente) {
        direccionCliente = aDireccionCliente;
    }

    /**
     * Access method for rfcCliente.
     *
     * @return the current value of rfcCliente
     */
    public String getRfcCliente() {
        return rfcCliente;
    }

    /**
     * Setter method for rfcCliente.
     *
     * @param aRfcCliente the new value for rfcCliente
     */
    public void setRfcCliente(String aRfcCliente) {
        rfcCliente = aRfcCliente;
    }

    /**
     * Access method for telefonoCliente.
     *
     * @return the current value of telefonoCliente
     */
    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    /**
     * Setter method for telefonoCliente.
     *
     * @param aTelefonoCliente the new value for telefonoCliente
     */
    public void setTelefonoCliente(String aTelefonoCliente) {
        telefonoCliente = aTelefonoCliente;
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

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public int getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}

	public int getSucursalID() {
		return sucursalID;
	}

	public void setSucursalID(int sucursalID) {
		this.sucursalID = sucursalID;
	}


	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public List<ArticulosVendidos> getArticulosVendidos() {
		return articulosVendidos;
	}

	public void setArticulosVendidos(List<ArticulosVendidos> articulosVendidos) {
		this.articulosVendidos = articulosVendidos;
	}

	public int getCantidadArticulos() {
		return cantidadArticulos;
	}

	public void setCantidadArticulos(int cantidadArticulos) {
		this.cantidadArticulos = cantidadArticulos;
	}
	
	
	
	

	public Integer[] getExistencias() {
		return existencias;
	}

	public void setExistencias(Integer[] existencias) {
		this.existencias = existencias;
	}

	public Long[] getProductoID() {
		return productoID;
	}

	public void setProductoID(Long[] productoID) {
		this.productoID = productoID;
	}

	@Override
	public String toString() {
		return "Ventas [id=" + id + ", conceptoVenta=" + conceptoVenta + ", comentarios=" + comentarios
				+ ", direccionEntrega=" + direccionEntrega + ", numProductosVendidos=" + numProductosVendidos
				+ ", formaPago=" + formaPago + ", importeTotal=" + importeTotal + ", importeIva=" + importeIva
				+ ", fechaVenta=" + fechaVenta + ", nombreCliente=" + nombreCliente + ", direccionCliente="
				+ direccionCliente + ", rfcCliente=" + rfcCliente + ", telefonoCliente=" + telefonoCliente
				+ ", estatusVenta=" + estatusVenta + ", fechaModificacion=" + fechaModificacion + ", cantidadArticulos="
				+ cantidadArticulos + ", usuarioID=" + usuarioID + ", sucursalID=" + sucursalID + ", articulosVendidos="
				+ articulosVendidos + ", operation=" + operation + ", existencias=" + Arrays.toString(existencias)
				+ ", productoID=" + Arrays.toString(productoID) + "]";
	}



	

  

}
