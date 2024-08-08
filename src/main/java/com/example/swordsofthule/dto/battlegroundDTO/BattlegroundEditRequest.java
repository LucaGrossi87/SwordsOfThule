package com.example.swordsofthule.dto.battlegroundDTO;

import com.example.swordsofthule.entity.BattlegroundType;
import lombok.Data;

@Data
public class BattlegroundEditRequest {
    private String name;
    private BattlegroundType type;
    private final String method = "edit";
}
