package kot

/*
Сортировка выбором. Дана последовательность чисел a1<=a2<=...<=an. Требуется переставить элементы так, чтобы они были
расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший элемент и ставится на первое
место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура повторяется. Написать алгоритм
сортировки выбором.
 */

fun main() {
    val array = intArrayOf(6, 9, 12, 1, 45, 78, 3, 2, 88, 27, 18)
    for (i in 0..<array.size) {
        var maxIndex = i
        for (j in i + 1..<array.size) {
            if (array[maxIndex] < array[j]) {
                maxIndex = j

            }
        }
        val tempIndex = array[maxIndex]
        array[maxIndex] = array[i]
        array[i] = tempIndex


    }
    for (i in array) {
        println("$i")
    }


}