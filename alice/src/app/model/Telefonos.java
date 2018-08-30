package app.model;

public class Telefonos {

	private long id;
	private long idPersona;
	private int idTipoTelefono;
	private String referenciado;
	private String numeroTel;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}
	public int getIdTipoTelefono() {
		return idTipoTelefono;
	}
	public void setIdTipoTelefono(int idTipoTelefono) {
		this.idTipoTelefono = idTipoTelefono;
	}
	public String getReferenciado() {
		return referenciado;
	}
	public void setReferenciado(String referenciado) {
		this.referenciado = referenciado;
	}
	public String getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	
	
}
