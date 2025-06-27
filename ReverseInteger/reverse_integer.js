// LeetCode Problem: Reverse Integer
// Given a signed 32-bit integer x, return x with its digits reversed.
// If reversing x causes the value to go outside the signed 32-bit integer
// range [-2^31, 2^31 - 1], then return 0.
// Assume the environment does not allow you to store 64-bit integers.
// Note: While JavaScript numbers are typically 64-bit floating-point,
// we must strictly adhere to the 32-bit signed integer constraints for this problem.

const MAX_INT32 = Math.pow(2, 31) - 1; // 2147483647
const MIN_INT32 = -Math.pow(2, 31);   // -2147483648

/**
 * @param {number} x The input 32-bit signed integer.
 * @return {number} The reversed integer, or 0 if it overflows.
 */
const reverse = function (x) {
    // Trata MIN_INT32 imediatamente, pois revertê-lo sempre causa overflow.
    if (x === MIN_INT32) {
        return 0;
    }

    let signed = 1;
    // Se x for negativo, torna-o positivo e guarda o sinal
    if (x < 0) {
        x = -x;
        signed = -1;
    }

    let reversedNum = 0;
    const OVERFLOW_DIV_10 = Math.floor(MAX_INT32 / 10);
    const OVERFLOW_MOD_10 = MAX_INT32 % 10;

    while (x > 0) {
        const digit = x % 10; // Pega o último dígito

        // Verificação de overflow antecipada para a construção do número invertido positivo
        // Verifica se reversedNum * 10 + digit excederá MAX_INT32
        if (reversedNum > OVERFLOW_DIV_10 || 
            (reversedNum === OVERFLOW_DIV_10 && digit > OVERFLOW_MOD_10)) {
            return 0; // Ocorreria overflow
        }

        reversedNum = reversedNum * 10 + digit;
        x = Math.floor(x / 10); // Remove o último dígito de x
    }

    return signed * reversedNum; // Aplica o sinal original
};


console.log("LeetCode: Reverse Integer Problem in JavaScript");
console.log(`Input: 123, Output: ${reverse(123)}`); 
console.log(`Input: -123, Output: ${reverse(-123)}`);
console.log(`Input: 120, Output: ${reverse(120)}`);
console.log(`Input: 0, Output: ${reverse(0)}`);
console.log(`Input: 1534236469, Output: ${reverse(1534236469)}`); // Should be 0 (overflows to 9646324351)
console.log(`Input: -1534236469, Output: ${reverse(-1534236469)}`);// Should be 0 (overflows to -9646324351)
console.log(`Input: ${MAX_INT32}, Output: ${reverse(MAX_INT32)}`); // Should be 0 (overflows to 7463847412)
console.log(`Input: ${MIN_INT32}, Output: ${reverse(MIN_INT32)}`); // Should be 0

// console.log(`Input:`, -Math.pow(2, 31), (Math.pow(2, 31) -1)); 