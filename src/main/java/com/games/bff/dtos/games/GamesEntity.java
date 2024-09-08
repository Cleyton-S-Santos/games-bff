package com.games.bff.dtos.games;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GamesEntity {
    private Long gameId;
    private String gameName;
    private String gameImage;
    private GamesCategoryEntity gameMainCategory;
    private GamesCategoryEntity gameSecondaryCategory;
    private int gameRating;
}
