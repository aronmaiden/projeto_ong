/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.dao;

import com.projeto.ong.entity.Oficina;
import com.projeto.ong.exception.BusinessException;
import com.projeto.ong.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author winston
 */
public class OficinaDAO implements IDAO<Oficina> {

    private final EntityManager manager;

    /**
     * Construtor da classe
     */
    public OficinaDAO() {
        manager = JPAUtil.getEntityManager();
    }

    /**
     *
     * @param o
     * @return
     * @throws BusinessException
     */
    @Override
    public Oficina save(Oficina o) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public List<Oficina> findAll() {
        return manager.createNamedQuery("Oficina.findAll", Oficina.class).getResultList();
    }

    /**
     *
     * @param o
     */
    @Override
    public void remove(Oficina o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Oficina findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
