package com.example.conf_web_service.controllers;

import com.example.conf_web_service.models.User;
import com.example.conf_web_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/users", produces = "application/json")

public class UserController {

    @Autowired
    private UserRepository personRepository;

    @GetMapping
    public ResponseEntity getUsers(){
        try {
            return ResponseEntity.ok("Server is online");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Oops! Something goes wrong :c");
        }
    }

    /*
    * This method creates a new User instance in the database and return it
    * when this method is called
     */
    @RequestMapping("create-person")
    public User createPerson() {
        return personRepository.save(new User());
    }
}
