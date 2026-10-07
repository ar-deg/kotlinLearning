package kot.classesTask2

/*
Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
и метод toString().
Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами и методами.
Задать критерии выбора данных и вывести эти данные на консоль.
Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.

Найти и вывести:
a) список покупателей в алфавитном порядке;
b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 */
fun main() {
    val customers = listOf(
        Customer(123, "Iv", "Tom", "Al", "vvv", 111, 23),
        Customer(228, "Pa", "Max", "Vl", "cvv", 234, 45),
        Customer(345, "Al", "Art", "Nk", "mat", 456, 89),
        Customer(567, "Dm", "Fil", "Kr", "mal", 987, 39)
    )
    println("Список покупателей в алфавитном порядке:")
    val dataCustomers = DataCustomers(customers)
    val sortedList = dataCustomers.sortedSurname()
    for (customer in sortedList) {
        println(customer)
    }
    println()
    println("Список покупателей с картами в заданном интервале: ")
    val filterList = dataCustomers.filterNumberOfCreditCards(100, 500)
    for (customer in filterList) {
        println(customer)
    }


}