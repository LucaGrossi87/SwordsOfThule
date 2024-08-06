package com.example.SwordsOfThule.repository;

import com.example.SwordsOfThule.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}
