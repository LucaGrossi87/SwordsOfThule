package com.example.swordsofthule.dto.battlegroundDTO;

import com.example.swordsofthule.entity.BattlegroundType;
import lombok.Data;

@Data
public class BattlegroundResponse {
    private Long id;
    private String name;
    private BattlegroundType type;
}
