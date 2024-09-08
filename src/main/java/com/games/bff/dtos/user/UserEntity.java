package com.games.bff.dtos.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {
    private Long userId;
    private String userName;
    private String userEmail;
    private Boolean userVerifiedAccount;
}
