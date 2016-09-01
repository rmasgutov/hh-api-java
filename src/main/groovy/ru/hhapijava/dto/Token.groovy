package ru.hhapijava.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Token {
    String accessToken
    String tokenType
    Long expiresIn
    String refreshToken
}
