package kot.classesTask3

data class State(val capitalName: String, val regions: List<Region>) {
    fun printCapitalName() {
        println("Название столицы Республики Беларусь: $capitalName")
    }

    fun printNumberOfRegions() {
        println("Количество областей: ${regions.size}")
    }

    fun findAreaOfState() {
        var sumArea: Double = 0.0
        for (region in regions) {
            sumArea += region.area
        }
        println("Общая площадь гос-ва: $sumArea")

    }

    fun printCentreOfRegion() {
        for (region in regions) {
            println("Центр ${region.regionName} области ${region.centreOfRegion}")
        }
    }

}