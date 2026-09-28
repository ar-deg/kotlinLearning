package kot


fun main() {
    println(sum("10", "10"))
}

fun sum(a: String, b: String): Int {
    return try {
        val numA = a.toInt()
        val numB = b.toInt()
        numA + numB
    } catch (e: Exception) {
        0
    }

}