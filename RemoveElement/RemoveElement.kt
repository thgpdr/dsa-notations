// LeetCode Problem: Remove Element
// Given an integer array nums and an integer val, remove all occurrences of val
// in nums in-place. The order of the elements may be changed. Then return the
// number of elements in nums which are not equal to val.

// Consider the number of elements in nums which are not equal to val be k,
// to get accepted, you need to do the following things:
// - Change the array nums such that the first k elements of nums contain the
//   elements which are not equal to val.
// - The remaining elements of nums are not important as well as the size of nums.
// - Return k.

/**
 * Modifies the array nums in-place to remove all instances of `val`
 * and returns the new length of the array.
 * @param nums The input integer array.
 * @param `val` The value to remove. `val` is a keyword in Kotlin, so it's backticked.
 * @return The number of elements in nums which are not equal to `val`.
 */
fun removeElement(nums: IntArray, `val`: Int): Int {
    // Initialize k as the "write" pointer. It represents the index where the next
    // element not equal to `val` should be placed. It also counts the valid elements.
    var k = 0

    // Iterate through the array with 'i' as the "read" pointer.
    for (i in nums.indices) {
        // If the element at the current "read" position is not the value to remove...
        if (nums[i] != `val`) {
            // ...then we copy this "good" element to the "write" position.
            nums[k] = nums[i]
            // And then we move the "write" pointer forward to the next available slot.
            k++
        }
    }

    // After the loop, k is the total count of elements not equal to `val`.
    // The first k elements of `nums` now hold all the desired values.
    return k
}

fun main() {
    println("LeetCode: Remove Element Problem in Kotlin")

    // Example 1:
    val nums1 = intArrayOf(3, 2, 2, 3)
    val val1 = 3
    println("Input: nums = ${nums1.contentToString()}, val = $val1")
    val k1 = removeElement(nums1, val1)
    println("Output: k = $k1, nums = ${nums1.sliceArray(0 until k1).contentToString()} (actual nums: ${nums1.contentToString()})")

    // Example 2:
    val nums2 = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
    val val2 = 2
    println("Input: nums = ${nums2.contentToString()}, val = $val2")
    val k2 = removeElement(nums2, val2)
    println("Output: k = $k2, nums = ${nums2.sliceArray(0 until k2).contentToString()} (actual nums: ${nums2.contentToString()})")
} 