package com.games.bff.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.games.bff.client.CoreGamesClient;
import com.games.bff.dtos.games.*;
import com.games.bff.exceptions.CustomFeignException;
import feign.FeignException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GamesService {

    private final CoreGamesClient coreGamesClient;
    private final ObjectMapper objectMapper;

    public GamesService(CoreGamesClient coreGamesClient, ObjectMapper objectMapper) {
        this.coreGamesClient = coreGamesClient;
        this.objectMapper = objectMapper;
    }

    public Page<GameResponseDTO> listGamesPage(int page, int size){
        try {
            return coreGamesClient.listGamePage(page, size);
        } catch (FeignException feignException) {
            String errorMessage = "Erro desconhecido ao listar games.";
            int statusCode = feignException.status();

            try {
                String responseBody = feignException.contentUTF8();
                Map<String, Object> errorAttributes = objectMapper.readValue(responseBody, Map.class);
                errorMessage = (String) errorAttributes.get("message");
                statusCode = (int) errorAttributes.get("statusCode");

            } catch (Exception parsingException) {
                errorMessage = "Erro desconhecido";
                statusCode = HttpStatus.BAD_REQUEST.value();
                parsingException.printStackTrace();
            }
            throw new CustomFeignException(errorMessage, statusCode);
        }
    }

    public GameFeedbackResponseCountDto listGameFeedback(String id){
        try {
            return coreGamesClient.getGameFeedbacks(id);
        } catch (FeignException feignException) {
            String errorMessage = "Erro desconhecido ao listar games.";
            int statusCode = feignException.status();

            try {
                String responseBody = feignException.contentUTF8();
                Map<String, Object> errorAttributes = objectMapper.readValue(responseBody, Map.class);
                errorMessage = (String) errorAttributes.get("message");
                statusCode = (int) errorAttributes.get("statusCode");

            } catch (Exception parsingException) {
                errorMessage = "Erro desconhecido";
                statusCode = HttpStatus.BAD_REQUEST.value();
                parsingException.printStackTrace();
            }
            throw new CustomFeignException(errorMessage, statusCode);
        }
    }

    public GameFeedbackResponseDTO createGameFeedback(GameFeedbackRequestDTO gameFeedbackRequestDTO){
        try {
            return coreGamesClient.createGameFeedback(gameFeedbackRequestDTO);
        } catch (FeignException feignException) {
            String errorMessage = "Erro desconhecido ao listar games.";
            int statusCode = feignException.status();

            try {
                String responseBody = feignException.contentUTF8();
                Map<String, Object> errorAttributes = objectMapper.readValue(responseBody, Map.class);
                errorMessage = (String) errorAttributes.get("message");
                statusCode = (int) errorAttributes.get("statusCode");

            } catch (Exception parsingException) {
                errorMessage = "Erro desconhecido";
                statusCode = HttpStatus.BAD_REQUEST.value();
                parsingException.printStackTrace();
            }
            throw new CustomFeignException(errorMessage, statusCode);
        }
    }

    public List<GamesCategoryEntity> searchCategory(String input){
        try {
            return coreGamesClient.searchCategory(input);
        } catch (FeignException feignException) {
            String errorMessage = "Erro desconhecido ao listar games.";
            int statusCode = feignException.status();

            try {
                String responseBody = feignException.contentUTF8();
                Map<String, Object> errorAttributes = objectMapper.readValue(responseBody, Map.class);
                errorMessage = (String) errorAttributes.get("message");
                statusCode = (int) errorAttributes.get("statusCode");

            } catch (Exception parsingException) {
                errorMessage = "Erro desconhecido";
                statusCode = HttpStatus.BAD_REQUEST.value();
                parsingException.printStackTrace();
            }
            throw new CustomFeignException(errorMessage, statusCode);
        }
    }

    public List<GamesCategoryEntity> listCategory(){
        try {
            return coreGamesClient.listCategory();
        } catch (FeignException feignException) {
            String errorMessage = "Erro desconhecido ao listar games.";
            int statusCode = feignException.status();

            try {
                String responseBody = feignException.contentUTF8();
                Map<String, Object> errorAttributes = objectMapper.readValue(responseBody, Map.class);
                errorMessage = (String) errorAttributes.get("message");
                statusCode = (int) errorAttributes.get("statusCode");

            } catch (Exception parsingException) {
                errorMessage = "Erro desconhecido";
                statusCode = HttpStatus.BAD_REQUEST.value();
                parsingException.printStackTrace();
            }
            throw new CustomFeignException(errorMessage, statusCode);
        }
    }

    public GamesCategoryResponseDTO createCategory(GamesCategoryRequestDTO data){
        try {
            return coreGamesClient.createCategory(data);
        } catch (FeignException feignException) {
            String errorMessage = "Erro desconhecido ao listar games.";
            int statusCode = feignException.status();

            try {
                String responseBody = feignException.contentUTF8();
                Map<String, Object> errorAttributes = objectMapper.readValue(responseBody, Map.class);
                errorMessage = (String) errorAttributes.get("message");
                statusCode = (int) errorAttributes.get("statusCode");

            } catch (Exception parsingException) {
                errorMessage = "Erro desconhecido";
                statusCode = HttpStatus.BAD_REQUEST.value();
                parsingException.printStackTrace();
            }
            throw new CustomFeignException(errorMessage, statusCode);
        }
    }

    public GamesEntity getGameById(Long id){
        try {
            return coreGamesClient.getGameById(id);
        } catch (FeignException feignException) {
            String errorMessage = "Erro desconhecido ao listar games.";
            int statusCode = feignException.status();

            try {
                String responseBody = feignException.contentUTF8();
                Map<String, Object> errorAttributes = objectMapper.readValue(responseBody, Map.class);
                errorMessage = (String) errorAttributes.get("message");
                statusCode = (int) errorAttributes.get("statusCode");

            } catch (Exception parsingException) {
                errorMessage = "Erro desconhecido";
                statusCode = HttpStatus.BAD_REQUEST.value();
                parsingException.printStackTrace();
            }
            throw new CustomFeignException(errorMessage, statusCode);
        }
    }

    public Page<GameResponseDTO> getGameByCategoryId(int page, int size, int id){
        try {
            return coreGamesClient.listGameByCategoryIdPage(page, size, id);
        } catch (FeignException feignException) {
            String errorMessage = "Erro desconhecido ao listar games.";
            int statusCode = feignException.status();

            try {
                String responseBody = feignException.contentUTF8();
                Map<String, Object> errorAttributes = objectMapper.readValue(responseBody, Map.class);
                errorMessage = (String) errorAttributes.get("message");
                statusCode = (int) errorAttributes.get("statusCode");

            } catch (Exception parsingException) {
                errorMessage = "Erro desconhecido";
                statusCode = HttpStatus.BAD_REQUEST.value();
                parsingException.printStackTrace();
            }
            throw new CustomFeignException(errorMessage, statusCode);
        }
    }

    public Page<GameResponseDTO> listGameByNamePage(int page, int size, String gameName){
        try {
            return coreGamesClient.listGameByNamePage(page, size, gameName);
        } catch (FeignException feignException) {
            String errorMessage = "Erro desconhecido ao listar games.";
            int statusCode = feignException.status();

            try {
                String responseBody = feignException.contentUTF8();
                Map<String, Object> errorAttributes = objectMapper.readValue(responseBody, Map.class);
                errorMessage = (String) errorAttributes.get("message");
                statusCode = (int) errorAttributes.get("statusCode");

            } catch (Exception parsingException) {
                errorMessage = "Erro desconhecido";
                statusCode = HttpStatus.BAD_REQUEST.value();
                parsingException.printStackTrace();
            }
            throw new CustomFeignException(errorMessage, statusCode);
        }
    }
}
