package com.games.bff.controllers;

import com.games.bff.dtos.games.*;
import com.games.bff.service.GamesService;
import com.games.bff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GamesService gamesService;

    @Autowired
    GameController(GamesService gamesService){
        this.gamesService = gamesService;
    }

    @GetMapping("/list")
    ResponseEntity<Page<GameResponseDTO>> listGamesPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size
    ){
        return ResponseEntity.ok(this.gamesService.listGamesPage(page, size));
    }

    @GetMapping("/feedback/game/{gameId}")
    ResponseEntity<GameFeedbackResponseCountDto> getGameFeedbacks(@PathVariable("gameId") String id){
        return ResponseEntity.ok(this.gamesService.listGameFeedback(id));
    };

    @PostMapping("/feedback/create")
    ResponseEntity<GameFeedbackResponseDTO> createGameFeedback(@RequestBody GameFeedbackRequestDTO gameFeedbackRequestDTO){
        return ResponseEntity.ok(this.gamesService.createGameFeedback(gameFeedbackRequestDTO));
    };

    @GetMapping("/category/search")
    ResponseEntity<List<GamesCategoryEntity>> searchCategory(@RequestParam String input){
        return ResponseEntity.ok(this.gamesService.searchCategory(input));
    };

    @GetMapping("/category/list")
    ResponseEntity<List<GamesCategoryEntity>> listCategory(){
        return ResponseEntity.ok(this.gamesService.listCategory());
    };

    @PostMapping("/category/create")
    ResponseEntity<GamesCategoryResponseDTO> createCategory(@RequestBody() GamesCategoryRequestDTO data){
        return ResponseEntity.ok(this.gamesService.createCategory(data));
    };
    @GetMapping("/game/{id}")
    ResponseEntity<GamesEntity> getGameById(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.gamesService.getGameById(id));
    };

}
