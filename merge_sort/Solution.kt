/**
 * https://en.wikipedia.org/wiki/Merge_sort
 */
class Solution {
    fun sort(nums: IntArray): IntArray {
        return sort(nums, 0, nums.size - 1)
    }

    private fun sort(nums: IntArray, startIndex: Int, endIndex: Int): IntArray {
        if (startIndex == endIndex) return intArrayOf(nums[startIndex])
        val middleIndex = (startIndex + endIndex) / 2
        val leftNums = sort(nums, startIndex, middleIndex)
        val rightNums = sort(nums, middleIndex + 1, endIndex)
        return merge(leftNums, rightNums)
    }

    private fun merge(firstNums: IntArray, secondNums: IntArray): IntArray {
        val result = IntArray(firstNums.size + secondNums.size)

        var firstIndex = 0
        var secondIndex = 0
        var resultIndex = 0

        while (firstIndex < firstNums.size && secondIndex < secondNums.size) {
            val firstNum = firstNums[firstIndex]
            val secondNum = secondNums[secondIndex]
            if (firstNum < secondNum) {
                result[resultIndex] = firstNum
                firstIndex++
            } else {
                result[resultIndex] = secondNum
                secondIndex++
            }
            resultIndex++
        }

        while (firstIndex < firstNums.size) {
            result[resultIndex++] = firstNums[firstIndex++]
        }

        while (secondIndex < secondNums.size) {
            result[resultIndex++] = secondNums[secondIndex++]
        }

        return result
    }
}