package br.com.marca.api.domain.dto;

public class CriarProfissionalDTO {

	private String nome;
	private String sobrenome;
	private String nomeFantasia;
	private String email;
	private String senha;
	private String telefone;
	private Long idEstabelecimento;

	public CriarProfissionalDTO() {

	}

	public CriarProfissionalDTO(String nome, String sobrenome, String nomeFantasia, String email, String senha,
			String telefone, Long idUsuario, Long idEstabelecimento) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomeFantasia = nomeFantasia;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.idEstabelecimento = idEstabelecimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Long getIdEstabelecimento() {
		return idEstabelecimento;
	}

	public void setIdEstabelecimento(Long idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}

}
