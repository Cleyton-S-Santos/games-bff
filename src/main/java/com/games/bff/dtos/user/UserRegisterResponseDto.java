package com.games.bff.dtos.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterResponseDto {
        String email;
        String name;
        String passwordHash;
        Long id;
        Boolean verifiedAccount;
}