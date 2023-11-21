package br.com.marca.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marca.api.domain.dto.AtualizarCategoriaDTO;
import br.com.marca.api.domain.dto.CriarCategoriaDTO;
import br.com.marca.api.domain.models.Categoria;
import br.com.marca.api.domain.models.Estabelecimento;
import br.com.marca.api.domain.models.Servico;
import br.com.marca.api.repository.CategoriaRepository;
import br.com.marca.api.repository.EstabelecimentoRepository;
import br.com.marca.api.repository.ServicoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class CategoriaService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Categoria> findCategoriaByEstabelecimento(Long idEstabelecimento) {

        try {

            Estabelecimento estabelecimento = estabelecimentoRepository.findById(idEstabelecimento).orElseThrow();

            return categoriaRepository.findCategoriaByEstabelecimento(estabelecimento);

        } catch (Exception e) {
            return null;
        }

    }

    @Transactional
    public Categoria criarNovaCategoria(CriarCategoriaDTO criarCategoriaDTO) {

        try {
            Estabelecimento estabelecimento = estabelecimentoRepository
                    .findById(criarCategoriaDTO.getIdEstabelecimento()).orElseThrow();

            Categoria categoria = new Categoria(
                    criarCategoriaDTO.getNome(),
                    criarCategoriaDTO.getImagem(),
                    0,
                    estabelecimento);

            entityManager.persist(categoria);
            entityManager.flush();

            return categoria;

        } catch (Exception e) {

            return null;
        }

    }

    @Transactional
    public Categoria desabilitarCategoria(Long id) {

        try {

            Categoria categoria = categoriaRepository.findById(id).orElseThrow();

            List<Servico> listServicos = servicoRepository
                    .findServicoByEstabelecimentoAndCategoria(categoria.getEstabelecimento(), categoria);

            for (Servico servico : listServicos) {

                servicoService.desabilitarServico(servico.getId());

            }

            categoria.setDesabilitado(1);

            entityManager.persist(categoria);
            entityManager.flush();

            return categoria;

        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public Categoria atualizarCategoria(AtualizarCategoriaDTO atualizarCategoriaDTO) {

        try {

            Categoria categoria = categoriaRepository.findById(atualizarCategoriaDTO.getId()).orElseThrow();

            if (categoria != null) {

                categoria.setNome(atualizarCategoriaDTO.getNome());

                entityManager.persist(categoria);
                entityManager.flush();

                return categoria;
            }

            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
