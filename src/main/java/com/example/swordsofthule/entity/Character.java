package com.example.swordsofthule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
@AllArgsConstructor
public abstract class Character {
    @NotBlank(message = "Campo obbligatorio")
    @Column(nullable = false)
    private String name;

    @Min(value=1, message = "Il livello deve essere almeno 1")
    @Column(nullable = false)
    private int level;

    @NotNull(message = "Campo obbligatorio")
    @Column(nullable = false)
    private int attack;

    @NotNull(message = "Campo obbligatorio")
    @Column(nullable = false)
    private int defence;

    @Min(value = 0, message = "I punti ferita non possono essere meno di 0")
    @Column(nullable = false)
    private int hitPointsMax;

    @Min(value = 0, message = "I punti ferita non possono essere meno di 0")
    @Column(nullable = false)
    private int hitPoints;
}
