package kot

fun main() {
    val fullNames = mutableListOf<String>()
    for (i in 0..100) {
        fullNames.add("Имя$i Фамилия$i")

    }
    val names = fullNames.map { it.substringBefore(" ") }
    val lastNames = fullNames.map { it.substringAfter(" ") }

    val users = names.zip(lastNames)
    for (user in users) {
        println("Name: ${user.first} - LastName: ${user.second}")
    }

//    val users = fullNames.map { Pair(it.substringBefore(" "),it.substringAfter(" ")) }
//    for (user in users) {
//        println("Name: ${user.first} - LastName: ${user.second}")
//    }


}

