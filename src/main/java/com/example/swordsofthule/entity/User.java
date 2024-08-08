package com.example.swordsofthule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Campo obbligatorio")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Campo obbligatorio")
    @Column(nullable = false)
    private String lastName;

    @NotBlank(message = "Campo obbligatorio")
    @Column(nullable = false)
    private String userName;

    @Email(message = "Campo obbligatorio")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Campo obbligatorio")
    @Column(nullable = false)
    private String password;

    @NotNull(message = "Campo obbligatorio")
    @Column(nullable = false)
    private int goldShards;

    @OneToMany(mappedBy = "user")
    @Column(nullable = false)
    private List<Hero> heroList;

}
