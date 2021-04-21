package DesignPattern.BuilderPattern

class Student private constructor(
    val name: String?,
    val age: Int
) {

    class Builder {
        private var name: String? = null
        private var age: Int = 0

        fun name(name: String): Builder {
            this.name = name
            return this
        }

        fun age(age: Int): Builder {
            this.age = age
            return this
        }

        fun build() = Student(name, age)
    }
}

fun main() {
    val minsoo = Student.Builder()
        .name("김민수")
        .age(7)
        .build()

    // 이름 : 김민수 / 나이 : 7
    println("이름 : ${minsoo.name} / 나이 : ${minsoo.age}")
}