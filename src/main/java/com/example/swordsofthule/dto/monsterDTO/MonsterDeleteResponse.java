package com.example.swordsofthule.dto.monsterDTO;

import lombok.Data;

@Data
public class MonsterDeleteResponse {
    private long id;
    private String message;
    private final String method = "delete";
}
