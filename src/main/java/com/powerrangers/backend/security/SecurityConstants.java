package com.powerrangers.backend.security;

public class SecurityConstants {
    static final String SECRET = "white_rabbit"; //Key to generate JWT
    static final long EXPIRATION_TIME = 1800000; //30 minutes
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
}
