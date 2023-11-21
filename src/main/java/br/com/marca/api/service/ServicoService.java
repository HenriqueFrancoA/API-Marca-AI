package br.com.marca.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marca.api.domain.dto.AtualizarServicoDTO;
import br.com.marca.api.domain.dto.CriarServicoDTO;
import br.com.marca.api.domain.dto.ServicoDTO;
import br.com.marca.api.domain.models.Categoria;
import br.com.marca.api.domain.models.Estabelecimento;
import br.com.marca.api.domain.models.Funcao;
import br.com.marca.api.domain.models.Profissional;
import br.com.marca.api.domain.models.Servico;
import br.com.marca.api.repository.CategoriaRepository;
import br.com.marca.api.repository.EstabelecimentoRepository;
import br.com.marca.api.repository.FuncaoRepository;
import br.com.marca.api.repository.ProfissionalRepository;
import br.com.marca.api.repository.ServicoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ServicoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private FuncaoService funcaoService;

    @Autowired
    private FuncaoRepository funcaoRepository;

    public List<Servico> findServicoByEstabelecimentoAndCategoria(Long idEstabelecimento, Long idCategoria) {

        try {

            Estabelecimento estabelecimento = estabelecimentoRepository.findById(idEstabelecimento).orElseThrow();

            Categoria categoria = categoriaRepository.findById(idCategoria).orElseThrow();

            return servicoRepository.findServicoByEstabelecimentoAndCategoria(estabelecimento, categoria);

        } catch (Exception e) {
            return null;
        }

    }

    @Transactional
    public Servico criarNovoServico(CriarServicoDTO criarServicoDTO) {

        try {

            Estabelecimento estabelecimento = estabelecimentoRepository.findById(criarServicoDTO.getIdEstabelecimento())
                    .orElseThrow();

            Categoria categoria = categoriaRepository.findById(criarServicoDTO.getIdCategoria()).orElseThrow();

            Double novoValor = 0d;
            if (criarServicoDTO.getValor().contains(",")) {
                novoValor = Double.parseDouble(criarServicoDTO.getValor().replace(",", "."));
            } else {
                novoValor = Double.parseDouble(criarServicoDTO.getValor());
            }

            Servico servico = new Servico(
                    criarServicoDTO.getNomeServico(),
                    criarServicoDTO.getDescricao(),
                    criarServicoDTO.getTempo(),
                    novoValor,
                    0,
                    estabelecimento,
                    categoria);

            entityManager.persist(servico);
            entityManager.flush();

            if (!criarServicoDTO.getListIdProfissional().isEmpty()) {

                funcaoService.criarFuncao(criarServicoDTO.getListIdProfissional(), servico.getId());
            }

            return servico;

        } catch (Exception e) {

            return null;
        }
    }

    @Transactional
    public Servico desabilitarServico(Long id) {
        try {
            Servico servico = servicoRepository.findById(id).orElseThrow();

            servico.setDesabilitado(1);

            entityManager.persist(servico);
            entityManager.flush();

            funcaoService.deletarFuncao(servico, null);

            return servico;
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public Servico atualizarServico(AtualizarServicoDTO atualizarServicoDTO) {

        try {
            Servico servico = servicoRepository.findById(atualizarServicoDTO.getId()).orElseThrow();

            if (servico != null) {
                Double novoValor = 0d;
                if (atualizarServicoDTO.getValor().contains(",")) {
                    novoValor = Double.parseDouble(atualizarServicoDTO.getValor().replace(",", "."));
                } else {
                    novoValor = Double.parseDouble(atualizarServicoDTO.getValor());
                }
                servico.setServico(atualizarServicoDTO.getServico());
                servico.setTempo(atualizarServicoDTO.getTempo());
                servico.setValor(novoValor);

                Funcao funcao = null;
                Profissional profissional = null;
                for (ServicoDTO servicoDto : atualizarServicoDTO.getIdProfissionais()) {

                    profissional = profissionalRepository.findById(servicoDto.getId()).orElseThrow();

                    funcao = funcaoRepository.findFuncaoByProfissionalAndServico(profissional, servico);

                    if (funcao == null) {
                        if (servicoDto.getCriar().equals("S")) {
                            Funcao novaFuncao = new Funcao(
                                    servico,
                                    profissional);

                            entityManager.persist(novaFuncao);
                        }
                    } else {
                        if (servicoDto.getCriar().equals("N")) {
                            entityManager.remove(funcao);
                        }
                    }

                }
            }

            entityManager.persist(servico);
            entityManager.flush();
            return servico;

        } catch (Exception e) {
            return null;
        }
    }
}
