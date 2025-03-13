package com.web.tornese.SpringWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.tornese.SpringWeb.models.Administrador;
import com.web.tornese.SpringWeb.repositorio.AdministradoresRepo;
import com.web.tornese.SpringWeb.servico.CookieService;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private AdministradoresRepo repo;
    @GetMapping("/login")
    public String index() {
        return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, Administrador admParam, String lembrar, HttpServletResponse response) {
        Administrador adm = this.repo.login(admParam.getEmail(), admParam.getSenha());

        if(adm != null){
            int tempoLogado = 60*60;
            if(lembrar != null){
                tempoLogado = 60*60*24*365;
            }
            CookieService.SetCookie(response,"usuarioId", String.valueOf(adm.getId()),tempoLogado);
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login/index";
    }

    @GetMapping("/sair")
    public String logar(HttpServletResponse response) {
        
        CookieService.SetCookie(response,"usuarioId", "",0);
        return "redirect:/login";
    }
}
