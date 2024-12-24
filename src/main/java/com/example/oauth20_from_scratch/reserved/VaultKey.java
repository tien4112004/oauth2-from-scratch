//package com.example.oauth20_from_scratch.reserved;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.sql.Timestamp;
//
//@Entity
//@Data
//@Table(name = "vault_keys")
//@AllArgsConstructor
//@NoArgsConstructor
//public class VaultKey {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Integer id;
//
//    @Column(unique = true, nullable = false)
//    private String keyId;
//
//    @Column(nullable = false)
//    private String publicKey;
//
//    @Column(nullable = false)
//    private String privateKey;
//
//    @Column(nullable = false)
//    private String algorithm;
//
//    private Timestamp expiresAt;
//
//    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private Timestamp createdAt;
//
//    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
//    private boolean active;
//}