package com.example.swordsofthule.controller;

import com.example.swordsofthule.dto.itemDTO.ItemCreateRequest;
import com.example.swordsofthule.dto.itemDTO.ItemDeleteResponse;
import com.example.swordsofthule.dto.itemDTO.ItemEditRequest;
import com.example.swordsofthule.dto.itemDTO.ItemResponse;
import com.example.swordsofthule.entity.Item;
import com.example.swordsofthule.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    public List<ItemResponse> getAllItems() {
        return itemService.findAll().stream().
                map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping ("/{id}")
    public ItemResponse getItemById (@PathVariable Long id) {
        Optional<Item> item = itemService.findById(id);
        return item.map(this::convertToDTO).orElse(null);
    }

    @PostMapping
    public ItemResponse createItem (@RequestBody ItemCreateRequest itemCreateReq){
        Item item = convertToEntity(itemCreateReq);
        Item savedItem = itemService.save(item);
        return convertToDTO(savedItem);
    }

    @PutMapping ("/{id}")
    public ItemResponse editItem (@RequestBody ItemEditRequest itemEditReq, @PathVariable Long id){
        Item item=convertToEntity(itemEditReq);
        item.setId(id);
        Item updatedItem = itemService.save(item);
        return convertToDTO(updatedItem);
    }

    @DeleteMapping ("/{id}")
    public ItemDeleteResponse deleteItem (@PathVariable Long id){
        itemService.deleteById(id);
        ItemDeleteResponse response = new ItemDeleteResponse();
        response.setId(id);
        response.setMessage("Item eliminato");
        return response;
    }

    private ItemResponse convertToDTO (Item item){
        ItemResponse dto = new ItemResponse();
        dto.setId(item.getId());
        dto.setType(item.getType());
        dto.setName(item.getName());
        dto.setAttack(item.getAttack());
        dto.setDefence(item.getDefence());
        dto.setPrice(item.getPrice());
        return dto;
    }

    private Item convertToEntity (ItemCreateRequest dto){
        return new Item(dto.getName(),
                dto.getType(),
                dto.getAttack(),
                dto.getDefence(),
                dto.getPrice());
    }

    private Item convertToEntity (ItemEditRequest dto){
        return new Item(dto.getName(),
                dto.getType(),
                dto.getAttack(),
                dto.getDefence(),
                dto.getPrice());
    }
}
