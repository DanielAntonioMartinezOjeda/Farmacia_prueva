/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farma.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * @author Avalon
 */
@Slf4j
@Controller
public class RegisterController {

    @GetMapping("/register")
    public String register(Model model) {
        log.info("estas en el registro  usuario controller controller");
        return "register";
    }

}
