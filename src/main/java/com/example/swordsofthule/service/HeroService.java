package com.example.swordsofthule.service;

import com.example.swordsofthule.entity.Hero;
import com.example.swordsofthule.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public List<Hero> findAll (){
        return heroRepository.findAll();
    }

    public Optional<Hero> findById(Long id){
        return heroRepository.findById(id);
    }

    public Hero save (Hero hero){
        return heroRepository.save(hero);
    }

    public void deleteById (Long id) {
        heroRepository.deleteById(id);
    }
}
