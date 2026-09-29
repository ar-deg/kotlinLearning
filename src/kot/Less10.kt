package kot

fun main() {
    val listOfNumbers = mutableListOf<Int>()
    for (i in 0..99) {
        listOfNumbers.add(i)
    }
    val listOfEvenNumbers = listOfNumbers.filter({ number: Int -> number % 2 == 0 })
    for (i in listOfEvenNumbers) {
        println(i)
    }
    println()

    val listOfNames = listOf("Anya", "Marina", "Katya", "Olya", "Nastya")
    val namesStartsFromA = listOfNames.filter { name -> name.startsWith("A") }
    for (name in namesStartsFromA) {
        println(name)
    }
    println()

    val numbers = (0..100).toList()
    val doubledNumbers = numbers.map { number -> number * 2 }
    for (i in doubledNumbers) {
        println(i)
    }
    val employees = numbers.map { "Employee #$it" }
    for (employee in employees) {
        println(employee)
    }
    println()

    val array = arrayOf(3, 6, 4, 0, 1, 2, 5, 8)
    val sortedArray = array.sorted()
    for (i in sortedArray) {
        println(i)
    }
    println()

    val sortedArray2 = array.sortedArrayDescending()
    for (i in sortedArray2) {
        println(i)
    }
    println()
    val array1 = mutableListOf<Int>()
    for (i in 0..1000) {
        array1.add((Math.random() * 1000).toInt())
    }
    val result = array1.filter { it % 3 == 0 || it % 5 == 0 }.map { it * it }.sortedDescending().map { "$it" }
    for (i in result) {
        println(i)
    }

}
