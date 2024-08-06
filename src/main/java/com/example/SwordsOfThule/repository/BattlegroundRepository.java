package com.example.SwordsOfThule.repository;

import com.example.SwordsOfThule.entity.Battleground;
import com.example.SwordsOfThule.entity.BattlegroundType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BattlegroundRepository extends JpaRepository<Battleground, Long> {
    List<Battleground> findByType (BattlegroundType type);
    Optional<Battleground> findByName (String name);
    void deleteByName(String name);
}
