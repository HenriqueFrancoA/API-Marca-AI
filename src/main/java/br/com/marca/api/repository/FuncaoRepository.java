package br.com.marca.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.marca.api.domain.models.Funcao;
import br.com.marca.api.domain.models.Profissional;
import br.com.marca.api.domain.models.Servico;

@Repository
public interface FuncaoRepository extends JpaRepository<Funcao, Long> {

    @Query("From Funcao f where f.servico = :servico")
    List<Funcao> findFuncaoByServico(@Param("servico") Servico servico);

    @Query("From Funcao f where f.profissional = :profissional")
    List<Funcao> findFuncaoByProfissional(@Param("profissional") Profissional profissional);

    @Query("From Funcao f where f.profissional = :profissional and f.servico = :servico")
    Funcao findFuncaoByProfissionalAndServico(@Param("profissional") Profissional profissional,
            @Param("servico") Servico servico);

}
