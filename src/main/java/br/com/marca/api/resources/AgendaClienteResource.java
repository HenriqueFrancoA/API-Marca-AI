package br.com.marca.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.marca.api.domain.models.AgendaCliente;
import br.com.marca.api.domain.models.Estabelecimento;
import br.com.marca.api.service.AgendaClienteService;

@RestController
@RequestMapping("/v1/agendaCliente")
public class AgendaClienteResource {

    @Autowired
    private AgendaClienteService agendaClienteService;

    @GetMapping(path = "/estabelecimentos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Estabelecimento> findEstabelecimentoByCliente(@RequestParam(name = "idCliente") Long idCliente,
            @RequestParam(name = "repetido") Boolean repetido) {

        return agendaClienteService.findEstabelecimentoByCliente(idCliente,
                repetido);
    }

    @GetMapping(path = "/agenda", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AgendaCliente> findAgendaClienteByCliente(@RequestParam(name = "idCliente") Long idCliente,
            @RequestParam(name = "repetido") Boolean repetido) {

        return agendaClienteService.findAgendaClienteByCliente(idCliente);
    }

}
