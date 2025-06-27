### LeetCode Notebook: 26. Remove Duplicates from Sorted Array

---

#### **1. The Problem**

*   **Goal:** Given a **sorted** array `nums`, remove the duplicates **in-place** so that each unique element appears only once.
*   **Return Value:** Return `k`, the number of unique elements.
*   **Key Constraint:** The relative order of the unique elements must be preserved. The elements beyond `k` do not matter.

---

#### **2. The Core Idea: Two-Pointer Technique (Read/Write)**

This problem is a perfect application of the **Read/Write Pointer** pattern. The fact that the array is sorted is the key piece of information we can leverage.

*   **Write Pointer (`k`):** Tracks the position where the *next unique element* should be placed. It also serves as the final count of unique elements.
*   **Read Pointer (`i`):** Scans through the array to find new unique elements.

**The Key Question:** How do we identify a "new" unique element in a sorted array? An element is unique if it is **different from the element immediately preceding it**.

---

#### **3. Step-by-Step Logic**

1.  **Handle Edge Cases:** A good habit is to check for an empty array. If `nums` is empty, there are `0` unique elements, so we can return `0`. (Note: The problem constraints say the array will have at least one element, but this is still good practice).

2.  **Initialize `k`:** We know the first element (`nums[0]`) is always unique in its own right. So, we can initialize our "write" pointer `k` to `1`, ready for the next unique element.

3.  **Loop Through the Array (starting at the second element):** Our "read" pointer `i` can start at index `1` because we've already accounted for the element at index `0`. We loop until the end of the array.

4.  **Check the Condition:** Inside the loop, we check if the current element `nums[i]` is different from the one just before it, `nums[i - 1]`. This tells us if we've found a new unique number.

5.  **Perform the Actions:** If the condition is true, we have a new unique number. We perform two actions:
    *   **Action A (Copy):** Copy the new unique element from the "read" position `i` to the "write" position `k`.
    *   **Action B (Increment):** Move the "write" pointer `k` to the next available slot.

6.  **Return `k`:** After the loop finishes, `k` holds the total count of the unique elements we have kept.

---

#### **4. Final Kotlin Code**

```kotlin
fun removeDuplicates(nums: IntArray): Int {
    // Constraints guarantee a non-empty array.
    if (nums.isEmpty()) {
        return 0
    }

    // 'k' is the write pointer, starts at 1
    // because nums[0] is always kept.
    var k = 1

    // 'i' is the read pointer, starts at the second element.
    for (i in 1 until nums.size) {
    
        // If we find a new unique number...
        if (nums[i] != nums[i - 1]) {
        
            // ...copy it to the write position...
            nums[k] = nums[i]
            
            // ...and move the write pointer.
            k++
        }
    }
    
    return k
}
```

