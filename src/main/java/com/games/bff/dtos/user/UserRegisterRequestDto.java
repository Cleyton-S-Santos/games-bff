package com.games.bff.dtos.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRegisterRequestDto {
    String username;
    String password;
    String email;
}
