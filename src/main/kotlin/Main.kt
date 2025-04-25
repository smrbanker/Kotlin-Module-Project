fun main(args: Array<String>) {

    var arcMap : MutableMap<String, MutableMap<String, String>> = mutableMapOf()

    var archives = Archives(arcMap)
    var notes = Notes()

    var i : Int = archives.menuMove()
    var j : Int
    var k : String

    while (i != 0) {
        k = archives.getKey(i)
        j = notes.menuMove(arcMap, k)
        while (j != 0) {
            notes.notesPrint(arcMap, k, j)
            j = notes.menuMove(arcMap, k)
        }
        i = archives.menuMove()
    }
    println("Программа завершена. Спасибо!")
}