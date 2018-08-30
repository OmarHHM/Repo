// Generated with WSg.

package app.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

public class CatMarcas implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7489572741788475732L;
	private int id;
    private String clave;
    private String nombre;
    private String modelo;
    private String color;
    private String fechaAlta;
    private String estatus;
    private Set<Productos> productos;

    /** Default constructor. */
    public CatMarcas() {
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
     * Access method for modelo.
     *
     * @return the current value of modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Setter method for modelo.
     *
     * @param aModelo the new value for modelo
     */
    public void setModelo(String aModelo) {
        modelo = aModelo;
    }

    /**
     * Access method for color.
     *
     * @return the current value of color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter method for color.
     *
     * @param aColor the new value for color
     */
    public void setColor(String aColor) {
        color = aColor;
    }

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Set<Productos> getProductos() {
		return productos;
	}

	public void setProductos(Set<Productos> productos) {
		this.productos = productos;
	}

   

}
