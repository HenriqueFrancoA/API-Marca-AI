package br.com.marca.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marca.api.domain.dto.AtualizarEstabelecimentoDTO;
import br.com.marca.api.domain.models.Estabelecimento;
import br.com.marca.api.repository.EstabelecimentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class EstabelecimentoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Transactional
    public Estabelecimento atualizarEstabelecimento(AtualizarEstabelecimentoDTO atualizarEstabelecimentoDTO) {

        try {

            Estabelecimento estabelecimento = estabelecimentoRepository.findById(atualizarEstabelecimentoDTO.getId())
                    .orElseThrow();

            if (estabelecimento != null) {
                estabelecimento.setNome(atualizarEstabelecimentoDTO.getNome());
                estabelecimento.setTelefone(atualizarEstabelecimentoDTO.getTelefone());
                estabelecimento.setCnpj(atualizarEstabelecimentoDTO.getCnpj());
                estabelecimento.setLocalizacao(atualizarEstabelecimentoDTO.getLocalizacao());
                estabelecimento.setDiasFuncionamento(atualizarEstabelecimentoDTO.getDiasFuncionamento());
                estabelecimento.setHorarioAbertura(atualizarEstabelecimentoDTO.getHorarioAbertura());
                estabelecimento.setHorarioFechamento(atualizarEstabelecimentoDTO.getHorarioFechamento());

                entityManager.persist(estabelecimento);
                entityManager.flush();

                return estabelecimento;
            }

            return null;
        } catch (Exception e) {
            return null;

        }

    }
}
