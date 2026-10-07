package kot.classesTask3

/*
Создать объект класса Государство, используя классы Область, Район, Город.
Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
 */
fun main() {
    val cityMinsk = City("Minsk")
    val cityZaslavl = City("Zaslav")
    val cityBobruisk = City("Bobruisk")
    val cityGrodno = City("Grodno")
    val cityKirovsk = City("Kirovsk")
    val citySkidel = City("Skidel")

    val minskCities = listOf(cityMinsk, cityZaslavl)
    val bobruiskCities = listOf(cityBobruisk, cityKirovsk)
    val grodnoCities = listOf(cityGrodno, citySkidel)

    val districtMinsk = District("Минский", minskCities)
    val districtBobruisk = District("Бобруйский", bobruiskCities)
    val districtGrodno = District("Гродненский", grodnoCities)

    val minskDistricts = listOf(districtMinsk)
    val bobruiskDistricts = listOf(districtBobruisk)
    val grodnoDistricts = listOf(districtGrodno)

    val minskRegion = Region("Минская", "Minsk", minskDistricts, 23.6)
    val mogilevRegion = Region("Могилевская", "Mogilev", bobruiskDistricts, 20.6)
    val grodnoRegion = Region("Гродненская", "Grodno", grodnoDistricts, 21.6)

    val regions = listOf(minskRegion, mogilevRegion, grodnoRegion)
    val state = State("Минск", regions)
    state.printCentreOfRegion()
    state.printCapitalName()
    state.printNumberOfRegions()
    state.findAreaOfState()


}