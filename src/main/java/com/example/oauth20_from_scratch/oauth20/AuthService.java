package com.example.oauth20_from_scratch.oauth20;

import com.example.oauth20_from_scratch.reserved.AuthorizationCode;
import com.example.oauth20_from_scratch.reserved.Client;
import com.example.oauth20_from_scratch.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class AuthService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorizationCodeRepository authorizationCodeRepository;


    public String createAuthorizationCode(
            String clientId,
            String redirectUri,
            String userId) {
        String code = UUID.randomUUID().toString();

        AuthorizationCode authCode = new AuthorizationCode();

        authCode.setCode(code);
        authCode.setClientId(clientId);
        authCode.setUserId(userId);
        authCode.setRedirectUri(redirectUri);

        authorizationCodeRepository.save(authCode);
        return code;
    }

    public boolean validateClient(String clientId, String clientSecret) {
        Client client = clientRepository.findByClientId(clientId)
                .orElse(null);
        return client != null && client.getClientSecret().equals(clientSecret);
    }
}