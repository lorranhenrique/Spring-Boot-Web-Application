package com.web.tornese.SpringWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class AdminitradoresController {
    @GetMapping("/administradores")
    public String index(Model model) {
        return "administradores/index";
    }
}
