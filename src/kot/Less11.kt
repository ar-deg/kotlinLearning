package kot

fun main() {
    val array = (0..1000).toList()
    val employees = array.map { "Employee #$it" }
    val topTwenty = employees.take(20)
    for (employee in topTwenty) {
        println(employee)
    }
    println()
    val topTwenty2 = employees.takeLast(20)
    for (employee in topTwenty2) {
        println(employee)
    }
    println()
    val topTwenty3 = employees.drop(20)
    for (employee in topTwenty3) {
        println(employee)
    }
    println()
    val topTwenty4 = employees.dropLast(20)
    for (employee in topTwenty4) {
        println(employee)
    }
    println()
    val array2 = generateSequence(0) {
        println("Сгенерировано: $it")
        it + 2
    }
    val evenList = array2.take(10)
    for (i in evenList) {
        println(i)
    }
    println()
    val employees5 = generateSequence(1) { it + 1 }
    val firstEmployees = employees5.take(100)
    for (employee in firstEmployees) {
        println("Сотрудник №$employee")
    }
}
