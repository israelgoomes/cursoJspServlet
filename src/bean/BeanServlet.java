package bean;

public class BeanServlet {

	private Long idUser;
	private String nome;
	private String senha;
	private String email;
	private String celular;
	private String residencial;
	
	
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



	public BeanServlet(){}
	
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Long getIdUser() {
		return idUser;
	}



	public void setIdUser(Long id_user) {
		this.idUser = id_user;
	}
	
}
