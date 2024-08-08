package com.example.swordsofthule.service;

import com.example.swordsofthule.entity.Monster;
import com.example.swordsofthule.repository.MonsterRepository;
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
