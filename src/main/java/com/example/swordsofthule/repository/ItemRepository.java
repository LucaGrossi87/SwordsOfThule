package com.example.swordsofthule.repository;

import com.example.swordsofthule.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
