package com.security.security.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.security.models.UsuarioModel;

import lombok.Data;

@Repository

public interface UsuarioRepository extends JpaRepository<UsuarioModel,UUID> {

    Optional<UsuarioModel> findBynome(String nome);
    
}
