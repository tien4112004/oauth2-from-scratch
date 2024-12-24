package com.example.oauth20_from_scratch.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TokenResponseDto {
    @JsonProperty
    private String token;
}