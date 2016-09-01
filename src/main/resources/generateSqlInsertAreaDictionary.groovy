import ru.hhapijava.dto.dictionary.AreaDictionary

def buildChild = { area ->
    println "INSERT INTO areas(external_id, name, parent_id) VALUES ($area.id, '$area.name', $area.parentId);"
    if (area.areas != null) {
        (area.areas as List).stream()
            .forEach({ child -> owner.call(child) })
    }
}
AreaDictionary.dictionary.forEach({ parentArea ->
    buildChild(parentArea)
})