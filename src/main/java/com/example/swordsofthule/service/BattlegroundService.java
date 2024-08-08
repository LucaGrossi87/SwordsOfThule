package com.example.swordsofthule.service;

import com.example.swordsofthule.entity.Battleground;
import com.example.swordsofthule.entity.BattlegroundType;
import com.example.swordsofthule.repository.BattlegroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BattlegroundService {

    @Autowired
    private BattlegroundRepository bgRepository;

    public List<Battleground> findAll(){
        return bgRepository.findAll();
    }

    public Optional<Battleground> findById(Long id){
        return bgRepository.findById(id);
    }

    public List<Battleground> findByType(BattlegroundType type){
        return bgRepository.findByType(type);
    }

    public Optional<Battleground> findByName(String name){
        return bgRepository.findByName(name);
    }

    public Battleground save (Battleground battleground){
        return bgRepository.save(battleground);
    }

    public void deleteById (Long id){
        bgRepository.deleteById(id);
    }

    public void deleteByName (String name){
        bgRepository.deleteByName(name);
    }

}
