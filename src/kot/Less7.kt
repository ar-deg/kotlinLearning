package kot

fun main() {
    printInfo(patronymic = "Ivanovich", lastname = "Ivanov", name = "Ivan")
    println(volumeOfPar(25, 10))
}


fun printInfo(lastname: String = "", name: String = "", patronymic: String = "") {
    if (lastname.isNotEmpty()) {
        println("Фамилия: $lastname")
    }
    if (name.isNotEmpty()) {
        println("Имя: $name")
    }
    if (!patronymic.isEmpty()) {
        println("Отчество: $patronymic")
    }
}

//fun printInfo(lastname: String, name: String) {
//    printInfo(lastname, name, "")
//}

fun volumeOfPar(firstSide: Int, secondSide: Int = firstSide, thirdSide: Int = firstSide) =
    firstSide * secondSide * thirdSide