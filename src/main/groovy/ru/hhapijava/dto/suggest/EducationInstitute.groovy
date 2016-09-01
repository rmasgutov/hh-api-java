package ru.hhapijava.dto.suggest

import groovy.transform.CompileStatic
import ru.hhapijava.dto.common.Area

@CompileStatic
class EducationInstitute {
    Long id
    String acronym
    String text
    String synonyms
    Area area
}
