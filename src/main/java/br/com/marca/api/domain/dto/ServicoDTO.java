package br.com.marca.api.domain.dto;

public class ServicoDTO {
    private Long id;
    private String criar;

    public ServicoDTO() {
    }

    public ServicoDTO(Long id, String criar) {
        this.id = id;
        this.criar = criar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCriar() {
        return criar;
    }

    public void setCriar(String criar) {
        this.criar = criar;
    }

}
