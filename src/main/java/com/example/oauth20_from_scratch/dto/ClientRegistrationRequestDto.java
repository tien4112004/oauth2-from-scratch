package com.example.oauth20_from_scratch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientRegistrationRequestDto {
    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "redirect_uri")
    private String redirectUri;
}
