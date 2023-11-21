package br.com.marca.api.resources;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marca.api.domain.dto.AtualizarEstabelecimentoDTO;
import br.com.marca.api.domain.models.Estabelecimento;
import br.com.marca.api.domain.models.Response;
import br.com.marca.api.service.EstabelecimentoService;

@RestController
@RequestMapping("/v1/estabelecimento")
public class EstabelecimentoResource {

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @PutMapping(path = "/atualizar")
    public Response<Estabelecimento> atualizarEstabelecimento(
            @RequestBody AtualizarEstabelecimentoDTO atualizarEstabelecimentoDTO) {
        Response<Estabelecimento> response = new Response<Estabelecimento>(
                (long) HttpStatus.OK.value(),
                estabelecimentoService.atualizarEstabelecimento(atualizarEstabelecimentoDTO),
                LocalDateTime.now().toString());

        return response;
    }

}
