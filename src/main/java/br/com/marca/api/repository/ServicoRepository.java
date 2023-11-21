package br.com.marca.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.marca.api.domain.models.Categoria;
import br.com.marca.api.domain.models.Estabelecimento;
import br.com.marca.api.domain.models.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

    @Query("From Servico s where s.estabelecimento = :estabelecimento and s.categoria = :categoria and s.desabilitado = 0")
    List<Servico> findServicoByEstabelecimentoAndCategoria(@Param("estabelecimento") Estabelecimento estabelecimento,
            @Param("categoria") Categoria categoria);

}
