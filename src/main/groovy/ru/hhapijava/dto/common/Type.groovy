package ru.hhapijava.dto.common

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import groovy.transform.EqualsAndHashCode

@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(includes = 'id')
class Type {
    String id
    String name
}
