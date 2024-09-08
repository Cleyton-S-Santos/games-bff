package com.games.bff.dtos.games;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GamesCategoryRequestDTO {
    @NotNull(message = "Field cant be null")
    private String gameCategoryName;
}