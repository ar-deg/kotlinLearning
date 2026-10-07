package kot.classesTask1

/*
Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость(массив из пяти элементов).
Создайте массив из десяти элементов такого типа.
Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */
fun main() {
    val students = arrayOf(
        Student("Ivanov", "A.A", "22B", intArrayOf(2, 7, 8, 4, 9)),
        Student("Karpow", "B.B", "20B", intArrayOf(9, 10, 9, 10, 9)),
        Student("Filipova", "K. B", "20A", intArrayOf(9, 9, 10, 10, 9)),
        Student("Lazareva", "K. V", "20G", intArrayOf(9, 9, 10, 9, 9)),
        Student("Maksimova", "N. B", "20A", intArrayOf(3, 9, 10, 10, 9)),
        Student("Kirkorov", "F. B", "20A", intArrayOf(9, 6, 10, 10, 9)),
        Student("Semenova", "T. D", "20B", intArrayOf(9, 9, 8, 10, 9)),
        Student("Smirnov", "K. B", "20A", intArrayOf(9, 9, 7, 10, 9)),
        Student("Kotov", "A. B", "20B", intArrayOf(9, 9, 2, 10, 9)),
        Student("Petrova", "K. K", "20A", intArrayOf(9, 9, 10, 10, 9)),


        )




    println("Фамилии и группы студентов, имеющих оценки только 9 и 10:")
    for (i in students.indices) {
        if (students[i].checkProgress()) {
            println("${students[i].surname}, ${students[i].numberOfGroup}")
        }


    }
}