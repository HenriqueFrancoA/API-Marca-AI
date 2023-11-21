package br.com.marca.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marca.api.domain.models.Usuario;
import br.com.marca.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {

        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.procuraPeloId(id);
    }

    public Usuario login(String email, String senha) {

        try {
            Usuario usuarioLogado = usuarioRepository.login(email, senha).orElseThrow();

            return usuarioLogado;
        } catch (Exception e) {

            return null;
        }

    }
}
