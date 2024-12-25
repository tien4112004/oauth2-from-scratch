package com.example.oauth20_from_scratch.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @JsonProperty(value = "client_id")
    private String clientId;

    @JsonProperty(value = "client_secret")
    @NonNull
    private String clientSecret;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "redirect_uri")
    private String redirectUri;

    @JsonProperty
    @ElementCollection
    private List<String> scopes;
}