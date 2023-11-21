package br.com.marca.api.domain.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORIA")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "imagem")
    private String imagem;

    @Column(name = "desabilitado")
    private Integer desabilitado;

    @OneToOne
    @JoinColumn(name = "estabelecimento")
    private Estabelecimento estabelecimento;

    public Categoria() {

    }

    public Categoria(String nome, String imagem, Integer desabilitado, Estabelecimento estabelecimento) {
        this.nome = nome;
        this.imagem = imagem;
        this.desabilitado = desabilitado;
        this.estabelecimento = estabelecimento;
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

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Integer getDesabilitado() {
        return desabilitado;
    }

    public void setDesabilitado(Integer desabilitado) {
        this.desabilitado = desabilitado;
    }

}
