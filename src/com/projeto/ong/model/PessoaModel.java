/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.model;

/**
 *
 * @author aron.oliveira
 */
import com.projeto.ong.entity.Pessoa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Classe utilizada como modelo de dados para a tela de manutenção de pessoas
 */

public class PessoaModel extends BindableModel {

    private Pessoa pessoaSelecionada;
    private Pessoa pessoaSelecionadaBackup;
    private List<Pessoa> pessoaList;
    private NavigableMap<Long, Pessoa> pessoaNavigableMap;

    /**
     * Construtor da classe
     */
    public PessoaModel() {
        pessoaSelecionada = new Pessoa();
        pessoaList = new ArrayList();
        pessoaNavigableMap = new TreeMap();
    }

    /**
     *
     * @return
     */
    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    /**
     *
     * @param pessoa
     */
    public void setPessoaSelecionada(Pessoa pessoa) {
        this.pessoaSelecionada = pessoa;
        firePropertyChange("pessoaSelecionada", null, pessoa);
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
     * @param pessoa
     */
    public void setPessoaList(List<Pessoa> pessoas) {
        this.pessoaList = new ArrayList();
        this.pessoaList.addAll(pessoas);
        firePropertyChange("pessoaList", null, Collections.unmodifiableList(pessoas));
    }

   


    /**
     *
     * @param pessoas
     */
    public void setPessoaMap(List<Pessoa> pessoas) {
        pessoaNavigableMap = new TreeMap();
        pessoas.forEach(pessoa -> {
            this.pessoaNavigableMap.put(pessoa.getId(), pessoa);
        });
        firePropertyChange("pessoaNavigableMap", null, Collections.unmodifiableNavigableMap(pessoaNavigableMap));
    }

    /**
     *
     * @param pessoa
     */
    public void removePessoa(Pessoa pessoa) {
        this.pessoaList.remove(pessoa);
        this.pessoaNavigableMap.remove(pessoa.getId());
        Entry<Long, Pessoa> entry = pessoaNavigableMap.lowerEntry(pessoa.getId());
        if (entry == null) {
            entry = pessoaNavigableMap.higherEntry(pessoa.getId());
            if (entry == null) {
                setPessoaSelecionada(new Pessoa());
            } else {
                setPessoaSelecionada(entry.getValue());
            }
        } else {
            setPessoaSelecionada(entry.getValue());
        }
        firePropertyChange("pessoaList", null, Collections.unmodifiableList(pessoaList));
        firePropertyChange("pessoaNavigableMap", null, Collections.unmodifiableNavigableMap(pessoaNavigableMap));
    }

    /**
     *
     * @param pessoa
     */
    public void addPessoa(Pessoa pessoa) {
        this.pessoaList.add(pessoa);
        this.pessoaNavigableMap.put(pessoa.getId(), pessoa);
        setPessoaSelecionada(pessoa);
        firePropertyChange("pessoaList", null, Collections.unmodifiableList(pessoaList));
        firePropertyChange("pessoaNavigableMap", null, Collections.unmodifiableNavigableMap(pessoaNavigableMap));
    }

    /**
     * Efetua a navegação até o primeiro elemento da coleção
     */
    public void navigateToFirstPessoa() {
        if (pessoaNavigableMap != null && !pessoaNavigableMap.isEmpty()) {
            Entry<Long, Pessoa> entry = pessoaNavigableMap.firstEntry();
            if (entry != null) {
                setPessoaSelecionada(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação na coleção até o elemento anterior ao atual
     */
    public void navigateToPreviousPessoa() {
        if (pessoaNavigableMap != null && !pessoaNavigableMap.isEmpty()) {
            Entry<Long, Pessoa> entry = pessoaNavigableMap.lowerEntry(pessoaSelecionada.getId());
            if (entry != null) {
                setPessoaSelecionada(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação na coleção até o elemento posterior ao atual
     */
    public void navigateToNextPessoa() {
        if (pessoaNavigableMap != null && !pessoaNavigableMap.isEmpty()) {
            Entry<Long, Pessoa> entry = pessoaNavigableMap.higherEntry(pessoaSelecionada.getId());
            if (entry != null) {
                setPessoaSelecionada(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação até o último elemento da coleção
     */
    public void navigateToLastPessoa() {
        if (pessoaNavigableMap != null && !pessoaNavigableMap.isEmpty()) {
            Entry<Long, Pessoa> entry = pessoaNavigableMap.lastEntry();
            if (entry != null) {
                setPessoaSelecionada(entry.getValue());
            }
        }
    }

    /**
     *
     * @return
     */
    public Pessoa getPessoaSelecionadaBackup() {
        return pessoaSelecionadaBackup;
    }

    /**
     *
     * @param pessoaSelecionadaBackup
     */
    public void setPessoaSelecionadaBackup(Pessoa pessoaSelecionadaBackup) {
        if (pessoaSelecionadaBackup == null) {
            this.pessoaSelecionadaBackup = null;
        } else {
            this.pessoaSelecionadaBackup = pessoaSelecionadaBackup;
        }
    }

    /**
     *
     * @return
     */
    public NavigableMap<Long, Pessoa> getPessoaNavigableMap() {
        return pessoaNavigableMap;
    }

    /**
     *
     * @param pessoaNavigableMap
     */
    public void setPessoaNavigableMap(NavigableMap<Long, Pessoa> pessoaNavigableMap) {
        this.pessoaNavigableMap = pessoaNavigableMap;
    }

}
