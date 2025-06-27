// LeetCode Problem: 80. Remove Duplicates from Sorted Array II
// Given an integer array nums sorted in non-decreasing order, remove some
// duplicates in-place such that each unique element appears at most twice.
// The relative order of the elements should be kept the same.

// If there are k elements after removing the duplicates, then the first k
// elements of nums should hold the final result. It does not matter what you
// leave beyond the first k elements.

// Return k after placing the final result in the first k slots of nums.

/**
 * Removes duplicates from a sorted array in-place such that each unique
 * element appears at most twice.
 * @param nums The input sorted integer array.
 * @return The number of elements after removing duplicates (k).
 */
fun removeDuplicates(nums: IntArray): Int {
    if (nums.size <= 2) {
        return nums.size
    }

    var k = 2
    for (i in 2 until nums.size) {
        if (nums[i] != nums[k - 2]) {
            nums[k] = nums[i]
            k++
        }
    }
    return k
}

fun main() {
    println("LeetCode: Remove Duplicates from Sorted Array II Problem in Kotlin")

    // Example 1:
    val nums1 = intArrayOf(1, 1, 1, 2, 2, 3)
    println("\nInput: nums = ${nums1.contentToString()}")
    val k1 = removeDuplicates(nums1)
    println("Output: k = $k1, nums = ${nums1.sliceArray(0 until k1).contentToString()}")

    // Example 2:
    val nums2 = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
    println("\nInput: nums = ${nums2.contentToString()}")
    val k2 = removeDuplicates(nums2)
    println("Output: k = $k2, nums = ${nums2.sliceArray(0 until k2).contentToString()}")
} 