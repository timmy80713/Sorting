/**
 * https://en.wikipedia.org/wiki/Heapsort
 */
class Solution {
    fun sort(nums: IntArray): IntArray {
        for (i in nums.size / 2 - 1 downTo 0) {
            maxHeapify(nums, i, nums.size)
        }
        for (i in nums.size - 1 downTo 1) {
            val temp = nums[i]
            nums[i] = nums[0]
            nums[0] = temp
            maxHeapify(nums, 0, i)
        }
        return nums
    }

    private fun maxHeapify(sources: IntArray, startIndex: Int, size: Int) {
        var parentIndex = startIndex
        var childIndex = parentIndex * 2 + 1
        while (childIndex < size) {
            if (childIndex + 1 < size && sources[childIndex] < sources[childIndex + 1]) {
                childIndex++
            }
            if (sources[parentIndex] > sources[childIndex]) {
                return
            } else {
                val temp = sources[parentIndex]
                sources[parentIndex] = sources[childIndex]
                sources[childIndex] = temp
                parentIndex = childIndex
                childIndex = parentIndex * 2 + 1
            }
        }
    }
}