/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.model;

import com.projeto.ong.entity.Doacao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Classe utilizada como modelo de dados para a tela de manutenção de doações
 *
 *
 */
public class DoacaoModel extends BindableModel {

    private Doacao doacaoSelecionada;
    private Doacao doacaoSelecionadaBackup;
    private List<Doacao> doacaoList;
    private NavigableMap<Long, Doacao> doacaoNavigableMap;

    /**
     * Construtor da classe
     */
    public DoacaoModel() {
        doacaoSelecionada = new Doacao();
        doacaoList = new ArrayList();
        doacaoNavigableMap = new TreeMap();
    }

    /**
     *
     * @return
     */
    public Doacao getDoacaoSelecionada() {
        return doacaoSelecionada;
    }

    /**
     *
     * @param doacao
     */
    public void setDoacaoSelecionada(Doacao doacao) {
        this.doacaoSelecionada = doacao;
        firePropertyChange("doacaoSelecionada", null, doacao);
    }

    /**
     *
     * @return
     */
    public List<Doacao> getDoacaoList() {
        return doacaoList;
    }

    /**
     *
     * @param doacoes
     */
    public void setDoacaoList(List<Doacao> doacoes) {
        this.doacaoList = new ArrayList();
        this.doacaoList.addAll(doacoes);
        firePropertyChange("doacaoList", null, Collections.unmodifiableList(doacoes));
    }

    /**
     *
     * @param doacoes
     */
    public void setDoacaoMap(List<Doacao> doacoes) {
        doacaoNavigableMap = new TreeMap();
        doacoes.forEach(doacao -> {
            this.doacaoNavigableMap.put(doacao.getId(), doacao);
        });
        firePropertyChange("doacaoNavigableMap", null, Collections.unmodifiableNavigableMap(doacaoNavigableMap));
    }

    /**
     *
     * @param doacao
     */
    public void removeDoacao(Doacao doacao) {
        this.doacaoList.remove(doacao);
        this.doacaoNavigableMap.remove(doacao.getId());
        Entry<Long, Doacao> entry = doacaoNavigableMap.lowerEntry(doacao.getId());
        if (entry == null) {
            entry = doacaoNavigableMap.higherEntry(doacao.getId());
            if (entry == null) {
                setDoacaoSelecionada(new Doacao());
            } else {
                setDoacaoSelecionada(entry.getValue());
            }
        } else {
            setDoacaoSelecionada(entry.getValue());
        }
        firePropertyChange("doacaoList", null, Collections.unmodifiableList(doacaoList));
        firePropertyChange("doacaoNavigableMap", null, Collections.unmodifiableNavigableMap(doacaoNavigableMap));
    }

    /**
     *
     * @param doacao
     */
    public void addDoacao(Doacao doacao) {
        this.doacaoList.add(doacao);
        this.doacaoNavigableMap.put(doacao.getId(), doacao);
        setDoacaoSelecionada(doacao);
        firePropertyChange("doacaoList", null, Collections.unmodifiableList(doacaoList));
        firePropertyChange("doacaoNavigableMap", null, Collections.unmodifiableNavigableMap(doacaoNavigableMap));
    }

    /**
     * Efetua a navegação até o primeiro elemento da coleção
     */
    public void navigateToFirstDoacao() {
        if (doacaoNavigableMap != null && !doacaoNavigableMap.isEmpty()) {
            Entry<Long, Doacao> entry = doacaoNavigableMap.firstEntry();
            if (entry != null) {
                setDoacaoSelecionada(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação na coleção até o elemento anterior ao atual
     */
    public void navigateToPreviousDoacao() {
        if (doacaoNavigableMap != null && !doacaoNavigableMap.isEmpty()) {
            Entry<Long, Doacao> entry = doacaoNavigableMap.lowerEntry(doacaoSelecionada.getId());
            if (entry != null) {
                setDoacaoSelecionada(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação na coleção até o elemento posterior ao atual
     */
    public void navigateToNextDoacao() {
        if (doacaoNavigableMap != null && !doacaoNavigableMap.isEmpty()) {
            Entry<Long, Doacao> entry = doacaoNavigableMap.higherEntry(doacaoSelecionada.getId());
            if (entry != null) {
                setDoacaoSelecionada(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação até o último elemento da coleção
     */
    public void navigateToLastDoacao() {
        if (doacaoNavigableMap != null && !doacaoNavigableMap.isEmpty()) {
            Entry<Long, Doacao> entry = doacaoNavigableMap.lastEntry();
            if (entry != null) {
                setDoacaoSelecionada(entry.getValue());
            }
        }
    }

    /**
     *
     * @return
     */
    public Doacao getDoacaoSelecionadaBackup() {
        return doacaoSelecionadaBackup;
    }

    /**
     *
     * @param doacaoSelecionadaBackup
     */
    public void setDoacaoSelecionadaBackup(Doacao doacaoSelecionadaBackup) {
        if (doacaoSelecionadaBackup == null) {
            this.doacaoSelecionadaBackup = null;
        } else {
            this.doacaoSelecionadaBackup = doacaoSelecionadaBackup;
        }
    }

    /**
     *
     * @return
     */
    public NavigableMap<Long, Doacao> getDoacaoNavigableMap() {
        return doacaoNavigableMap;
    }

    /**
     *
     * @param doacaoNavigableMap
     */
    public void setDoacaoNavigableMap(NavigableMap<Long, Doacao> doacaoNavigableMap) {
        this.doacaoNavigableMap = doacaoNavigableMap;
    }
}
