package com.example.swordsofthule.dto.battlegroundDTO;

import com.example.swordsofthule.entity.BattlegroundType;
import lombok.Data;

@Data
public class BattlegroundCreateRequest {
    private String name;
    private BattlegroundType type;
    private final String method = "create";
}
