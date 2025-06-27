/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    /**
     * Função auxiliar para reverter um segmento do array in-place.
     * @param {number[]} arr - O array a ser modificado.
     * @param {number} left - O ponteiro/índice inicial.
     * @param {number} right - O ponteiro/índice final.
     */
    const reverse = function(arr, left, right) {
        while (left < right) {
            // Troca os elementos usando atribuição via desestruturação
            [arr[left], arr[right]] = [arr[right], arr[left]];
            
            // Move os ponteiros em direção ao centro
            left++;
            right--;
        }
    };

    const n = nums.length;

    // Passo 1: Normaliza k para o caso de ser maior que o tamanho do array.
    k %= n;

    // Passo 2: Reverte o array inteiro.
    reverse(nums, 0, n - 1);

    // Passo 3: Reverte os k primeiros elementos.
    reverse(nums, 0, k - 1);

    // Passo 4: Reverte os n-k elementos restantes.
    reverse(nums, k, n - 1);
};


let array1 = [ 1, 2, 3, 4, 5, 6, 7];
let array2 = [ -1 , -100, 3, 99];
rotate(array1, 3)
rotate(array2, 2)

console.log(array1);
console.log(array2);

