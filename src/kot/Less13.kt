package kot

fun main() {
    val revenueByWeek = listOf(
        listOf(2, 4, 6, 7, 9),
        listOf(4, 3, 2, 1, 8),
        listOf(2, 9, 5, 6, 7),
        listOf(3, 1, 7, 4, 8)
    )

    val total = revenueByWeek.flatten()
    val average = total.average()
    println(average)
    println()

    val data = mapOf(
        "file1" to listOf(2, 4, 6, 7, 9),
        "file2" to listOf(3, -5, 1, 7, 9),
        "file3" to listOf(6, 9, 3, 9, 8)
    )
//    val average2 = data.flatMap { it.value }.average()
//    println(average2)
    val average2 = data.filter { it.value.all { it >= 0 } }.flatMap { it.value }.average()
    println(average2)

}