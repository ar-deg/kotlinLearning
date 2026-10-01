package kot

fun main() {
    val data = mapOf(
        "Июль" to listOf(200, 100, 300, 100),
        "Август" to listOf(320, 140, 100, -120),
        "Сентябрь" to listOf(200, 150, -300, 250),
        "Октябрь" to listOf(200, 150, 100, 300),
        "Ноябрь" to listOf(200, 100, 400, 300),
        "Декабрь" to listOf(400, 300, 250, 400)
    )
    printInfo(data)


}

fun printInfo(data: Map<String, List<Int>>) {
    val valiData = data.filter { it.value.all { it >= 0 } }
    val averageWeek = valiData.flatMap { it.value }.average()
    println("Средняя выручка в неделю: $averageWeek")

    val listOfSum = valiData.map { it.value.sum() }
    val max = listOfSum.max()
    val min = listOfSum.min()
    val averageMonth = listOfSum.average()

    val maxMonth = valiData.filter { it.value.sum() == max }.keys
    val minMonth = valiData.filter { it.value.sum() == min }.keys

    println("Средняя выручка в месяц $averageMonth")
    println("Максимальная выручка в месяц $max")
    print("Была в следующих месяцах: ")
    for (month in maxMonth)
        print("$month ")
    println("\nМинимальная выручка в месяц $min")
    print("Была в следующих месяцах: ")
    for (month in minMonth)
        print("$month ")


    val invaliData = data.filter { it.value.any { it < 0 } }
    val errorMonth = invaliData.keys
    println()
    print("Ошибки произошли в следующих месяцах: ")
    for (month in errorMonth)
        print("$month ")
}