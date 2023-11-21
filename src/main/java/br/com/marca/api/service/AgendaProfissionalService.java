package br.com.marca.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marca.api.domain.models.AgendaProfissional;
import br.com.marca.api.domain.models.Servico;
import br.com.marca.api.repository.AgendaProfissionalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class AgendaProfissionalService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AgendaProfissionalRepository agendaProfissionalRepository;

    public List<AgendaProfissional> deletarAgendaProfissional(Servico servico) {
        List<AgendaProfissional> listAgendas = new ArrayList<>();

        try {
            listAgendas = agendaProfissionalRepository.findAgendaByServico(servico);

            for (AgendaProfissional agendaProfissional : listAgendas) {
                entityManager.remove(agendaProfissional);
                entityManager.flush();
            }

            return listAgendas;

        } catch (Exception e) {
            return null;
        }
    }

}
