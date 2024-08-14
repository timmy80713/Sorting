/**
 * https://en.wikipedia.org/wiki/Selection_sort
 */
class Solution {
    fun sort(nums: IntArray): IntArray {
        for (i in 0 until nums.size) {
            var minIndex = i
            for (j in i + 1 until nums.size) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j
                }
            }
            if (minIndex != i) {
                val temp = nums[i]
                nums[i] = nums[minIndex]
                nums[minIndex] = temp
            }
        }
        return nums
    }
}