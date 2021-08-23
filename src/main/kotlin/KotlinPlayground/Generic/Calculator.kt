package KotlinPlayground.Generic

class Calculator {

    fun <T> plusNumber(num1: T, num2: T): T
            where T : Number, T : Comparable<T> {
        return (num1.toDouble() + num2.toDouble()) as T
    }
}