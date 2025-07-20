package com.domain.alif.iam.person.auth;

import lombok.Data;

@Data
class AuthRequest {
    private String email;
    private String password;
}