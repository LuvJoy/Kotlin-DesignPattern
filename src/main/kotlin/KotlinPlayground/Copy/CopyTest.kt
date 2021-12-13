package KotlinPlayground.Copy

fun main() {
    deepCopy()
}

private fun shallowCopy() {
    val roboA = Robot("RoboA", 10)
    val roboB = roboA

    roboB.name = "roboB"

    println("[RoboA name] : ${roboA.name} [RoboB name] : ${roboB.name}")
    println("[RoboA Address] : ${roboA.toString()} [RoboB Address] : ${roboB.toString()}")
}

class Robot(
    var name: String,
    val power: Int
)

private fun deepCopy() {
    val roboA = Robot2("RoboA", 10)
    val roboB = roboA.copy()

    roboB.name = "roboB"

    println("[RoboA name] : ${roboA.name} [RoboB name] : ${roboB.name}")
}

data class Robot2(
    var name: String,
    val power: Int
)



