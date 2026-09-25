package kot

fun main() {
    val a = 50
    if (a < 40) {
        println("Меньше 40")
    } else if (a < 60) {
        println("Больше 40, но меньше 60")
    } else {
        println("Больше либо равно 60")
    }


    var count = 300
    val food = if (count > 500) { //присваиваем, можно сразу и объявить переменную
        count -= 500               //можно отнять кол-во денег, кот. потратили
        "Pizza"
    } else if (count > 200) {
        count -= 200
        "Shaurma"
    } else {
        count -= 30
        "Doshirak"
    }
    println("Вы можете позволить себе купить след. продукт: $food") //$ == +, если надо вывести метод -> ()

}