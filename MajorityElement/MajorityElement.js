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
