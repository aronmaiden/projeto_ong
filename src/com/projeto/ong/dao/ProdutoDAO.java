/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.dao;

import com.projeto.ong.entity.Produto;
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
public class ProdutoDAO implements IDAO<Produto> {

    private final EntityManager em;

    /**
     * Construtor da classe
     */
    public ProdutoDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    /**
     *
     * @param p
     * @return
     * @throws BusinessException
     */
    @Override
    public Produto save(Produto p) throws BusinessException {
        try {
            em.getTransaction().begin();
            if (p.getId() == null || p.getId() == 0L) {
                em.persist(p);
            } else {
                p = em.merge(p);
            }
            em.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao salvar o produto " + p, e);
        }
        return p;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Produto> findAll() {
        TypedQuery<Produto> query = em.createNamedQuery("Produto.findAll", Produto.class);
        return query.getResultList();
    }

    /**
     *
     * @param p
     */
    @Override
    public void remove(Produto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Produto findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
