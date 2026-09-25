package kot

fun main() {
//    val array: Array<Int?> = arrayOf(1, 2, 5, 10, 52)
    val array = arrayOfNulls<Int?>(10)
    array[4] = null
    println(array[4])

    println()

    val listOfNumbers: MutableList<Int> = mutableListOf() //ArrayList
    listOfNumbers.add(5)
//    println(listOfNumbers.get(0))
    println(listOfNumbers[0])
}
