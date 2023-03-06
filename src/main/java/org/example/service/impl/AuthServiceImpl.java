package org.example.service.impl;

import org.example.models.dto.AuthDTO;
import org.example.models.entity.User;
import org.example.models.form.LoginForm;
import org.example.models.form.RegisterUserForm;
import org.example.repository.UserRepository;
import org.example.utils.JwtProvider;
import org.example.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authManager;
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(
            AuthenticationManager authManager,
            JwtProvider jwtProvider,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthDTO login(LoginForm form) {

        authManager.authenticate( new UsernamePasswordAuthenticationToken(form.getLogin(),form.getPassword()) );

        User user = userRepository.findByLogin(form.getLogin() )
                .orElseThrow();

        String token = jwtProvider.generateToken(user.getUsername(), List.copyOf(user.getRoles()) );

        return AuthDTO.builder()
                .token(token)
                .username(user.getUsername())
                .roles(user.getRoles())
                .build();
    }

    @Override
    public AuthDTO register(RegisterUserForm form) {
        User user = form.toEntity();
        user.setPassword( passwordEncoder.encode(form.getPassword()) );
        user = userRepository.save( user );

        String token = jwtProvider.generateToken(user.getUsername(), List.copyOf(user.getRoles()));

        return AuthDTO.builder()
                .token(token)
                .username(user.getUsername())
                .roles(user.getRoles())
                .build();
    }
}
