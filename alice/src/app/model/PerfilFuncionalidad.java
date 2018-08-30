// Generated with WSg.

package app.model;

import java.io.Serializable;
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

public class PerfilFuncionalidad implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6364793323781445608L;
	private int id;
    private CatFuncionalidad catFuncionalidad;
    private CatPerfil catPerfil;

    /** Default constructor. */
    public PerfilFuncionalidad() {
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
     * Access method for catFuncionalidad.
     *
     * @return the current value of catFuncionalidad
     */
    public CatFuncionalidad getCatFuncionalidad() {
        return catFuncionalidad;
    }

    /**
     * Setter method for catFuncionalidad.
     *
     * @param aCatFuncionalidad the new value for catFuncionalidad
     */
    public void setCatFuncionalidad(CatFuncionalidad aCatFuncionalidad) {
        catFuncionalidad = aCatFuncionalidad;
    }

    /**
     * Access method for catPerfil.
     *
     * @return the current value of catPerfil
     */
    public CatPerfil getCatPerfil() {
        return catPerfil;
    }

    /**
     * Setter method for catPerfil.
     *
     * @param aCatPerfil the new value for catPerfil
     */
    public void setCatPerfil(CatPerfil aCatPerfil) {
        catPerfil = aCatPerfil;
    }
}
