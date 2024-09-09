package com.example.swordsofthule.repository;

import com.example.swordsofthule.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Long> {

    @Query("SELECT h FROM Hero h LEFT JOIN FETCH h.user")
    List<Hero> findAllWithUser();
}
