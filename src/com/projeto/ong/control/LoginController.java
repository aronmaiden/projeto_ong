/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.control;

import com.projeto.ong.dao.UsuarioDAO;
import com.projeto.ong.entity.Usuario;
import com.projeto.ong.exception.BusinessException;
import com.projeto.ong.model.LoginModel;
import com.projeto.ong.session.SessionManager;

/**
 *
 * @author aron.oliveira
 */
public class LoginController implements IController {
    private LoginModel model;
    
    public LoginController(LoginModel model) {
        this.model = model;
    }
    
    public void doLogin(Usuario usuario) throws BusinessException {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuarioLogado = dao.findByLoginSenha(usuario);
        if (usuarioLogado == null) {
            throw new BusinessException("Usuário e/ou senha inválidos!");
        }
        SessionManager.setUsuarioLogado(usuarioLogado);        
    }
}
