package br.com.marca.api.resources;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marca.api.domain.dto.AtualizarCategoriaDTO;
import br.com.marca.api.domain.dto.CriarCategoriaDTO;
import br.com.marca.api.domain.models.Categoria;
import br.com.marca.api.domain.models.Response;
import br.com.marca.api.service.CategoriaService;

@RestController
@RequestMapping("/v1/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(path = "/estabelecimento/{id}")
    public List<Categoria> findCategoriaByEstabelecimento(@PathVariable Long id) {
        return categoriaService.findCategoriaByEstabelecimento(id);
    }

    @PostMapping(path = "/criar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Categoria> criarNovaCategoria(@RequestBody CriarCategoriaDTO criarCategoriaDTO) {
        Response<Categoria> response = new Response<Categoria>(
                (long) HttpStatus.OK.value(),
                categoriaService.criarNovaCategoria(criarCategoriaDTO),
                LocalDateTime.now().toString());
        return response;
    }

    @PutMapping(path = "/desabilitar/{id}")
    public Categoria desabilitarCategoria(@PathVariable Long id) {
        return categoriaService.desabilitarCategoria(id);
    }

    @PutMapping(path = "/atualizar")
    public Response<Categoria> atualizaCategoria(
            @RequestBody AtualizarCategoriaDTO atualizarCategoriaDTO) {
        Response<Categoria> response = new Response<Categoria>(
                (long) HttpStatus.OK.value(),
                categoriaService.atualizarCategoria(atualizarCategoriaDTO),
                LocalDateTime.now().toString());

        return response;
    }
}
