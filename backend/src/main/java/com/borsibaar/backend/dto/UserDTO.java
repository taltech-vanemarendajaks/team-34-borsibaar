package com.borsibaar.backend.dto;

public record UserDTO (
        String email,
        String name,
        String role,
        String token
) {}
