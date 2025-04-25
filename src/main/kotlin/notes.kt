import java.util.*

class Notes () : menu <MutableMap<String, String>> () {
    private var scanner = Scanner(System.`in`)

    fun notesAdd(arc : MutableMap<String, MutableMap<String, String>>, arcKey : String) {
        println("Для создания новой заметки введите её название.")
        val arc1Name : String = scanner.next()

        println("Введите текст заметки.")
        val arc1Text: String = scanner.next()

        var tempNote : MutableMap<String, String> = (arc.get(arcKey)!!)
        tempNote.put(arc1Name, arc1Text)
        arc.set(arcKey, tempNote)
    }

    fun menuMove(arc : MutableMap<String, MutableMap<String, String>>, arcKey : String) : Int { // логика движения по меню
        var arc1 : MutableMap<String, String> = (arc.get(arcKey)!!)
        do {
            var i : Int = menuChoise(arc1, "Список заметок архива $arcKey:", "Создать заметку", "Выход", "Заметка")
            var menuSize = if (arc1 == null) 1 else arc1.size + 1
            when (i) {
                0 -> notesAdd(arc, arcKey)
                menuSize -> return 0
                else -> return i
            }
        } while (i == 0)

        return 0
    }

    fun notesPrint(arc : MutableMap<String, MutableMap<String, String>>, arcKey : String, j : Int) {
        var arc1 : MutableMap<String, String> = (arc.get(arcKey)!!)
        var i = 1

        for ((key, value) in arc1) {
           if (i == j) {
              println("")
              println("Текст заметки $key: $value")
           }
           i++
        }

        println("")
        println("Введите любой символ для возврата")
        val t: String = scanner.next()
    }
}