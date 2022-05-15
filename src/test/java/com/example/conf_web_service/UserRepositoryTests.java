package com.example.conf_web_service;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.conf_web_service.models.auth.User;
import com.example.conf_web_service.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

    @DataJpaTest
    @AutoConfigureTestDatabase(replace = Replace.NONE)
    @Rollback(false)
    @SpringBootTest
    public class UserRepositoryTests {

        @Autowired
        private TestEntityManager entityManager;

        @Autowired
        private UserRepository repo;

        @Test
        public void testCreateUser() {
            User user = new User();
            user.setEmail("johndoe@gmail.com");
            user.setPassword("qwerty");
            user.setUsername("John");

            User savedUser = repo.save(user);

            User existUser = entityManager.find(User.class, savedUser.getId());

            assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
        }
    }

