package com.security.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.security.models.UsuarioModel;
import com.security.security.response.UsuarioResponse;
import com.security.security.services.UsuarioService;

import lombok.Data;

@RestController
@Data
public class UsuarioController {
    @Autowired
    private UsuarioService us;
    @GetMapping("/")
    public String inicio(){
        return "bem vindo a api de usuario";
    }
    @PostMapping("/cadastrarUsuario")
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody UsuarioModel usuario){
        return us.cadastrarUsuario(usuario);
    }

    @PostMapping("/cadastrarAdmin")
    public ResponseEntity<UsuarioResponse> cadastrarAdmin(@RequestBody UsuarioModel usuario){
        return us.cadastrarAdmin(usuario);
    }
}
