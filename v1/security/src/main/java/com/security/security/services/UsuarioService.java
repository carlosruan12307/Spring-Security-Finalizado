package com.security.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.security.controllers.UsuarioController;
import com.security.security.enums.RoleEnum;
import com.security.security.models.RoleModel;
import com.security.security.models.UsuarioModel;
import com.security.security.repository.RoleRepository;
import com.security.security.repository.UsuarioRepository;
import com.security.security.response.UsuarioResponse;

import lombok.Data;

@Service
@Data
public class UsuarioService {

    @Autowired
    private UsuarioResponse r;
    @Autowired
    private UsuarioRepository ur;
    @Autowired
    private RoleRepository rr;
 


    public ResponseEntity<UsuarioResponse> cadastrarUsuario(UsuarioModel usuario){
      
        if((rr.findBynome(RoleEnum.ROLE_USER)).isEmpty()){
            r.setMensagem("role User nao existe");
            return new ResponseEntity<UsuarioResponse>(r, HttpStatus.BAD_REQUEST);
        }else{
            r.setMensagem("usuario cadastrado com sucesso");
            RoleModel roleuser = rr.findBynome(RoleEnum.ROLE_USER).orElseThrow(() -> new UsernameNotFoundException("role user nao encontrada"));
            usuario.addRole(roleuser);
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getPassword()));
            ur.save(usuario);
            return new ResponseEntity<UsuarioResponse>(r, HttpStatus.OK);
        }
      
    }

    public ResponseEntity<UsuarioResponse> cadastrarAdmin(UsuarioModel usuario){
        if((rr.findBynome(RoleEnum.ROLE_ADMIN)).isEmpty()){
            r.setMensagem("Role Admin Nao existe");
            return new ResponseEntity<UsuarioResponse>(r, HttpStatus.BAD_REQUEST);
        }else{
            r.setMensagem("Admin cadastrado com sucesso");
            RoleModel roleuser = rr.findBynome(RoleEnum.ROLE_ADMIN).orElseThrow(() -> new UsernameNotFoundException("role user nao encontrada"));
            usuario.addRole(roleuser);
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getPassword()));
            ur.save(usuario);
            return new ResponseEntity<UsuarioResponse>(r, HttpStatus.OK);
        }
    }
    
}
