package com.example.conf_web_service.models.auth;

import com.example.conf_web_service.models.auth.Roles;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class SelectRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Roles name;

    public SelectRole() {

    }

    public SelectRole(Roles name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Roles getName() {
        return name;
    }

    public void setName(Roles name) {
        this.name = name;
    }
}
