package com.example.conf_web_service.repositories;

import java.util.Optional;

import com.example.conf_web_service.models.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existByUsername(String username);

    Boolean existByEmail(String email);
}
