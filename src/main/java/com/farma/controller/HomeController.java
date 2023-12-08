package com.farma.controller;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * @author Avalon
 */
@Slf4j
@Controller
public class HomeController {
    

      
    /**
     * Método index().
     * Método para retornar la vista principal.
     * @return El fragmento principal llamado general.html.
     */

    @GetMapping("/")
    public String index(Model model) {
		log.info("Estas en el home");
    	return"home";
    }

}
