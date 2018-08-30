package app.model;

import java.io.Serializable;

public class Empleados implements Serializable {

	private static final long serialVersionUID = 1L;
	private String oper;
	private long id;
    private String numeroEmpleado;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String nss;
    private String curp;
    private String rfc;
    private String tipoPersona;
    private String fchIngreso;
    private String fechaModifica;
    private String estatus;
    private int sucursalID;
    private String email ;
    
    /*Telephones*/
    private String telefonoCasaEmp;
    private String telefonoCelEmp;
    
    /*Address*/
    private String calle;
    private String pais;
    private String numExt;
    private String numInt;
    private String estado;
    private String delegacion;
    private String colonia;
    private String codigoPostal;
    private String referencia;
    
    /*Usuarios*/
    private String usuarioID;
    
    /*Contactos*/
    private String nombreContacto;
    private String apellidoPContacto;
    private String apellidoMContacto;
    private String parentesco;
    private String prioridadContacto;
    private String telContactoCasa;
    private String telContactoCel;
    
    /*Otros*/
    private DireccionesEmpleado direccionesEmpleado;
    private Usuarios usuarios;
    private ContactosEmpleado contactos;
    private Telefonos	telefono;
    
    
    /** Default constructor. */
    public Empleados() {
        super();
    }

    public String getOper() {
		return oper;
	}
    
    public void setOper(String oper) {
		this.oper = oper;
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
     * Access method for numeroEmpleado.
     *
     * @return the current value of numeroEmpleado
     */
    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    /**
     * Setter method for numeroEmpleado.
     *
     * @param aNumeroEmpleado the new value for numeroEmpleado
     */
    public void setNumeroEmpleado(String aNumeroEmpleado) {
        numeroEmpleado = aNumeroEmpleado;
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
     * Access method for apellidoPaterno.
     *
     * @return the current value of apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Setter method for apellidoPaterno.
     *
     * @param aApellidoPaterno the new value for apellidoPaterno
     */
    public void setApellidoPaterno(String aApellidoPaterno) {
        apellidoPaterno = aApellidoPaterno;
    }

    /**
     * Access method for apellidoMaterno.
     *
     * @return the current value of apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Setter method for apellidoMaterno.
     *
     * @param aApellidoMaterno the new value for apellidoMaterno
     */
    public void setApellidoMaterno(String aApellidoMaterno) {
        apellidoMaterno = aApellidoMaterno;
    }

    /**
     * Access method for fechaNacimiento.
     *
     * @return the current value of fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Setter method for fechaNacimiento.
     *
     * @param aFechaNacimiento the new value for fechaNacimiento
     */
    public void setFechaNacimiento(String aFechaNacimiento) {
        fechaNacimiento = aFechaNacimiento;
    }

    /**
     * Access method for nss.
     *
     * @return the current value of nss
     */
    public String getNss() {
        return nss;
    }

    /**
     * Setter method for nss.
     *
     * @param aNss the new value for nss
     */
    public void setNss(String aNss) {
        nss = aNss;
    }

    /**
     * Access method for curp.
     *
     * @return the current value of curp
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Setter method for curp.
     *
     * @param aCurp the new value for curp
     */
    public void setCurp(String aCurp) {
        curp = aCurp;
    }

    /**
     * Access method for rfc.
     *
     * @return the current value of rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Setter method for rfc.
     *
     * @param aRfc the new value for rfc
     */
    public void setRfc(String aRfc) {
        rfc = aRfc;
    }

    /**
     * Access method for tipoPersona.
     *
     * @return the current value of tipoPersona
     */
    public String getTipoPersona() {
        return tipoPersona;
    }

    /**
     * Setter method for tipoPersona.
     *
     * @param aTipoPersona the new value for tipoPersona
     */
    public void setTipoPersona(String aTipoPersona) {
        tipoPersona = aTipoPersona;
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
     * Access method for direccionesEmpleado.
     *
     * @return the current value of direccionesEmpleado
     */
    public DireccionesEmpleado getDireccionesEmpleado() {
        return direccionesEmpleado;
    }

    /**
     * Setter method for direccionesEmpleado.
     *
     * @param aDireccionesEmpleado the new value for direccionesEmpleado
     */
    public void setDireccionesEmpleado(DireccionesEmpleado aDireccionesEmpleado) {
        direccionesEmpleado = aDireccionesEmpleado;
    }

    /**
     * Access method for usuarios.
     *
     * @return the current value of usuarios
     */
    public Usuarios getUsuarios() {
        return usuarios;
    }

    /**
     * Setter method for usuarios.
     *
     * @param aUsuarios the new value for usuarios
     */
    public void setUsuarios(Usuarios aUsuarios) {
        usuarios = aUsuarios;
    }

  
    public Telefonos getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefonos telefono) {
		this.telefono = telefono;
	}

	

    public String getFchIngreso() {
		return fchIngreso;
	}

	public void setFchIngreso(String fchIngreso) {
		this.fchIngreso = fchIngreso;
	}

	public String getFechaModifica() {
		return fechaModifica;
	}

	public void setFechaModifica(String fechaModifica) {
		this.fechaModifica = fechaModifica;
	}

	public int getSucursalID() {
		return sucursalID;
	}

	public void setSucursalID(int sucursalID) {
		this.sucursalID = sucursalID;
	}

	public String getTelefonoCasaEmp() {
		return telefonoCasaEmp;
	}

	public void setTelefonoCasaEmp(String telefonoCasaEmp) {
		this.telefonoCasaEmp = telefonoCasaEmp;
	}

	public String getTelefonoCelEmp() {
		return telefonoCelEmp;
	}

	public void setTelefonoCelEmp(String telefonoCelEmp) {
		this.telefonoCelEmp = telefonoCelEmp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public ContactosEmpleado getContactos() {
		return contactos;
	}

	public void setContactos(ContactosEmpleado contactos) {
		this.contactos = contactos;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(String usuarioID) {
		this.usuarioID = usuarioID;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getApellidoPContacto() {
		return apellidoPContacto;
	}

	public void setApellidoPContacto(String apellidoPContacto) {
		this.apellidoPContacto = apellidoPContacto;
	}

	public String getApellidoMContacto() {
		return apellidoMContacto;
	}

	public void setApellidoMContacto(String apellidoMContacto) {
		this.apellidoMContacto = apellidoMContacto;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getPrioridadContacto() {
		return prioridadContacto;
	}

	public void setPrioridadContacto(String prioridadContacto) {
		this.prioridadContacto = prioridadContacto;
	}

	public String getTelContactoCasa() {
		return telContactoCasa;
	}

	public void setTelContactoCasa(String telContactoCasa) {
		this.telContactoCasa = telContactoCasa;
	}

	public String getTelContactoCel() {
		return telContactoCel;
	}

	public void setTelContactoCel(String telContactoCel) {
		this.telContactoCel = telContactoCel;
	}

	public String getNumExt() {
		return numExt;
	}

	public void setNumExt(String numExt) {
		this.numExt = numExt;
	}

	public String getNumInt() {
		return numInt;
	}

	public void setNumInt(String numInt) {
		this.numInt = numInt;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "Empleados [oper=" + oper + ", id=" + id + ", numeroEmpleado=" + numeroEmpleado + ", nombre=" + nombre
				+ ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento="
				+ fechaNacimiento + ", nss=" + nss + ", curp=" + curp + ", rfc=" + rfc + ", tipoPersona=" + tipoPersona
				+ ", fchIngreso=" + fchIngreso + ", fechaModifica=" + fechaModifica + ", estatus=" + estatus
				+ ", sucursalID=" + sucursalID + ", email=" + email + ", telefonoCasaEmp=" + telefonoCasaEmp
				+ ", telefonoCelEmp=" + telefonoCelEmp + ", calle=" + calle + ", pais=" + pais + ", numExt=" + numExt
				+ ", numInt=" + numInt + ", estado=" + estado + ", delegacion=" + delegacion + ", colonia=" + colonia
				+ ", codigoPostal=" + codigoPostal + ", referencia=" + referencia + ", usuarioID=" + usuarioID
				+ ", nombreContacto=" + nombreContacto + ", apellidoPContacto=" + apellidoPContacto
				+ ", apellidoMContacto=" + apellidoMContacto + ", parentesco=" + parentesco + ", prioridadContacto="
				+ prioridadContacto + ", telContactoCasa=" + telContactoCasa + ", telContactoCel=" + telContactoCel
				+ ", direccionesEmpleado=" + direccionesEmpleado + ", usuarios=" + usuarios + ", contactos=" + contactos
				+ ", telefono=" + telefono + "]";
	}

}
