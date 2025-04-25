import java.util.*

open class menu <T> {
    private var scanner = Scanner(System.`in`)

    fun menuCreate(arc : T?, title : String, open : String, close : String, middle : String) : Int {
        //создаем меню, содержащее все существующие архивы/заметки (смотря, что передать)
        if (arc is MutableMap<*, *>) {
            println("$title")
            println("0. $open")
            if (arc == null) {
                println("1. $close")
                return 1
            } else {
                var i = 1
                for ((key, value) in arc) {
                    println("$i. $middle - $key")
                    i++
                }
                println("${arc.size + 1}. $close")
                return arc.size + 1
            }
        }
        return 1
    }

    fun menuChoise(arc : T?, title : String, open : String, close : String, middle : String) : Int {
        //выбираем пункт меню, возвращаем выбранный номер
        val menuSize : Int = menuCreate(arc, title, open, close, middle)
        println("")
        println("Выберите пункт меню [введите число от 0 до $menuSize]")

        var menuScan : Int = -1
        do {
            while (!scanner.hasNextInt())
            {
                println("Вы ввели не целое число, попробуйте снова!")
                scanner.next()
            }
            menuScan = scanner.nextInt()
            if ((menuScan < 0) || (menuScan > menuSize)) {
                println("Введенное число вне интервала 0-$menuSize, введите еще раз!")
            }
        } while ((menuScan < 0) || (menuScan > menuSize))

        return menuScan
    }
}