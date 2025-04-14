package com.pfe.challenge.Model;
import jakarta.persistence.*;
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;
    private String role; // ex: "ADMIN", "USER"

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return  password;
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
// Getters and setters
}
