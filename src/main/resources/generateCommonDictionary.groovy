import groovy.json.JsonSlurper
import org.apache.http.HttpResponse
import org.apache.http.HttpStatus
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import ru.hhapijava.HhApi

HttpClient client = HttpClientBuilder.create().build()
HttpGet get = new HttpGet('https://api.hh.ru/dictionaries')
get.header = HhApi.USER_AGENT
HttpResponse response = client.execute(get)

if (response.statusLine.statusCode == HttpStatus.SC_OK) {
    Map content = new JsonSlurper().parse(response.entity.content) as Map
    content.keySet().forEach({ String key ->
        String camelCaseKey = key.replaceAll("(_)([A-Za-z0-9])", { Object[] it -> it[2].toUpperCase() })
            .replaceAll("(^[a-z])", { Object[] it -> it[1].toUpperCase() })
        String temp = "enum $camelCaseKey {\n"
        List dict = content.get(key) as List
        if (key != 'currency') {
            dict.forEach({ keyDict ->
                temp += "\t${keyDict.get('id').toUpperCase()}('${keyDict.get('name')}'),\n"
            })
            temp += "" +
                "   private String name;\n " +
                "   $camelCaseKey(String name) {\n" +
                "       this.name = name\n" +
                "   }" +
                "}"
        } else {
            dict.forEach({ keyDict ->
                temp += "\t${keyDict.get('code').toUpperCase()}('${keyDict.get('abbr')}',${keyDict.get('in_use')},'${keyDict.get('name')}',${keyDict.get('rate')}),\n"
            })
            temp += "" +
                "   private String abbr\n" +
                "   private boolean inUse\n" +
                "   private String name\n" +
                "   private double rate\n" +
                "   $camelCaseKey(String abbr, boolean inUse, String name, double rate){\n" +
                "       this.abbr = abbr\n" +
                "       this.inUse = inUse\n" +
                "       this.name = name\n" +
                "       this.rate = rate\n" +
                "   }" +
                "}"
        }


        println temp
    })


}