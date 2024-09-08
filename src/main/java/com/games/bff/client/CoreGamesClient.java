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
    ResponseEntity<GameFeedbackResponseCountDto> getGameFeedbacks(@PathVariable("gameId") String id);

    @PostMapping("/feedback/create")
    ResponseEntity<GameFeedbackResponseDTO> createGameFeedback(@RequestBody GameFeedbackRequestDTO gameFeedbackRequestDTO);

    @GetMapping("/category/search")
    ResponseEntity<List<GamesCategoryEntity>> searchCategory(@RequestParam String input);

    @GetMapping("/category/list")
    ResponseEntity<List<GamesCategoryEntity>> listCategory();

    @PostMapping("/category/create")
    ResponseEntity<GamesCategoryResponseDTO> createCategory(@RequestBody() GamesCategoryRequestDTO data);

    @GetMapping("/game/{id}")
    ResponseEntity<GamesEntity> getGameById(@PathVariable("id") String id);

    @GetMapping("/game/v2/list")
    ResponseEntity<Page<GameResponseDTO>> listGamePage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size
    );
}
