package com.example.oauth20_from_scratch.oauth20;

import com.example.oauth20_from_scratch.dto.AuthCodeDto;
import com.example.oauth20_from_scratch.dto.TokenDto;
import com.example.oauth20_from_scratch.dto.TokenResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth")
public class OAuth20Controller {
    @Autowired
    private OAuth20Service oAuth20Service;

    @PostMapping("/authorize")
    public ResponseEntity<String> authorize(@RequestBody AuthCodeDto authCodeDto) throws Exception {
        if (!oAuth20Service.verifyUserDetails(authCodeDto)) {
            return ResponseEntity.badRequest().body("Invalid user credentials");
        }

        if (!oAuth20Service.verifyClientDetails(authCodeDto.getClientId())) {
            return ResponseEntity.badRequest().body("Invalid client");
        }

        String authCode = oAuth20Service.generateAuthCode(authCodeDto);
        return ResponseEntity.ok(authCode);
    }

    @PostMapping("/token")
    public ResponseEntity<TokenResponseDto> token(@RequestBody TokenDto tokenDto) throws Exception {
        String token = oAuth20Service.generateTokenFromAuthCode(tokenDto);

        TokenResponseDto response = new TokenResponseDto();
        response.setToken(token);

        return ResponseEntity.ok(response);
    }
}