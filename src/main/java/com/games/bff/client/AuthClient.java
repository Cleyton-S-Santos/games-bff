package com.games.bff.client;

import com.games.bff.dtos.user.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "AuthClient", url = "${auth.service.url}")
public interface AuthClient {
    @PostMapping("/user/register")
    UserRegisterResponseDto registerUser(@RequestHeader("x-api-token") String apiToken, @RequestBody() UserRegisterRequestDto userRegisterRequestDto);

    @PostMapping("/user/login")
    UserLoginResponseDto loginUser(@RequestHeader("x-api-token") String apiToken, @RequestBody() UserLoginRequestDto userLoginRequestDto);

    @GetMapping("/user/session/verify/{id}")
    VerifySessionResponse verifySession(@PathVariable("id") String id, @RequestHeader("x-api-token") String apiToken);

    @GetMapping("/user/session/logout/{id}")
    UserLogoutDto logout(@PathVariable("id") Long id, @RequestHeader("x-api-token") String apiToken);

    @GetMapping("/user/session/refresh/{id}")
    VerifySessionResponse refreshSession(@PathVariable("id") Long id, @RequestHeader("x-api-token") String apiToken);
}
