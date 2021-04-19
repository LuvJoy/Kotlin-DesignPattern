package DesignPattern.StrategyPattern

interface AttackStrategy {
    fun attack()
}

class GunAttack: AttackStrategy {
    override fun attack() {
        println("총을 쏜다.")
    }
}

class PunchAttack: AttackStrategy {
    override fun attack() {
        println("주먹으로 친다.")
    }
}

class BackAttack: AttackStrategy {
    override fun attack() {
        println("뒤통수를 친다.")
    }
}
