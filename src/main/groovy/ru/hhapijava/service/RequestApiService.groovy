package ru.hhapijava.service

import com.fasterxml.jackson.core.type.TypeReference
import groovy.json.JsonBuilder
import org.apache.http.HttpResponse
import org.apache.http.HttpStatus
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ByteArrayEntity
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.message.BasicHeader
import org.apache.http.util.EntityUtils
import ru.hhapijava.HhApi
import ru.hhapijava.dto.Token
import ru.hhapijava.dto.common.Area
import ru.hhapijava.dto.common.Items
import ru.hhapijava.dto.common.Type
import ru.hhapijava.dto.suggest.EducationInstitute
import ru.hhapijava.exception.ApiException

class RequestApiService {
    static Items<Area> getAreaSuggestRequest(String url) throws ApiException {
        HttpClient client = HttpClientBuilder.create().build()
        HttpGet get = new HttpGet(HhApi.BASE_API_URL + url)
        HttpResponse response = client.execute(get)
        if (response.statusLine.statusCode == HttpStatus.SC_OK) {
            return CommonService.objectMapper.readValue(response.entity.content, new TypeReference<Items<Area>>() {
            })
        } else {
            throw new ApiException("Received code $response.statusLine.statusCode on request($get), response ${EntityUtils.toString(response.entity)}")
        }
    }

    static Items<EducationInstitute> getInstituteSuggestRequest(String url) throws ApiException {
        HttpClient client = HttpClientBuilder.create().build()
        HttpGet get = new HttpGet(HhApi.BASE_API_URL + url)
        HttpResponse response = client.execute(get)
        if (response.statusLine.statusCode == HttpStatus.SC_OK) {
            return CommonService.objectMapper.readValue(response.entity.content, new TypeReference<Items<EducationInstitute>>() {
            })
        } else {
            throw new ApiException("Received code $response.statusLine.statusCode on request($get), response ${EntityUtils.toString(response.entity)}")
        }
    }

    static Items<Type> getCommonSuggestRequest(String url) throws ApiException {
        HttpClient client = HttpClientBuilder.create().build()
        HttpGet get = new HttpGet(HhApi.BASE_API_URL + url)
        HttpResponse response = client.execute(get)
        if (response.statusLine.statusCode == HttpStatus.SC_OK) {
            return CommonService.objectMapper.readValue(response.entity.content, new TypeReference<Items<Type>>() {
            })
        } else {
            throw new ApiException("Received code $response.statusLine.statusCode on request($get), response ${EntityUtils.toString(response.entity)}")
        }
    }

    static def getRequest(String url, final Token token, Class aClass) throws ApiException {
        HttpClient client = HttpClientBuilder.create().build()
        HttpGet get = new HttpGet(HhApi.BASE_API_URL + url)
        get.headers = [HhApi.USER_AGENT, new BasicHeader('Authorization', "Bearer $token.accessToken")]
        HttpResponse response = client.execute(get)
        if (response.statusLine.statusCode == HttpStatus.SC_OK) {
            return CommonService.objectMapper.readValue(response.entity.content, aClass)
        } else {
            throw new ApiException("Received code $response.statusLine.statusCode on request($get), response ${EntityUtils.toString(response.entity)}")
        }
    }

    static def postRequest(String url, final Token token, final def object, Class aClass) throws ApiException {
        HttpClient client = HttpClientBuilder.create().build()
        HttpPost post = new HttpPost(HhApi.BASE_API_URL + url)
        post.headers = [HhApi.USER_AGENT, new BasicHeader('Authorization', "Bearer $token.accessToken")]
        post.entity = new ByteArrayEntity(new JsonBuilder(object).toPrettyString().getBytes('UTF-8'))
        HttpResponse response = client.execute(post)
        if (response.statusLine.statusCode == HttpStatus.SC_OK) {
            return CommonService.objectMapper.readValue(response.entity.content, aClass)
        } else {
            throw new ApiException("Received code $response.statusLine.statusCode on request($post), response ${EntityUtils.toString(response.entity)}")
        }
    }
}
