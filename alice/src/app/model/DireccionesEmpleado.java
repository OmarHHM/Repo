// Generated with WSg.

package app.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class DireccionesEmpleado implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8406662410836436073L;
	private long id;
    private String calle;
    private String colonia;
    private String delegacion;
    private String estado;
    private String pais;
    private String numExt;
    private String numInt;
    private String referencia;
    private String codigoPostal;
    
    private String estatus;
    private String numeroEmpleado;

    
    /** Default constructor. */
    public DireccionesEmpleado() {
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
     * Access method for calle.
     *
     * @return the current value of calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Setter method for calle.
     *
     * @param aCalle the new value for calle
     */
    public void setCalle(String aCalle) {
        calle = aCalle;
    }

    /**
     * Access method for colonia.
     *
     * @return the current value of colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Setter method for colonia.
     *
     * @param aColonia the new value for colonia
     */
    public void setColonia(String aColonia) {
        colonia = aColonia;
    }

    /**
     * Access method for delegacion.
     *
     * @return the current value of delegacion
     */
    public String getDelegacion() {
        return delegacion;
    }

    /**
     * Setter method for delegacion.
     *
     * @param aDelegacion the new value for delegacion
     */
    public void setDelegacion(String aDelegacion) {
        delegacion = aDelegacion;
    }

    /**
     * Access method for estado.
     *
     * @return the current value of estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Setter method for estado.
     *
     * @param aEstado the new value for estado
     */
    public void setEstado(String aEstado) {
        estado = aEstado;
    }

    /**
     * Access method for pais.
     *
     * @return the current value of pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * Setter method for pais.
     *
     * @param aPais the new value for pais
     */
    public void setPais(String aPais) {
        pais = aPais;
    }

    /**
     * Access method for numExt.
     *
     * @return the current value of numExt
     */
    public String getNumExt() {
        return numExt;
    }

    /**
     * Setter method for numExt.
     *
     * @param aNumExt the new value for numExt
     */
    public void setNumExt(String aNumExt) {
        numExt = aNumExt;
    }

    /**
     * Access method for numInt.
     *
     * @return the current value of numInt
     */
    public String getNumInt() {
        return numInt;
    }

    /**
     * Setter method for numInt.
     *
     * @param aNumInt the new value for numInt
     */
    public void setNumInt(String aNumInt) {
        numInt = aNumInt;
    }

    /**
     * Access method for referencia.
     *
     * @return the current value of referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Setter method for referencia.
     *
     * @param aReferencia the new value for referencia
     */
    public void setReferencia(String aReferencia) {
        referencia = aReferencia;
    }

    /**
     * Access method for codigoPostal.
     *
     * @return the current value of codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Setter method for codigoPostal.
     *
     * @param aCodigoPostal the new value for codigoPostal
     */
    public void setCodigoPostal(String aCodigoPostal) {
        codigoPostal = aCodigoPostal;
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

   

    public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	@Override
	public String toString() {
		return "DireccionesEmpleado [id=" + id + ", calle=" + calle + ", colonia=" + colonia + ", delegacion="
				+ delegacion + ", estado=" + estado + ", pais=" + pais + ", numExt=" + numExt + ", numInt=" + numInt
				+ ", referencia=" + referencia + ", codigoPostal=" + codigoPostal + ", estatus=" + estatus
				+ ", numeroEmpleado=" + numeroEmpleado + "]";
	}

	

}
