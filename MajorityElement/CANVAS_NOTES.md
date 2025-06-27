### LeetCode Notebook: 169. Majority Element

---

#### **1. The Problem**

* **Goal:** Given an array `nums` of size `n`, return the **majority element**.
* **Definition:** The majority element is the element that appears **more than $\lfloor n / 2 \rfloor$ times**.
* **Key Constraints:** You can assume that the array is non-empty and that the majority element always exists in the array.

---

#### **2. The Core Idea: Frequency Map (Hash Map)**

This problem can be efficiently solved by keeping track of the **frequency** of each number in the array. Since we need to identify an element that appears *more than half* the time, we can stop as soon as any element's count exceeds this threshold. A **Hash Map** (or a plain JavaScript object) is the ideal data structure for this.

* **How it works:** Each unique number in the array becomes a **key** in our map, and its **value** stores how many times that number has appeared so far.

---

#### **3. Step-by-Step Logic**

1.  **Calculate Threshold:** First, determine the `majorityThreshold`, which is `n / 2` (where `n` is the length of the `nums` array). Any number whose count surpasses this value is our majority element.

2.  **Initialize Frequency Map:** Create an empty JavaScript object, `counts`, to act as our frequency map.

3.  **Iterate and Count:** Loop through each `num` in the `nums` array:
    * For each `num`, increment its count in the `counts` map. If `num` isn't already a key, initialize its count to `1`. (A common JS trick for this is `counts[num] = (counts[num] || 0) + 1;`).
    * **Early Exit Check:** Immediately after updating `num`'s count, check if `counts[num]` is greater than `majorityThreshold`. If it is, we've found our majority element, so we can return `num` right away.

4.  **Guaranteed Return:** Because the problem guarantees that a majority element *always exists*, our loop will always find and return it, so no code outside the loop's check is strictly necessary for this specific problem.

---

#### **4. Final JavaScript Code**

```javascript
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    const n = nums.length;
    // Calculate the threshold for what constitutes a majority.
    // The majority element must appear more than n/2 times.
    const majorityThreshold = n / 2;

    // Use a JavaScript object as a hash map to store the frequency of each number.
    const counts = {};

    // Iterate through each number in the input array.
    for (let i = 0; i < n; i++) {
        const num = nums[i];

        // Increment the count for the current number.
        // If the number hasn't been seen before, its count starts at 0, then becomes 1.
        // Otherwise, its existing count is incremented.
        counts[num] = (counts[num] || 0) + 1;

        // Check if the current number's count has exceeded the majority threshold.
        // If it has, this is our majority element, and we can return it immediately
        // as the problem guarantees one exists.
        if (counts[num] > majorityThreshold) {
            return num;
        }
    }

    // This part of the code should theoretically never be reached
    // given the problem constraints (a majority element is guaranteed to exist).
    // It's a fallback or for scenarios where the guarantee doesn't apply.
    return -1; // Or throw an error, depending on desired behavior for invalid inputs.
};
