package kot

fun main() {
    val age = 5

    println(age.isAgeValid2())
    println(age.isPositive())
    println(age.isSimple())

    val name = ""
    if (name.isNotEmpty()) {
        println("ok")
    }


}

fun Int.isAgeValid2() = this in 6..100

fun Int.isPositive() = this >= 0

fun Int.isSimple(): Boolean {
    if (this <= 3) return false
    for (i in 2 until this) {
        if (this % i == 0) return false
    }
    return true

}
