import static ru.hhapijava.dto.dictionary.SpecializationDictionary.dictionary

dictionary.keySet().forEach({ key ->
    println "INSERT INTO specializations(external_id, name) VALUES ('${key.id}', '${key.name}');"
    dictionary.get(key).forEach({ innerSpecialization ->
        println "INSERT INTO specializations(external_id, name) VALUES ('${innerSpecialization.id}', '${innerSpecialization.name}');"
    })
})