package com.example.oauth20_from_scratch.client;

import com.example.oauth20_from_scratch.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Client findByClientId(String clientId);
}
