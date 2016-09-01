package ru.hhapijava.service

import groovy.transform.CompileStatic
import ru.hhapijava.dto.common.Area
import ru.hhapijava.dto.common.LocaleName
import ru.hhapijava.dto.common.Type
import ru.hhapijava.dto.suggest.EducationInstitute

@CompileStatic
class SuggestService {
    private static final String suggestBasePath = '/suggests'
    private static final String institutionsSuggestBasePath = suggestBasePath + '/educational_institutions'
    private static final String specializationSuggestBasePath = suggestBasePath + '/fields_of_study'
    private static final String skillSuggestBasePath = suggestBasePath + '/skill_set'
    private static final String areaSuggestBasePath = suggestBasePath + '/areas'

    static List<EducationInstitute> getInstituteSuggest(String text, LocaleName localeName = null) {
        RequestApiService.getInstituteSuggestRequest(institutionsSuggestBasePath + getParams(text, localeName)).items
    }

    static List<Type> getSpecializationSuggest(String text, LocaleName localeName = null) {
        RequestApiService.getCommonSuggestRequest(specializationSuggestBasePath + getParams(text, localeName)).items
    }

    static List<Type> getSkillSuggest(String text, LocaleName localeName = null) {
        RequestApiService.getCommonSuggestRequest(skillSuggestBasePath + getParams(text, localeName)).items
    }

    static List<Area> getAreaSuggest(String text, LocaleName localeName = null) {
        RequestApiService.getAreaSuggestRequest(areaSuggestBasePath + getParams(text, localeName)).items
    }

    static String getParams(String text, LocaleName localeName = null) {
        "?text=$text&locale${localeName ?: LocaleName.RU}"
    }
}
