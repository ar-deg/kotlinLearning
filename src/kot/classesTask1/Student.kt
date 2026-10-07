package kot.classesTask1

class Student(
    val surname: String,
    val initials: String,
    val numberOfGroup: String,
    val progress: IntArray
) {

    fun checkProgress(): Boolean {
        for (progress in progress) {
            if (progress < 9) {
                return false
            }
        }
        return true
    }
}