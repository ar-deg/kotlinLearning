package kot.oop

class MotorcycleHelmet(productName: String, price: Double, levelOfProtection: String, size: String, article: Int) :
    Equipment(productName, price, levelOfProtection, size, article) {
    override fun getStandardEquip(): String {
        return "Стандарт безопасности изделия $levelOfProtection"

    }

}