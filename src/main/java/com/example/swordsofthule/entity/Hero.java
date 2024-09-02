package com.example.swordsofthule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "heroes")
@Data
@NoArgsConstructor
public class Hero extends Character{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Campo obbligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HeroRace race;

    @NotNull(message = "Campo obbligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HeroClass type;

    @Min(value = 0, message = "Gli xp devono essere almeno 0")
    @Column(nullable = false)
    private int xp;

    @Min(value = 0, message = "I frammenti devono essere almeno 0")
    @Column(nullable = false)
    private int goldShards;

    @ManyToMany
    @Column(nullable = false)
    private List<Item> itemList;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    public Hero (String name, int level, int attack, int defence, int hitPoints, HeroRace race, HeroClass type, int xp, int goldShards, List<Item> itemList, User user){
        super(name, level, attack, defence, hitPoints);
        this.race=race;
        this.type=type;
        this.xp=xp;
        this.goldShards=goldShards;
        this.itemList=itemList;
        this.user=user;
    }
}
