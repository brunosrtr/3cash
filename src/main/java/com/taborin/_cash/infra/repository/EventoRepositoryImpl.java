package com.taborin._cash.infra.repository;

import com.taborin._cash.core.domain.model.Evento;
import com.taborin._cash.core.domain.model.Saida;
import com.taborin._cash.core.interfaces.EventoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventoRepositoryImpl implements EventoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void criar(Evento evento) {
        String sql = "INSERT INTO evento (nome, valor_arrecadado, data) " +
                "VALUES (:nome, :valorArrecadado, :data)";
        entityManager.createNativeQuery(sql)
                .setParameter("nome", evento.getNome())
                .setParameter("valorArrecadado", evento.getValorArrecadado())
                .setParameter("data", evento.getData())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void atualizarPorId(Evento evento, Long id) {
        String sql = "UPDATE evento SET nome = :nome, valor_arrecadado = :valorArrecadado, data = :data" +
                "WHERE id = :id";
        entityManager.createNativeQuery(sql)
                .setParameter("id", id)
                .setParameter("nome", evento.getNome())
                .setParameter("valorArrecadado", evento.getValorArrecadado())
                .setParameter("data", evento.getData())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deletarPorId(Long id) {
        String sql = "DELETE FROM evento WHERE id = :id";
        entityManager.createNativeQuery(sql)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Evento> listarEventos() {
        String sql = "SELECT * FROM evento";
        return entityManager.createNativeQuery(sql, Evento.class)
                .getResultList();
    }

    @Override
    public Evento listarPorId(Long id) {
        String sql = "SELECT * FROM evento WHERE id = :id";
        List<Evento> result = entityManager.createNativeQuery(sql, Evento.class)
                .setParameter("id", id)
                .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

}
