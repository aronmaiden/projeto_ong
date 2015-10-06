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
import com.projeto.ong.entity.Usuario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

public class UsuarioModel extends BindableModel {

    private Usuario usuarioSelecionado;
    private Usuario usuarioSelecionadoBackup;
    private List<Usuario> usuarioList;
    private NavigableMap<Long, Usuario> usuarioNavigableMap;

    /**
     * Construtor da classe
     */
    public UsuarioModel() {
        usuarioSelecionado = new Usuario();
        usuarioList = new ArrayList();
        usuarioNavigableMap = new TreeMap();
    }

    /**
     *
     * @return
     */
    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuarioSelecionado(Usuario usuario) {
        this.usuarioSelecionado = usuario;
        firePropertyChange("usuarioSelecionado", null, usuario);
    }

    /**
     *
     * @return
     */
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    /**
     *
     * @param produtos
     */
    public void setUsuarioList(List<Usuario> usuarios) {
        this.usuarioList = new ArrayList();
        this.usuarioList.addAll(usuarios);
        firePropertyChange("usuarioList", null, Collections.unmodifiableList(usuarios));
    }

   


    /**
     *
     * @param usuarios
     */
    public void setUsuarioMap(List<Usuario> usuarios) {
        usuarioNavigableMap = new TreeMap();
        usuarios.forEach(usuario -> {
            this.usuarioNavigableMap.put(usuario.getId(), usuario);
        });
        firePropertyChange("usuarioNavigableMap", null, Collections.unmodifiableNavigableMap(usuarioNavigableMap));
    }

    /**
     *
     * @param usuario
     */
    public void removeUsuario(Usuario usuario) {
        this.usuarioList.remove(usuario);
        this.usuarioNavigableMap.remove(usuario.getId());
        Entry<Long, Usuario> entry = usuarioNavigableMap.lowerEntry(usuario.getId());
        if (entry == null) {
            entry = usuarioNavigableMap.higherEntry(usuario.getId());
            if (entry == null) {
                setUsuarioSelecionado(new Usuario());
            } else {
                setUsuarioSelecionado(entry.getValue());
            }
        } else {
            setUsuarioSelecionado(entry.getValue());
        }
        firePropertyChange("usuarioList", null, Collections.unmodifiableList(usuarioList));
        firePropertyChange("usuarioNavigableMap", null, Collections.unmodifiableNavigableMap(usuarioNavigableMap));
    }

    /**
     *
     * @param usuario
     */
    public void addUsuario(Usuario usuario) {
        this.usuarioList.add(usuario);
        this.usuarioNavigableMap.put(usuario.getId(), usuario);
        setUsuarioSelecionado(usuario);
        firePropertyChange("usuarioList", null, Collections.unmodifiableList(usuarioList));
        firePropertyChange("usuarioNavigableMap", null, Collections.unmodifiableNavigableMap(usuarioNavigableMap));
    }

    /**
     * Efetua a navegação até o primeiro elemento da coleção
     */
    public void navigateToFirstUsuario() {
        if (usuarioNavigableMap != null && !usuarioNavigableMap.isEmpty()) {
            Entry<Long, Usuario> entry = usuarioNavigableMap.firstEntry();
            if (entry != null) {
                setUsuarioSelecionado(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação na coleção até o elemento anterior ao atual
     */
    public void navigateToPreviousUsuario() {
        if (usuarioNavigableMap != null && !usuarioNavigableMap.isEmpty()) {
            Entry<Long, Usuario> entry = usuarioNavigableMap.lowerEntry(usuarioSelecionado.getId());
            if (entry != null) {
                setUsuarioSelecionado(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação na coleção até o elemento posterior ao atual
     */
    public void navigateToNextUsuario() {
        if (usuarioNavigableMap != null && !usuarioNavigableMap.isEmpty()) {
            Entry<Long, Usuario> entry = usuarioNavigableMap.higherEntry(usuarioSelecionado.getId());
            if (entry != null) {
                setUsuarioSelecionado(entry.getValue());
            }
        }
    }

    /**
     * Efetua a navegação até o último elemento da coleção
     */
    public void navigateToLastUsuario() {
        if (usuarioNavigableMap != null && !usuarioNavigableMap.isEmpty()) {
            Entry<Long, Usuario> entry = usuarioNavigableMap.lastEntry();
            if (entry != null) {
                setUsuarioSelecionado(entry.getValue());
            }
        }
    }

    /**
     *
     * @return
     */
    public Usuario getUsuarioSelecionadoBackup() {
        return usuarioSelecionadoBackup;
    }

    /**
     *
     * @param usuarioSelecionadoBackup
     */
    public void setUsuarioSelecionadoBackup(Usuario usuarioSelecionadoBackup) {
        if (usuarioSelecionadoBackup == null) {
            this.usuarioSelecionadoBackup = null;
        } else {
            this.usuarioSelecionadoBackup = usuarioSelecionadoBackup;
        }
    }

    /**
     *
     * @return
     */
    public NavigableMap<Long, Usuario> getUsuarioNavigableMap() {
        return usuarioNavigableMap;
    }

    /**
     *
     * @param usuarioNavigableMap
     */
    public void setUsuarioNavigableMap(NavigableMap<Long, Usuario> usuarioNavigableMap) {
        this.usuarioNavigableMap = usuarioNavigableMap;
    }

}
