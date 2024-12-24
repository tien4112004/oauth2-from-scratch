package com.example.oauth20_from_scratch.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AuthCodeDto {
    private String username;

    private String password;

    @JsonProperty(value = "client_id")
    private String clientId;

    @JsonProperty(value = "response_type")
    private String responseType;

    private List<String> scopes;

    private String state;

    @JsonProperty(value = "redirect_uri")
    private String redirectUri;
}
