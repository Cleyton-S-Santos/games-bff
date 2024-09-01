package com.games.bff.dtos.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserLoginResponseDto {
    String access_token;
    String refresh_token;
}
