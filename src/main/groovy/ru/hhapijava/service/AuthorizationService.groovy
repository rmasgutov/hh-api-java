package ru.hhapijava.service

import org.apache.http.HttpResponse
import org.apache.http.HttpStatus
import org.apache.http.NameValuePair
import org.apache.http.client.HttpClient
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.message.BasicNameValuePair
import ru.hhapijava.HhApi
import ru.hhapijava.dto.Token
import ru.hhapijava.exception.ApiException

class AuthorizationService {
    private static final String BASE_AUTH_URL = 'https://hh.ru/oauth/authorize'
    private static final String BASE_TOKEN_URL = 'https://hh.ru/oauth/token'

    String appClientId
    String appClientIdSecret

    AuthorizationService(String appClientId, String appClientIdSecret) {
        this.appClientId = appClientId
        this.appClientIdSecret = appClientIdSecret
    }

    String getAuthUrl() {
        "$BASE_AUTH_URL?response_type=code&client_id=$appClientId"
    }

    Token getToken(final String code) throws ApiException {
        List<NameValuePair> parameters = [
            new BasicNameValuePair('grant_type', 'authorization_code'),
            new BasicNameValuePair('client_id', appClientId),
            new BasicNameValuePair('client_secret', appClientIdSecret),
            new BasicNameValuePair('code', code)
        ]
        tokenRequest(parameters)
    }

    static Token refreshToken(final Token token) throws ApiException {
        List<NameValuePair> parameters = [
            new BasicNameValuePair('grant_type', 'refresh_token'),
            new BasicNameValuePair('refresh_token', token.refreshToken)
        ]
        tokenRequest(parameters)
    }

    private static Token tokenRequest(final List<NameValuePair> parameters) throws ApiException {
        HttpClient client = HttpClientBuilder.create().build()
        HttpPost post = new HttpPost(BASE_TOKEN_URL)
        post.header = HhApi.USER_AGENT
        post.entity = new UrlEncodedFormEntity(parameters)
        HttpResponse response = client.execute(post)
        if (response.statusLine.statusCode == HttpStatus.SC_OK) {
            CommonService.objectMapper.readValue(response.entity.content, Token)
        } else {
            throw new ApiException("Received code $response.statusLine.statusCode on request($post) to $BASE_TOKEN_URL")
        }
    }
}
