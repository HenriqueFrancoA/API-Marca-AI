package br.com.marca.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marca.api.domain.models.Funcao;
import br.com.marca.api.domain.models.Profissional;
import br.com.marca.api.domain.models.Servico;
import br.com.marca.api.repository.FuncaoRepository;
import br.com.marca.api.repository.ProfissionalRepository;
import br.com.marca.api.repository.ServicoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class FuncaoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private FuncaoRepository funcaoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private AgendaProfissionalService agendaProfissionalService;

    @Transactional
    public List<Funcao> criarFuncao(List<Long> listIdProfissional, Long idServico) {
        try {
            List<Funcao> listFuncao = new ArrayList<>();
            Servico servico = servicoRepository.findById(idServico).orElseThrow();

            for (Long id : listIdProfissional) {

                Profissional profissional = profissionalRepository.findById(id).orElseThrow();

                Funcao funcao = new Funcao(
                        servico,
                        profissional);

                listFuncao.add(funcao);
                entityManager.persist(funcao);
                entityManager.flush();
            }

            return listFuncao;
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public List<Funcao> deletarFuncao(Servico servico, Profissional profissional) {

        try {
            List<Funcao> listFuncao = new ArrayList<>();

            if (servico != null) {
                listFuncao = funcaoRepository.findFuncaoByServico(servico);
                agendaProfissionalService.deletarAgendaProfissional(servico);
            } else {
                listFuncao = funcaoRepository.findFuncaoByProfissional(profissional);
            }

            for (Funcao funcao : listFuncao) {

                if (profissional != null)

                    entityManager.remove(funcao);
                entityManager.flush();
            }

            return listFuncao;

        } catch (Exception e) {
            return null;
        }
    }

    public List<Profissional> findFuncaoPorServico(Long idServico) {

        try {

            Servico servico = servicoRepository.findById(idServico).orElseThrow();

            List<Funcao> listFuncoes = funcaoRepository.findFuncaoByServico(servico);

            List<Profissional> listProfissionais = new ArrayList<>();

            for (Funcao funcao : listFuncoes) {
                listProfissionais.add(funcao.getProfissional());
            }

            return listProfissionais;
        } catch (Exception e) {
            return null;
        }
    }
}
