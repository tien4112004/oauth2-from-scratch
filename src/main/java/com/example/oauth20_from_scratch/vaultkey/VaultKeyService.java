//package com.example.oauth20_from_scratch.vaultkey;
//
//import com.example.oauth20_from_scratch.entity.VaultKey;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class VaultKeyService {
//    @Autowired
//    VaultKeyRepository vaultKeyRepository;
//
//    public String getPublicKey() {
//        VaultKey latestKey = vaultKeyRepository.findTopByOrderByIdDesc();
//        VaultKey vaultKey = vaultKeyRepository.findById(latestKey.getId()).orElse(null);
//
//        String publicKey = vaultKey.getPublicKey().toString();
//        return publicKey;
//    }
//}
