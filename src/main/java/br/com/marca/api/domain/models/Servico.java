package br.com.marca.api.domain.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SERVICO")
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "servico")
    private String servico;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "tempo")
    private String tempo;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "desabilitado")
    private Integer desabilitado;

    @ManyToOne
    @JoinColumn(name = "estabelecimento", referencedColumnName = "id")
    private Estabelecimento estabelecimento;

    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    private Categoria categoria;

    public Servico() {
    }

    public Servico(String servico, String descricao, String tempo, Double valor, Integer desabilitado,
            Estabelecimento estabelecimento, Categoria categoria) {
        this.servico = servico;
        this.descricao = descricao;
        this.tempo = tempo;
        this.valor = valor;
        this.desabilitado = desabilitado;
        this.estabelecimento = estabelecimento;
        this.categoria = categoria;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public Integer getDesabilitado() {
        return desabilitado;
    }

    public void setDesabilitado(Integer desabilitado) {
        this.desabilitado = desabilitado;
    }

}
