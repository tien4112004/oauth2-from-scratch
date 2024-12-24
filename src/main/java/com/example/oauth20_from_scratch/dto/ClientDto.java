package com.example.oauth20_from_scratch.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ClientDto {
    @JsonProperty(value = "client_id")
    private String clientId;

    private List<String> scopes;

    @JsonProperty(value = "client_secret", access = JsonProperty.Access.READ_ONLY)
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String clientSecret;
}
