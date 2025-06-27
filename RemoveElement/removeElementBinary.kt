// LeetCode Problem: Remove Element (Optimized for a Sorted Array)
// This file demonstrates how to solve the problem if we can assume the
// input array `nums` is already sorted.

/**
 * Finds the first index of a target value in a sorted array.
 * Uses a modified binary search.
 * @return The index of the first occurrence, or -1 if not found.
 */
fun findFirstOccurrence(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    var result = -1

    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            nums[mid] == target -> {
                // We found an occurrence, but it might not be the first one.
                // Store this index and keep looking to the left.
                result = mid
                high = mid - 1
            }
            nums[mid] < target -> low = mid + 1
            else -> high = mid - 1
        }
    }
    return result
}

/**
 * Solves the "Remove Element" problem for a SORTED array using binary search.
 * @param nums The input SORTED integer array.
 * @param `val` The value to remove.
 * @return The number of elements in nums which are not equal to `val`.
 */
fun removeElementBinary(nums: IntArray, `val`: Int): Int {
    // Step 1: Find the first occurrence of `val` using binary search.
    val firstIndex = findFirstOccurrence(nums, `val`)

    // If `val` is not found in the array, no elements need to be removed.
    if (firstIndex == -1) {
        return nums.size
    }

    // Step 2: Find the first element *after* the block of `val`s.
    var readIndex = firstIndex
    while (readIndex < nums.size && nums[readIndex] == `val`) {
        readIndex++
    }
    // Now, `readIndex` is at the start of the elements we need to shift left.

    // Step 3: Shift the rest of the array to the left.
    // `writeIndex` starts where the `val` block began.
    var writeIndex = firstIndex
    while (readIndex < nums.size) {
        nums[writeIndex] = nums[readIndex]
        writeIndex++
        readIndex++
    }

    // `writeIndex` is now the new length `k` of the array.
    return writeIndex
}

fun main() {
    println("LeetCode: Remove Element (Sorted Array / Binary Search) in Kotlin")

    // Example 1:
    val nums1 = intArrayOf(2, 2, 3, 3) // Sorted version of the original example
    val val1 = 3
    println("\nInput: nums = ${nums1.contentToString()}, val = $val1")
    val k1 = removeElementBinary(nums1, val1)
    println("Output: k = $k1, nums = ${nums1.sliceArray(0 until k1).contentToString()} (actual nums: ${nums1.contentToString()})")

    // Example 2:
    val nums2 = intArrayOf(0, 0, 1, 2, 2, 2, 3, 4) // Sorted version
    val val2 = 2
    println("\nInput: nums = ${nums2.contentToString()}, val = $val2")
    val k2 = removeElementBinary(nums2, val2)
    println("Output: k = $k2, nums = ${nums2.sliceArray(0 until k2).contentToString()} (actual nums: ${nums2.contentToString()})")

    // Example 3: Value not in array
    val nums3 = intArrayOf(1, 2, 3, 4, 5)
    val val3 = 6
    println("\nInput: nums = ${nums3.contentToString()}, val = $val3")
    val k3 = removeElementBinary(nums3, val3)
    println("Output: k = $k3, nums = ${nums3.sliceArray(0 until k3).contentToString()} (actual nums: ${nums3.contentToString()})")
} 