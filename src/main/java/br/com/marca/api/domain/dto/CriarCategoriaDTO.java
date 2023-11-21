package br.com.marca.api.domain.dto;

public class CriarCategoriaDTO {

	private String nome;
	private String imagem;
	private Long idEstabelecimento;

	public CriarCategoriaDTO() {

	}

	public CriarCategoriaDTO(String nome, String imagem, Long idEstabelecimento) {
		this.nome = nome;
		this.imagem = imagem;
		this.idEstabelecimento = idEstabelecimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Long getIdEstabelecimento() {
		return idEstabelecimento;
	}

	public void setIdEstabelecimento(Long idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}

}
