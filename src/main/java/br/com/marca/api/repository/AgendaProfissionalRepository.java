package br.com.marca.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.marca.api.domain.models.AgendaProfissional;
import br.com.marca.api.domain.models.Servico;

@Repository
public interface AgendaProfissionalRepository extends JpaRepository<AgendaProfissional, Long> {

    @Query("From AgendaProfissional ap where ap.servico = :servico")
    public List<AgendaProfissional> findAgendaByServico(@Param("servico") Servico servico);
}
