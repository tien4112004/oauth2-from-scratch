package com.example.oauth20_from_scratch.client;

import com.example.oauth20_from_scratch.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("clients/register")
    public ClientDto registerClient(@RequestBody ClientDto clientDto) {
        return clientService.registerClientDetails(clientDto);
    }

    @GetMapping("clients/{clientId}/details")
    public ClientDto getClient(@PathVariable String clientId) {
        return clientService.getClientDetails(clientId);
    }
}
