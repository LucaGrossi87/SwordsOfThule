package com.example.swordsofthule.dto.monsterDTO;

import com.example.swordsofthule.entity.MonsterType;
import lombok.Data;

@Data
public class MonsterResponse {
    private long id;
    private long name;
    private int level;
    private int attack;
    private int defence;
    private int hitPoints;
    private MonsterType type;
}
