package com.example.swordsofthule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "battlegrounds")
@NoArgsConstructor
public class Battleground {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Campo obbligatorio")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Campo obbligatorio")
    @Column(nullable = false)
    private BattlegroundType type;

    public Battleground(String name, BattlegroundType type){
        this.name=name;
        this.type=type;
    }
}
