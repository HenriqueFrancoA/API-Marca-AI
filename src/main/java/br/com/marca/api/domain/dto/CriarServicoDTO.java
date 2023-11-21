package br.com.marca.api.domain.dto;

import java.util.List;

public class CriarServicoDTO {

	private String nomeServico;
	private String descricao;
	private String tempo;
	private String valor;
	private Long idEstabelecimento;
	private Long idCategoria;
	private List<Long> listIdProfissional;

	public CriarServicoDTO() {

	}

	

	public CriarServicoDTO(String nomeServico, String descricao, String tempo, String valor, Long idEstabelecimento,
            Long idCategoria, List<Long> listIdProfissional) {
        this.nomeServico = nomeServico;
        this.descricao = descricao;
        this.tempo = tempo;
        this.valor = valor;
        this.idEstabelecimento = idEstabelecimento;
        this.idCategoria = idCategoria;
        this.listIdProfissional = listIdProfissional;
    }



    public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Long getIdEstabelecimento() {
		return idEstabelecimento;
	}

	public void setIdEstabelecimento(Long idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}



    public List<Long> getListIdProfissional() {
        return listIdProfissional;
    }



    public void setListIdProfissional(List<Long> listIdProfissional) {
        this.listIdProfissional = listIdProfissional;
    }

}
