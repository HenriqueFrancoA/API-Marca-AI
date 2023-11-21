package br.com.marca.api.resources;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marca.api.domain.dto.CriarProfissionalDTO;
import br.com.marca.api.domain.models.Profissional;
import br.com.marca.api.domain.models.Response;
import br.com.marca.api.service.ProfissionalService;

@RestController
@RequestMapping("/v1/profissional")
public class ProfissionalResource {

    @Autowired
    private ProfissionalService profissionalService;

    @GetMapping(path = "/estabelecimento/{idEstabelecimento}")
    public List<Profissional> findServicoByEstabelecimentoAndCategoria(@PathVariable Long idEstabelecimento
            ) {
        return profissionalService.findProfissionalByEstabelecimento(idEstabelecimento);
    }

    @PostMapping(path = "/criar")
    public Response<Profissional> criarNovoProfissional(@RequestBody CriarProfissionalDTO criarProfissionalDTO) {
        Response<Profissional> response = new Response<Profissional>(
                (long) HttpStatus.OK.value(),
                profissionalService.criarNovoProfissional(criarProfissionalDTO),
                LocalDateTime.now().toString());

        return response;
    }

    @DeleteMapping(path = "/deletar/{id}")
    public Response<Profissional> deletarProfissional(@PathVariable Long id) {
        Response<Profissional> response = new Response<Profissional>(
                (long) HttpStatus.OK.value(),
                profissionalService.deletarProfissional(id),
                LocalDateTime.now().toString());

        return response;
    }

}
