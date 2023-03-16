package com.vishwa.mytodobackend.todoappbackend.auth;

import com.vishwa.mytodobackend.todoappbackend.auth.AuthenticationRequest;
import com.vishwa.mytodobackend.todoappbackend.security.JwtUtil;
import com.vishwa.mytodobackend.todoappbackend.user.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody AuthenticationRequest loginRequest) throws Exception {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return jwt;
    }
}
