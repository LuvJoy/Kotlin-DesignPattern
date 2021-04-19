package DesignPattern.StrategyPattern

fun main() {
    val jetRobot = Robot("전투기", GunAttack(), MoveByWing())
    val punchRobot = Robot("태권브이", PunchAttack(), MoveByLeg())

    jetRobot.attack()
    jetRobot.move()

    punchRobot.attack()
    punchRobot.move()
}