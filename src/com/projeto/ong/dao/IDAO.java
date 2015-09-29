/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.dao;

import com.projeto.ong.exception.BusinessException;
import java.util.List;

/**
 *
 * @author winston
 * @param <E>
 */
public interface IDAO <E>{

    /**
     *
     * @param entity
     * @return
     * @throws BusinessException
     */
    E save(E entity) throws BusinessException;

    /**
     *
     * @param entity
     * @throws BusinessException
     */
    void remove(E entity) throws BusinessException;

    /**
     *
     * @param id
     * @return
     */
    E findById(Long id);

    /**
     *
     * @return
     */
    List<E> findAll();
}
