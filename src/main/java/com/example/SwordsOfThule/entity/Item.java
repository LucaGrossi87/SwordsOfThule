package com.example.SwordsOfThule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "items")
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Campo obbligatorio")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Campo obbligatorio")
    @Column(nullable = false)
    private ItemType type;

    @NotNull(message = "Campo obbligatorio")
    @Column(nullable = false)
    private int attack;

    @NotNull(message = "Campo obbligatorio")
    @Column(nullable = false)
    private int defence;
}
