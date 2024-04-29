package com.roberto.algafood.infraestructure.repository;

import com.roberto.algafood.domain.model.Cozinha;
import com.roberto.algafood.domain.repository.CozinhaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cozinha> listar() {
        return entityManager.createQuery("from Cozinha", Cozinha.class)
                .getResultList();
    }

    @Override
    public List<Cozinha> consultarPorNome(String nome) {
        return entityManager.createQuery("from Cozinha where nome = :nome", Cozinha.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    @Override
    public Cozinha buscar(Long id) {
        return entityManager.find(Cozinha.class, id);
    }

    @Override
    @Transactional
    public Cozinha salvar(Cozinha cozinha) {
        return entityManager.merge(cozinha);
    }

    @Override
    @Transactional
    public void remover(Long id) {
        Cozinha cozinha = buscar(id);
        if (cozinha == null) {
            throw new EmptyResultDataAccessException(1);
        }
        entityManager.remove(cozinha);
    }

}
