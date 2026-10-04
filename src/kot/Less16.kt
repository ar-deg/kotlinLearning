package kot

fun main() {
    val result = (0..100).toList()
//    listModify(result){
//        println(it.sum())
//    }
    println(result.sum())


}

inline fun listModify(list: List<Int>, modify: (List<Int>) -> Unit) {
    modify(list)
}