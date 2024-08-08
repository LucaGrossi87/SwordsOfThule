package com.example.swordsofthule.dto.heroDTO;

import lombok.Data;

@Data
public class HeroDeleteResponse {
    private Long id;
    private String message;
    private final String method = "delete";
}
