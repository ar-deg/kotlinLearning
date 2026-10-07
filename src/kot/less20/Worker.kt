package kot.less20

import java.util.Calendar

class Worker(val name: String, val position: String, val startYear: Int) {
    fun work() {
        println("Работаю...")
    }

    val experience: Int
        get() = Calendar.getInstance().get(Calendar.YEAR) - startYear


}