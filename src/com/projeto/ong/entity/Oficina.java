/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author winston
 */
@Entity
@Table(name = "oficina")
@NamedQueries({
    @NamedQuery(name = "Oficina.findAll", query = "SELECT o FROM Oficina o"),
    @NamedQuery(name = "Oficina.findById", query = "SELECT o FROM Oficina o WHERE o.id = :id"),
    @NamedQuery(name = "Oficina.findByDataOficina", query = "SELECT o FROM Oficina o WHERE o.dataOficina = :dataOficina"),
    @NamedQuery(name = "Oficina.findByFoto", query = "SELECT o FROM Oficina o WHERE o.foto = :foto"),
    @NamedQuery(name = "Oficina.findByHorario", query = "SELECT o FROM Oficina o WHERE o.horario = :horario"),
    @NamedQuery(name = "Oficina.findByNome", query = "SELECT o FROM Oficina o WHERE o.nome = :nome"),
    @NamedQuery(name = "Oficina.findByQtdPessoas", query = "SELECT o FROM Oficina o WHERE o.qtdPessoas = :qtdPessoas")})
public class Oficina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "data_oficina")
    @Temporal(TemporalType.DATE)
    private Date dataOficina;
    @Column(name = "foto")
    private String foto;
    @Basic(optional = false)
    @Column(name = "horario")
    @Temporal(TemporalType.TIME)
    private Date horario;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "qtd_pessoas")
    private Integer qtdPessoas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oficina", fetch = FetchType.LAZY)
    private List<Inscricao> inscricaoList;
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Endereco endereco;

    /**
     * Construtor da classe
     */
    public Oficina() {
    }

    /**
     * Construtor da classe
     * @param id
     */
    public Oficina(Long id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param dataOficina
     * @param horario
     * @param nome
     */
    public Oficina(Long id, Date dataOficina, Date horario, String nome) {
        this.id = id;
        this.dataOficina = dataOficina;
        this.horario = horario;
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Date getDataOficina() {
        return dataOficina;
    }

    /**
     *
     * @param dataOficina
     */
    public void setDataOficina(Date dataOficina) {
        this.dataOficina = dataOficina;
    }

    /**
     *
     * @return
     */
    public String getFoto() {
        return foto;
    }

    /**
     *
     * @param foto
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     *
     * @return
     */
    public Date getHorario() {
        return horario;
    }

    /**
     *
     * @param horario
     */
    public void setHorario(Date horario) {
        this.horario = horario;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public Integer getQtdPessoas() {
        return qtdPessoas;
    }

    /**
     *
     * @param qtdPessoas
     */
    public void setQtdPessoas(Integer qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
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
     * @param inscricaoList
     */
    public void setInscricaoList(List<Inscricao> inscricaoList) {
        this.inscricaoList = inscricaoList;
    }

    /**
     *
     * @return
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     *
     * @param endereco
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
    
}
