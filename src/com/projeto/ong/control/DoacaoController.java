/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.control;

import com.projeto.ong.dao.DoacaoDAO;
import com.projeto.ong.entity.Doacao;
import com.projeto.ong.exception.BusinessException;
import com.projeto.ong.model.DoacaoModel;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author
 */
public class DoacaoController implements IController {

    private DoacaoDAO doacaoDAO;
    private final DoacaoModel model;

    /**
     *
     * @param model
     */
    public DoacaoController(DoacaoModel model) {
        this.model = model;
    }

    /**
     * Efetua carga a partir dos registros da tabela inscricao
     */
    public void carregarDoacoes() {
        doacaoDAO = new DoacaoDAO();
        List<Doacao> doacoes = doacaoDAO.findAll();
        model.setDoacoes(doacoes);
    }

    /**
     *
     * @param doacao
     * @throws BusinessException
     */
    public void remove(Doacao doacao) throws BusinessException {
        doacaoDAO = new DoacaoDAO();
        doacaoDAO.remove(doacao);
        model.removeDoacao(doacao);        
    }

    /**
     *
     * @param doacao
     * @throws BusinessException
     */
    public void save(Doacao doacao) throws BusinessException {
        doacaoDAO = new DoacaoDAO();
        doacao = doacaoDAO.save(doacao);
        model.addDoacao(doacao);
    }

    public DoacaoModel getModel() {
        return model;
    }

}
