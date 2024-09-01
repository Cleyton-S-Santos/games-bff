package com.games.bff.dtos.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserLoginRequestDto {
    String password;
    String email;
}
