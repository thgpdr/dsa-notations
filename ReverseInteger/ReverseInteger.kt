import kotlin.math.absoluteValue

// Problema LeetCode: Inverter Inteiro
// Dado um inteiro de 32 bits com sinal x, retorne x com seus dígitos invertidos.
// Se a inversão de x fizer com que o valor saia do intervalo de inteiros de 32 bits com sinal
// [-2^31, 2^31 - 1], então retorne 0.
// Suponha que o ambiente não permita armazenar inteiros de 64 bits.

// Constantes para os limites de Int (32-bit em Kotlin/JVM)
const val MAX_INT_32 = Int.MAX_VALUE // 2147483647
const val MIN_INT_32 = Int.MIN_VALUE // -2147483648

fun reverse(xInput: Int): Int {
    var x = xInput // Tornar x mutável para a lógica

    // Trata MIN_INT_32 imediatamente, pois revertê-lo sempre causa overflow.
    if (x == MIN_INT_32) {
        return 0
    }

    val signed = if (x < 0) -1 else 1
    // Se x for negativo, torna-o positivo
    // Usar absoluteValue para clareza, x = -x também funcionaria aqui (após a checagem de MIN_INT_32)
    if (x < 0) {
        x = x.absoluteValue
    }

    var reversedNum = 0
    // Pré-calcula os limites para a verificação de overflow
    val overflowDiv10 = MAX_INT_32 / 10 // 214748364
    val overflowMod10 = MAX_INT_32 % 10 // 7

    while (x > 0) {
        val digit = x % 10 // Pega o último dígito

        // Verificação de overflow antecipada
        if (reversedNum > overflowDiv10 || (reversedNum == overflowDiv10 && digit > overflowMod10)) {
            return 0 // Ocorreria overflow
        }

        reversedNum = reversedNum * 10 + digit
        x /= 10 // Em Kotlin, a divisão de inteiros já remove o último dígito
    }

    return signed * reversedNum // Aplica o sinal original
}

fun main() {
    println("Problema LeetCode: Inverter Inteiro em Kotlin")

    val testCases = listOf(
        123 to 321,
        -123 to -321,
        120 to 21,
        0 to 0,
        1534236469 to 0,  // Deve ser 0 (overflow para 9646324351)
        -1534236469 to 0, // Deve ser 0 (overflow para -9646324351)
        MAX_INT_32 to 0,    // Deve ser 0 (overflow para 7463847412)
        MIN_INT_32 to 0     // Deve ser 0
    )

    testCases.forEach { (input, expected) ->
        val result = reverse(input)
        println("Entrada: $input, Saída: $result, Esperado: $expected -> ${result == expected}")
    }
} 