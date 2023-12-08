/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farma.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;


/**
 *
 * @author Avalon
 */
@Slf4j
@Controller
public class LoginController {

    @GetMapping("/login")
    public String index(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model, Principal principal, RedirectAttributes attribute) {
        if (error!= null){
                model.addAttribute("error", "Usuario y/o contraseña incorrectos");
        }

        if (principal!= null){
           attribute.addFlashAttribute("warning", "ATENCION: Ud ya ha iniciado sesion previamente");
            return "redirect:/";
        }
        if (logout!= null){
            model.addAttribute("success", "ATENCION: Ha finalizado session con exito");
        }


        return "login";
    }

}
