package br.com.marca.api.domain.dto;

import java.util.List;

public class AtualizarServicoDTO {
    private Long id;
    private String servico;
    private String tempo;
    private String valor;
    private List<ServicoDTO> idProfissionais;

    public AtualizarServicoDTO() {
    }

    public AtualizarServicoDTO(Long id, String servico, String tempo, String valor, List<ServicoDTO> idProfissionais) {
        this.id = id;
        this.servico = servico;
        this.tempo = tempo;
        this.valor = valor;
        this.idProfissionais = idProfissionais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
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

    public List<ServicoDTO> getIdProfissionais() {
        return idProfissionais;
    }

    public void setIdProfissionais(List<ServicoDTO> idProfissionais) {
        this.idProfissionais = idProfissionais;
    }

}
