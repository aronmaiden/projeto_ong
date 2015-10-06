/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.control;

import com.projeto.ong.dao.OficinaDAO;
import com.projeto.ong.entity.Oficina;
import com.projeto.ong.exception.BusinessException;
import com.projeto.ong.model.OficinaModel;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author
 */
public class OficinaController implements IController {

    private OficinaDAO oficinaDAO;
    private final OficinaModel model;

    /**
     *
     * @param model
     */
    public OficinaController(OficinaModel model) {
        this.model = model;
    }

    /**
     * Efetua carga a partir dos registros da tabela inscricao
     */
    public void carregarOficinas() {
        oficinaDAO = new OficinaDAO();
        List<Oficina> oficinas = OficinaDAO.findAll();
        model.setOficinas(oficinas);
    }

    /**
     *
     * @param doacao
     * @throws BusinessException
     */
    public void remove(Oficina oficina) throws BusinessException {
        oficinaDAO = new OficinaDAO();
        oficinaDAO.remove(oficina);
        model.removeOficina(oficina);        
    }

    /**
     *
     * @param oficina
     * @throws BusinessException
     */
    public void save(Oficina oficina) throws BusinessException {
        oficinaDAO = new OficinaDAO();
        oficina = oficinaDAO.save(oficina);
        model.addOficina(oficina);
    }

    public OficinaModel getModel() {
        return model;
    }

}
