package kot

val coll: MutableList<Int>? = mutableListOf()
fun main() {
    coll?.let {
        with(it) {
            for (i in 0..<1000) {
                add((Math.random() * 100).toInt())


            }
            val result = filter { it % 2 == 0 }.take(100)
            for (i in result) {
                println(i)
            }


        }

    }

}