package com.example.swordsofthule.dto.battlegroundDTO;

import lombok.Data;

@Data
public class BattlegroundDeleteResponse {
    private Long id;
    private String message;
    private final String method = "delete";
}
