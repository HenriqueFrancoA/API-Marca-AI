package br.com.marca.api.domain.dto;

import java.util.List;

public class CriarFuncaoDTO {

	private List<Long> listIdProfissional;
	private Long idServico;

	public CriarFuncaoDTO() {

	}

	public CriarFuncaoDTO(List<Long> listIdProfissional, Long idServico) {
		this.listIdProfissional = listIdProfissional;
		this.idServico = idServico;
	}

	public List<Long> getListIdProfissional() {
		return listIdProfissional;
	}

	public void setListIdProfissional(List<Long> listIdProfissional) {
		this.listIdProfissional = listIdProfissional;
	}

	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

}
