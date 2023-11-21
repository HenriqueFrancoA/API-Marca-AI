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
@Table(name = "AGENDA_CLIENTE")
public class AgendaCliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private Date data;

    @Column(name = "horario")
    private String horario;

    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    private Usuario cliente;

    @OneToOne
    @JoinColumn(name = "servico_agendado")
    private Funcao servicoAgendado;

    @ManyToOne
    @JoinColumn(name = "estabelecimento", referencedColumnName = "id")
    private Estabelecimento estabelecimento;

    @OneToOne
    @JoinColumn(name = "status")
    private Status status;

    public AgendaCliente() {

    }

    public AgendaCliente(Date data, String horario, Usuario cliente, Funcao servicoAgendado,
            Estabelecimento estabelecimento, Status status) {
        this.data = data;
        this.horario = horario;
        this.cliente = cliente;
        this.servicoAgendado = servicoAgendado;
        this.estabelecimento = estabelecimento;
        this.status = status;
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

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Funcao getServicoAgendado() {
        return servicoAgendado;
    }

    public void setServicoAgendado(Funcao servicoAgendado) {
        this.servicoAgendado = servicoAgendado;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
