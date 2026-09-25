package kot

fun main() {
    val nameOfMonth = "Июль"
//    val season: String
    val season = when (nameOfMonth) {
        "Декабрь", "Январь", "Февраль" -> {
//            season = "Зима"                //break здесь не нужен, т.к когда будет выполнен блок операторов внури фигурных скобок, мы сразу выйдем из этой конструкции
            "Зима"
        }

        "Март", "Апрель", "Май" -> {
//            season = "Весна"
            "Весна"
        }

        "Июнь", "Июль", "Август" -> {
//            season = "Лето"
            "Лето"
        }

        "Сентябрь", "Октябрь", "Ноябрь" -> {
//            season = "Осень"
            "Осень"
        }

        else -> {
//            season = "Не найдено"
            "Не найдено"
        }
    }
    println(season)

    println()

    val indexOfMonth1 = 4
    val season1 = when (indexOfMonth1) {
        12, 1, 2 -> {
            "Зима"
        }

        in 3..5 -> {     //можно использовать диапазон чисел in 3..5
            "Весна"
        }

        6, 7, 8 -> {
            "Лето"
        }

        in 9..11 -> {
            "Осень"
        }

        else -> {
            "Не найдено"
        }
    }
    println(season1)

    println()

    val tempOfWat = 50
//    val state = if (tempOfWat < 0) {
//        "Твердое состояние воды"
//    } else if (tempOfWat >= 100) {
//       "Газообразное"
//    } else {
//        "Жидкое"
//    }
//    println("Состояние воды: $state")

    val state = when {
        tempOfWat < 0 -> {
            "Твердое состояние воды"
        }

        tempOfWat >= 100 -> { //также можно использовать диапазон in 0..100
            "Газообразное"
        }

        else -> {
            "Жидкое"
        }
    }
    println("Состояние воды: $state")

    println()

    val time: Int = 10
    val weathercondgood: Boolean = true
    val result = when {
        time in 6..22 && weathercondgood -> {
            "Гулять"
        }

        time in 6..22 && !weathercondgood -> {
            "Читать книгу"
        }

        else -> {
            "Спать"
        }

    }
    println(result)


}