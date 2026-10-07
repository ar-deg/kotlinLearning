package kot.less20

fun main() {
    val programmer = Worker("Ivan", "dev", 2021)
    programmer.printInfo()

}

fun Worker.printInfo() {
    println("Name: $name \nPosition: $position \nstartYear: $startYear \nExperience: $experience")
}