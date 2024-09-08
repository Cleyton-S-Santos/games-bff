package com.games.bff.dtos.games;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class GameFeedbackResponseCountDto {
    private List<GameFeedbackResponseDTO> gameFeedbackResponseDTOList;
    private int gameFeedbackResponseCount;
}
