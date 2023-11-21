package br.com.marca.api.resources;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marca.api.domain.dto.LoginDTO;
import br.com.marca.api.domain.models.Response;
import br.com.marca.api.domain.models.Usuario;
import br.com.marca.api.service.UsuarioService;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/all")
    public List<Usuario> findAll() {

        return usuarioService.findAll();
    }

    @GetMapping(path = "/login")
    public Response<Usuario> login(@RequestBody LoginDTO login) {
        Response<Usuario> response = new Response<Usuario>(
                (long) HttpStatus.OK.value(),
                usuarioService.login(login.getEmail(), login.getSenha()),
                LocalDateTime.now().toString());

        return response;
    }

}
