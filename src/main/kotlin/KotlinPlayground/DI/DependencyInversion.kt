package KotlinPlayground.DI

fun main() {
    val foodDeliveryMan = DeliveryMan(items = PackageInjector.provideFoodPackage())
    val furnitureDeliveryMan = DeliveryMan(items = PackageInjector.provideFoodPackage())
}

class DeliveryMan(
    val items: List<DeliveryPackage>
){
    //...
}

interface DeliveryPackage {
    val name: String
    val cost: Int
}

class Food(
    override val name: String,
    override val cost: Int
) : DeliveryPackage

class Furniture(
    override val name: String,
    override val cost: Int
) : DeliveryPackage

object PackageInjector {

    fun provideFoodPackage(): List<DeliveryPackage> {
        return listOf<Food>()
    }

    fun provideFurniturePackage(): List<Furniture> {
        return listOf<Furniture>()
    }

}

