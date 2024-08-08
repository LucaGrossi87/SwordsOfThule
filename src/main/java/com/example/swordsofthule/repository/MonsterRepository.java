package com.example.swordsofthule.repository;

import com.example.swordsofthule.entity.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<Monster, Long> {
}
