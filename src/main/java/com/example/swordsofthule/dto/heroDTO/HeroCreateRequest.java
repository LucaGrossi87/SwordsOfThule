package com.example.swordsofthule.dto.heroDTO;

import com.example.swordsofthule.entity.HeroClass;
import com.example.swordsofthule.entity.HeroRace;
import com.example.swordsofthule.entity.Item;
import lombok.Data;

import java.util.List;

@Data
public class HeroCreateRequest {
    private String name;
    private int level;
    private int attack;
    private int defence;
    private int hitPoints;
    private HeroRace race;
    private HeroClass type;
    private int xp;
    private List<Item> itemList;
    private final String method = "create";
}
