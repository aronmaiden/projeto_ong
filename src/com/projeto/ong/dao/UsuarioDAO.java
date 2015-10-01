/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.dao;

import com.projeto.ong.entity.Usuario;
import com.projeto.ong.exception.BusinessException;
import com.projeto.ong.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

/**
 *
 *
 * @author aron.oliveira
 */
public class UsuarioDAO implements IDAO<Usuario> {

    private final EntityManager em;

    /**
     * Construtor da classe
     */
    public UsuarioDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    /**
     *
     * @param u
     * @return
     * @throws BusinessException
     */
    @Override
    public Usuario save(Usuario u) throws BusinessException {
        try {
            em.getTransaction().begin();
            if (u.getId() == null || u.getId() == 0L) {
                em.persist(u);
            } else {
                u = em.merge(u);
            }
            em.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao salvar o usuario " + u, e);
        }
        return u;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Usuario> findAll() {
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAll", Usuario.class);
        return query.getResultList();
    }

    /**
     *
     * @param u
     */
    @Override
    public void remove(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Usuario findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario findByLoginSenha(Usuario usuario) {
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByLoginSenha", Usuario.class)
                .setParameter("login", usuario.getLogin())
                .setParameter("senha", usuario.getSenha());

        Usuario u = query.getSingleResult();
        em.close();
        return u;
    }
}
