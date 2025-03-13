package com.web.tornese.SpringWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.tornese.SpringWeb.servico.CookieService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {

        model.addAttribute("nome",CookieService.GetCookie(request, "nomeUsuario"));
        return "home/index";
    }
}
