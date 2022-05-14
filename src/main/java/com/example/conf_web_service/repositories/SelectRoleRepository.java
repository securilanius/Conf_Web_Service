package com.example.conf_web_service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.conf_web_service.models.Roles;
import com.example.conf_web_service.models.SelectRole;

@Repository
public interface SelectRoleRepository extends JpaRepository<SelectRole, Long> {
    Optional<SelectRole> findByName(Roles name);
}
