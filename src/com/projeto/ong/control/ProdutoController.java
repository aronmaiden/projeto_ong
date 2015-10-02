/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.control;


import com.projeto.ong.dao.ProdutoDAO;
import com.projeto.ong.entity.Produto;
import com.projeto.ong.exception.BusinessException;
import com.projeto.ong.model.ProdutoModel;
import java.util.List;


public class ProdutoController implements IController {

    private ProdutoDAO produtoDAO;
    private final ProdutoModel model;

    /**
     *
     * @param model
     */
    public ProdutoController(ProdutoModel model) {
        this.model = model;
    }


    /**
     * Efetua carga a partir dos registros da tabela produto
     */
    public void carregarProdutos() {
        produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.findAll();
        model.setProdutoList(produtos);
        model.setProdutoMap(produtos);
    }


    /**
     *
     * @param produto
     * @throws BusinessException
     */
    public void remove(Produto produto) throws BusinessException {
        produtoDAO = new ProdutoDAO();
        produtoDAO.remove(produto);
        model.removeProduto(produto);
    }

    /**
     *
     * @param produto
     * @throws BusinessException
     */
    public void save(Produto produto) throws BusinessException {
        produtoDAO = new ProdutoDAO();
        produto = produtoDAO.save(produto);
        model.addProduto(produto);
    }

    /**
     * Efetua a navegação até o primeiro elemento da coleção
     */
    public void navigateToFirstProduto() {
        model.navigateToFirstProduto();
    }

    /**
     * Efetua a navegação na coleção até o elemento anterior ao atual
     */
    public void navigateToPreviousProduto() {
        model.navigateToPreviousProduto();
    }

    /**
     * Efetua a navegação na coleção até o elemento posterior ao atual
     */
    public void navigateToNextProduto() {
        model.navigateToNextProduto();
    }

    /**
     * Efetua a navegação até o último elemento da coleção
     */
    public void navigateToLastProduto() {
        model.navigateToLastProduto();
    }

}
