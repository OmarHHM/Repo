// Generated with WSg.

package app.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CatSucursalCaja implements Serializable {

    /** Primary key. */
    protected static final String PK = "CatSucursalCajaPrimary";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    private int id;
    private String clave;
    private String nombre;
    private float saldoInicial;
    private Timestamp fechaCorte;
    private String estatus;
    private CatSucursales catSucursales;
    private Set<Ventas> ventas;

    /** Default constructor. */
    public CatSucursalCaja() {
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
     * Access method for saldoInicial.
     *
     * @return the current value of saldoInicial
     */
    public float getSaldoInicial() {
        return saldoInicial;
    }

    /**
     * Setter method for saldoInicial.
     *
     * @param aSaldoInicial the new value for saldoInicial
     */
    public void setSaldoInicial(float aSaldoInicial) {
        saldoInicial = aSaldoInicial;
    }

    /**
     * Access method for fechaCorte.
     *
     * @return the current value of fechaCorte
     */
    public Timestamp getFechaCorte() {
        return fechaCorte;
    }

    /**
     * Setter method for fechaCorte.
     *
     * @param aFechaCorte the new value for fechaCorte
     */
    public void setFechaCorte(Timestamp aFechaCorte) {
        fechaCorte = aFechaCorte;
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
     * Access method for catSucursales.
     *
     * @return the current value of catSucursales
     */
    public CatSucursales getCatSucursales() {
        return catSucursales;
    }

    /**
     * Setter method for catSucursales.
     *
     * @param aCatSucursales the new value for catSucursales
     */
    public void setCatSucursales(CatSucursales aCatSucursales) {
        catSucursales = aCatSucursales;
    }

    /**
     * Access method for ventas.
     *
     * @return the current value of ventas
     */
    public Set<Ventas> getVentas() {
        return ventas;
    }

    /**
     * Setter method for ventas.
     *
     * @param aVentas the new value for ventas
     */
    public void setVentas(Set<Ventas> aVentas) {
        ventas = aVentas;
    }

    /** Temporary value holder for group key fragment catSucursalesId */
    private transient int tempCatSucursalesId;

    /**
     * Gets the key fragment id for member catSucursales.
     * If this.catSucursales is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setCatSucursalesId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see CatSucursales
     */
    public int getCatSucursalesId() {
        return (getCatSucursales() == null ? tempCatSucursalesId : getCatSucursales().getId());
    }

    /**
     * Sets the key fragment id from member catSucursales.
     * If this.catSucursales is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getCatSucursalesId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see CatSucursales
     */
    public void setCatSucursalesId(int aId) {
        if (getCatSucursales() == null) {
            tempCatSucursalesId = aId;
        } else {
            getCatSucursales().setId(aId);
        }
    }

    /**
     * Compares the key for this instance with another CatSucursalCaja.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class CatSucursalCaja and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof CatSucursalCaja)) {
            return false;
        }
        CatSucursalCaja that = (CatSucursalCaja) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        Object myClave = this.getClave();
        Object yourClave = that.getClave();
        if (myClave==null ? yourClave!=null : !myClave.equals(yourClave)) {
            return false;
        }
        if (this.getCatSucursalesId() != that.getCatSucursalesId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another CatSucursalCaja.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CatSucursalCaja)) return false;
        return this.equalKeys(other) && ((CatSucursalCaja)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        if (getClave() == null) {
            i = 0;
        } else {
            i = getClave().hashCode();
        }
        result = 37*result + i;
        i = getCatSucursalesId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[CatSucursalCaja |");
        sb.append(" id=").append(getId());
        sb.append(" clave=").append(getClave());
        sb.append(" catSucursalesId=").append(getCatSucursalesId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", new Integer(getId()));
        ret.put("clave", getClave());
        ret.put("catSucursalesId", new Integer(getCatSucursalesId()));
        return ret;
    }

}
