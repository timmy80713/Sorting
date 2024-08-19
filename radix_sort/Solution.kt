import java.util.*

/**
 * https://en.wikipedia.org/wiki/Radix_sort
 */
class Solution {
    fun sort(nums: IntArray): IntArray {
        if (nums.isEmpty()) return nums

        val buckets = Array(10) { ArrayDeque<Int>() }

        var maxNum = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] > maxNum) {
                maxNum = nums[i]
            }
        }

        val digitCount = maxNum.toString().length

        var round = 1
        while (round <= digitCount) {
            for (i in 0 until nums.size) {
                val num = nums[i]
                var numString = num.toString()
                if (numString.length < round) {
                    for (j in 0 until round - numString.length) {
                        numString = "0" + numString
                    }
                }
                buckets[numString[numString.length - round].toString().toInt()].add(num)
            }

            var index = 0
            for (i in 0 until buckets.size) {
                val queue = buckets[i]
                while (queue.size != 0) {
                    nums[index++] = queue.pop()
                }
            }
            round++
        }

        return nums
    }
}