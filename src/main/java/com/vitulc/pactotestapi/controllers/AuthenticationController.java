package com.vitulc.pactotestapi.controllers;

import com.vitulc.pactotestapi.common.ResponseResult;
import com.vitulc.pactotestapi.dtos.LoginDto;
import com.vitulc.pactotestapi.dtos.RegisterDto;
import com.vitulc.pactotestapi.dtos.UserDto;
import com.vitulc.pactotestapi.routes.Routes;
import com.vitulc.pactotestapi.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(Routes.Public.Auth.Register.path)
    public ResponseResult<UserDto> registerUser(@Valid @RequestBody RegisterDto registerDto) {
        return ResponseResult.success(new UserDto(authenticationService.registerUser(registerDto)));
    }

    @PostMapping(Routes.Public.Auth.Login.path)
    public ResponseResult<UserDto> login(@Valid @RequestBody LoginDto loginDto) {
        return ResponseResult.success(new UserDto(authenticationService.loginUser(loginDto)));
    }
}
