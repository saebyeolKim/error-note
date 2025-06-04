package com.project.ErrorNote.domain.user;

import com.project.ErrorNote.domain.user.model.LoginRequestDto;
import com.project.ErrorNote.domain.user.model.LoginResponseDto;
import com.project.ErrorNote.global.response.BaseResponse;
import com.project.ErrorNote.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public BaseResponse<?> login(@RequestBody LoginRequestDto req) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );

        String token = jwtTokenProvider.createToken(req.getEmail());
        return new BaseResponse<>(new LoginResponseDto(token));
    }
}
