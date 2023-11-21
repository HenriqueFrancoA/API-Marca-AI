package br.com.marca.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.marca.api.domain.models.AgendaCliente;
import br.com.marca.api.domain.models.Funcao;
import br.com.marca.api.domain.models.Usuario;

@Repository
public interface AgendaClienteRepository extends JpaRepository<AgendaCliente, Long> {

    @Query("From AgendaCliente ac where ac.cliente = :cliente")
    List<AgendaCliente> findAgendaClienteByCliente(@Param("cliente") Usuario cliente);

    @Query("From AgendaCliente ac where ac.servicoAgendado = :servicoAgendado")
    List<AgendaCliente> findAgendaClienteByServicoAgendado(@Param("servicoAgendado") Funcao servicoAgendado);
}
