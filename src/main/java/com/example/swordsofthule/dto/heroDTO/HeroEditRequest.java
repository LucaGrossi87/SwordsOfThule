package com.example.swordsofthule.dto.heroDTO;

import com.example.swordsofthule.entity.HeroClass;
import com.example.swordsofthule.entity.HeroRace;
import com.example.swordsofthule.entity.Item;
import com.example.swordsofthule.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class HeroEditRequest {
    private String name;
    private int level;
    private int attack;
    private int defence;
    private int hitPointsMax;
    private int hitPoints;
    private HeroRace race;
    private HeroClass type;
    private int xp;
    private int goldShards;
    private int perkPoints;
    private List<Item> itemList;
    private User user;
    private final String method = "edit";
}
