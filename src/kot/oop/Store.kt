package kot.oop

class Store(val equipment: MutableList<Equipment>) {

    fun sortEquipment() {
        equipment.sortBy { it.price }
    }

    fun calculateTotalEquipment(): Double {
        var sum: Double = 0.0
        for (equip in equipment) {
            sum += equip.price
        }
        return sum


    }

    fun findEquipment(levelOfProtEquip: String): List<Equipment> {
        val result = equipment.filter { it.levelOfProtection == levelOfProtEquip }
        if (result.isEmpty()) {
            println("К сожалению, не смогли найти совпадений")
        }
        return result
    }

    fun showStoreEquipment() {
        var number = 1
        for (equip in equipment) {
            println("Товар $number : ${equip.productName}: размер - ${equip.size}/ уровень защиты - ${equip.levelOfProtection}/ артикул - ${equip.article} ")
            number++
        }

    }

}