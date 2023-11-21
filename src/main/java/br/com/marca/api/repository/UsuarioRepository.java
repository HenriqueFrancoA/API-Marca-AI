package br.com.marca.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.marca.api.domain.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("From Usuario u where u.email = :email and u.senha = :senha")
    Optional<Usuario> login(@Param("email") String email, @Param("senha") String senha);

    @Query("From Usuario u where u.id = :id")
    Optional<Usuario> procuraPeloId(@Param("id") Long id);
}
