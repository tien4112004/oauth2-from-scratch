package com.example.oauth20_from_scratch.repository;


import com.example.oauth20_from_scratch.entity.AuthCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthCodeRepository extends JpaRepository<AuthCode, String> {
    AuthCode findByClientId(String clientId);
}
