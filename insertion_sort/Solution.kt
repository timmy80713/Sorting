/**
 * https://en.wikipedia.org/wiki/Insertion_sort
 */
class Solution {
    fun sort(nums: IntArray): IntArray {
        nums.forEachIndexed { index, value ->
            var position = index
            while (position > 0 && nums[position - 1] > nums[position]) {
                nums[position] = nums[position - 1]
                nums[position - 1] = value
                position--
            }
        }
        return nums
    }
}