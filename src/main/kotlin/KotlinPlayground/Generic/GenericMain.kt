package KotlinPlayground.Generic

fun main() {
    val calculator = Calculator()

    println(calculator.plusNumber<Int>(12, 2))      // 14
    println(calculator.plusNumber(1.5, 5.44))  // 6.94
    //println(calculator.plusNumber("dsfd", "sdfsdf"))  // compile error

    // reified를 사용한 메서드 오버로딩
    val result : Int = getMessage(10)
    println("result: $result")

    val resultString : String = getMessage(100)
    println("result: $resultString")
}

// reified를 사용하지 않을 때
fun <T> printGenerics(value: T, classType: Class<T>) {
    when (classType) {
        String::class.java -> {
            println("String : $value")
        }
        Int::class.java -> {
            println("Int : $value")
        }
    }
}

// reified를 사용하지 않을 때 오버로딩 (컴파일 에러 발생)
fun getMessageWithOutReified(number: Int): String {
    return "The number is : $number"
}

fun getMessageWithOutReified(number: Int): Int {
    return number
}

// reified를 사용할 때 오버로딩
inline fun<reified T> getMessage(number: Int): T {
    return when (T::class) {
        String::class -> "The number is : $number" as T
        Int::class -> number as T
        else -> "Not string, Not Integer" as T
    }
}