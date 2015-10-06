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
import javax.persistence.RollbackException;


/**
 *
 * @author aron.oliveira
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
     * @return
     */
    @Override
    public List<Oficina> findAll() {
        List<Oficina> oficinas = manager.createNamedQuery("Oficina.findAll", Oficina.class).getResultList();
        manager.close();
        return oficinas;
    }


    /**
     *
     * @param doacao
     * @throws BusinessException
     */
    
    @Override
    public Oficina save(Oficina oficina) throws BusinessException {
        try {
            manager.getTransaction().begin();
            if (!manager.contains(oficina)) {
                oficina = manager.merge(oficina);
            }
            manager.persist(oficina);
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao salvar registro: " + oficina, e);
        } finally {
            manager.close();
        }
        return oficina;
    }
    
    @Override
    public void remove(Oficina oficina) throws BusinessException {
        try {
            manager.getTransaction().begin();
            manager.remove(manager.merge(oficina));
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao remover registro: " + oficina, e);
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
    public Oficina findById(Long id) {
        Oficina oficina = manager.find(Oficina.class, id);
        manager.close();
        return oficina;
    }

}
