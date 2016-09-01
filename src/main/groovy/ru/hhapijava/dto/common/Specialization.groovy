package ru.hhapijava.dto.common

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Specialization extends Type {
    String profareaId
}
