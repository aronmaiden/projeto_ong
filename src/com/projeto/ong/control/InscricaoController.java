/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.control;

import com.projeto.ong.dao.InscricaoDAO;
import com.projeto.ong.dao.OficinaDAO;
import com.projeto.ong.dao.PessoaDAO;
import com.projeto.ong.entity.Inscricao;
import com.projeto.ong.exception.BusinessException;
import com.projeto.ong.model.InscricaoModel;
import java.util.List;

/**
 *
 * @author
 */
public class InscricaoController implements IController {

    private InscricaoDAO inscricaoDAO;
    private OficinaDAO oficinaDAO;
    private PessoaDAO pessoaDAO;
    private final InscricaoModel model;

    /**
     *
     * @param model
     */
    public InscricaoController(InscricaoModel model) {
        this.model = model;
    }

    /**
     * Efetua carga a partir dos registros da tabela pessoa
     */
    public void carregarPessoas() {
        pessoaDAO = new PessoaDAO();
        model.setPessoaList(pessoaDAO.findAll());
    }

    /**
     * Efetua carga a partir dos registros da tabela inscricao
     */
    public void carregarInscricoes() {
        inscricaoDAO = new InscricaoDAO();
        List<Inscricao> inscricoes = inscricaoDAO.findAll();
        model.setInscricaoList(inscricoes);
        model.setInscricaoMap(inscricoes);
    }

    /**
     * Efetua carga a partir dos registros da tabela oficina
     */
    public void carregarOficinas() {
        oficinaDAO = new OficinaDAO();
        model.setOficinaList(oficinaDAO.findAll());
    }

    /**
     *
     * @param inscricao
     * @throws BusinessException
     */
    public void remove(Inscricao inscricao) throws BusinessException {
        inscricaoDAO = new InscricaoDAO();
        inscricaoDAO.remove(inscricao);
        model.removeInscricao(inscricao);
    }

    /**
     *
     * @param inscricao
     * @throws BusinessException
     */
    public void save(Inscricao inscricao) throws BusinessException {
        inscricaoDAO = new InscricaoDAO();
        inscricao = inscricaoDAO.save(inscricao);
        model.addInscricao(inscricao);
    }

    /**
     * Efetua a navegação até o primeiro elemento da coleção
     */
    public void navigateToFirstInscricao() {
        model.navigateToFirstInscricao();
    }

    /**
     * Efetua a navegação na coleção até o elemento anterior ao atual
     */
    public void navigateToPreviousInscricao() {
        model.navigateToPreviousInscricao();
    }

    /**
     * Efetua a navegação na coleção até o elemento posterior ao atual
     */
    public void navigateToNextInscricao() {
        model.navigateToNextInscricao();
    }

    /**
     * Efetua a navegação até o último elemento da coleção
     */
    public void navigateToLastInstrucao() {
        model.navigateToLastInstrucao();
    }

}
