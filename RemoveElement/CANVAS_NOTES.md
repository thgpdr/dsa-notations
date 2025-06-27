### LeetCode Notebook: 27. Remove Element

---

#### **1. The Problem**

*   **Goal:** Given an unsorted array `nums` and a value `val`, remove all instances of `val` **in-place**.
*   **Return Value:** Return `k`, the number of elements remaining in the array that are not equal to `val`.
*   **Key Constraint:** The final array must have the `k` "good" elements at the beginning. The order of these `k` elements *does not* matter.

---

#### **2. The Core Idea: Two-Pointer Technique (Read/Write)**

This problem is a classic example of the **Read/Write Pointer** pattern.

*   **Write Pointer (`k`):** This pointer keeps track of where the *next valid element* should be written. It starts at `0` and only moves when we find a valid element. It also naturally becomes the final count of valid elements.
*   **Read Pointer (`i`):** This is our standard loop index. Its only job is to iterate through the entire array from start to finish and inspect every single element.

---

#### **3. Step-by-Step Logic**

1.  **Initialize `k`:** Start the "write" pointer `k` at `0`. This signifies that we have found `0` valid elements so far, and the first valid one should be placed at index `0`.

2.  **Loop Through the Array:** Create a `for` loop where the "read" pointer `i` goes through every index of `nums`.

3.  **Check the Condition:** Inside the loop, for each element `nums[i]`, check if it's a "good" element (i.e., one we want to keep). The condition is simply `nums[i] != val`.

4.  **Perform the Actions:** If the condition is true, we must do two things:
    *   **Action A (Copy):** Copy the "good" element from the "read" position `i` to the "write" position `k`.
    *   **Action B (Increment):** Move the "write" pointer `k` to the next available slot.

5.  **Return `k`:** After the loop has checked every element, `k` will hold the exact count of the elements we kept.

---

#### **4. Final Kotlin Code**

```kotlin
fun removeElement(nums: IntArray, `val`: Int): Int {
    // Initialize k as the "write" pointer. It represents the index where the next
    // element not equal to `val` should be placed.
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
    return k
}
```

---

#### **5. Follow-up Discussion: What if the array were sorted?**

*   **Key Insight:** If the array is sorted, all occurrences of `val` are grouped together.
*   **Different Algorithm:** We no longer need to check every element. We can use **Binary Search** (O(log N)) to find the start of the block of `val`s, then shift the remaining elements.
*   **Benefit:** This approach is more complex to implement but leverages the sorted property, which is a key skill to demonstrate. It's much faster if the task is only to count `k`. 