package ru.hhapijava

import groovy.transform.CompileStatic
import org.apache.http.Header
import org.apache.http.message.BasicHeader
import ru.hhapijava.dto.Resume
import ru.hhapijava.dto.Token
import ru.hhapijava.dto.Vacancy
import ru.hhapijava.dto.common.Area
import ru.hhapijava.dto.common.LocaleName
import ru.hhapijava.dto.common.Type
import ru.hhapijava.dto.context.User
import ru.hhapijava.dto.suggest.EducationInstitute
import ru.hhapijava.exception.ApiException
import ru.hhapijava.service.*

@CompileStatic
class HhApi {
    static final String BASE_API_URL = 'https://api.hh.ru'
    static final Header USER_AGENT = new BasicHeader('User-Agent', 'api-test-agent')

    AuthorizationService authorizationService

    /**
     * Инициализация клиента для взаимоействия с апи.
     * @param appClientId id приложения.
     * @param appClientIdSecret секретный ключ.
     */
    HhApi(String appClientId, String appClientIdSecret) {
        this.authorizationService = new AuthorizationService(appClientId, appClientIdSecret)
    }

    /**
     * Получение адреса страницы авторизации.
     * @return урл.
     */
    String getAuthUrl() {
        authorizationService.getAuthUrl()
    }

    /**
     * Получение токена по коду аутентификации.
     * @param code код.
     * @return токен.
     * @throws ApiException
     */
    Token getToken(final String code) throws ApiException {
        authorizationService.getToken(code)
    }

    /**
     * Обновление токена.
     * @param token старый токен.
     * @return новый токен.
     * @throws ApiException
     */
    Token refreshToken(final Token token) throws ApiException {
        authorizationService.refreshToken(token)
    }

    /**
     * Поиск резюме по ключевым словам
     * @param token токен.
     * @param textParams список ключевых слов
     * @return список резюме.
     * @throws ApiException
     */
    static List<Resume> search(final Token token, final List<String> textParams) throws ApiException {
        ResumeService.search(token, textParams)
    }

    /**
     * Получение резюме по его id.
     * @param token токен.
     * @param resumeId id резюме.
     * @return резюме.
     * @throws ApiException
     */
    static Resume getResume(final Token token, final String resumeId) throws ApiException {
        ResumeService.getResume(token, resumeId)
    }

    /**
     * Публикация вакансии.
     * @param token токен.
     * @param vacancy вакансия.
     * @throws ApiException
     */
    static void publish(final Token token, final Vacancy vacancy) throws ApiException {
        VacancyService.publish(token, vacancy)
    }

    /**
     * Получение информации о текущем пользователе.
     * @param token токен.
     * @return пользователь.
     * @throws ApiException
     */
    static User getCurrentUser(final Token token) throws ApiException {
        ContextService.getCurrentUser(token)
    }

    /**
     * Обновление имени текущего пользователя.
     * @param lastName фамилия.
     * @param firstName имя.
     * @param middleName отчество.
     * @param token токен.
     * @throws ApiException
     */
    static void updateNameCurrentUser(String lastName, String firstName, String middleName, Token token) throws ApiException {
        ContextService.updateNameCurrentUser(lastName, firstName, middleName, token)
    }

    /**
     * Подсказки по институтам.
     * @param text поисковое слово.
     * @param localeName локаль
     * @return список.
     */
    static List<EducationInstitute> getInstituteSuggest(String text, LocaleName localeName = null) {
        SuggestService.getInstituteSuggest(text, localeName)
    }

    /**
     * Подсказки по специализациям.
     * @param text поисковое слово.
     * @param localeName локаль
     * @return список.
     */
    static List<Type> getSpecializationSuggest(String text, LocaleName localeName = null) {
        SuggestService.getSpecializationSuggest(text, localeName)
    }

    /**
     * Подсказки по навыкам.
     * @param text поисковое слово.
     * @param localeName локаль
     * @return список.
     */
    static List<Type> getSkillSuggest(String text, LocaleName localeName = null) {
        SuggestService.getSkillSuggest(text, localeName)
    }

    /**
     * Подсказки по городам.
     * @param text поисковое слово.
     * @param localeName локаль
     * @return список.
     */
    static List<Area> getAreaSuggest(String text, LocaleName localeName = null) {
        SuggestService.getAreaSuggest(text, localeName)
    }
}
