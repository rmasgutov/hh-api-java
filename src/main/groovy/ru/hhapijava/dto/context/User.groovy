package ru.hhapijava.dto.context

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import groovy.transform.CompileStatic

@CompileStatic
@JsonIgnoreProperties(ignoreUnknown = true)
class User {
    long id
    String lastName
    String firstName
    String middleName
    boolean isAdmin
    boolean isApplicant
    boolean isEmployer
    String email
    Employer employer
    Manager manager
    PersonalManager personalManager
    Counters counters
    boolean isInSearch
    String resumeUrl
    String negotiationsUrl

    static class Employer {
        long id
        String name
    }

    static class Manager {
        long id
        boolean hasAdminRights
        boolean isMainContactPerson
        String managerSettingsUrl
    }

    static class PersonalManager {
        long id
        String firstName
        String lastName
        String email
        boolean isAvailable
    }

    static class Counters {
        long unreadNegotiations
        long newResumeViews
    }

}
