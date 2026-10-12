package kot.multithreading

import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread

/*
Смоделировать перекрёсток двух дорог: Север–Юг и Запад–Восток.
На каждом направлении — светофор, через перекрёсток едут машины.

Каждый светофор циклически переключается: зелёный → жёлтый → красный → зелёный.
Два перпендикулярных направления никогда не должны гореть зелёным одновременно.

Машина подъезжает к перекрёстку, ждёт зелёного на своём направлении и проезжает. На красный — стоит в очереди и ждёт.

Реализовать светофоры и машины как отдельные потоки.
Обеспечить корректную синхронизацию: зелёный горит максимум у одного направления в каждый момент времени,
ни одна машина не ждёт вечно, программа корректно завершается по сигналу остановки.

-поток машин
-поток светофоров
-синхронизация
-если цвета светофоров циклически переключаются => нужет sleep / то же самое с машинами - одни едут, а другие стоят?
-мне надо знать цвета светофоров (создать класс с данными о цветах)
-нужно знать направления : их должно быть  4
-светофор можно сделать через метод sleep зеленый -> желтый -> красный -> зеленый ?
каждая машина присвоена своему направлению и у нее свой светофор
 */

fun main() {
    val crossroad = Crossroad()
    val trafficLightNS = Crossroad.TrafficLight(crossroad, "GREEN", "Север-Юг")
    val trafficLightThread1 = Thread(trafficLightNS)
    trafficLightThread1.start()
    val trafficLightWE = Crossroad.TrafficLight(crossroad, "RED", "Запад-Восток")
    val trafficLightThread2 = Thread(trafficLightWE)
    trafficLightThread2.start()

    val car1 = Crossroad.Car("BMW", Crossroad.Direction.NORTH_TO_SOUTH, crossroad, trafficLightNS)
    val carThread1 = Thread(car1)
    carThread1.start()

    val car2 = Crossroad.Car("Audi", Crossroad.Direction.WEST_TO_EAST, crossroad, trafficLightWE)
    val carThread2 = Thread(car2)
    carThread2.start()

    val car3 = Crossroad.Car("Geely", Crossroad.Direction.SOUTH_TO_NORTH, crossroad, trafficLightNS)
    val carThread3 = Thread(car3)
    carThread3.start()

    val car4 = Crossroad.Car("Lixiang", Crossroad.Direction.EAST_TO_WEST, crossroad, trafficLightWE)
    val carThread4 = Thread(car4)
    carThread4.start()

    Thread.sleep(10000)
    trafficLightThread1.interrupt()
    trafficLightThread2.interrupt()


}

class Crossroad {
    val lock: Lock = ReentrantLock()
    val directionCondition: Condition = lock.newCondition()

    fun waitingForPass(trafficLight: TrafficLight) {
        lock.lock()
        try {
            while (trafficLight.currentColor != trafficLight.GREEN) {
                directionCondition.await()
            }
        } catch (e: InterruptedException) {
            throw RuntimeException(e)


        } finally {
            lock.unlock()
        }

    }

    enum class Direction {
        NORTH_TO_SOUTH, SOUTH_TO_NORTH, EAST_TO_WEST, WEST_TO_EAST

    }

    class TrafficLight(
        val crossroad: Crossroad, @Volatile
        var currentColor: String, val directionName: String
    ) : Runnable {
        val GREEN = "GREEN"
        val YELLOW = "YELLOW"
        val RED = "RED"


        override fun run() {
            while (!Thread.currentThread().isInterrupted) {
                if (currentColor == GREEN) {
                    println("Светофор $directionName: зеленый свет")
                    try {
                        Thread.sleep(2000)
                    } catch (e: InterruptedException) {
                        Thread.currentThread().interrupt()
                        return
                    }
                    crossroad.lock.lock()
                    try {
                        currentColor = YELLOW
                        crossroad.directionCondition.signalAll()
                    } finally {
                        crossroad.lock.unlock()
                    }

                } else if (currentColor == YELLOW) {
                    println("Светофор $directionName: желтый свет")
                    try {
                        Thread.sleep(2000)
                    } catch (e: InterruptedException) {
                        Thread.currentThread().interrupt()
                        return
                    }
                    crossroad.lock.lock()
                    try {
                        currentColor = RED
                        crossroad.directionCondition.signalAll()
                    } finally {
                        crossroad.lock.unlock()
                    }

                } else if (currentColor == RED) {
                    println("Светофор $directionName: красный свет")
                    try {
                        Thread.sleep(5000)
                    } catch (e: InterruptedException) {
                        Thread.currentThread().interrupt()
                        return
                    }
                    crossroad.lock.lock()
                    try {
                        currentColor = GREEN
                        crossroad.directionCondition.signalAll()
                    } finally {
                        crossroad.lock.unlock()
                    }
                }

            }
        }

    }

    class Car(
        val carMod: String,
        val direction: Direction,
        val crossroad: Crossroad,
        val trafficLight: TrafficLight
    ) : Runnable {
        override fun run() {
            crossroad.waitingForPass(trafficLight)
            println("Машина $carMod проезжает перекресток по направлению $direction на ${trafficLight.currentColor} свет")


        }

    }


}
