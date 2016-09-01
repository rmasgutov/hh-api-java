import static ru.hhapijava.dto.dictionary.IndustryDictionary.dictionary

dictionary.keySet().forEach({ key ->
    println "INSERT INTO industries(external_id, name) VALUES ('${key.id}', '${key.name}');"
    dictionary.get(key).forEach({ innerIndustry ->
        println "INSERT INTO industries(external_id, name) VALUES ('${innerIndustry.id}', '${innerIndustry.name}');"
    })
})