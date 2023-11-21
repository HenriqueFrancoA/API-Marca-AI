package br.com.marca.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marca.api.domain.dto.CriarProfissionalDTO;
import br.com.marca.api.domain.models.Estabelecimento;
import br.com.marca.api.domain.models.Profissional;
import br.com.marca.api.domain.models.Usuario;
import br.com.marca.api.repository.EstabelecimentoRepository;
import br.com.marca.api.repository.ProfissionalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ProfissionalService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private FuncaoService funcaoService;

    public List<Profissional> findProfissionalByEstabelecimento(Long idEstabelecimento) {

        try {

            Estabelecimento estabelecimento = estabelecimentoRepository.findById(idEstabelecimento).orElseThrow();

            return profissionalRepository.findCategoriaByEstabelecimento(estabelecimento);

        } catch (Exception e) {
            return null;
        }

    }

    @Transactional
    public Profissional criarNovoProfissional(CriarProfissionalDTO criarProfissionalDTO) {

        try {
            Estabelecimento estabelecimento = estabelecimentoRepository
                    .findById(criarProfissionalDTO.getIdEstabelecimento()).orElseThrow();

            Usuario usuario = new Usuario(
                    criarProfissionalDTO.getEmail(),
                    criarProfissionalDTO.getNome(),
                    criarProfissionalDTO.getSobrenome(),
                    criarProfissionalDTO.getSenha(),
                    criarProfissionalDTO.getTelefone(),
                    "",
                    1L
            );

            entityManager.persist(usuario);
            entityManager.flush();

            Profissional profissional = new Profissional(
                    criarProfissionalDTO.getNomeFantasia(),
                    estabelecimento,
                    usuario);

            entityManager.persist(profissional);
            entityManager.flush();

            return profissional;

        } catch (Exception e) {

            return null;
        }

    }

    @Transactional
    public Profissional deletarProfissional(Long id) {

        try {

            Profissional profissional = profissionalRepository.findById(id).orElseThrow();

            funcaoService.deletarFuncao(null, profissional);

            entityManager.remove(profissional);
            entityManager.flush();

            return profissional;

        } catch (Exception e) {
            return null;
        }
    }
}
