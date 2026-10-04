package kot

/*
Замена нескольких пробелов на один
Написать метод который заменяет любые последовательности из двух и более пробелов на один.
Например, "Hello    world   !" → "Hello world !".
 */
fun main() {
    val text = readln()
    println(text.replace("\\s+".toRegex(), " "))

}