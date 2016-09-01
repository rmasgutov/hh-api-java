package ru.hhapijava.service

import ru.hhapijava.dto.Resume
import ru.hhapijava.dto.Token
import ru.hhapijava.exception.ApiException

import java.util.stream.Collectors

class ResumeService {
    static String resumeBasePath = '/resumes'

    static List<Resume> search(final Token token, final List<String> textParams) throws ApiException {
        String params = "?"
        textParams.forEach({ param -> params += "text=$param&" })
        (RequestApiService.getRequest("$resumeBasePath$params", token, Resume).items as List).stream()
            .map({ item -> item as Resume })
            .collect(Collectors.toList())
    }

    static Resume getResume(final Token token, final String resumeId) throws ApiException {
        RequestApiService.getRequest("$resumeBasePath/$resumeId", token, Resume) as Resume
    }
}
