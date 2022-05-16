package com.example.conf_web_service.models.auth;

import com.example.conf_web_service.models.auth.SelectRole;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {

    private Boolean enabled;
    private boolean active;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 40)
    private Long id;
    @Email(message = "Email is not correct")
    @Column(name = "email", nullable = false, unique = true, length = 40)
    @NotBlank(message = "Email cannot be empty")
    @Size(max = 20)
    private String email;

    @Column(name = "password", nullable = false, length = 40)
    @NotBlank(message = "Password cannot be empty")
    @Size(max = 100)
    private String password;
    @Column(name = "username", nullable = false, length = 40)
    @NotBlank(message = "username cannot be empty")
    @Size(max = 20)
    private String username;

    @Column(name = "verification_code", length = 64)
    private String verificationCode;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<SelectRole> roles = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_subscriptions",
            joinColumns = {@JoinColumn(name = "subscriber_id")},
            inverseJoinColumns = { @JoinColumn(name = "channel_id")}
            )
    private Set<User> subscriptions = new HashSet<>();

    /*@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Message> messages;*/
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
    public Set<User> getSubscriptions() {
        return subscriptions;
    }
    public void setSubscriptions(Set<User> subscriptions) {
        this.subscriptions = subscriptions;
    }
    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
    public boolean isActive() {
        return active;
    }
    @Override
    public boolean isEnabled() {
        return isActive();
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
