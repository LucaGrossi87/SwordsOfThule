package com.example.SwordsOfThule.service;

import com.example.SwordsOfThule.entity.Hero;
import com.example.SwordsOfThule.entity.Item;
import com.example.SwordsOfThule.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll (){
        return itemRepository.findAll();
    }

    public Optional<Item> findById(Long id){
        return itemRepository.findById(id);
    }

    public Item save (Item item){
        return itemRepository.save(item);
    }

    public void deleteById (Long id) {
        itemRepository.deleteById(id);
    }
}
