package com.example.swordsofthule.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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

    @NotNull(message = "Campo obbligatorio")
    @Email(message = "Inserire email valida")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Campo obbligatorio")
    @Column(nullable = false)
    private String password;

    @NotNull(message = "Campo obbligatorio")
    @Column(nullable = false)
    private int goldShards;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Hero> heroList;

    public User (String firstName,String lastName, String userName, String password, String email, int goldShards, List<Hero> heroList){
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.email=email;
        this.password=password;
        this.goldShards=goldShards;
        this.heroList=heroList;
    }
}
