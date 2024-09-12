package com.example.swordsofthule.dto.monsterDTO;

import com.example.swordsofthule.entity.MonsterType;
import lombok.Data;

@Data
public class MonsterEditRequest {
    private String name;
    private int level;
    private int attack;
    private int defence;
    private int hitPointsMax;
    private int hitPoints;
    private MonsterType type;
    private final String method = "Edit";
}
