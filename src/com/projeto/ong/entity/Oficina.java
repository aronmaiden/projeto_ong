/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author 
 */
@Entity
@Table(name = "oficina")
@NamedQueries({
    @NamedQuery(name = "Oficina.findAll", query = "SELECT o FROM Oficina o"),
    @NamedQuery(name = "Oficina.findById", query = "SELECT o FROM Oficina o WHERE o.id = :id"),
    @NamedQuery(name = "Oficina.findByDataOficina", query = "SELECT o FROM Oficina o WHERE o.dataOficina = :dataOficina"),
    @NamedQuery(name = "Oficina.findByNome", query = "SELECT o FROM Oficina o WHERE o.nome = :nome"),
    @NamedQuery(name = "Oficina.findByHorario", query = "SELECT o FROM Oficina o WHERE o.horario = :horario"),
    @NamedQuery(name = "Oficina.findByQtd_pessoas", query = "SELECT o FROM Oficina o WHERE o.qtd_pessoas = :qtd_pessoas"),
    @NamedQuery(name = "Oficina.findByFoto", query = "SELECT o FROM Oficina o WHERE o.foto = :foto")})
public class Oficina implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "dataoficina")
    @Temporal(TemporalType.DATE)
    private Date dataOficina;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "horario")
    private String horario;
    @Basic(optional = false)
    @Column(name = "qtd_pessoas")
    private int qtd_pessoas;
    @Basic(optional = false)
    @Column(name = "foto")
    private String foto;
    

    public Oficina() {
    }

    public Oficina(Long id) {
        this.id = id;
    }

    public Oficina(Long id, Date dataOficina, String nome, String horario, int qtd_pessoas, String foto) {
        this.id = id;
        this.dataOficina = dataOficina;
        this.nome = nome;
        this.horario = horario;
        this.qtd_pessoas = qtd_pessoas;
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Date getDataOficina() {
        return dataOficina;
    }

    public void setDataOficina(Date dataOficina) {
        Date oldDataOficina = this.dataOficina;
        this.dataOficina = dataOficina;
        changeSupport.firePropertyChange("dataOficina", oldDataOficina, dataOficina);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }
    
     public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        String oldHorario = this.horario;
        this.horario = horario;
        changeSupport.firePropertyChange("horario", oldHorario, horario);
    }

    public int getQtd_pessoas() {
        return qtd_pessoas;
    }

    public void setQtd_pessoas(int qtd_pessoas) {
        int oldQtd_pessoas = this.qtd_pessoas;
        this.qtd_pessoas = qtd_pessoas;
        changeSupport.firePropertyChange("qtd_pessoas", oldQtd_pessoas, qtd_pessoas);
    }
     public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        String oldFoto = this.foto;
        this.foto = foto;
        changeSupport.firePropertyChange("foto", oldFoto, foto);
    }
 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oficina)) {
            return false;
        }
        Oficina other = (Oficina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projeto.ong.entity.Oficina[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

