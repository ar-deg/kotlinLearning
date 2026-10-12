package kot.oop

class Cart(val cartEquipment: MutableList<Equipment> = mutableListOf()) {
    fun calculateTotal(): Double {
        var total = 0.0
        for (equip in cartEquipment) {
            total += equip.price
        }
        return total
    }

    fun showCart() {
        for (equip in cartEquipment) {
            println("Товар в корзине: ${equip.productName} : размер - ${equip.size}/ уровень защиты - ${equip.levelOfProtection}/ артикул - ${equip.article} ")

        }
    }

    fun clear() {
        cartEquipment.clear()

    }
}