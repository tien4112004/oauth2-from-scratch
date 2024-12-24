package com.example.oauth20_from_scratch.reserved;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "client_vaults")
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @JsonProperty
    private String clientId;

    @JsonProperty
    @Column(nullable = false)
    private String clientSecret;

//    @JsonProperty
//    @Column(nullable = false)
//    private String name;

//    private String description;

    @ElementCollection
    private List<String> redirectUris;

    @JsonProperty
    @ElementCollection
    private List<String> scope;

    @ElementCollection
    private List<String> grantTypes;

    @JsonProperty
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean enabled;

    @JsonProperty
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @JsonProperty
    private Timestamp updatedAt;
}