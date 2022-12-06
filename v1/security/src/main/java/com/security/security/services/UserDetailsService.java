package com.security.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.security.models.UsuarioModel;
import com.security.security.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UsuarioRepository ur;

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
       UsuarioModel usuario = ur.findBynome(nome).orElseThrow(() -> new UsernameNotFoundException("usuario" + nome + "nao encontrado"));
        return usuario;
    }
    
}
