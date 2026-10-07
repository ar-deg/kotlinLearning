package kot.classesTask2

data class DataCustomers(val customers: List<Customer>) {
    fun sortedSurname(): List<Customer> {
        return customers.sortedBy { it.surname }
    }

    fun filterNumberOfCreditCards(first: Int, second: Int): List<Customer> {
        return customers.filter { it.numberOfCreditCard in first..second }

    }

}