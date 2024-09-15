package com.games.bff.client;

import com.games.bff.dtos.games.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@FeignClient(name = "CoreGamesClient", url = "${games.service.url}")
public interface CoreGamesClient {
    @GetMapping("/feedback/game/{gameId}")
    GameFeedbackResponseCountDto getGameFeedbacks(@PathVariable("gameId") String id);

    @PostMapping("/feedback/create")
    GameFeedbackResponseDTO createGameFeedback(@RequestBody GameFeedbackRequestDTO gameFeedbackRequestDTO);

    @GetMapping("/category/search")
    List<GamesCategoryEntity> searchCategory(@RequestParam String input);

    @GetMapping("/category/list")
    List<GamesCategoryEntity> listCategory();

    @PostMapping("/category/create")
    GamesCategoryResponseDTO createCategory(@RequestBody() GamesCategoryRequestDTO data);

    @GetMapping("/game/{id}")
    GamesEntity getGameById(@PathVariable("id") Long id);

    @GetMapping("/game/v2/list")
    Page<GameResponseDTO> listGamePage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size
    );

    @GetMapping("/game/search/{gameName}")
    Page<GameResponseDTO> listGameByNamePage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size,
            @RequestParam(defaultValue = "15") String gameName
    );

    @GetMapping("/game/category/{categoryId}")
    Page<GameResponseDTO> listGameByCategoryIdPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size,
            @RequestParam(defaultValue = "15") int categoryId
    );
}
