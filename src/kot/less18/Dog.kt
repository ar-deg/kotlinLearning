package kot.less18


class Dog {
    var nickName = ""
        get() = field.lowercase().replaceFirstChar { it.uppercase() }
    var age: Int = 0
        set(value) {
            if (value >= 0) {
                field = value
            }


        }
    var weight: Double = 0.0
        set(value) {
            if (value >= 0) {
                field = value
            }
        }


}
