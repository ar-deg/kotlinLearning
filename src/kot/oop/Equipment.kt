package kot.oop

abstract class Equipment(
    val productName: String,
    val price: Double,
    val levelOfProtection: String,
    val size: String,
    val article: Int
) {
    abstract fun getStandardEquip(): String

}