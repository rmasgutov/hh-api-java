package ru.hhapijava.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import ru.hhapijava.dto.common.Amount
import ru.hhapijava.dto.common.Area
import ru.hhapijava.dto.common.Specialization
import ru.hhapijava.dto.common.Type

@JsonIgnoreProperties(ignoreUnknown = true)
class Resume {
    String lastName
    String firstName
    String middleName
    String birthDate
    Photo photo
    Area area
    Relocation relocation
    Type businessTripReadiness
    List<Contact> contact
    String title
    List<Specialization> specialization
    Amount salary
    Type employment
    List<Type> schedules
    Education education
    TotalExperience totalExperience
    List<Experience> experience
    String skills
    List<String> skillSet
    List<Area> citizenship

    static class TotalExperience {
        Integer months
    }

    static class Photo {
        String small
        String medium
        String id
        String description
    }

    static class Relocation {
        Type type
    }

    static class Contact {
        String comment
        Type type
        boolean preferred
        def value
    }



    static class Education {
        List<EducationBase> elementary
        List<EducationBase> additional
        List<EducationBase> attestation
        List<EducationBase> primary
        Type level
    }

    static class EducationBase {
        String name
        String organization
        String result
        String year
    }

    static class Experience {
        String company
        Area area
        String position
        String start
        String end
        String description
    }


}
