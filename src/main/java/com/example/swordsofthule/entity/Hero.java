package com.example.swordsofthule.entity;

import com.fasterxml.jackson.annotation.*;
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
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
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

    @Min(value = 0, message = "I punti perks devono essere almeno 0")
    @Column(nullable = false)
    private int perkPoints;

    @ManyToMany
    @Column(nullable = false)
    private List<Item> itemList;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id")
    private User user;

    public Hero (String name, int level, int attack, int defence, int hitPointsMax, int hitPoints, HeroRace race, HeroClass type, int xp, int perkPoints, int goldShards, List<Item> itemList, User user){
        super(name, level, attack, defence,hitPointsMax, hitPoints);
        this.race=race;
        this.type=type;
        this.xp=xp;
        this.goldShards=goldShards;
        this.perkPoints=perkPoints;
        this.itemList=itemList;
        this.user=user;
    }
}
