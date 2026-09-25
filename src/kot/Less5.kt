package kot

fun main() {
//    val array = arrayOf(1,4,3,5,6,7,8)
//    for( i in array ) {
//        println(i)
//    }
    val array = arrayOfNulls<Int?>(101)
//    for (i in 0..100) {
    for (i in 0..<array.size) {
        array[i] = i
    }
    for (i in array) {
        println(i)
    }

    println()
    for (i in 100 downTo 0 step 2) { //если хотим вывести только четные - указать step 2
        println(i)
    }
    println()

    val array2 = arrayOfNulls<Int?>(101)
    for (i in 0..<array2.size) {
        array2[i] = i
    }
    for (i in array2) {
        println(i)
    }
    println()

    val array3 = arrayOfNulls<Int?>(301)
    for ((index, i) in (300..600).withIndex()) {
        array3[index] = i
    }
    for (i in array3.size - 1 downTo 0 step 5) {
        println(array3[i])
    }
}
