package br.com.marca.api.domain.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "AGENDA_PROFISSIONAL")
public class AgendaProfissional implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private Date data;

    @Column(name = "horario")
    private String horario;

    @Column(name = "marcado")
    private Boolean marcado;

    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "profissional", referencedColumnName = "id")
    private Profissional profissional;

    @OneToOne
    @JoinColumn(name = "servico", referencedColumnName = "id")
    private Servico servico;

    public AgendaProfissional() {

    }

    public AgendaProfissional(Date data, String horario, Boolean marcado, Usuario cliente, Profissional profissional,
            Servico servico) {
        this.data = data;
        this.horario = horario;
        this.marcado = marcado;
        this.cliente = cliente;
        this.profissional = profissional;
        this.servico = servico;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Boolean getMarcado() {
        return marcado;
    }

    public void setMarcado(Boolean marcado) {
        this.marcado = marcado;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

}
