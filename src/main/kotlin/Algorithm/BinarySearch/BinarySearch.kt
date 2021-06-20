package Algorithm.BinarySearch

fun main() {
    val numbers = intArrayOf(1, 2, 3, 4, 5)
    println(binarySearch(numbers, 4))
    println(binarySearch(numbers, 6))
}

fun binarySearch(numbers: IntArray, findNumber: Int): Boolean {
    var low = 0
    var high = numbers.size - 1

    var stepCount = 0
    while (low <= high) {
        val mid = (low + high) / 2
        val guess = numbers[mid]
        stepCount++

        when {
            guess == findNumber -> {
                return true
            }
            guess > findNumber -> high = mid - 1
            else -> low = mid + 1
        }
    }

    return false
}