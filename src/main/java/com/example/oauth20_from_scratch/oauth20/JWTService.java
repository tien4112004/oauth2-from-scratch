package com.example.oauth20_from_scratch.oauth20;

import com.example.oauth20_from_scratch.client.ClientRepository;
import com.example.oauth20_from_scratch.entity.Client;
import com.example.oauth20_from_scratch.entity.VaultKey;
import com.example.oauth20_from_scratch.vaultkey.VaultKeyRepository;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    VaultKeyRepository vaultKeyRepository;

    public String generateToken(String clientId) {
        Map<String, Object> claims = new HashMap<>();
        var client = clientRepository.findByClientId(clientId);
        setClaims(client, claims);
        return createToken(claims);
    }

    private String createToken(Map<String, Object> claims) {
        KeyPair keyPair = generateRSAKeys();
        Key privateKey = keyPair.getPrivate();
        Key publicKey = keyPair.getPublic();
        persistKeys(privateKey, publicKey);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("testissuer")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
                .signWith(SignatureAlgorithm.RS256, privateKey).compact();
    }

    private Map<String, Object> setClaims(Client client, Map<String, Object> claims) {
        claims.put("scp", new ArrayList<>(client.getScopes()));
        claims.put("sub", client.getClientId());
        return claims;
    }

    private KeyPair generateRSAKeys() {
        KeyPairGenerator keyPairGenerator = null;

        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (Exception e) {
            e.printStackTrace();
        }

        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    private void persistKeys(Key privateKey, Key publicKey) {
        VaultKey vaultKey = new VaultKey();
        vaultKey.setPrivateKey(privateKey.toString());
        vaultKey.setPublicKey(publicKey.toString());

        vaultKeyRepository.save(vaultKey);
    }
}
