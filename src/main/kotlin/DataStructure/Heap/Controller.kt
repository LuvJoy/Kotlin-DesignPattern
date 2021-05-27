package DataStructure.Heap

fun main() {
    val heap = MaxHeap()

    while (true) {
        println("명령어를 입력해주세요")
        val command = readLine()!!.toInt()
        when (command) {
            1 -> {
                println("삽입할 숫자 입력")
                val number = readLine()!!.toInt()
                heap.insert(number)
            }
            2 -> {
                println("삭제된 숫자 : ${heap.delete()}")
            }
            3 -> {
                println("조회")
                heap.print()
            }
            else -> {
                print("종료합니다.")
            }
        }
    }
}