import groovy.json.JsonSlurper
import org.apache.http.HttpResponse
import org.apache.http.HttpStatus
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import ru.hhapijava.HhApi

HttpClient client = HttpClientBuilder.create().build()
HttpGet get = new HttpGet('https://api.hh.ru/industries')
get.header = HhApi.USER_AGENT
HttpResponse response = client.execute(get)

if (response.statusLine.statusCode == HttpStatus.SC_OK) {
    List content = new JsonSlurper().parse(response.entity.content) as List
    String result = ''
    content.forEach({ industryParent ->
        String templateIndustries = ''
        industryParent.industries.forEach({ industry ->
            templateIndustries += !templateIndustries.empty ? ',\n' : '';
            templateIndustries += "[id:'$industry.id', name:'$industry.name'] as Type"
        })
        def templateIndustry = "realDictionary.put([id: '$industryParent.id', name: '$industryParent.name'] as Type,[$templateIndustries])\n"
        result += templateIndustry
    })
    println result
}