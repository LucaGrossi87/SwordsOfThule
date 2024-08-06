package com.example.SwordsOfThule.repository;

import com.example.SwordsOfThule.entity.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<Monster, Long> {
}
