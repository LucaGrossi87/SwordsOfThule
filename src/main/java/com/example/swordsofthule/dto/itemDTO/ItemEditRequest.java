package com.example.swordsofthule.dto.itemDTO;

import com.example.swordsofthule.entity.ItemType;
import lombok.Data;

@Data
public class ItemEditRequest {
    private String name;
    private ItemType type;
    private int attack;
    private int defence;
    private int price;
    private final String method = "edit";
}
