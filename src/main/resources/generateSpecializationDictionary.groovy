import groovy.json.JsonSlurper
import org.apache.http.HttpResponse
import org.apache.http.HttpStatus
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import ru.hhapijava.HhApi

HttpClient client = HttpClientBuilder.create().build()
HttpGet get = new HttpGet('https://api.hh.ru/specializations')
get.header = HhApi.USER_AGENT
HttpResponse response = client.execute(get)

if (response.statusLine.statusCode == HttpStatus.SC_OK) {
    List content = new JsonSlurper().parse(response.entity.content) as List
    String result = ''
    content.forEach({ specializationParent ->
        String templateSpecializations = ''
        specializationParent.specializations.forEach({ specialization ->
            templateSpecializations += !templateSpecializations.empty ? ',\n' : '';
            templateSpecializations += "[id:'$specialization.id', name:'$specialization.name'] as Type"
        })
        def templateSpecializationParent = "realDictionary.put([id: '$specializationParent.id', name: '$specializationParent.name'] as Type,[$templateSpecializations])\n"
        result += templateSpecializationParent
    })
    println result

}