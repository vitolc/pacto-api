package com.vitulc.pactotestapi.controllers;

import com.vitulc.pactotestapi.common.ResponseResult;
import com.vitulc.pactotestapi.dtos.UserDto;
import com.vitulc.pactotestapi.routes.Routes;
import com.vitulc.pactotestapi.services.UserService;
import com.vitulc.pactotestapi.utilities.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(Routes.Dashboard.User.Me.path)
    public ResponseResult<UserDto> findMe() {
        return ResponseResult.success(new UserDto(userService.findById(Utils.loggedUser().getId())));
    }
}
