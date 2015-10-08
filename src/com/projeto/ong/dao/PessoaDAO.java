/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.dao;

import com.projeto.ong.entity.Pessoa;
import com.projeto.ong.exception.BusinessException;
import com.projeto.ong.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;


/**
 *
 * @author aron.oliveira
 */
public class PessoaDAO implements IDAO<Pessoa> {

    private final EntityManager manager;

    /**
     * Construtor da classe
     */
    public PessoaDAO() {
        manager = JPAUtil.getEntityManager();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = manager.createNamedQuery("Pessoa.findAll", Pessoa.class).getResultList();
        manager.close();
        return pessoas;
    }


    /**
     *
     * @param doacao
     * @throws BusinessException
     */
    
    @Override
    public Pessoa save(Pessoa pessoa) throws BusinessException {
        try {
            manager.getTransaction().begin();
            if (!manager.contains(pessoa)) {
                pessoa = manager.merge(pessoa);
            }
            manager.persist(pessoa);
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao salvar registro: " + pessoa, e);
        } finally {
            manager.close();
        }
        return pessoa;
    }
    
    @Override
    public void remove(Pessoa pessoa) throws BusinessException {
        try {
            manager.getTransaction().begin();
            manager.remove(manager.merge(pessoa));
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao remover registro: " + pessoa, e);
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
    public Pessoa findById(Long id) {
        Pessoa pessoa = manager.find(Pessoa.class, id);
        manager.close();
        return pessoa;
    }

}
