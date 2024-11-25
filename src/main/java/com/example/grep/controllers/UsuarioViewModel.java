package com.example.grep.controllers;


import com.example.grep.models.Usuarios;
import com.example.grep.services.UsuariosService;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.List;
public class UsuarioViewModel {

//    @WireVariable
    @WireVariable
    private UsuariosService usuarioService;
    private List<Usuarios> usuarios;


    public List<Usuarios> getUsuarios() {
        if (usuarios == null) {
            usuarios = usuarioService.getAllUsuarios();
        }
        return usuarios;
    }

//    @Command
//    @NotifyChange("usuarios")
    public void agregarUsuario(String nombre) {
        Usuarios usuario = new Usuarios();
        usuarioService.saveUsuario(usuario);
    }
}
