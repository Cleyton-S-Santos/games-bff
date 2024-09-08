package com.games.bff.dtos.games;

import com.games.bff.dtos.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameFeedbackResponseDTO {
    private Long feedBackId;
    private Long gameFeedbackScore;
    private UserEntity userOrigin;
    private GamesEntity game;
    private String feedback;
    private int totalFeedback;
}
