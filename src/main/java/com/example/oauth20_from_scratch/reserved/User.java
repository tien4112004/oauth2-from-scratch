//package com.example.oauth20_from_scratch.reserved;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//import jakarta.persistence.Column;
//import jakarta.persistence.Id;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.sql.Timestamp;
//import java.util.UUID;
//
//@Entity
//@Data
//@Table(name = "users")
//@AllArgsConstructor
//@NoArgsConstructor
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private UUID id;
//
//    @Column(unique = true, nullable = false)
//    @JsonProperty
//    private String username;
//
//    @Column(nullable = false)
//    @JsonProperty
//    private String password;
//
//    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
//    private boolean enabled;
//
//    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    @JsonProperty
//    Timestamp createdAt;
//
//    @JsonProperty
//    Timestamp updatedAt;
//}
