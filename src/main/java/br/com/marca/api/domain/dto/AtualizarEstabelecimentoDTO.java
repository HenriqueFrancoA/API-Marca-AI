package br.com.marca.api.domain.dto;

public class AtualizarEstabelecimentoDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String cnpj;
    private String localizacao;
    private String diasFuncionamento;
    private String horarioAbertura;
    private String horarioFechamento;

    public AtualizarEstabelecimentoDTO() {
    }

    public AtualizarEstabelecimentoDTO(Long id, String nome, String telefone, String cnpj, String localizacao,
            String diasFuncionamento, String horarioAbertura, String horarioFechamento) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.localizacao = localizacao;
        this.diasFuncionamento = diasFuncionamento;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDiasFuncionamento() {
        return diasFuncionamento;
    }

    public void setDiasFuncionamento(String diasFuncionamento) {
        this.diasFuncionamento = diasFuncionamento;
    }

    public String getHorarioAbertura() {
        return horarioAbertura;
    }

    public void setHorarioAbertura(String horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public String getHorarioFechamento() {
        return horarioFechamento;
    }

    public void setHorarioFechamento(String horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

}
