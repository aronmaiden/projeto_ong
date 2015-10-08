/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.control;

/**
 *
 * @author aron.oliveira
 */
import com.projeto.ong.dao.PessoaDAO;
import com.projeto.ong.entity.Pessoa;
import com.projeto.ong.exception.BusinessException;
import com.projeto.ong.model.PessoaModel;
import java.util.List;


public class PessoaController implements IController {

    private PessoaDAO pessoaDAO;
    private final PessoaModel model;

    /**
     *
     * @param model
     */
    public PessoaController(PessoaModel model) {
        this.model = model;
    }


    /**
     * Efetua carga a partir dos registros da tabela pessoa
     */
    public void carregarPessoas() {
        pessoaDAO = new PessoaDAO();
        List<Pessoa> pessoas = pessoaDAO.findAll();
        model.setPessoaList(pessoas);
        model.setPessoaMap(pessoas);
    }


    /**
     *
     * @param pessoa
     * @throws BusinessException
     */
    public void remove(Pessoa pessoa) throws BusinessException {
        pessoaDAO = new PessoaDAO();
        pessoaDAO.remove(pessoa);
        model.removePessoa(pessoa);
    }

    /**
     *
     * @param pessoa
     * @throws BusinessException
     */
    public void save(Pessoa pessoa) throws BusinessException {
        pessoaDAO = new PessoaDAO();
        pessoa = pessoaDAO.save(pessoa);
        model.addPessoa(pessoa);
    }

    /**
     * Efetua a navegação até o primeiro elemento da coleção
     */
    public void navigateToFirstPessoa() {
        model.navigateToFirstPessoa();
    }

    /**
     * Efetua a navegação na coleção até o elemento anterior ao atual
     */
    public void navigateToPreviousPessoa() {
        model.navigateToPreviousPessoa();
    }

    /**
     * Efetua a navegação na coleção até o elemento posterior ao atual
     */
    public void navigateToNextPessoa() {
        model.navigateToNextPessoa();
    }

    /**
     * Efetua a navegação até o último elemento da coleção
     */
    public void navigateToLastPessoa() {
        model.navigateToLastPessoa();
    }
    
    public PessoaModel getModel() {
        return model;
    }
}

