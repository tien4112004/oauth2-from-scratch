//package com.example.oauth20_from_scratch.reserved;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//import java.security.Timestamp;
//
//@Entity
//@Data
//@Table(name = "refresh_tokens")
//@AllArgsConstructor
//@NoArgsConstructor
//public class RefreshToken {
//    @Id
//    @JsonProperty
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private String id;
//
//    @JsonProperty
//    private String token;
//
//    @JsonProperty
//    private String userId;
//
//    @JsonProperty
//    private String clientId;
//
//    @JsonProperty
//    @ElementCollection
//    private List<String> scope;
//
//    @JsonProperty
//    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private Timestamp createdAt;
//
//    @JsonProperty
//    private Timestamp expiredAt;
//
//    @JsonProperty
//    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
//    private boolean revoked;
//}
