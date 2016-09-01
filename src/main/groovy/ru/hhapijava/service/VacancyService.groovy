package ru.hhapijava.service

import ru.hhapijava.dto.Token
import ru.hhapijava.dto.Vacancy
import ru.hhapijava.exception.ApiException

class VacancyService {
    static String vacancyBasePath = '/vacancies'

    static void publish(Token token, Vacancy vacancy) throws ApiException {
        RequestApiService.postRequest(vacancyBasePath, token, vacancy, Vacancy)
    }

}
