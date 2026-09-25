package kot

fun main() {
    println(max(3, 5))
    println(max2("hello"))
    println(sum(1, 4, 6, 7, 8))
    println()
//    val numbers = mutableListOf(5, 9, 6, 8, 2, 4, 7, 1)
//    val result = sort(numbers)
    val result = sort(4, 7, 5, 9)
    for (i in result) {
        println(i)
    }

}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun max2(str: String) = str.substring(0, 3)
fun sum(vararg numbers: Int): Int {
    var result = 0
    for (num in numbers) {
        result += num
    }
    return result
}

fun sort(numbers: MutableList<Int>): List<Int> {
    for (i in 1..<numbers.size) {
        for (j in numbers.size - 1 downTo i) {
            if (numbers[j] < numbers[j - 1]) {
                val temp = numbers[j]
                numbers[j] = numbers[j - 1]
                numbers[j - 1] = temp
            }
        }
    }
    return numbers
}

fun sort(numbers: Array<Int>) = sort(numbers.toMutableList())
fun sort(vararg numbers: Int) = sort(numbers.toMutableList())