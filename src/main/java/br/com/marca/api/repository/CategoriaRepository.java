package br.com.marca.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.marca.api.domain.models.Categoria;
import br.com.marca.api.domain.models.Estabelecimento;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("From Categoria c where c.estabelecimento = :estabelecimento and c.desabilitado = 0")
    List<Categoria> findCategoriaByEstabelecimento(@Param("estabelecimento") Estabelecimento estabelecimento);

}
