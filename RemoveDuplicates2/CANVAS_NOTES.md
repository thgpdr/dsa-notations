# LeetCode 80: Remove Duplicates from Sorted Array II

## Problem Statement

Given a sorted integer array `nums`, remove the duplicates in-place such that each unique element appears **at most twice**. The relative order of the elements should be kept the same.

Return `k`, the number of elements after removing the duplicates.

## Our Approach: The Read/Write Pointer (Two-Pointer) Method

This problem is a direct extension of "Remove Duplicates from Sorted Array I". We can adapt the same two-pointer technique.

-   **`i` (the read pointer)**: Iterates through the original array from the beginning to the end. Its job is to find elements that should be kept.
-   **`k` (the write pointer)**: Points to the next position in the array where a "kept" element should be placed. It effectively tracks the size of the valid part of the array.

### Core Logic

1.  **Edge Case**: If the array has 2 or fewer elements (`nums.size <= 2`), no duplicates need to be removed according to the "at most twice" rule. We can simply return the original size.

2.  **Initialization**:
    *   We can start checking for the "at most twice" rule from the third element.
    *   We initialize both the read pointer `i` and the write pointer `k` to `2`.

3.  **Iteration**: The read pointer `i` scans the array from index 2 onwards. In each step, we compare the current element `nums[i]` with the element at `nums[k - 2]`.

    *   `nums[k - 2]` is the last element in our valid subarray that *could* be a duplicate of `nums[i]`. For example, if our valid portion is `[1, 1, ...]`, `k` is 2, so `k-2` is 0. The element is `nums[0]`, which is 1.

4.  **The Condition**: `if (nums[i] != nums[k - 2])`
    *   If this condition is true, it means `nums[i]` is NOT a third duplicate of the element at `nums[k-1]` and `nums[k-2]`.
    *   Therefore, we should keep `nums[i]`.

5.  **The "Keep" Action**:
    *   Copy the value: `nums[k] = nums[i]`
    *   Increment the write pointer: `k++`

6.  **Return Value**: After the loop finishes, `k` is the length of the modified array with at most two duplicates for each element. We return `k`.

### Final Kotlin Code

```kotlin
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
``` 