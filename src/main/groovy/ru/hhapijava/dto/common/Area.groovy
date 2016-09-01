package ru.hhapijava.dto.common

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Area {
    Integer id
    String name
    Integer parentId
    String text
    String url
    List<Area> areas
}