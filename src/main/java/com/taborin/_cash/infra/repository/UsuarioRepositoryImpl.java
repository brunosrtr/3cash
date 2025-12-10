package com.taborin._cash.infra.repository;

import com.taborin._cash.core.domain.model.Aluno;
import com.taborin._cash.core.domain.model.Professor;
import com.taborin._cash.core.domain.model.Usuario;
import com.taborin._cash.core.interfaces.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void criar(Usuario usuario) {

        if (usuario instanceof Professor) {
            String sql = "INSERT INTO usuario (nome, quantia_moletom) VALUES (:nome, :quantiaMoletom)";
            entityManager.createNativeQuery(sql)
                    .setParameter("nome", usuario.getNome())
                    .setParameter("tipo", "PROFESSOR")
                    .setParameter("quantiaMoletom", ((Professor) usuario).getQuantiaMoletom())
                    .executeUpdate();
        } else if (usuario instanceof Aluno) {
            String sql = "INSERT INTO usuario (nome, quantia_mensalidade, quantia_moletom) VALUES (:nome, :quantiaMensalidade, :quantiaMoletom)";
            entityManager.createNativeQuery(sql)
                    .setParameter("nome", usuario.getNome())
                    .setParameter("tipo", "ALUNO")
                    .setParameter("quantiaMensalidade", ((Aluno) usuario).getQuantiaMensalidade())
                    .setParameter("quantiaMoletom", ((Aluno) usuario).getQuantiaMoletom())
                    .executeUpdate();
        }

    }

    @Transactional
    @Override
    public void atualizarPorId(String nome, Long id) {
        String sql = "UPDATE usuario SET nome = :nome WHERE id = :id";
        entityManager.createNativeQuery(sql)
                .setParameter("nome", nome)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deletarPorId(Long id) {
        String sql = "DELETE FROM usuario WHERE id = :id";
        entityManager.createNativeQuery(sql)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Usuario> listarUsuarios() {
        String sql = "SELECT * FROM usuario";
        return entityManager.createNativeQuery(sql, Usuario.class)
                .getResultList();
    }

    @Override
    public Usuario listarporId(Long id) {
        String sql = "SELECT * FROM usuario WHERE id = :id";

        List<Usuario> result = entityManager.createNativeQuery(sql, Usuario.class)
                .setParameter("id", id)
                .getResultList();

        return result.isEmpty() ? null : result.get(0);
    }
}
