package com.example.grep.controllers;


import com.example.grep.models.Usuarios;
import com.example.grep.services.UsuariosService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import java.util.List;

public class UsuarioViewModel {

    @WireVariable
    private UsuariosService usuarioService;

    private ListModelList<Usuarios> usuariosModel;
    private Usuarios nuevoUsuario = new Usuarios(); // Objeto para el nuevo usuario



    @Init
    public void init() {
        // Obtén el ApplicationContext manualmente
        ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(
                org.zkoss.zk.ui.Executions.getCurrent().getDesktop().getWebApp().getServletContext()
        );
        usuarioService = context.getBean(UsuariosService.class);

        // Inicializa la lista de usuarios
        List<Usuarios> usuariosList = usuarioService.getAllUsuarios();
        usuariosModel = new ListModelList<>(usuariosList);
    }

    public ListModelList<Usuarios> getUsuariosModel() {
        return usuariosModel;
    }
    public Usuarios getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(Usuarios nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }

    @Command
    @NotifyChange({"usuariosModel", "nuevoUsuario"})
    public void guardarUsuario() {
        if (usuarioService == null) {
            // Obtén el ApplicationContext manualmente si aún no está inicializado
            ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(
                    org.zkoss.zk.ui.Executions.getCurrent().getDesktop().getWebApp().getServletContext()
            );
            usuarioService = context.getBean(UsuariosService.class);
        }

        if (nuevoUsuario != null) {
            nuevoUsuario.setNombreUsuario(nuevoUsuario.getNombreUsuario().replaceAll("\\s+", ""));
            nuevoUsuario.setIdUsuario(nuevoUsuario.getIdUsuario().trim());
            nuevoUsuario.setPassword(nuevoUsuario.getPassword().trim());
            // Guardar el usuario en la base de datos
            usuarioService.saveUsuario(nuevoUsuario);

            // Actualizar la lista de usuarios
            usuariosModel.add(nuevoUsuario);

            // Limpiar el formulario
            nuevoUsuario = new Usuarios();

            // Mostrar una notificación
            Clients.showNotification("Usuario creado correctamente.");
        }
    }

}