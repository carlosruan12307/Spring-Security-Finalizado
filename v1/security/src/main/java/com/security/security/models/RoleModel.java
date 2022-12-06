package com.security.security.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;

import com.security.security.enums.RoleEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "role")
public class RoleModel implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idRole;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private RoleEnum nome;
    @ManyToMany(mappedBy = "roles")
    private List<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();
    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return this.nome.toString();
    }
    public RoleModel(@NotBlank RoleEnum nome) {
        this.nome = nome;
    }
    public RoleModel(){}

}
