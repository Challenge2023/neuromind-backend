package com.neuromind.neuromind.configuration.authentication.controller;

import com.neuromind.neuromind.configuration.authentication.dto.JwtAuthenticationResponse;
import com.neuromind.neuromind.configuration.authentication.dto.SignInRequest;
import com.neuromind.neuromind.configuration.authentication.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public JwtAuthenticationResponse signin(@RequestBody SignInRequest request) {
        return authenticationService.signin(request);
    }

}
