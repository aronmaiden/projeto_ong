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


/**
 *
 * @author winston
 */
public class ProdutoDAO implements IDAO<Produto> {

    private final EntityManager manager;

    /**
     * Construtor da classe
     */
    public ProdutoDAO() {
        manager = JPAUtil.getEntityManager();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Produto> findAll() {
        List<Produto> produtos = manager.createNamedQuery("Produto.findAll", Produto.class).getResultList();
        manager.close();
        return produtos;
    }

    /**
     *
     * @param produto
     * @return
     * @throws BusinessException
     */
    @Override
    public Produto save(Produto produto) throws BusinessException {
        try {
            manager.getTransaction().begin();
            if (!manager.contains(produto)) {
                produto = manager.merge(produto);
            }
            manager.persist(produto);
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao salvar registro: " + produto, e);
        } finally {
            manager.close();
        }
        return produto;
    }

    /**
     *
     * @param produto
     * @throws BusinessException
     */
    @Override
    public void remove(Produto produto) throws BusinessException {
        try {
            manager.getTransaction().begin();
            manager.remove(manager.merge(produto));
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao remover registro: " + produto, e);
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
    public Produto findById(Long id) {
        Produto produto = manager.find(Produto.class, id);
        manager.close();
        return produto;
    }

}
