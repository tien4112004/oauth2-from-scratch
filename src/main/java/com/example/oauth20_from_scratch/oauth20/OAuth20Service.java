package com.example.oauth20_from_scratch.oauth20;

import com.example.oauth20_from_scratch.client.ClientRepository;
import com.example.oauth20_from_scratch.dto.AuthCodeDto;
import com.example.oauth20_from_scratch.dto.TokenDto;
import com.example.oauth20_from_scratch.entity.AuthCode;
import com.example.oauth20_from_scratch.entity.Client;
import com.example.oauth20_from_scratch.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

@Service
public class OAuth20Service {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AuthCodeRepository authCodeRepository;

    @Autowired
    JWTService jwtService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public boolean verifyUserDetails(AuthCodeDto authCodeDto) throws BadRequestException {
        var user = userRepository.findByUsername(authCodeDto.getUsername());
        if (user == null) {
            throw new BadRequestException("User not found");
        }
        return passwordEncoder.matches(authCodeDto.getPassword(), user.getPassword());
    }

    @Transactional(readOnly = true)
    public boolean verifyClientDetails(String clientId) throws EntityNotFoundException {
        Client client = clientRepository.findByClientId(clientId);
        if (client == null) {
            throw new EntityNotFoundException("Client not found");
        }
        return true;
    }

    @Transactional
    public String generateAuthCode(AuthCodeDto authCodeDto) {
        String code = RandomStringUtils.randomAlphanumeric(6);
        var encodedAuthCode = passwordEncoder.encode(code);

        AuthCode authCode = new AuthCode();
        authCode.setClientId(authCodeDto.getClientId());
        authCode.setRedirectURI(authCodeDto.getRedirectUri());
        authCode.setState(authCodeDto.getState());
        authCode.setAuthorizationCode(encodedAuthCode);
        authCodeRepository.save(authCode);

        return code;
    }

    public String generateTokenFromAuthCode(TokenDto tokenDto) throws BadRequestException {
        validateClientDetails(tokenDto);
        validateAuthCode(tokenDto);
        return jwtService.generateToken(tokenDto.getClientId());
    }

    private void validateClientDetails(TokenDto tokenDto) throws BadRequestException {
        var client = clientRepository.findByClientId(tokenDto.getClientId());
        if (client == null) {
            throw new EntityNotFoundException("Client not found");
        }

        if (tokenDto.getClientSecret().equalsIgnoreCase(client.getClientSecret())) {
            return;
        }
        throw new BadRequestException("Invalid client details");
    }

    private void validateAuthCode(TokenDto tokenDto) throws BadRequestException {
        var authCodeEntity = authCodeRepository.findByClientId(tokenDto.getClientId());
        if (authCodeEntity == null) {
            throw new EntityNotFoundException("Auth code not found");
        }

        if (passwordEncoder.matches(tokenDto.getCode(), authCodeEntity.getAuthorizationCode())) {
            return;
        }
        throw new BadRequestException("Invalid auth code");
    }
}
