package br.com.marca.api.resources;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marca.api.domain.dto.CriarFuncaoDTO;
import br.com.marca.api.domain.models.Funcao;
import br.com.marca.api.domain.models.Profissional;
import br.com.marca.api.domain.models.Response;
import br.com.marca.api.service.FuncaoService;

@RestController
@RequestMapping("/v1/funcao")
public class FuncaoResource {

    @Autowired
    private FuncaoService funcaoService;

    @PostMapping(path = "/criar")
    public Response<List<Funcao>> login(@RequestBody CriarFuncaoDTO criarFuncaoDTO) {
        Response<List<Funcao>> response = new Response<List<Funcao>>(
                (long) HttpStatus.OK.value(),
                funcaoService.criarFuncao(criarFuncaoDTO.getListIdProfissional(), criarFuncaoDTO.getIdServico()),
                LocalDateTime.now().toString());

        return response;
    }

    @GetMapping(path = "/{idServico}")
    public List<Profissional> findFuncaoPorServico(@PathVariable Long idServico) {
        return funcaoService.findFuncaoPorServico(idServico);
    }

}
