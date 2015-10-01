/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.dao;

import com.projeto.ong.entity.Doacao;
import com.projeto.ong.exception.BusinessException;
import com.projeto.ong.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

/**
 *
 * @author aron.oliveira
 */
public class DoacaoDAO implements IDAO<Doacao> {

    private final EntityManager manager;

    /**
     * Construtor da classe
     */
    public DoacaoDAO() {
        this.manager = JPAUtil.getEntityManager();
    }
    
     /**
     *
     * @return
     */
    @Override
    public List<Doacao> findAll() {
        List<Doacao> doacoes = manager.createNamedQuery("Doacao.findAll", Doacao.class).getResultList();
        manager.close();
        return doacoes;
    }
    
    /**
     *
     * @param doacao
     * @return
     * @throws BusinessException
     */
    
    @Override
    public Doacao save(Doacao doacao) throws BusinessException {
        try {
            manager.getTransaction().begin();
            if (!manager.contains(doacao)) {
                doacao = manager.merge(doacao);
            }
            manager.persist(doacao);
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao salvar registro: " + doacao, e);
        } finally {
            manager.close();
        }
        return doacao;
    }

    /**
     *
     * @param d
     * @throws BusinessException
     */
    @Override
    public void remove(Doacao doacao) throws BusinessException {
        try {
            manager.getTransaction().begin();
            manager.remove(manager.merge(doacao));
            manager.getTransaction().commit();            
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao remover registro: " + doacao, e);
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
    public Doacao findById(Long id) {
        Doacao doacao = manager.find(Doacao.class, id);
        manager.close();
        return doacao;
    }

}
