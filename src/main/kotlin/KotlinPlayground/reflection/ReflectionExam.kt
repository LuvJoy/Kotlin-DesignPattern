package KotlinPlayground.reflection

import kotlin.math.min
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.isAccessible

fun main() {
    val calculator = Calculator()

    val ref1 = calculator::class
    val ref2 = Calculator::class

    val functions = ref1.memberFunctions

    val plus = functions.find { it.name == "plus" }
    val minus = functions.find { it.name == "minus" }
    val div = functions.find { it.name == "div" }

    plus?.call(calculator)
    minus?.call(calculator, 5)
    div?.isAccessible = true

    div?.call(calculator)
    //functions.forEach { println(it.name) }
}

class Calculator() {
    fun plus() = println("plus")
    fun minus(number: Int) = println("minus $number")
    fun multi() = println("multi")
    private fun div() = println("division")
}

class Dummy(private var dummyString: String) {

    fun dummyFunction1() = println("The DummyString is $dummyString")

    fun dummyFunction1(dummyArg: Int) = println("The DummyArg is $dummyArg")

    private fun dummyFunction() = println("private dummy function invoked")
}