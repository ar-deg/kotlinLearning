package kot.oop


/*
Нужно спроектировать программу для интернет-магазина мотоэкипировки. Программа должна хранить список товаров
(шлем, куртка, мотоботы и тп (не менее 5) ), уметь сортировать их по цене, считать общую стоимость и
находить экипировку, соответствующую заданному уровню защиты. Все невалидные варианты запросов должны быть обработаны.
Требуется максимальное использование ООП - Инкапсуляция,Наследование,Полиморфизм,Абстракция .
 */
fun main() {
    val BackProtection1 = BackProtection("Протектор(защита)", 50.5, "lvl2", "s", 234567)
    val BackProtection2 = BackProtection("Протектор(защита)", 40.2, "lvl1", "m", 456890)
    val BackProtection3 = BackProtection("Протектор(защита)", 50.5, "lvl2", "l", 197546)

    val KneeProtection1 = KneeProtection("Наколенники", 30.3, "lvl1", "xs", 854321)
    val KneeProtection2 = KneeProtection("Наколенники", 31.1, "lvl2", "s", 256435)
    val KneeProtection3 = KneeProtection("Наколенники", 30.3, "lvl1", "xl", 887654)

    val MotorcycleBoots1 = MotorcycleBoots("мотоБоты", 100.0, "EN13634", "42", 228778)
    val MotorcycleBoots2 = MotorcycleBoots("мотоБоты", 100.5, "EN13632", "40", 987654)
    val MotorcycleBoots3 = MotorcycleBoots("мотоБоты", 95.0, "EN13634", "45", 345678)

    val MotorcycleHelmet1 = MotorcycleHelmet("Шлем", 230.0, "ECE 22.06", "xs", 123567)
    val MotorcycleHelmet2 = MotorcycleHelmet("Шлем", 225.0, "DOT", "s", 998887)
    val MotorcycleHelmet3 = MotorcycleHelmet("Шлем", 220.0, "SNELL", "m", 156354)

    val MotorcycleGloves1 = MotorcycleGloves("Мотоперчатки", 20.0, "EN13593", "s", 356789)
    val MotorcycleGloves2 = MotorcycleGloves("Мотоперчатки", 20.5, "EN13594", "m", 332456)
    val MotorcycleGloves3 = MotorcycleGloves("Мотоперчатки", 20.5, "EN13594", "l", 11223)

    val Jacket1 = Jacket("Куртка", 165.0, "AA", "s", 256512)
    val Jacket2 = Jacket("Куртка", 100.0, "A", "l", 856345)
    val Jacket3 = Jacket("Куртка", 95.0, "B", "m", 745365)


    val equipment = listOf(
        BackProtection1,
        BackProtection2,
        BackProtection3,
        KneeProtection1,
        KneeProtection2,
        KneeProtection3,
        MotorcycleBoots1,
        MotorcycleBoots2,
        MotorcycleBoots3,
        MotorcycleHelmet1,
        MotorcycleHelmet2,
        MotorcycleHelmet3,
        MotorcycleGloves1,
        MotorcycleGloves2,
        MotorcycleGloves3,
        Jacket1,
        Jacket2,
        Jacket3

    )
    val random = equipment.shuffled()
    val sublist = random.subList(0, 3)

    println()
    val store = Store(equipment.toMutableList())
    val cart = Cart(mutableListOf())

    println("Добрый день! Подобрали для Вас: ")
    for (equip in sublist) {
        println("${equip.productName}/ артикул - ${equip.article}/ уровень защиты - ${equip.levelOfProtection}/ размер - ${equip.size}/стоимость - ${equip.price} byn ")
    }
    println(
        """
        Выберите следующее действие: (нажмите соответствующую цифру)
        1 - Добавить товар из подборки в корзину
        2 - Перейти в каталог товаров
        """.trimIndent()
    )
    var choice: Int = readln().toInt()
    var number: Int
    while (choice != 0) {
        when (choice) {
            1 -> {
                println("Напишите артикул товара, который хотите добавить в корзину")
                val articlePr = readln().toInt()
                var selectedEquipment: Equipment? = null
                for (equip in store.equipment) {
                    if (equip.article == articlePr) {
                        selectedEquipment = equip
                    }
                }
                if (selectedEquipment != null) {
                    cart.cartEquipment.add(selectedEquipment)
                    println("${selectedEquipment.productName}/ артикул - ${selectedEquipment.article}/ уровень защиты - ${selectedEquipment.levelOfProtection}/ размер - ${selectedEquipment.size}/стомость - ${selectedEquipment.price} byn - добавлен в корзину")//просто костыль. сначала обработка не получалась, потом хотелось обработку на null с помощью if, но тоже не вышло, потом хотелось через нулевое значение, передавать 0- знач в equipment, но не вышло, т.к класс абстрактный, потом так
                } else {
                    println("К сожалению, товара с таким артикулом не найдено")
                }
                println(
                    """
            Выберите следующее действие (или 0 для выхода):
            2 - Перейти в каталог товаров
        3 - Перейти в корзину
        """.trimIndent()
                )
                choice = readln().toInt()


            }

            2 -> {
                println(
                    """
                        Каталог товаров: 
                    10 - Протектор(защита)
                    11 - Мотоперчатки
                    12 - мотоБоты
                    13 - Наколенники
                    14 - Куртка
                    15 - Шлем
                    16 - отсортировать/просмотреть товар по уровню защиты
                    Выберите интересующую категорию
                    """.trimIndent()
                )
                choice = readln().toInt()


            }

            3 -> {
                println("Корзина: ")
                cart.showCart()
                val calculateTotal = cart.calculateTotal()
                println("Товаров в корзине на сумму $calculateTotal byn")
                if (calculateTotal > 0) {
                    println(
                        """
                    Оформить заказ?
                    Нажмите 8 - чтобы оформить
                    9 - продолжить покупки
                       """.trimIndent()
                    )
                    val answer = readln().toInt()
                    if (answer == 8) {
                        println(
                            """
                            Применить скидку или промокод? 
                            1- да, у меня есть скидка/ промокод
                            2 - продолжить без применения
                            """.trimIndent()
                        )
                        val discountAnswer = readln().toInt()
                        var finalPrice = calculateTotal
                        if (discountAnswer == 1) {
                            println(
                                """
                                Какую скидку/промокод Вы хотите применить? 
                                1- ввести промокод
                                2 - применить скидку
                                 """.trimIndent()
                            )
                            val choiceAnswer = readln().toInt()
                            if (choiceAnswer == 1) {
                                println("Введите промокод")
                                val promo = readln().uppercase()
                                val promoCode = DiscounType(promo)
                                promoCode.calculateNewPrice(calculateTotal)
                                finalPrice = promoCode.calculateNewPrice(calculateTotal)
                            } else if (choiceAnswer == 2) {
                                println("Введите процент скидки")
                                val discount = readln().toInt()
                                val discountCode = DiscounType(discount)
                                discountCode.calculateNewPrice(calculateTotal)
                                finalPrice = discountCode.calculateNewPrice(calculateTotal)
                            }
                            println("Итоговая сумма к оплате $finalPrice byn")
                        } else {
                            println("Оформляем заказ без скидки. Итоговая стоимость $calculateTotal byn")
                        }
                        println("Заказ оформлен. Спасибо за покупку!")

                        cart.clear()
                        println(
                            """
                            Нажмите 2 для перехода в каталог
                            Нажмите 0 - для выхода
                            """.trimIndent()
                        )

                        choice = readln().toInt()
                    } else if (answer == 9) {
                        println("Рады снова видеть Вас!")
                        println(
                            """
                            Нажмите 2 - для продолжения покупок (перехода в каталог)
                            Нажмите 0 для выхода
                            """.trimIndent()
                        )
                        choice = readln().toInt()

                    }


                }

            }

            4 -> {
                println("Напишите артикул товара, который хотите добавить в корзину: ")
                val articlePr = readln().toInt()
                var selectedEquipment: Equipment? = null
                for (equip in equipment) {
                    if (equip.article == articlePr) {
                        selectedEquipment = equip
                    }
                }
                if (selectedEquipment != null) {
                    cart.cartEquipment.add(selectedEquipment)
                    println("${selectedEquipment.productName}/ артикул - ${selectedEquipment.article}/ уровень защиты - ${selectedEquipment.levelOfProtection}/ размер - ${selectedEquipment.size}/стомость - ${selectedEquipment.price} byn - добавлен в корзину")
                    //просто костыль. сначала обработка не получалась, потом хотелось обработку на null с помощью if, но тоже не вышло, потом хотелось через нулевое значение, передавать 0- знач в equipment, но не вышло, т.к класс абстрактный, потом так
                } else {
                    println("К сожалению, товара с таким артикулом не найден")
                }
                println(
                    """Выберите следующее действие: 
                    2 -  вернуться в каталог
                    3 - просмотреть корзину
                    0 - выйти
                    """.trimIndent()
                )
                choice = readln().toInt()

            }

            10 -> {
                println("Протектор(защита):")
                for (equip in store.equipment) {
                    if (equip.productName == "Протектор(защита)") {
                        println("${equip.productName}/ артикул - ${equip.article}/ уровень защиты - ${equip.levelOfProtection}/ размер - ${equip.size}/стомость - ${equip.price} byn")
                    }
                }
                println(
                    """
                    Выберите следующее действие:
                            Нажмите 4 - для добавления товара в корзину
                            Нажмите 5 - для сортировки протектор(защита) по цене
                            Нажмите 2 - для возврата в каталог
                            Нажмите 0 - для выхода
                            """.trimIndent()
                )
                choice = readln().toInt()

            }

            11 -> {
                println("Мотоперчатки :")
                for (equip in store.equipment) {
                    if (equip.productName == "Мотоперчатки") {
                        println("${equip.productName}/ артикул - ${equip.article}/ уровень защиты - ${equip.levelOfProtection}/ размер - ${equip.size}/стоимость - ${equip.price} byn")
                    }
                }
                println(
                    """
                    Выберите следующее действие:
                            Нажмите 4 - для добавления товара в корзину
                            Нажмите 6 - для сортировки мотоперчаток по цене
                            Нажмите 2 - для возврата в каталог
                            Нажмите 0 - для выхода
                            """.trimIndent()
                )
                choice = readln().toInt()

            }

            12 -> {
                println("мотоБоты")
                for (equip in store.equipment) {
                    if (equip.productName == "мотоБоты") {
                        println("${equip.productName}/ артикул - ${equip.article}/ уровень защиты - ${equip.levelOfProtection}/ размер - ${equip.size}/стоимость - ${equip.price} byn")
                    }
                }
                println(
                    """
                    Выберите следующее действие:
                            Нажмите 4 - для добавления товара в корзину
                            Нажмите 7 - для сортировки мотоБот по цене
                            Нажмите 2 - для возврата в каталог
                            Нажмите 0 - для выхода
                            """.trimIndent()
                )
                choice = readln().toInt()
            }

            13 -> {
                println("Наколенники")
                for (equip in store.equipment) {
                    if (equip.productName == "Наколенники") {
                        println("${equip.productName}/ артикул - ${equip.article}/ уровень защиты - ${equip.levelOfProtection}/ размер - ${equip.size}/стоимость - ${equip.price} byn")
                    }
                }
                println(
                    """
                    Выберите следующее действие:
                            Нажмите 4 - для добавления товара в корзину
                            Нажмите 17 - для сортировки наколенников по цене
                            Нажмите 2 - для возврата в каталог
                            Нажмите 0 - для выхода
                            """.trimIndent()
                )
                choice = readln().toInt()
            }

            14 -> {
                println("Куртка")
                for (equip in store.equipment) {
                    if (equip.productName == "Куртка") {
                        println("${equip.productName}/ артикул - ${equip.article}/ уровень защиты - ${equip.levelOfProtection}/ размер - ${equip.size}/стоимость - ${equip.price} byn")
                    }
                }
                println(
                    """
                    Выберите следующее действие:
                            Нажмите 4 - для добавления товара в корзину
                            Нажмите 18 - для сортировки курток по цене
                            Нажмите 2 - для возврата в каталог
                            Нажмите 0 - для выхода
                            """.trimIndent()
                )
                choice = readln().toInt()
            }

            15 -> {
                println("Шлем")
                for (equip in store.equipment) {
                    if (equip.productName == "Шлем") {
                        println("${equip.productName}/ артикул - ${equip.article}/ уровень защиты - ${equip.levelOfProtection}/ размер - ${equip.size}/стоимость - ${equip.price} byn")
                    }
                }
                println(
                    """
                    Выберите следующее действие:
                            Нажмите 4 - для добавления товара в корзину
                            Нажмите 19 - для сортировки шлемов по цене
                            Нажмите 2 - для возврата в каталог
                            Нажмите 0 - для выхода
                            """.trimIndent()
                )
                choice = readln().toInt()
            }

            16 -> {
                println(
                    """
                    Поиск экипировки по уровню защиты: 
                        Выберите уровень защиты:
                        lvl1
                        lvl2
                        EN13593
                        EN13594
                        EN13632
                        DOT
                        SNELL
                        AA
                        A
                        B
                        """.trimIndent()
                )
                val levelOfProtSc = readln()
                if (levelOfProtSc.isEmpty()) {
                    println("Введите уровень защиты")
                } else {
                    val a = store.findEquipment(levelOfProtSc)
                    for (equip in a) {
                        println("${equip.productName}/ артикул - ${equip.article}/ уровень защиты - ${equip.levelOfProtection}/ размер - ${equip.size}/стоимость - ${equip.price} byn")

                    }
                }
                println(
                    """
                    Выберите следующее действие:
                        Нажмите 4 - для добавления товара в корзину
                        Нажмите 2 - для возврата в каталог
                        Нажмите 0 - для выхода
                        """.trimIndent()
                )
                choice = readln().toInt()


            }

            5 -> {
                println("Сортировка протектор(защита) по цене: ")
                store.sortEquipment()
                for (equip in store.equipment) {
                    if (equip.productName == "Протектор(защита)") {
                        println("${equip.productName}/ артикул - ${equip.article}/ уровень защиты - ${equip.levelOfProtection}/ размер - ${equip.size}/стоимость - ${equip.price} byn")
                    }
                }
                println(
                    """
                    Выберите следующее действие:
                            Нажмите 4 - для добавления товара в корзину
                            Нажмите 2 - для возврата в каталог
                            Нажмите 0 - для выхода
                            """.trimIndent()
                )
                choice = readln().toInt()


            }

            6 -> {
                println("Сортировка мотоперчаток по цене: ")
                store.sortEquipment()
                for (equip in store.equipment) {
                    if (equip.productName == "Мотоперчатки") {
                        println("${equip.productName}/ артикул - ${equip.article}/ уровень защиты - ${equip.levelOfProtection}/ размер - ${equip.size}/стоимость - ${equip.price} byn")
                    }
                }
                println(
                    """
                    Выберите следующее действие:
                            Нажмите 4 - для добавления товара в корзину
                            Нажмите 2 - для возврата в каталог
                            Нажмите 0 - для выхода
                            """.trimIndent()
                )
                choice = readln().toInt()

            }

            7 -> {
                println("Сортировка мотоБот по цене: ")
                store.sortEquipment()
                for (equip in store.equipment) {
                    if (equip.productName == "мотоБоты") {
                        println("${equip.productName}/ артикул - ${equip.article}/ уровень защиты - ${equip.levelOfProtection}/ размер - ${equip.size}/стоимость - ${equip.price} byn")
                    }
                }
                println(
                    """
                    Выберите следующее действие:
                            Нажмите 4 - для добавления товара в корзину 
                            Нажмите 2 - для возврата в каталог
                            Нажмите 0 - для выхода
                            """.trimIndent()
                )
                choice = readln().toInt()

            }

            17 -> {
                println("Сортировка наколенников по цене: ")
                store.sortEquipment()
                for (equip in store.equipment) {
                    if (equip.productName == "Наколенники") {
                        println("${equip.productName}/ артикул - ${equip.article}/ уровень защиты - ${equip.levelOfProtection}/ размер - ${equip.size}/стоимость - ${equip.price} byn")
                    }
                }
                println(
                    """
                    Выберите следующее действие:
                            Нажмите 4 - для добавления товара в корзину
                            Нажмите 2 - для возврата в каталог
                            Нажмите 0 - для выхода
                            """.trimIndent()
                )
                choice = readln().toInt()

            }

            18 -> {
                println("Сортировка курток по цене: ")
                store.sortEquipment()
                for (equip in store.equipment) {
                    if (equip.productName == "Куртка") {
                        println("${equip.productName}/ артикул - ${equip.article}/ уровень защиты - ${equip.levelOfProtection}/ размер - ${equip.size}/стоимость - ${equip.price} byn")
                    }
                }
                println(
                    """
                    Выберите следующее действие:
                            Нажмите 4 - для добавления товара в корзину
                            Нажмите 2 - для возврата в каталог
                            Нажмите 0 - для выхода
                            """.trimIndent()
                )
                choice = readln().toInt()

            }

            19 -> {
                println("Сортировка шлемов по цене: ")
                store.sortEquipment()
                for (equip in store.equipment) {
                    if (equip.productName == "Шлем") {
                        println("${equip.productName}/ артикул - ${equip.article}/ уровень защиты - ${equip.levelOfProtection}/ размер - ${equip.size}/стоимость - ${equip.price} byn")
                    }
                }
                println(
                    """
                    Выберите следующее действие:
                            Нажмите 4 - для добавления товара в корзину
                            Нажмите 2 - для возврата в каталог
                            Нажмите 0 - для выхода
                            """.trimIndent()
                )
                choice = readln().toInt()

            }

        }

    }


}


