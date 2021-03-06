/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.model;

import com.projeto.ong.entity.Doacao;
import java.util.Collections;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Classe utilizada como modelo de dados para a tela de manutenção de doações
 *
 *
 */
public class DoacaoModel extends BindableModel {
    
    private Doacao registroSelecionado;
    private Doacao backupRegistro;
    private Doacao registroEditado;
    private List<Doacao> doacoes;
    private Boolean isEnabled;

    /**
     * Construtor da classe
     */
    public DoacaoModel() {
        
    }

    /**
     *
     * @return
     */
    public Doacao getRegistroSelecionado() {
        return registroSelecionado;
    }

    /**
     *
     * @param doacao
     */
    public void setRegistroSelecionado(Doacao doacao) {
        this.registroSelecionado = doacao;
        firePropertyChange("registroSelecionado", null, doacao);
    }

    /**
     *
     * @return
     */
    public List<Doacao> getDoacoes() {
        return doacoes;
    }

    /**
     *
     * @param doacoes
     */
    public void setDoacoes(List<Doacao> doacoes) {
        this.doacoes = ObservableCollections.observableList(doacoes);
        firePropertyChange("doacoes", null, Collections.unmodifiableList(doacoes));
    }

    /**
     *
     * @param doacao
     */
    public void removeDoacao(Doacao doacao) {
        this.doacoes.remove(doacao);
        firePropertyChange("doacoes", null, Collections.unmodifiableList(doacoes));
    }

    /**
     *
     * @param doacao
     */
    public void addDoacao(Doacao doacao) {
        this.doacoes.add(doacao);
        firePropertyChange("doacoes", null, Collections.unmodifiableList(doacoes));
    }

    /**
     *
     * @return
     */
    public Doacao getBackupRegistro() {
        return backupRegistro;
    }

    /**
     *
     * @param backupRegistro
     */
    public void setBackupRegistro(Doacao backupRegistro) {
        if (backupRegistro == null) {
            this.backupRegistro = null;
        } else {
            this.backupRegistro = backupRegistro;
        }
    }
    
    public Boolean getIsEnabled() {
        return isEnabled;
    }
    
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
        firePropertyChange("isEnabled", null, isEnabled);
    }
    
    public Doacao getRegistroEditado() {
        return registroEditado;
    }
    
    public void setRegistroEditado(Doacao registroEditado) {
        this.registroEditado = registroEditado;
        firePropertyChange("registroEditado", null, registroEditado);
    }
    
}
