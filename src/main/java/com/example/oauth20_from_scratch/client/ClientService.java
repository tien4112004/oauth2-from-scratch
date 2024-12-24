package com.example.oauth20_from_scratch.client;

import com.example.oauth20_from_scratch.dto.ClientDto;
import com.example.oauth20_from_scratch.entity.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Transactional
    public ClientDto registerClientDetails(ClientDto clientDto) {
        var clientSecret = passwordGenerator();
        clientDto.setClientSecret(clientSecret);

        var client = setClientData(clientDto);
        var addedClient = clientRepository.save(client);
        return objectMapper.convertValue(addedClient, ClientDto.class);
    }

    @Transactional
    public ClientDto getClientDetails(String clientId) {
        var client = clientRepository.findByClientId(clientId);
        return objectMapper.convertValue(client, ClientDto.class);
    }

    private String passwordGenerator() {
        return UUID.randomUUID().toString();
    }

    private Client setClientData(ClientDto clientDto) {
        var clientId = clientDto.getClientId();
        var clientSecret = clientDto.getClientSecret();
        return new Client(clientId, clientSecret, clientDto.getScopes());
    }
}
