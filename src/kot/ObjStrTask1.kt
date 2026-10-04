package kot
/*
Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было
введено "abc cde def", то должно быть выведено "abcdef".
 */

fun main() {
    println("Введите символы: ")
    val word = readln()
    val newWord = StringBuilder()
    for (i in word.indices) {
        if (word.indexOf(word[i]) == i) {
            newWord.append(word[i])
        }

    }
    val result = newWord.toString().replace(" ", "")
    println(result)


}
