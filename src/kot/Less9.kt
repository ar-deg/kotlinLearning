package kot

fun main() {
    val square: (Int) -> Int = { a -> a * a }
    println(square(5))
    println()

    val perimeter: (Int, Int) -> Int = { a, b -> (a + b) * 2 }
    println(perimeter(2, 5))
    println()

    val sayHello: (String) -> Unit = { println("Hello, $it!") }
    sayHello("Maksim")
    println()

    val array: (Array<Int>) -> Array<Int> = {
        for (i in it.size - 2 downTo 0) {
            for (j in 0..i) {
                if (it[j] < it[j + 1]) {
                    val temp = it[j]
                    it[j] = it[j + 1]
                    it[j + 1] = temp
                }
            }
        }
        it
    }
    val sortedArray = array(arrayOf(4, 6, 3, 2, 1))
    for (i in sortedArray) {
        println(i)
    }


}