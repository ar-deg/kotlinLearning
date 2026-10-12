package kot.oop


class DiscounType<T>(val discount: T) {
    fun calculateNewPrice(currentTotalCart: Double): Double {
        if (discount == "МОТО") {
            return currentTotalCart - 50.0
        } else if (discount == 10) {
            return currentTotalCart - (currentTotalCart * 0.10)
        } else return currentTotalCart

    }

}