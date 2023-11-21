package br.com.marca.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marca.api.domain.models.AgendaCliente;
import br.com.marca.api.domain.models.Estabelecimento;
import br.com.marca.api.domain.models.Funcao;
import br.com.marca.api.domain.models.Usuario;
import br.com.marca.api.repository.AgendaClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class AgendaClienteService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AgendaClienteRepository agendaClienteRepository;

    @Autowired
    private UsuarioService usuarioService;

    public List<Estabelecimento> findEstabelecimentoByCliente(Long idUsuario, Boolean repetido) {
        List<AgendaCliente> listAgendas = new ArrayList<>();

        try {
            Usuario usuario = usuarioService.findById(idUsuario).orElseThrow();

            listAgendas = agendaClienteRepository.findAgendaClienteByCliente(usuario);
            if (!repetido) {
                List<Long> listIdEstabalecimento = new ArrayList<>();
                List<Estabelecimento> listEstabelecimentoSemRepeticao = new ArrayList<>();

                for (AgendaCliente agenda : listAgendas) {
                    if (!listIdEstabalecimento.contains(agenda.getEstabelecimento().getId())) {
                        listIdEstabalecimento.add(agenda.getEstabelecimento().getId());
                        listEstabelecimentoSemRepeticao.add(agenda.getEstabelecimento());
                    }
                }

                return listEstabelecimentoSemRepeticao;
            }
            List<Estabelecimento> listEstabelecimento = new ArrayList<>();
            for (AgendaCliente agenda : listAgendas) {

                listEstabelecimento.add(agenda.getEstabelecimento());
            }
            return listEstabelecimento;

        } catch (Exception e) {
            return null;
        }
    }

    public List<AgendaCliente> findAgendaClienteByCliente(Long idUsuario) {
        try {
            Usuario usuario = usuarioService.findById(idUsuario).orElseThrow();

            List<AgendaCliente> listAgendas = agendaClienteRepository.findAgendaClienteByCliente(usuario);

            return listAgendas;

        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public List<AgendaCliente> retirarServicoAgendado(Funcao funcao) {

        try {

            List<AgendaCliente> listCliente = agendaClienteRepository.findAgendaClienteByServicoAgendado(funcao);

            for (AgendaCliente agenda : listCliente) {

                agenda.setServicoAgendado(null);

                entityManager.persist(agenda);
                entityManager.flush();
            }

            return listCliente;

        } catch (Exception e) {
            return null;
        }
    }
}
