package ru.hhapijava.service

import groovy.transform.CompileStatic
import ru.hhapijava.dto.Token
import ru.hhapijava.dto.context.User
import ru.hhapijava.exception.ApiException

@CompileStatic
class ContextService {
    static String meBasePath = '/me'

    static User getCurrentUser(final Token token) throws ApiException {
        RequestApiService.getRequest(meBasePath, token, User) as User
    }

    static void updateNameCurrentUser(String lastName, String firstName, String middleName, Token token) throws ApiException {
        RequestApiService.postRequest("$meBasePath?last_name=$lastName&first_name=$firstName&middle_name=$middleName", token, null, User)
    }
}
