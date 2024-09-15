package com.games.bff.controllers;

import com.games.bff.dtos.games.*;
import com.games.bff.service.GamesService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Pagina com todos os games")
    @GetMapping("/list")
    ResponseEntity<Page<GameResponseDTO>> listGamesPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size
    ){
        return ResponseEntity.ok(this.gamesService.listGamesPage(page, size));
    }

    @Operation(summary = "Lista todos os feedbacks de um game -> gameId")
    @GetMapping("/feedback/{gameId}")
    ResponseEntity<GameFeedbackResponseCountDto> getGameFeedbacks(@PathVariable("gameId") String id){
        return ResponseEntity.ok(this.gamesService.listGameFeedback(id));
    };

    @Operation(summary = "Criar um feedback pra um game")
    @PostMapping("/feedback/create")
    ResponseEntity<GameFeedbackResponseDTO> createGameFeedback(@RequestBody GameFeedbackRequestDTO gameFeedbackRequestDTO){
        return ResponseEntity.ok(this.gamesService.createGameFeedback(gameFeedbackRequestDTO));
    };

    @Operation(summary = "Pesquisa por uma categoria")
    @GetMapping("/category/search")
    ResponseEntity<List<GamesCategoryEntity>> searchCategory(@RequestParam String input){
        return ResponseEntity.ok(this.gamesService.searchCategory(input));
    };

    @Operation(summary = "Lista todas as categorias")
    @GetMapping("/category/list")
    ResponseEntity<List<GamesCategoryEntity>> listCategory(){
        return ResponseEntity.ok(this.gamesService.listCategory());
    };

    @Operation(summary = "Criar uma categoria")
    @PostMapping("/category/create")
    ResponseEntity<GamesCategoryResponseDTO> createCategory(@RequestBody() GamesCategoryRequestDTO data){
        return ResponseEntity.ok(this.gamesService.createCategory(data));
    };

    @Operation(summary = "Pesquisa um game por id")
    @GetMapping("/find/{id}")
    ResponseEntity<GamesEntity> getGameById(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.gamesService.getGameById(id));
    };

    @Operation(summary = "Pesquisa por games por titulo")
    @GetMapping("/search/{gameName}")
    ResponseEntity<Page<GameResponseDTO>> listGameByNamePage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size,
            @RequestParam(defaultValue = "AION") String gameName
    ){
       return ResponseEntity.ok(this.gamesService.listGameByNamePage(page, size, gameName));
    }

    @Operation(summary = "Pesquisa por games de uma categoria")
    @GetMapping("/find/category/{categoryId}")
    ResponseEntity<Page<GameResponseDTO>> listGameByCategoryIdPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size,
            @RequestParam(defaultValue = "1") int categoryId
    ){
        return ResponseEntity.ok(this.gamesService.getGameByCategoryId(page, size, categoryId));
    }

}
