package com.example.swordsofthule.dto.itemDTO;

import lombok.Data;

@Data
public class ItemDeleteResponse {
    private Long id;
    private String message;
    private final String method = "delete";
}
