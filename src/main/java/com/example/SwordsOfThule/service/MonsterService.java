package com.example.SwordsOfThule.service;

import com.example.SwordsOfThule.entity.Hero;
import com.example.SwordsOfThule.entity.Monster;
import com.example.SwordsOfThule.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    public List<Monster> findAll (){
        return monsterRepository.findAll();
    }

    public Optional<Monster> findById(Long id){
        return monsterRepository.findById(id);
    }

    public Monster save (Monster monster){
        return monsterRepository.save(monster);
    }

    public void deleteById (Long id) {
        monsterRepository.deleteById(id);
    }
}
