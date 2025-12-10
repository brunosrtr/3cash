package com.taborin._cash.infra.repository;

import com.taborin._cash.core.domain.model.Saida;
import com.taborin._cash.core.interfaces.SaidaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaidaRepositoryImpl implements SaidaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void criar(Saida saida) {
        String sql = "INSERT INTO saida (valor, descricao, data) " +
                "VALUES (:valor, :descricao, :data)";
        entityManager.createNativeQuery(sql)
                .setParameter("valor", saida.getValor())
                .setParameter("descricao", saida.getDescricao())
                .setParameter("data", saida.getData())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void atualizarPorId(Saida saida, Long id) {
        String sql = "UPDATE saida SET valor = :valor, descricao = :descricao, data = :data " +
                "WHERE id = :id";
        entityManager.createNativeQuery(sql)
                .setParameter("valor", saida.getValor())
                .setParameter("descricao", saida.getDescricao())
                .setParameter("data", saida.getData())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deletarPorId(Long id) {
        String sql = "DELETE FROM saida WHERE id = :id";
        entityManager.createNativeQuery(sql)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Saida> listarSaidas() {
        String sql = "SELECT * FROM saida";
        return entityManager.createNativeQuery(sql, Saida.class)
                .getResultList();
    }

    @Override
    public Saida listarPorId(Long id) {
        String sql = "SELECT * FROM saida WHERE id = :id";
        List<Saida> result = entityManager.createNativeQuery(sql, Saida.class)
                .setParameter("id", id)
                .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}