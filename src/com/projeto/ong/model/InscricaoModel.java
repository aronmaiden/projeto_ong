/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.model;

import com.projeto.ong.entity.Inscricao;
import com.projeto.ong.entity.Oficina;
import com.projeto.ong.entity.Pessoa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Classe utilizada como modelo de dados para a tela de manutenção de inscrições
 * 
 * @author winston
 */
public class InscricaoModel extends BindableModel {

    private Inscricao inscricaoSelecionada;
    private Inscricao inscricaoSelecionadaBackup;
    private List<Inscricao> inscricaoList;
    private List<Pessoa> pessoaList;
    private List<Oficina> oficinaList;
    private NavigableMap<Long, Inscricao> inscricaoNavigableMap;

    /**
     * Construtor da classe
     */
    public InscricaoModel() {
        inscricaoSelecionada = new Inscricao();
        inscricaoList = new ArrayList();
        pessoaList = new ArrayList();
        oficinaList = new ArrayList();
        inscricaoNavigableMap = new TreeMap();
    }

    /**
     * 
     * @return
     */
    public Inscricao getInscricaoSelecionada() {
        return inscricaoSelecionada;
    }

    /**
     *
     * @param inscricao
     */
    public void setInscricaoSelecionada(Inscricao inscricao) {
        this.inscricaoSelecionada = inscricao;
        firePropertyChange("inscricaoSelecionada", null, inscricao);
    }

    /**
     *
     * @return
     */
    public List<Inscricao> getInscricaoList() {
        return inscricaoList;
    }

    /**
     *
     * @param inscricoes
     */
    public void setInscricaoList(List<Inscricao> inscricoes) {
        this.inscricaoList = new ArrayList();
        this.inscricaoList.addAll(inscricoes);
        firePropertyChange("inscricaoList", null, Collections.unmodifiableList(inscricoes));
    }

    /**
     *
     * @return
     */
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    /**
     *
     * @param pessoas
     */
    public void setPessoaList(List<Pessoa> pessoas) {
        this.pessoaList = new ArrayList();
        this.pessoaList.addAll(pessoas);
        firePropertyChange("pessoaList", null, Collections.unmodifiableList(pessoas));
    }

    /**
     *
     * @return
     */
    public List<Oficina> getOficinaList() {
        return oficinaList;
    }

    /**
     *
     * @param oficinas
     */
    public void setOficinaList(List<Oficina> oficinas) {
        this.oficinaList = new ArrayList();
        this.oficinaList.addAll(oficinas);
        firePropertyChange("oficinaList", null, Collections.unmodifiableList(oficinaList));
    }

    /**
     *
     * @param inscricoes
     */
    public void setInscricaoMap(List<Inscricao> inscricoes) {
        inscricaoNavigableMap = new TreeMap();
        inscricoes.forEach(inscricao -> {
            this.inscricaoNavigableMap.put(inscricao.getId(), inscricao);
        });
        firePropertyChange("inscricaoNavigableMap", null, Collections.unmodifiableNavigableMap(inscricaoNavigableMap));
    }

    /**
     *
     * @param inscricao
     */
    public void removeInscricao(Inscricao inscricao) {
        this.inscricaoList.remove(inscricao);
        this.inscricaoNavigableMap.remove(inscricao.getId());
        Entry<Long, Inscricao> entry = inscricaoNavigableMap.lowerEntry(inscricao.getId());
        if (entry == null) {
            entry = inscricaoNavigableMap.higherEntry(inscricao.getId());
            if (entry == null) {
                setInscricaoSelecionada(new Inscricao());
            } else {
                setInscricaoSelecionada(entry.getValue());
            }
        } else {
            setInscricaoSelecionada(entry.getValue());
        }
        firePropertyChange("inscricaoList", null, Collections.unmodifiableList(inscricaoList));
        firePropertyChange("inscricaoNavigableMap", null, Collections.unmodifiableNavigableMap(inscricaoNavigableMap));
    }

    /**
     *
     * @param inscricao
     */
    public void addInscricao(Inscricao inscricao) {
        this.inscricaoList.add(inscricao);
        this.inscricaoNavigableMap.put(inscricao.getId(), inscricao);
        setInscricaoSelecionada(inscricao);
        firePropertyChange("inscricaoList", null, Collections.unmodifiableList(inscricaoList));
        firePropertyChange("inscricaoNavigableMap", null, Collections.unmodifiableNavigableMap(inscricaoNavigableMap));
    }

    /**
     * Efetua a navegação até o primeiro elemento da coleção
     */
    public void navigateToFirstInscricao() {
        if (inscricaoNavigableMap != null && !inscricaoNavigableMap.isEmpty()) {
            Entry<Long, Inscricao> entry = inscricaoNavigableMap.firstEntry();
            if (entry != null) {
                setInscricaoSelecionada(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação na coleção até o elemento anterior ao atual
     */
    public void navigateToPreviousInscricao() {
        if (inscricaoNavigableMap != null && !inscricaoNavigableMap.isEmpty()) {
            Entry<Long, Inscricao> entry = inscricaoNavigableMap.lowerEntry(inscricaoSelecionada.getId());
            if (entry != null) {
                setInscricaoSelecionada(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação na coleção até o elemento posterior ao atual
     */
    public void navigateToNextInscricao() {
        if (inscricaoNavigableMap != null && !inscricaoNavigableMap.isEmpty()) {
            Entry<Long, Inscricao> entry = inscricaoNavigableMap.higherEntry(inscricaoSelecionada.getId());
            if (entry != null) {
                setInscricaoSelecionada(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação até o último elemento da coleção
     */
    public void navigateToLastInstrucao() {
        if (inscricaoNavigableMap != null && !inscricaoNavigableMap.isEmpty()) {
            Entry<Long, Inscricao> entry = inscricaoNavigableMap.lastEntry();
            if (entry != null) {
                setInscricaoSelecionada(entry.getValue());
            }
        }
    }

    /**
     *
     * @return
     */
    public Inscricao getInscricaoSelecionadaBackup() {
        return inscricaoSelecionadaBackup;
    }

    /**
     *
     * @param inscricaoSelecionadaBackup
     */
    public void setInscricaoSelecionadaBackup(Inscricao inscricaoSelecionadaBackup) {
        if (inscricaoSelecionadaBackup == null) {
            this.inscricaoSelecionadaBackup = null;
        } else {
            this.inscricaoSelecionadaBackup = inscricaoSelecionadaBackup;
        }
    }

    /**
     *
     * @return
     */
    public NavigableMap<Long, Inscricao> getInscricaoNavigableMap() {
        return inscricaoNavigableMap;
    }

    /**
     *
     * @param inscricaoNavigableMap
     */
    public void setInscricaoNavigableMap(NavigableMap<Long, Inscricao> inscricaoNavigableMap) {
        this.inscricaoNavigableMap = inscricaoNavigableMap;
    }

}
