package DataStructure.Heap

class MaxHeap() {

    private val heap: ArrayList<Int> = arrayListOf()

    init {
        heap.add(Int.MAX_VALUE) // index를 1부터 사용하기 위함
    }

    fun print() {
        for(idx in 1 until heap.size) {
            print("${heap[idx]} ")
        }
        println()
    }

    fun insert(value: Int) {
        heap.add(value)
        var index = heap.lastIndex

        while(index > 1 && heap[index/2] < heap[index]) {
            println("swap")
            swap(index, index/2)

            index /= 2
        }
    }

    fun delete(): Int {
        if(heap.lastIndex < 1) {
            return 0
        }

        val deletedItem = heap[FIRST]
        heap[FIRST] = heap.lastIndex
        heap.remove(heap.lastIndex)

        var index = 1
        while(index * 2 < heap.size) {
            // 우선 노드의 왼쪽 인덱스와 키값을 저장한다.
            var max = heap[index * 2]
            var maxIndex = index * 2

            // 오른쪽 노드가 존재하는지와 왼쪽 값과 오른쪽 값을 비교하고 오른쪽이 더 크다면
            // 오른쪽 노드의 인덱스와 키값을 넣어준다.
            if(index * 2 + 1 <heap.size && max < heap[index * 2 + 1]) {
                max = heap[index * 2 + 1]
                maxIndex = index * 2 + 1
            }

            // 루트노드가 양쪽보다 클 경우 따로 스왑이 필요가 없다.
            if(heap[index] > max) {
                break
            }

            swap(index, maxIndex)
            index = maxIndex
        }
        return deletedItem
    }

    private fun swap(from: Int, to: Int) {
        val temp = heap[from]
        heap[from] = heap[to]
        heap[to] = temp
    }

    companion object {
        const val FIRST = 1
    }
}