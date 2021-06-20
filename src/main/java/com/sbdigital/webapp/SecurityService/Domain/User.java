package com.sbdigital.webapp.SecurityService.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max=40)
    private String name;

    @NotBlank
    @Size(max=15)
    private String username;

    @NotBlank
    @Size(max=40)
    @Email
    private String email;

    @NotBlank
    @Size(max=50)
    private String password;

    @OneToOne(cascade = {CascadeType.ALL})
    private Role role;

    public User(long id, @NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username, @NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 50) String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
