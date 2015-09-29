/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.dao;

import com.projeto.ong.entity.Endereco;
import com.projeto.ong.entity.Inscricao;
import com.projeto.ong.exception.BusinessException;
import com.projeto.ong.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

/**
 *
 * @author winston
 */
public class InscricaoDAO implements IDAO<Inscricao> {

    private final EntityManager manager;

    /**
     * Construtor da classe
     */
    public InscricaoDAO() {
        manager = JPAUtil.getEntityManager();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Inscricao> findAll() {
        List<Inscricao> inscricoes = manager.createNamedQuery("Inscricao.findAll", Inscricao.class).getResultList();
        manager.close();
        return inscricoes;
    }

    /**
     *
     * @param inscricao
     * @return
     * @throws BusinessException
     */
    @Override
    public Inscricao save(Inscricao inscricao) throws BusinessException {
        try {
            manager.getTransaction().begin();
            if (!manager.contains(inscricao)) {
                inscricao = manager.merge(inscricao);
            }
            manager.persist(inscricao);
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao salvar registro: " + inscricao, e);
        } finally {
            manager.close();
        }
        return inscricao;
    }

    /**
     *
     * @param inscricao
     * @throws BusinessException
     */
    @Override
    public void remove(Inscricao inscricao) throws BusinessException {
        try {
            manager.getTransaction().begin();
            manager.remove(manager.merge(inscricao));
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao remover registro: " + inscricao, e);
        } finally {
            manager.close();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Inscricao findById(Long id) {
        Inscricao inscricao = manager.find(Inscricao.class, id);
        manager.close();
        return inscricao;
    }

}
