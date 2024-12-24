package com.example.oauth20_from_scratch.repository;

import com.example.oauth20_from_scratch.reserved.VaultKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaultKeyRepository extends JpaRepository<VaultKey, Integer> {
    VaultKey findTopOrderDescById();
}
