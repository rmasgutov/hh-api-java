import groovy.json.JsonSlurper
import org.apache.http.HttpResponse
import org.apache.http.HttpStatus
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import ru.hhapijava.HhApi

import java.util.stream.Collectors

HttpClient client = HttpClientBuilder.create().build()
HttpGet get = new HttpGet('https://api.hh.ru/areas')
get.header = HhApi.USER_AGENT
HttpResponse response = client.execute(get)
def build = { area ->
    String childTemplate = null
    if (area.areas != null) {
        childTemplate = (area.areas as List).stream()
            .map({ child -> owner.call(child) })
            .collect(Collectors.joining(',\n'))
    }
    "[name:'$area.name',id:$area.id, parentId:$area.parent_id, areas:[${!childTemplate.empty ? '\n' + childTemplate + '\n' : ''}]] as Area"
}
if (response.statusLine.statusCode == HttpStatus.SC_OK) {
    List content = new JsonSlurper().parse(response.entity.content) as List
    String result = ''
    content.forEach({ parentArea ->
        if (parentArea.name.equals('Россия')){
            String temp = "Area russia = [name:'$parentArea.name',id:$parentArea.id, parentId:$parentArea.parent_id, areas:[]] as Area\n"
            String subAreas = (parentArea.areas as List).stream()
                .map({area -> "russia.areas.add(${build(area)})"})
                .collect(Collectors.joining('\n'))
//            String temp = build(parentArea)
            def parentTemplate = "$temp $subAreas realDictionary.add(russia)\n"
            result += parentTemplate
        } else {
            String temp = build(parentArea)
            def parentTemplate = "realDictionary.add($temp)\n"
            result += parentTemplate
        }
    })
    println result
}