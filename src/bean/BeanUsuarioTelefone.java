package bean;

public class BeanUsuarioTelefone {

	private Long idTelefone;
	private Long idUser;
	private String celular;
	private String residencial;
	
	public BeanUsuarioTelefone() {}
	
	
	
	public Long getIdTelefone() {
		return idTelefone;
	}


	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}


	public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getResidencial() {
		return residencial;
	}
	public void setResidencial(String residencial) {
		this.residencial = residencial;
	}
	
	
	
	
}
