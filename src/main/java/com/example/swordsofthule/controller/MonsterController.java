package com.example.swordsofthule.controller;

import com.example.swordsofthule.dto.monsterDTO.MonsterCreateRequest;
import com.example.swordsofthule.dto.monsterDTO.MonsterDeleteResponse;
import com.example.swordsofthule.dto.monsterDTO.MonsterEditRequest;
import com.example.swordsofthule.dto.monsterDTO.MonsterResponse;
import com.example.swordsofthule.entity.Monster;
import com.example.swordsofthule.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/monsters")
public class MonsterController {

    @Autowired
    MonsterService monsterService;

    @GetMapping
    public List<MonsterResponse> getAllMonsters() {
        return monsterService.findAll().stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MonsterResponse getMonsterById (@PathVariable Long id){
        Optional<Monster> monster = monsterService.findById(id);
        return monster.map(this::convertToDTO).orElse(null);
    }

    @PostMapping
    public MonsterResponse createMonster(@RequestBody MonsterCreateRequest monsterCreateReq){
        Monster monster = convertToEntity(monsterCreateReq);
        Monster savedMonster = monsterService.save(monster);
        return convertToDTO(savedMonster);
    }

    @PutMapping("/{id}")
    public MonsterResponse createMonster(@RequestBody MonsterEditRequest monsterEditReq, @PathVariable Long id){
        Monster monster = convertToEntity(monsterEditReq);
        monster.setId(id);
        Monster updatedMonster = monsterService.save(monster);
        return convertToDTO(updatedMonster);
    }

    @DeleteMapping("/{id}")
    public MonsterDeleteResponse deleteMonster (@PathVariable Long id){
        monsterService.deleteById(id);
        MonsterDeleteResponse response = new MonsterDeleteResponse();
        response.setId(id);
        response.setMessage("Monster eliminato");
        return response;
    }

    private MonsterResponse convertToDTO(Monster monster){
        MonsterResponse dto = new MonsterResponse();
        dto.setId(monster.getId());
        dto.setLevel(monster.getLevel());
        dto.setType(monster.getType());
        dto.setAttack(monster.getAttack());
        dto.setDefence(monster.getDefence());
        dto.setHitPointsMax(monster.getHitPointsMax());
        dto.setHitPoints(monster.getHitPoints());
        dto.setName(monster.getName());
        return dto;
    }

    private Monster convertToEntity(MonsterCreateRequest dto){
        return new Monster(
                dto.getName(),
                dto.getLevel(),
                dto.getAttack(),
                dto.getDefence(),
                dto.getHitPointsMax(),
                dto.getHitPoints(),
                dto.getType());
    }

    private Monster convertToEntity(MonsterEditRequest dto){
        return new Monster(
                dto.getName(),
                dto.getLevel(),
                dto.getAttack(),
                dto.getDefence(),
                dto.getHitPointsMax(),
                dto.getHitPoints(),
                dto.getType());
    }
}
