package com.example.oauth20_from_scratch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vault_keys")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaultKey {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="MySequenceGenerator")
    private Integer id;

    private String publicKey;

    private String privateKey;
}