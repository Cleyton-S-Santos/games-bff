package com.games.bff.controllers;

import com.games.bff.client.AuthClient;
import com.games.bff.dtos.user.*;
import com.games.bff.exceptions.CustomFeignException;
import com.games.bff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class UserController {
    UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("user/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterRequestDto requestDto, @RequestHeader("x-api-token") String apiToken) {
        UserRegisterResponseDto response = userService.registerUser(requestDto, apiToken);
        return ResponseEntity.ok(response);
    }

    @PostMapping("user/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequestDto requestDto, @RequestHeader("x-api-token") String apiToken) {
        UserLoginResponseDto response = userService.login(requestDto, apiToken);
        return ResponseEntity.ok(response);
    }

    @GetMapping("user/session/verify/{id}")
    public ResponseEntity<VerifySessionResponse> verifySession(@PathVariable("id") String id, @RequestHeader("x-api-token") String apiToken) {
        VerifySessionResponse verifySessionResponse = userService.verifySession(id, apiToken);
        return ResponseEntity.ok(verifySessionResponse);
    }

    @GetMapping("user/logout/{id}")
    public ResponseEntity<?> logout(@PathVariable("id") Long id, @RequestHeader("x-api-token") String apiToken) {
        UserLogoutDto userLogoutDto = userService.logout(id, apiToken);
        return ResponseEntity.ok(userLogoutDto);
    }

    @GetMapping("user/refresh/{id}")
    public ResponseEntity<?> refresh(@PathVariable("id") Long id, @RequestHeader("x-api-token") String apiToken) {
        VerifySessionResponse tokenRefresh = userService.refreshSession(id, apiToken);
        return ResponseEntity.ok(tokenRefresh);
    }
}
