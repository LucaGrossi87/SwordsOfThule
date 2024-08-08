package com.example.swordsofthule.repository;

import com.example.swordsofthule.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}
