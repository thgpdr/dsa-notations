package main

import "fmt"

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

// removeElement modifies the array nums in-place and returns k.
func removeElement(nums []int, val int) int {
	// We'll implement the two-pointer logic here step-by-step
	return 0 // Placeholder
}

func main() {
	fmt.Println("LeetCode: Remove Element Problem in Go")

	// Example 1:
	// nums1 := []int{3, 2, 2, 3}
	// val1 := 3
	// fmt.Printf("Input: nums = %v, val = %d\n", nums1, val1)
	// k1 := removeElement(nums1, val1)
	// fmt.Printf("Output: k = %d, nums = %v (actual nums: %v)\n", k1, nums1[:k1], nums1)

	// Example 2:
	// nums2 := []int{0, 1, 2, 2, 3, 0, 4, 2}
	// val2 := 2
	// fmt.Printf("Input: nums = %v, val = %d\n", nums2, val2)
	// k2 := removeElement(nums2, val2)
	// fmt.Printf("Output: k = %d, nums = %v (actual nums: %v)\n", k2, nums2[:k2], nums2)
}
