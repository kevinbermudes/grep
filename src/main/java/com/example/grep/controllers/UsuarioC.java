package com.example.grep.controllers;

import com.example.grep.models.Usuarios;
import com.example.grep.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.zkoss.zk.ui.Component;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import org.zkoss.zk.ui.event.Event;
import java.util.List;

@Controller
public class UsuarioC  extends SelectorComposer<Component> {

    @Autowired
    private UsuariosService usuarioService;

    @Wire
    private List<Usuarios> usuarios;

    @Wire
    private Textbox idUsuario;
    @Wire
    private Textbox nombreUsuario;
    @Wire
    private Textbox password;
    @Wire
    private Button btn;

    // Endpoint para listar usuarios
    @GetMapping("/usuarios")
    public ModelAndView listarUsuarios() {
        usuarios = usuarioService.getAllUsuarios();
        ModelAndView modelAndView = new ModelAndView("usuarios"); // Nombre del archivo ZUL
        modelAndView.addObject("usuariosList", new ListModelList<>(usuarios));
        return modelAndView;
    }




    @Listen("onClick = #btnCrear")
    public void guardar(Event event){
         String idUsr= idUsuario.getValue();
        String nombreUsr= nombreUsuario.getValue();
        String passwordUsr= password.getValue();

        Usuarios nuevoUsr= new Usuarios();
        nuevoUsr.setIdUsuario(idUsr.trim()); // Aseguramos que no tenga espacios en blanco
        nuevoUsr.setNombreUsuario(nombreUsr.trim());
        nuevoUsr.setPassword(passwordUsr.trim());

        usuarioService.saveUsuario(nuevoUsr);

        usuarios.add(nuevoUsr);
        usuarios = new ListModelList<>(usuarios);

        // Redirigir a la lista de usuarios
        //return "redirect:/usuarios";
    }



}
