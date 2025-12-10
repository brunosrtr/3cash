package com.taborin._cash.infra.repository;

import com.taborin._cash.core.domain.model.Transacao;
import com.taborin._cash.core.interfaces.TransacaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransacaoRepositoryImpl implements TransacaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void criar(Transacao transacao) {
        String sql = "INSERT INTO transacao (tipo, valor, id_usuario, data, descricao) " +
                "VALUES (:tipo, :valor, :idUsuario, :data, :descricao)";
        entityManager.createNativeQuery(sql)
                .setParameter("tipo", transacao.getTipo())
                .setParameter("valor", transacao.getValor())
                .setParameter("idUsuario", transacao.getIdUsuario())
                .setParameter("data", transacao.getData())
                .setParameter("descricao", transacao.getDescricao())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void atualizarPorId(Transacao transacao, Long id) {
        String sql = "UPDATE transacao SET tipo = :tipo, valor = :valor, " +
                "id_usuario = :idUsuario, data = :data, descricao = :descricao " +
                "WHERE id = :id";
        entityManager.createNativeQuery(sql)
                .setParameter("tipo", transacao.getTipo())
                .setParameter("valor", transacao.getValor())
                .setParameter("idUsuario", transacao.getIdUsuario())
                .setParameter("data", transacao.getData())
                .setParameter("descricao", transacao.getDescricao())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deletarPorId(Long id) {
        String sql = "DELETE FROM transacao WHERE id = :id";
        entityManager.createNativeQuery(sql)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Transacao> listarTransacoes() {
        String sql = "SELECT * FROM transacao";
        return entityManager.createNativeQuery(sql, Transacao.class)
                .getResultList();
    }

    @Override
    public Transacao listarPorId(Long id) {
        String sql = "SELECT * FROM transacao WHERE id = :id";
        List<Transacao> result = entityManager.createNativeQuery(sql, Transacao.class)
                .setParameter("id", id)
                .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<Transacao> listarPorUsuario(Long idUsuario) {
        String sql = "SELECT * FROM transacao WHERE id_usuario = :idUsuario";
        return entityManager.createNativeQuery(sql, Transacao.class)
                .setParameter("idUsuario", idUsuario)
                .getResultList();
    }
}