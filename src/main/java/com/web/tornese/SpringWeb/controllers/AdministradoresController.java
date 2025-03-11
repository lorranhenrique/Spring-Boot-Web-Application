package com.web.tornese.SpringWeb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.web.tornese.SpringWeb.models.Administrador;
import com.web.tornese.SpringWeb.repositorio.AdministradoresRepo;

import org.springframework.ui.Model;

@Controller
public class AdministradoresController {

    @Autowired
    private AdministradoresRepo repo;
    @GetMapping("/administradores")
    public String index(Model model) {
        
        List<Administrador> administradores = (List<Administrador>)repo.findAll();
        model.addAttribute("administradores", administradores);
        return "administradores/index";
    }

    @GetMapping("/administradores/novo")
    public String novo() {
        return "administradores/novo";
    }

    @PostMapping("/administradores/criar")
        public String criar(Administrador administrador) {
        repo.save(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}/excluir")
        public String delete(@PathVariable int id) {
        repo.deleteById(id);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}")
        public String busca(@PathVariable int id, Model model) {
        Optional<Administrador> admin = repo.findById(id);
        try{
            model.addAttribute("administrador", admin.get());
        }
        catch(Exception err){ return "redirect:/administradores"; }
        
        return "/administradores/editar";
    }

    @PostMapping("/administradores/{id}/atualizar")
        public String atualizar(@PathVariable int id, Administrador administrador) {

            if(!repo.existsById(id)) {
                return "redirect:/administradores";
            }
            Administrador existente = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Administrador não encontrado"));
            existente.setNome(administrador.getNome());
            existente.setEmail(administrador.getEmail());
            existente.setSenha(administrador.getSenha());
            existente.setObservacao(administrador.getObservacao());

            repo.save(existente);

            return "redirect:/administradores";
        }

}
