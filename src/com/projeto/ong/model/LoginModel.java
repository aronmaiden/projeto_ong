/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.model;

import com.projeto.ong.entity.Usuario;

/**
 *
 * @author aron.oliveira
 */
public class LoginModel extends BindableModel {

    private Usuario usuario;

    public LoginModel() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        Usuario oldValue = this.usuario;
        this.usuario = usuario;
        firePropertyChange("usuario", oldValue, usuario);
    }

}
