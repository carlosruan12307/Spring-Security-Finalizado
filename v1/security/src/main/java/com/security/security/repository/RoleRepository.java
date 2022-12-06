package com.security.security.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.security.security.enums.RoleEnum;
import com.security.security.models.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel,UUID> {

   Optional<RoleModel> findBynome(RoleEnum nome);
}
