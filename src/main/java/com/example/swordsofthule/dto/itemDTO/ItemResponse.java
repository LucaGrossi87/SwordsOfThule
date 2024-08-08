package com.example.swordsofthule.dto.itemDTO;

import com.example.swordsofthule.entity.ItemType;
import lombok.Data;

@Data
public class ItemResponse {
    private Long id;
    private String name;
    private ItemType type;
    private int attack;
    private int defence;
}
