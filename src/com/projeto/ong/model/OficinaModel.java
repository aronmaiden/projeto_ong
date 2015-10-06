/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.model;


import com.projeto.ong.entity.Oficina;
import java.util.Collections;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
/**
 *
 * @author aron.oliveira


/**
 * Classe utilizada como modelo de dados para a tela de manutenção de doações
 *
 *
 */
public class OficinaModel extends BindableModel {
    
    private Oficina registroSelecionado;
    private Oficina backupRegistro;
    private Oficina registroEditado;
    private List<Oficina> oficinas;
    private Boolean isEnabled;

    /**
     * Construtor da classe
     */
    public OficinaModel() {
        
    }

    /**
     *
     * @return
     */
    public Oficina getRegistroSelecionado() {
        return registroSelecionado;
    }

    /**
     *
     * @param oficina
     */
    public void setRegistroSelecionado(Oficina oficina) {
        this.registroSelecionado = oficina;
        firePropertyChange("registroSelecionado", null, oficina);
    }

    /**
     *
     * @return
     */
    public List<Oficina> getOficinas() {
        return oficinas;
    }

    /**
     *
     * @param oficinas
     */
    public void setOficinas(List<Oficina> oficinas) {
        this.oficinas = ObservableCollections.observableList(oficinas);
        firePropertyChange("oficinas", null, Collections.unmodifiableList(oficinas));
    }

    /**
     *
     * @param oficina
     */
    public void removeOficina(Oficina oficina) {
        this.oficinas.remove(oficina);
        firePropertyChange("oficinas", null, Collections.unmodifiableList(oficinas));
    }

    /**
     *
     * @param oficina
     */
    public void addOficina(Oficina oficina ) {
        this.oficinas.add(oficina);
        firePropertyChange("oficinas", null, Collections.unmodifiableList(oficinas));
    }

    /**
     *
     * @return
     */
    public Oficina getBackupRegistro() {
        return backupRegistro;
    }

    /**
     *
     * @param backupRegistro
     */
    public void setBackupRegistro(Oficina backupRegistro) {
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
    
    public Oficina getRegistroEditado() {
        return registroEditado;
    }
    
    public void setRegistroEditado(Oficina registroEditado) {
        this.registroEditado = registroEditado;
        firePropertyChange("registroEditado", null, registroEditado);
    }
    
}
