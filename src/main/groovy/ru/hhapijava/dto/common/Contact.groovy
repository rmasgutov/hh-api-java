package ru.hhapijava.dto.common

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Contact {
    String name
    String email
    List<Phone> phones
    static class Phone {
        String country
        String city
        String number
        String comment
    }
}
