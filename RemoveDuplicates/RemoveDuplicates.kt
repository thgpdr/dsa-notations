// LeetCode Problem: 26. Remove Duplicates from Sorted Array
// Given an integer array nums sorted in non-decreasing order, remove the
// duplicates in-place such that each unique element appears only once. The
// relative order of the elements should be kept the same. Then return the
// number of unique elements in nums.

/**
 * Removes duplicates from a sorted array in-place.
 * @param nums The input sorted integer array.
 * @return The number of unique elements (k).
 */
fun removeDuplicates(nums: IntArray): Int {
    // This check is good practice, though constraints say nums is never empty.
    // If it were empty, there are 0 unique elements.
    if (nums.isEmpty()) {
        return 0
    }

    // Now, let's initialize our "write" pointer, k.
    // Since the first element is always unique by itself,
    // we can start our "write" pointer at 1.
    var k = 1

    // ... loop will go here ...
    for (i in 1 until nums.size) {
        if (nums[i] != nums[i - 1]) {
            nums[k] = nums[i]
            k++
        }
    } 
    
    return k // At the end, we'll return the final count.
}

fun main() {
    println("LeetCode: Remove Duplicates from Sorted Array Problem in Kotlin")

    // Example 1:
    val nums1 = intArrayOf(1, 1, 2)
    println("\nInput: nums = ${nums1.contentToString()}")
    val k1 = removeDuplicates(nums1)
    println("Output: k = $k1, nums = ${nums1.sliceArray(0 until k1).contentToString()}")

    // Example 2:
    val nums2 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    println("\nInput: nums = ${nums2.contentToString()}")
    val k2 = removeDuplicates(nums2)
    println("Output: k = $k2, nums = ${nums2.sliceArray(0 until k2).contentToString()}")
} 