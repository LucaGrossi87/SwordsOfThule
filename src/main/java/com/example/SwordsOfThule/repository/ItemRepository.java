package com.example.SwordsOfThule.repository;

import com.example.SwordsOfThule.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
