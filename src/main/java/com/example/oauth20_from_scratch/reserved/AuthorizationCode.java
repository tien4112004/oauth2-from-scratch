package com.example.oauth20_from_scratch.reserved;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.security.Timestamp;

@Entity
@Data
@Table(name = "authorization_codes")
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String code;

    private String clientId;

    private String redirectUri;

    private String state;

    private String codeChallenge;

    private String codeChallengeMethod;

    @ElementCollection
    private List<String> scope;

    private String userId;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    private Timestamp expiredAt;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean used;
}
