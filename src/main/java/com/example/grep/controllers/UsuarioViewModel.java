package com.example.grep.controllers;


import com.example.grep.models.Usuarios;
import com.example.grep.services.UsuariosService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import java.util.List;

public class UsuarioViewModel extends SelectorComposer<Component> {

    @WireVariable
    private UsuariosService usuarioService; // Inyección del servicio

    @Wire
    private Listbox usuarios; // Vincula el listbox desde el ZUL

    private ListModelList<Usuarios> usuariosModel; // Modelo para el listbox

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        // Inicializa la lista de usuarios
        List<Usuarios> usuariosList = usuarioService.getAllUsuarios();
        usuariosModel = new ListModelList<>(usuariosList);
        usuarios.setModel(usuariosModel);
    }

    public void agregarUsuario(String nombre) {
        Usuarios usuario = new Usuarios();
        usuario.setNombreUsuario(nombre);
        usuarioService.saveUsuario(usuario);

        // Actualiza la lista después de agregar
        List<Usuarios> updatedList = usuarioService.getAllUsuarios();
        usuariosModel.clear();
        usuariosModel.addAll(updatedList);
    }
}