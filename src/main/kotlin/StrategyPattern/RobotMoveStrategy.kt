package StrategyPattern

interface MoveStrategy {
    fun move()
}

class MoveByLeg(): MoveStrategy {
    override fun move() {
        println("다리로 이동")
    }
}

class MoveByWheel(): MoveStrategy {
    override fun move() {
        println("바퀴로 이동")
    }
}

class MoveByWing(): MoveStrategy {
    override fun move() {
        println("날개로 이동")
    }
}
