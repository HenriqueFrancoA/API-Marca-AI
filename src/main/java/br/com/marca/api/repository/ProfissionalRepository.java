package br.com.marca.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.marca.api.domain.models.Estabelecimento;
import br.com.marca.api.domain.models.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    @Query("From Profissional p where p.estabelecimento = :estabelecimento")
    public List<Profissional> findCategoriaByEstabelecimento(@Param("estabelecimento") Estabelecimento estabelecimento);
}
