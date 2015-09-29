/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.util;

/**
 *
 * @author aron.oliveira
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author winston.sonnesen
 */
public class JPAUtil {

    private static final String PERSISTENCE_UNIT_NAME = "ONGPU_MYSQL";
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    /**
     * Obtendo um gerenciador de entidades
     *
     * @return EntityManager
     */
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Fechando as conexões com o banco de dados
     */
    public static void closeEntityManagerFactory() {
        emf.close();
    }
}