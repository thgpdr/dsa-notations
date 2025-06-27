### LeetCode Notebook: 7. Reverse Integer

---

#### **1. The Problem**

*   **Goal:** Given a 32-bit signed integer, reverse its digits.
*   **Return Value:** Return the reversed integer.
*   **Key Constraint:** If the reversed integer goes outside the 32-bit signed integer range (`[-2^31, 2^31 - 1]`), return `0`. We must assume the environment cannot store 64-bit integers.

---

#### **2. The Core Idea: Numerical Pop and Push**

The most robust way to solve this is by mathematically "popping" the last digit off the number and "pushing" it onto a new reversed number. This avoids string conversions and directly handles the numerical nature of the problem.

*   **Pop Digit:** Use the modulo operator (`% 10`) to get the last digit.
*   **Push Digit:** Multiply the current reversed number by 10 and add the new digit.
*   **Remove Digit:** Use integer division (`/ 10`) to remove the last digit from the original number.

---

#### **3. Step-by-Step Logic**

1.  **Handle Edge Cases:** The number `Int.MIN_VALUE` (`-2147483648`) is special. Its positive counterpart (`2147483648`) is larger than `Int.MAX_VALUE`. Since reversing it will always cause an overflow anyway, it's cleanest to check for it and return `0` immediately.

2.  **Handle the Sign:**
    *   Check if the number is negative. Store this information in a variable (e.g., `signed = -1` or `isNegative = true`).
    *   Work with the *absolute* (positive) value of the number for the reversal process. This simplifies the logic.

3.  **Initialize `reversedNum`:** Create a variable to build our result, initialized to `0`.

4.  **Loop and Reverse:** Loop as long as the (now positive) number is greater than `0`.
    *   `digit = x % 10` (Pop the last digit).
    *   **Crucial: Check for Overflow BEFORE you push.** This is the most important step. Before calculating `reversedNum * 10 + digit`, we must ensure it *won't* exceed `Int.MAX_VALUE`. The check is:
        ```
        if (reversedNum > Int.MAX_VALUE / 10 || (reversedNum == Int.MAX_VALUE / 10 && digit > 7))
        ```
        If this is true, return `0`.
    *   `reversedNum = reversedNum * 10 + digit` (Push the digit onto the result).
    *   `x = x / 10` (Remove the digit from the input).

5.  **Re-apply the Sign:** After the loop, multiply `reversedNum` by your `signed` variable (`1` or `-1`) to restore the original sign.

---

#### **4. Final Kotlin Code**

```kotlin
fun reverse(x: Int): Int {
    // Handle MIN_INT_32 edge case immediately.
    if (x == Int.MIN_VALUE) {
        return 0
    }

    val signed = if (x < 0) -1 else 1
    var num = if (x < 0) -x else x // Work with absolute value

    var reversedNum = 0
    val overflowDiv10 = Int.MAX_VALUE / 10
    val overflowMod10 = Int.MAX_VALUE % 10

    while (num > 0) {
        val digit = num % 10

        // Pre-emptive overflow check.
        if (reversedNum > overflowDiv10 || (reversedNum == overflowDiv10 && digit > overflowMod10)) {
            return 0
        }

        reversedNum = reversedNum * 10 + digit
        num /= 10
    }

    return signed * reversedNum
}
``` 