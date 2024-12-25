package com.example.oauth20_from_scratch.client;

import com.example.oauth20_from_scratch.dto.ClientDto;
import com.example.oauth20_from_scratch.entity.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Client registerClient(String name, String redirectUri) {
        Client client = new Client();
        client.setName(name);
        client.setRedirectUri(redirectUri);
        client.setClientId(UUID.randomUUID().toString());
        client.setClientSecret(UUID.randomUUID().toString());

        return clientRepository.save(client);
    }

    public boolean verifyClient(String clientId, String clientSecret) {
        Client client = clientRepository.findByClientId(clientId);
        return client != null && client.getClientSecret().equals(clientSecret);
    }
}
