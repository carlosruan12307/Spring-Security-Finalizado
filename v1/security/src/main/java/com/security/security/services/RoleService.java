package com.security.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.security.security.enums.RoleEnum;
import com.security.security.models.RoleModel;
import com.security.security.repository.RoleRepository;
import com.security.security.response.RoleResponse;

import lombok.Data;

@Service
@Data
public class RoleService {
    @Autowired
    private RoleRepository rr;
    @Autowired
    private RoleResponse r;

    public ResponseEntity<RoleResponse> cadastrarRole(RoleModel role){
      for(RoleEnum ro: RoleEnum.values()){
        if(ro == role.getNome()){
            r.setMensagem("role " + ro + " cadastrada com sucesso");
            rr.save(role);
            return new ResponseEntity<RoleResponse>(r, HttpStatus.OK);
        }

      }
      r.setMensagem("role nao existente no modelo de roles");
return new ResponseEntity<RoleResponse>(r, HttpStatus.BAD_REQUEST);

    }
    
}
