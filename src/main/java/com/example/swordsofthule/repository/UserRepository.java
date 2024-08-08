package com.example.swordsofthule.repository;

import com.example.swordsofthule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
