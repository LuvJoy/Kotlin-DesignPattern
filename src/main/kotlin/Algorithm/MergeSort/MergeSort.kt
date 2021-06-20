package Algorithm.MergeSort

fun main() {
    var numbers = listOf<Int> (1, 3, 10, 4, 5, 6, 7, 2, 3)
    var sortedNumbers = mergeSort(numbers)

    print(sortedNumbers)
}

fun mergeSort(list: List<Int>): List<Int> {
    if (list.size == 1) {
        return list
    }

    val middleIdx = list.size / 2
    val leftList = list.subList(0, middleIdx)
    val rightList = list.subList(middleIdx, list.size)

    return merge(mergeSort(leftList), mergeSort(rightList))
}

fun merge(left: List<Int>, right: List<Int>): List<Int> {
    var leftIdx = 0
    var rightIdx = 0
    var mergeList = mutableListOf<Int>()

    while(leftIdx < left.size && rightIdx < right.size) {
        if(left[leftIdx] <= right[rightIdx]) {
            mergeList.add(left[leftIdx])
            leftIdx ++
        } else {
            mergeList.add(right[rightIdx])
            rightIdx ++
        }
    }

    while(leftIdx < left.size) {
        mergeList.add(left[leftIdx])
        leftIdx ++
    }

    while(rightIdx < right.size) {
        mergeList.add(right[rightIdx])
        rightIdx ++
    }

    return mergeList
}