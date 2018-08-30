// Generated with WSg.

package app.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Scope(value = "singleton")
@Component
public class Usuarios implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5144344528771989217L;
	private long id;
    private String clave;
    private String usuario;
    private String password;
    private String fechaAlta;
    private String estatus;
    private String numeroEmpleado;
    private int perfilID;
    private int sucursalID;
    private String operation;
    //Atributos extras 
    private String nombrePerfil;
    private String codigoPerfil;
    private String descripcionPerfil;
    private String nombreEmp;
    private String apellidoPEmp;
    private String apellidoMEmp;
	public static String STATUS_ACTIVO = "A";
    private String username;
    
    /** Default constructor. */
    public Usuarios() {
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
     * Access method for usuario.
     *
     * @return the current value of usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Setter method for usuario.
     *
     * @param aUsuario the new value for usuario
     */
    public void setUsuario(String aUsuario) {
        usuario = aUsuario;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
    

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

	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public int getPerfilID() {
		return perfilID;
	}

	public void setPerfilID(int perfilID) {
		this.perfilID = perfilID;
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
	
	
	

	public String getNombrePerfil() {
		return nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	public String getCodigoPerfil() {
		return codigoPerfil;
	}

	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}

	public String getDescripcionPerfil() {
		return descripcionPerfil;
	}

	public void setDescripcionPerfil(String descripcionPerfil) {
		this.descripcionPerfil = descripcionPerfil;
	}

	public String getNombreEmp() {
		return nombreEmp;
	}

	public void setNombreEmp(String nombreEmp) {
		this.nombreEmp = nombreEmp;
	}

	public String getApellidoPEmp() {
		return apellidoPEmp;
	}

	public void setApellidoPEmp(String apellidoPEmp) {
		this.apellidoPEmp = apellidoPEmp;
	}

	public String getApellidoMEmp() {
		return apellidoMEmp;
	}

	public void setApellidoMEmp(String apellidoMEmp) {
		this.apellidoMEmp = apellidoMEmp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", clave=" + clave + ", usuario=" + usuario + ", password=" + password
				+ ", fechaAlta=" + fechaAlta + ", estatus=" + estatus + ", numeroEmpleado=" + numeroEmpleado
				+ ", perfilID=" + perfilID + ", sucursalID=" + sucursalID + ", operation=" + operation
				+ ", nombrePerfil=" + nombrePerfil + ", codigoPerfil=" + codigoPerfil + ", descripcionPerfil="
				+ descripcionPerfil + ", nombreEmp=" + nombreEmp + ", apellidoPEmp=" + apellidoPEmp + ", apellidoMEmp="
				+ apellidoMEmp + ", username=" + username + "]";
	}

	

}
