### LeetCode Notebook: Remove Element (Optimized for Sorted Array)

---

#### **1. The Problem (Special Case)**

*   **Goal:** Solve the "Remove Element" problem with the crucial assumption that the input array `nums` is **already sorted**.
*   **Key Insight:** If the array is sorted, all occurrences of the value `val` that we want to remove will be grouped together in a single, contiguous block.

---

#### **2. The Core Idea: Binary Search + Shift**

Instead of checking every element one-by-one, we can leverage the sorted property to be more efficient.

1.  **Find the Block:** Use a modified Binary Search to find the starting index of the block of `val`s. This is very fast (O(log N) time).
2.  **Shift the Rest:** Once the block is located, shift all the elements that appear *after* the block to the left, overwriting the `val`s.

---

#### **3. Step-by-Step Logic**

1.  **Find First Occurrence:** Use a helper function with a modified binary search to find the index of the *very first* `val` in the array. If no `val` is found, then no elements need to be removed, and we can return the array's original length.

2.  **Find End of Block:** Once `firstIndex` is found, start a "read" pointer `readIndex` at that position. Loop forward as long as the elements are equal to `val`. This will find the end of the block to be removed.

3.  **Shift Elements:** Start a "write" pointer `writeIndex` at `firstIndex`. Loop while the `readIndex` is not at the end of the array. In each step:
    *   Copy the element from the `readIndex` to the `writeIndex` (`nums[writeIndex] = nums[readIndex]`).
    *   Increment both `writeIndex` and `readIndex`.

4.  **Return New Length:** After the shifting is done, the `writeIndex` will be at the new end of the valid portion of the array. Its value is `k`, the new length.

---

#### **4. Final Kotlin Code**

```kotlin
/**
 * Finds the first index of a target value in a sorted array.
 */
fun findFirstOccurrence(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    var result = -1

    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            nums[mid] == target -> {
                result = mid
                high = mid - 1 // Keep looking left
            }
            nums[mid] < target -> low = mid + 1
            else -> high = mid - 1
        }
    }
    return result
}

/**
 * Solves the "Remove Element" problem for a SORTED array.
 */
fun removeElementBinary(nums: IntArray, `val`: Int): Int {
    // Step 1: Find the first occurrence.
    val firstIndex = findFirstOccurrence(nums, `val`)
    if (firstIndex == -1) {
        return nums.size
    }

    // Step 2: Find the end of the block of `val`s.
    var readIndex = firstIndex
    while (readIndex < nums.size && nums[readIndex] == `val`) {
        readIndex++
    }

    // Step 3: Shift the remaining elements.
    var writeIndex = firstIndex
    while (readIndex < nums.size) {
        nums[writeIndex] = nums[readIndex]
        writeIndex++
        readIndex++
    }

    // `writeIndex` is the new length `k`.
    return writeIndex
}
``` 