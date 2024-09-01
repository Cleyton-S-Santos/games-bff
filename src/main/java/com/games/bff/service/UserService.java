package com.games.bff.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.games.bff.client.AuthClient;
import com.games.bff.dtos.user.*;
import com.games.bff.exceptions.CustomFeignException;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    private final AuthClient authClient;
    private final ObjectMapper objectMapper;

    public UserService(AuthClient authClient, ObjectMapper objectMapper) {
        this.authClient = authClient;
        this.objectMapper = objectMapper;
    }

    public UserRegisterResponseDto registerUser(UserRegisterRequestDto requestDto, String apiToken) {
        try {
            return authClient.registerUser(apiToken, requestDto);
        } catch (FeignException feignException) {
            String errorMessage = "Erro desconhecido ao registrar usuário.";
            int statusCode = feignException.status();

            try {
                String responseBody = feignException.contentUTF8();
                Map<String, Object> errorAttributes = objectMapper.readValue(responseBody, Map.class);
                errorMessage = (String) errorAttributes.get("message");
                statusCode = (int) errorAttributes.get("statusCode");

            } catch (Exception parsingException) {
                parsingException.printStackTrace();
            }
            throw new CustomFeignException(errorMessage, statusCode);
        }
    }

    public UserLoginResponseDto login(UserLoginRequestDto requestDto, String apiToken) {
        try {
            return authClient.loginUser(apiToken, requestDto);
        } catch (FeignException feignException) {
            String errorMessage = "Erro desconhecido ao registrar usuário.";
            int statusCode = feignException.status();

            try {
                String responseBody = feignException.contentUTF8();
                Map<String, Object> errorAttributes = objectMapper.readValue(responseBody, Map.class);
                errorMessage = (String) errorAttributes.get("message");
                statusCode = (int) errorAttributes.get("statusCode");

            } catch (Exception parsingException) {
                parsingException.printStackTrace();
            }
            throw new CustomFeignException(errorMessage, statusCode);
        }
    }

    public VerifySessionResponse verifySession(String id, String apiToken) {
        try {
            return authClient.verifySession(id, apiToken);
        } catch (FeignException feignException) {
            String errorMessage = "Usuario sem sessão ativa.";
            int statusCode = feignException.status();
            throw new CustomFeignException(errorMessage, statusCode);
        }
    }

    public UserLogoutDto logout(Long id, String apiToken) {
        try{
            return authClient.logout(id, apiToken);
        } catch (FeignException feignException) {
            String errorMessage = "false";
            int statusCode = feignException.status();

            try {
                String responseBody = feignException.contentUTF8();
                Map<String, Object> errorAttributes = objectMapper.readValue(responseBody, Map.class);
                errorMessage = (String) errorAttributes.get("success");

            } catch (Exception parsingException) {
                parsingException.printStackTrace();
            }

            throw new CustomFeignException(errorMessage, statusCode);
        }
    }

    public VerifySessionResponse refreshSession(Long id, String apiToken) {
        try{
            return authClient.refreshSession(id, apiToken);
        } catch (FeignException feignException) {
            String errorMessage = "Erro ao atualizar sessão do usuario.";
            int statusCode = feignException.status();

            try {
                String responseBody = feignException.contentUTF8();
                Map<String, Object> errorAttributes = objectMapper.readValue(responseBody, Map.class);
                errorMessage = (String) errorAttributes.get("message");
                statusCode = (int) errorAttributes.get("statusCode");

            } catch (Exception parsingException) {
                parsingException.printStackTrace();
            }

            throw new CustomFeignException(errorMessage, statusCode);
        }
    }
}
