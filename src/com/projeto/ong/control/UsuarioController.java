/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ong.control;

import com.projeto.ong.dao.UsuarioDAO;
import com.projeto.ong.entity.Usuario;
import com.projeto.ong.exception.BusinessException;
import com.projeto.ong.model.UsuarioModel;
import java.util.List;


public class UsuarioController implements IController {

    private UsuarioDAO usuarioDAO;
    private final UsuarioModel model;

    /**
     *
     * @param model
     */
    public UsuarioController(UsuarioModel model) {
        this.model = model;
    }


    /**
     * Efetua carga a partir dos registros da tabela produto
     */
    public void carregarProdutos() {
        usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.findAll();
        model.setProdutoList(usuarios);
        model.setProdutoMap(usuarios);
    }


    /**
     *
     * @param produto
     * @throws BusinessException
     */
    public void remove(Usuario usuario) throws BusinessException {
        usuarioDAO = new UsuarioDAO();
        usuarioDAO.remove(usuario);
        model.removeUsuario(usuario);
    }

    /**
     *
     * @param usuario
     * @throws BusinessException
     */
    public void save(Usuario usuario) throws BusinessException {
        usuarioDAO = new UsuarioDAO();
        usuario = usuarioDAO.save(usuario);
        model.addUsuario(usuario);
    }

    /**
     * Efetua a navegação até o primeiro elemento da coleção
     */
    public void navigateToFirstUsuario() {
        model.navigateToFirstUsuario();
    }

    /**
     * Efetua a navegação na coleção até o elemento anterior ao atual
     */
    public void navigateToPreviousUsuario() {
        model.navigateToPreviousUsuario();
    }

    /**
     * Efetua a navegação na coleção até o elemento posterior ao atual
     */
    public void navigateToNextUsuario() {
        model.navigateToNextUsuario();
    }

    /**
     * Efetua a navegação até o último elemento da coleção
     */
    public void navigateToLastUsuario() {
        model.navigateToLastUsuario();
    }

}
