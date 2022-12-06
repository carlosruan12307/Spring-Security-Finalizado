package com.security.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.security.models.RoleModel;
import com.security.security.response.RoleResponse;
import com.security.security.services.RoleService;

import lombok.Data;

@RestController
@Data
public class RoleController {
    @Autowired
    private RoleService rs;

    @PostMapping("/cadastrarRole")
    public ResponseEntity<RoleResponse> cadastrarRole(@RequestBody RoleModel role){
        return rs.cadastrarRole(role);
    }
    
}
