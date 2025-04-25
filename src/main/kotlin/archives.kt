import java.util.*

class Archives (val arc : MutableMap<String, MutableMap<String, String>>?) : menu <MutableMap<String, MutableMap<String, String>>> () {

    private var scanner = Scanner(System.`in`)

    fun archiveAdd() {
        print("Для создания нового архива введите его название. ")
        println("Заметки можно будет добавить на следующем шаге.")
        val arc1Name : String = scanner.next()
        val emptyMap: MutableMap<String, String> = mutableMapOf()
        arc?.put(arc1Name, emptyMap)
    }

    fun menuMove() : Int { // логика движения по меню
        do {
            var i : Int = menuChoise(arc, "Список архивов:", "Создать архив", "Выход", "Архив")
            var menuSize = if (arc == null) 1 else arc.size + 1
            when (i) {
                0 -> archiveAdd()
                menuSize -> return 0
                else -> return i
            }
        } while (i == 0)

        return 0
    }

    fun getKey(k : Int) : String { // возврат ключа
        var i = 1
        if (arc != null) {
            for ((key, value) in arc) {
                if (i == k) return key
                i++
            }
        }
        return ""
    }
}