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
        return this.gamesService.listGamesPage(page, size);
    }

    @GetMapping("/feedback/game/{gameId}")
    ResponseEntity<GameFeedbackResponseCountDto> getGameFeedbacks(@PathVariable("gameId") String id){
        return this.gamesService.listGameFeedback(id);
    };

    @PostMapping("/feedback/create")
    ResponseEntity<GameFeedbackResponseDTO> createGameFeedback(@RequestBody GameFeedbackRequestDTO gameFeedbackRequestDTO){
        return this.gamesService.createGameFeedback(gameFeedbackRequestDTO);
    };

    @GetMapping("/category/search")
    ResponseEntity<List<GamesCategoryEntity>> searchCategory(@RequestParam String input){
        return this.gamesService.searchCategory(input);
    };

    @GetMapping("/category/list")
    ResponseEntity<List<GamesCategoryEntity>> listCategory(){
        return this.gamesService.listCategory();
    };

    @PostMapping("/category/create")
    ResponseEntity<GamesCategoryResponseDTO> createCategory(@RequestBody() GamesCategoryRequestDTO data){
        return this.gamesService.createCategory(data);
    };
    @GetMapping("/game/{id}")
    ResponseEntity<GamesEntity> getGameById(@PathVariable("id") String id){
        return this.gamesService.getGameById(id);
    };

}
