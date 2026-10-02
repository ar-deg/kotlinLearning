package kot

/*
Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера
которых являются простыми числами.

 */

fun main() {
    val array = arrayOf(8.0, 12.0, 4.0, 11.0, 10.0, 3.0, 2.0, 5.0, 0.0, 1.0)
    for ((index, number) in array.withIndex()) {
        println("Число - $number с порядковым номером : ${index + 1}")

    }
    var sum = 0.0
    for (index in array.indices) {
        val primeNumber = index + 1
        if (isSimple(primeNumber)) {
            println("Порядковый номер ${index + 1} - простое число ")
            sum += array[index]
        }

    }
    println("Сумма чисел с простыми порядковыми номерами = $sum")


}

fun isSimple(index: Int): Boolean {
    if (index < 2)
        return false
    for (j in 2..Math.sqrt(index.toDouble()).toInt()) {
        if (index % j == 0)
            return false
    }
    return true
}