package com.farma.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controlador que maneja las operaciones relacionadas con el inicio de sesión y login
 * el @Controller indica que es una clase  Controller relacionada con el login aquel que gestiona operaciones  del login .
 */
@Controller
public class LoginController {

    /**
     * Método que maneja las solicitudes GET para la página de inicio de sesión.
     *
     * @return La cadena que representa la vista o el html "login".
     */
    @RequestMapping("/")
    public String login() {
        return "login";
    }
}
