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

    private final EntityManager em;

    /**
     * Construtor da classe
     */
    public DoacaoDAO() {
        this.em = JPAUtil.getEntityManager();
    }
    
    /**
     *
     * @param d
     * @return
     * @throws BusinessException
     */
    @Override
    public Doacao save(Doacao d) throws BusinessException {
        try {
            em.getTransaction().begin();
            if (d.getId() == null || d.getId() == 0L) {
                em.persist(d);
            } else {
                d = em.merge(d);
            }
            em.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao salvar registro: " + d, e);
        } finally {
            em.close();
        }
        return d;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Doacao> findAll() {
        TypedQuery<Doacao> query = em.createNamedQuery("Doacao.findAll", Doacao.class);
        List<Doacao> doacoes = query.getResultList();
        em.close();
        return doacoes;
    }

    /**
     *
     * @param d
     * @throws BusinessException
     */
    @Override
    public void remove(Doacao d) throws BusinessException {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(d));
            em.getTransaction().commit();            
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao remover registro: " + d, e);
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Doacao findById(Long id) {
        Doacao doacao = null;
        em.find(Doacao.class, id);
        em.close();
        return doacao;
    }

}
