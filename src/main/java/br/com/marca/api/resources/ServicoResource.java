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

import br.com.marca.api.domain.dto.AtualizarServicoDTO;
import br.com.marca.api.domain.dto.CriarServicoDTO;
import br.com.marca.api.domain.models.Response;
import br.com.marca.api.domain.models.Servico;
import br.com.marca.api.service.ServicoService;

@RestController
@RequestMapping("/v1/servico")
public class ServicoResource {

    @Autowired
    private ServicoService servicoService;

    @GetMapping(path = "/estabelecimento/{idEstabelecimento}/{idCategoria}")
    public List<Servico> findServicoByEstabelecimentoAndCategoria(@PathVariable Long idEstabelecimento,
            @PathVariable Long idCategoria) {
        return servicoService.findServicoByEstabelecimentoAndCategoria(idEstabelecimento, idCategoria);
    }

    @PostMapping(path = "/criar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Servico> criarNovoServico(@RequestBody CriarServicoDTO criarServicoDTO) {
        Response<Servico> response = new Response<Servico>(
                (long) HttpStatus.OK.value(),
                servicoService.criarNovoServico(criarServicoDTO),
                LocalDateTime.now().toString());
        return response;
    }

    @PutMapping(path = "/desabilitar/{id}")
    public Servico desabilitarServico(@PathVariable Long id) {
        return servicoService.desabilitarServico(id);
    }

    @PutMapping(path = "/atualizar")
    public Servico atualizarServico(@RequestBody AtualizarServicoDTO atualizarServicoDTO) {
        return servicoService.atualizarServico(atualizarServicoDTO);
    }
}
