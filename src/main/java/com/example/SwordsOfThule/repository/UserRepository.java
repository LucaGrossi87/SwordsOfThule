package com.example.SwordsOfThule.repository;

import com.example.SwordsOfThule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
