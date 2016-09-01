package ru.hhapijava.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import ru.hhapijava.dto.common.Area
import ru.hhapijava.dto.common.Contact
import ru.hhapijava.dto.common.Specialization
import ru.hhapijava.dto.dictionary.CommonDictionary

@JsonIgnoreProperties(ignoreUnknown = true)
class Vacancy {
    String name
    String description
    List<Skill> keySkills
    List<Specialization> specializations
    Area area
    CommonDictionary.VacancyType type
    CommonDictionary.VacancyBillingType billingType
    CommonDictionary.VacancySite site
    String code
    Salary salary
    CommonDictionary.Experience experience
    CommonDictionary.Schedule schedule
    CommonDictionary.Employment employment
    Contact contacts

    static class Skill {
        String name
    }

    static class Salary {
        BigDecimal from
        BigDecimal to
        CommonDictionary.Currency currency

    }
}


