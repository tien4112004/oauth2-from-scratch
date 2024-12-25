package com.example.oauth20_from_scratch.client;

import com.example.oauth20_from_scratch.dto.ClientDto;
import com.example.oauth20_from_scratch.dto.ClientRegistrationRequestDto;
import com.example.oauth20_from_scratch.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<Client> registerClient(@RequestBody ClientRegistrationRequestDto request) {
        Client client = clientService.registerClient(request.getName(), request.getRedirectUri());
        return ResponseEntity.ok(client);
    }

//    @GetMapping("clients/{clientId}/details")
//    public ClientDto getClient(@PathVariable String clientId) {
//        return clientService.getClientDetails(clientId);
//    }
}
