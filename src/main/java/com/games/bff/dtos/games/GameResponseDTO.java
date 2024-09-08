package com.games.bff.dtos.games;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameResponseDTO {
    private Long gameId;
    private String gameName;
    private String gameImage;
    private GamesCategoryEntity gameMainCategory;
    private GamesCategoryEntity gameSecondaryCategory;
    private int game_score;
}