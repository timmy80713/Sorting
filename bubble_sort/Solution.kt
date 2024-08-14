/**
 * https://en.wikipedia.org/wiki/Bubble_sort
 */
class Solution {
    fun sort(nums: IntArray): IntArray {
        for (i in 0 until nums.size - 1) {
            for (j in nums.size - 1 downTo i + 1) {
                val rightValue = nums[j]
                val leftValue = nums[j - 1]
                if (rightValue < leftValue) {
                    nums[j - 1] = rightValue
                    nums[j] = leftValue
                }
            }
        }
        return nums
    }
}