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

/**
 *
 * @author winston
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
        return manager.createNamedQuery("Pessoa.findAll", Pessoa.class).getResultList();
    }

    /**
     *
     * @param entity
     * @return
     * @throws BusinessException
     */
    @Override
    public Pessoa save(Pessoa entity) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param entity
     * @throws BusinessException
     */
    @Override
    public void remove(Pessoa entity) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Pessoa findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
