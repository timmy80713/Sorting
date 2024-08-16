/**
 * https://en.wikipedia.org/wiki/Quicksort
 */
class Solution {
    fun sort(nums: IntArray): IntArray {
        quickSort(nums, 0, nums.size - 1)
        return nums
    }

    private fun quickSort(nums: IntArray, startIndex: Int, endIndex: Int) {
        val pivot = nums[startIndex]
        var leftIndex = startIndex
        var rightIndex = endIndex + 1

        do {
            do leftIndex++ while (leftIndex < nums.size && nums[leftIndex] < pivot)
            do rightIndex-- while (rightIndex >= 0 && nums[rightIndex] > pivot)
            if (leftIndex < rightIndex) {
                val rightNum = nums[rightIndex]
                nums[rightIndex] = nums[leftIndex]
                nums[leftIndex] = rightNum
            }
        } while (leftIndex < rightIndex)

        nums[startIndex] = nums[rightIndex]
        nums[rightIndex] = pivot

        if (startIndex < rightIndex - 1) quickSort(nums, startIndex, rightIndex - 1)
        if (rightIndex + 1 < endIndex) quickSort(nums, rightIndex + 1, endIndex)
    }
}