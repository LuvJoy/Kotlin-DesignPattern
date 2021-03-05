package StrategyPattern

class Robot(
    private var name: String,
    private var attackStrategy: AttackStrategy,
    private var moveStrategy: MoveStrategy
) {
    fun attack() {
        attackStrategy.attack()
    }
    fun move() {
        moveStrategy.move()
    }
}