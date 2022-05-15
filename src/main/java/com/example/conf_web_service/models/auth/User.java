package com.example.conf_web_service.models.auth;

import com.example.conf_web_service.models.auth.SelectRole;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 45)
    private Long id;

    @Column(name = "email", nullable = false, unique = true, length = 45)
    @NotBlank
    @Size(max = 20)
    private String email;

    @Column(name = "password", nullable = false, length = 64)
    @NotBlank
    @Size(max = 100)
    private String password;

    @Column(name = "username", nullable = false, length = 20)
    @NotBlank
    @Size(max = 20)
    private String username;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<SelectRole> roles = new HashSet<>();

    public User(){
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }
    public Set<SelectRole> getRoles() {
        return roles;
    }
    public void setRoles(Set<SelectRole> roles) {
        this.roles = roles;
    }
}
