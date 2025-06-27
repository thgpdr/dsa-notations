package main

import (
	"fmt"
	"math"
)

// Problema LeetCode: Inverter Inteiro
// Dado um inteiro de 32 bits com sinal x, retorne x com seus dígitos invertidos.
// Se a inversão de x fizer com que o valor saia do intervalo de inteiros de 32 bits com sinal
// [-2^31, 2^31 - 1], então retorne 0.
// Suponha que o ambiente não permita armazenar inteiros de 64 bits.

// Constantes para os limites de int32
const (
	MaxInt32 = math.MaxInt32
	MinInt32 = math.MinInt32
)

func reverse(x int32) int32 {
	// Trata MinInt32 imediatamente, pois revertê-lo sempre causa overflow.
	if x == MinInt32 {
		return 0
	}

	var signed int32 = 1
	// Se x for negativo, torna-o positivo e guarda o sinal
	if x < 0 {
		x = -x
		signed = -1
	}

	var reversedNum int32 = 0
	// Pré-calcula os limites para a verificação de overflow
	const overflowDiv10 = MaxInt32 / 10 // 214748364
	const overflowMod10 = MaxInt32 % 10 // 7

	for x > 0 {
		digit := x % 10 // Pega o último dígito

		// Verificação de overflow antecipada
		if reversedNum > overflowDiv10 || (reversedNum == overflowDiv10 && digit > overflowMod10) {
			return 0 // Ocorreria overflow
		}

		reversedNum = reversedNum*10 + digit
		x = x / 10 // Em Go, a divisão de inteiros já remove o último dígito
	}

	return signed * reversedNum // Aplica o sinal original
}

func main() {
	fmt.Println("Problema LeetCode: Inverter Inteiro em Go")

	testCases := []struct {
		input    int32
		expected int32
	}{
		{123, 321},
		{-123, -321},
		{120, 21},
		{0, 0},
		{1534236469, 0},  // Deve ser 0 (overflow para 9646324351)
		{-1534236469, 0}, // Deve ser 0 (overflow para -9646324351)
		{MaxInt32, 0},    // Deve ser 0 (overflow para 7463847412)
		{MinInt32, 0},    // Deve ser 0
	}

	for _, tc := range testCases {
		result := reverse(tc.input)
		fmt.Printf("Entrada: %d, Saída: %d, Esperado: %d -> %v\n", tc.input, result, tc.expected, result == tc.expected)
	}
}
