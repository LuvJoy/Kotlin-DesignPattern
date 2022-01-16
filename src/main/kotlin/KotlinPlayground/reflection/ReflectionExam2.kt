package KotlinPlayground.reflection

import kotlin.reflect.KMutableProperty

fun main() {
    val human = Human(id = 0, name = "John")

    val refProperty = human::weight


    println("isLateinit : " + refProperty.isLateinit)
    println("isConst : " + refProperty.isConst)

    refProperty.set(15)
    println(refProperty.get())

    println(human.weight)
}

private data class Human(
    val id: Int,
    val name: String
) {
    var weight: Int = 0
        set(value) {
            field = value

            println("$field Changed")
        }

    fun sayMyName() {
        println(name)
    }

    fun learn(content: String) {
        println("I Learned $content")
    }
}