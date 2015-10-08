/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.model;

import com.projeto.ong.entity.Produto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Classe utilizada como modelo de dados para a tela de manutenção de produtos
 *

 */
public class ProdutoModel extends BindableModel {

    private Produto produtoSelecionado;
    private Produto produtoSelecionadoBackup;
    private List<Produto> produtoList;
    private NavigableMap<Long, Produto> produtoNavigableMap;

    /**
     * Construtor da classe
     */
    public ProdutoModel() {
        produtoSelecionado = new Produto();
        produtoList = new ArrayList();
        produtoNavigableMap = new TreeMap();
    }

    /**
     *
     * @return
     */
    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    /**
     *
     * @param produto
     */
    public void setProdutoSelecionado(Produto produto) {
        this.produtoSelecionado = produto;
        firePropertyChange("produtoSelecionado", null, produto);
    }

    /**
     *
     * @return
     */
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    /**
     *
     * @param produtos
     */
    public void setProdutoList(List<Produto> produtos) {
        this.produtoList = new ArrayList();
        this.produtoList.addAll(produtos);
        firePropertyChange("produtoList", null, Collections.unmodifiableList(produtos));
    }

   


    /**
     *
     * @param produtos
     */
    public void setProdutoMap(List<Produto> produtos) {
        produtoNavigableMap = new TreeMap();
        produtos.forEach(produto -> {
            this.produtoNavigableMap.put(produto.getId(), produto);
        });
        firePropertyChange("produtoNavigableMap", null, Collections.unmodifiableNavigableMap(produtoNavigableMap));
    }

    /**
     *
     * @param produto
     */
    public void removeProduto(Produto produto) {
        this.produtoList.remove(produto);
        this.produtoNavigableMap.remove(produto.getId());
        Entry<Long, Produto> entry = produtoNavigableMap.lowerEntry(produto.getId());
        if (entry == null) {
            entry = produtoNavigableMap.higherEntry(produto.getId());
            if (entry == null) {
                setProdutoSelecionado(new Produto());
            } else {
                setProdutoSelecionado(entry.getValue());
            }
        } else {
            setProdutoSelecionado(entry.getValue());
        }
        firePropertyChange("produtoList", null, Collections.unmodifiableList(produtoList));
        firePropertyChange("produtoNavigableMap", null, Collections.unmodifiableNavigableMap(produtoNavigableMap));
    }

    /**
     *
     * @param produto
     */
    public void addProduto(Produto produto) {
        this.produtoList.add(produto);
        this.produtoNavigableMap.put(produto.getId(), produto);
        setProdutoSelecionado(produto);
        firePropertyChange("produtoList", null, Collections.unmodifiableList(produtoList));
        firePropertyChange("produtoNavigableMap", null, Collections.unmodifiableNavigableMap(produtoNavigableMap));
    }

    /**
     * Efetua a navegação até o primeiro elemento da coleção
     */
    public void navigateToFirstProduto() {
        if (produtoNavigableMap != null && !produtoNavigableMap.isEmpty()) {
            Entry<Long, Produto> entry = produtoNavigableMap.firstEntry();
            if (entry != null) {
                setProdutoSelecionado(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação na coleção até o elemento anterior ao atual
     */
    public void navigateToPreviousProduto() {
        if (produtoNavigableMap != null && !produtoNavigableMap.isEmpty()) {
            Entry<Long, Produto> entry = produtoNavigableMap.lowerEntry(produtoSelecionado.getId());
            if (entry != null) {
                setProdutoSelecionado(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação na coleção até o elemento posterior ao atual
     */
    public void navigateToNextProduto() {
        if (produtoNavigableMap != null && !produtoNavigableMap.isEmpty()) {
            Entry<Long, Produto> entry = produtoNavigableMap.higherEntry(produtoSelecionado.getId());
            if (entry != null) {
                setProdutoSelecionado(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação até o último elemento da coleção
     */
    public void navigateToLastProduto() {
        if (produtoNavigableMap != null && !produtoNavigableMap.isEmpty()) {
            Entry<Long, Produto> entry = produtoNavigableMap.lastEntry();
            if (entry != null) {
                setProdutoSelecionado(entry.getValue());
            }
        }
    }

    /**
     *
     * @return
     */
    public Produto getProdutoSelecionadoBackup() {
        return produtoSelecionadoBackup;
    }

    /**
     *
     * @param produtoSelecionadoBackup
     */
    public void setProdutoSelecionadoBackup(Produto produtoSelecionadoBackup) {
        if (produtoSelecionadoBackup == null) {
            this.produtoSelecionadoBackup = null;
        } else {
            this.produtoSelecionadoBackup = produtoSelecionadoBackup;
        }
    }

    /**
     *
     * @return
     */
    public NavigableMap<Long, Produto> getProdutoNavigableMap() {
        return produtoNavigableMap;
    }

    /**
     *
     * @param produtoNavigableMap
     */
    public void setProdutoNavigableMap(NavigableMap<Long, Produto> produtoNavigableMap) {
        this.produtoNavigableMap = produtoNavigableMap;
    }

}
