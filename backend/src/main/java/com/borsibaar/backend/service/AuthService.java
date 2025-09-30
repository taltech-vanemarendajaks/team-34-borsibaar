package com.borsibaar.backend.service;

import com.borsibaar.backend.entity.Role;
import com.borsibaar.backend.entity.User;
import com.borsibaar.backend.dto.UserDTO;
import com.borsibaar.backend.mapper.UserMapper;
import com.borsibaar.backend.repository.UserRepository;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final UserMapper userMapper;

    public AuthService(UserRepository userRepository, JwtService jwtService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.userMapper = userMapper;
    }

    public UserDTO processOAuthLogin(OAuth2AuthenticationToken auth) {
        String email = auth.getPrincipal().getAttribute("email");
        String name = auth.getPrincipal().getAttribute("name");

        // Check if user exists or create a new one
        User user = userRepository.findByEmail(email)
                .orElse(User.builder()
                        .email(email)
                        .name(name)
                        .organizationId(1L) // TODO: assign dynamically
                        .build());

        // Default role assignment (if new user)
        if (user.getRole() == null) {
            Role defaultRole = new Role(1L, "USER");
            user.setRole(defaultRole);
        }

        user.setName(name); // update name in case it changed
        userRepository.save(user);

        // Issue JWT
        String token = jwtService.generateToken(user.getEmail());

        return userMapper.toDto(user, token);
    }
}
