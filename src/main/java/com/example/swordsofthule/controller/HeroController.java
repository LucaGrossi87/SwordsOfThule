package com.example.swordsofthule.controller;

import com.example.swordsofthule.dto.heroDTO.HeroCreateRequest;
import com.example.swordsofthule.dto.heroDTO.HeroDeleteResponse;
import com.example.swordsofthule.dto.heroDTO.HeroEditRequest;
import com.example.swordsofthule.dto.heroDTO.HeroResponse;
import com.example.swordsofthule.entity.Hero;
import com.example.swordsofthule.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/heroes")
public class HeroController {

    @Autowired
    HeroService heroService;

    @GetMapping
    public List<HeroResponse> getAllHeroes() {
        return heroService.findAll().stream().
                map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping ("/{id}")
    public HeroResponse getHeroById (@PathVariable Long id){
        Optional<Hero> hero = heroService.findById(id);
        return hero.map(this::convertToDTO).orElse(null);
    }

    @PostMapping
    public HeroResponse createHero (@RequestBody HeroCreateRequest heroCreateReq){
        Hero hero = convertToEntity(heroCreateReq);
        Hero savedHero = heroService.save(hero);
        return convertToDTO(savedHero);
    }

    @PutMapping ("/{id}")
    public HeroResponse editHero (@PathVariable Long id, @RequestBody HeroEditRequest heroEditReq){
        Hero hero = convertToEntity(heroEditReq);
        hero.setId(id);
        Hero updatedHero = heroService.save(hero);
        return convertToDTO(updatedHero);
    }

    @DeleteMapping ("/{id}")
    public HeroDeleteResponse deleteHero (@PathVariable Long id){
        heroService.deleteById(id);
        HeroDeleteResponse response = new HeroDeleteResponse();
        response.setId(id);
        response.setMessage("Hero eliminato");
        return response;
    }

    private HeroResponse convertToDTO (Hero hero){
        HeroResponse dto = new HeroResponse();
        dto.setId(hero.getId());
        dto.setName(hero.getName());
        dto.setLevel(hero.getLevel());
        dto.setAttack(hero.getAttack());
        dto.setDefence(hero.getDefence());
        dto.setHitPoints(hero.getHitPoints());
        dto.setRace(hero.getRace());
        dto.setType(hero.getType());
        dto.setXp(hero.getXp());
        dto.setGoldShards(hero.getGoldShards());
        dto.setItemList(hero.getItemList());
        dto.setUser(hero.getUser());
        return dto;
    }

    private Hero convertToEntity (HeroCreateRequest dto){
        return new Hero(dto.getName(),
                dto.getLevel(),
                dto.getAttack(),
                dto.getDefence(),
                dto.getHitPoints(),
                dto.getRace(),
                dto.getType(),
                dto.getXp(),
                dto.getGoldShards(),
                dto.getItemList(),
                dto.getUser());
    }

    private Hero convertToEntity (HeroEditRequest dto){
        return new Hero(dto.getName(),
                dto.getLevel(),
                dto.getAttack(),
                dto.getDefence(),
                dto.getHitPoints(),
                dto.getRace(),
                dto.getType(),
                dto.getXp(),
                dto.getGoldShards(),
                dto.getItemList(),
                dto.getUser());
    }
}
