# Estudos de Estruturas de Dados e Algoritmos: JS vs. Clojure

Este repositório é o meu diário de bordo e notebook pessoal para o estudo aprofundado de estruturas de dados e algoritmos, com um foco particular na resolução de problemas do LeetCode.

O objetivo principal não é apenas encontrar *uma* solução, mas sim dominar os **padrões algorítmicos** e explorar a implementação desses padrões através de duas filosofias de programação distintas:
1.  **JavaScript (Vanilla):** Representando o paradigma imperativo, mainstream, e a linguagem do dia a dia para muitas aplicações web e de mercado.
2.  **Clojure:** Representando o paradigma funcional, com ênfase em imutabilidade, transformação de dados e expressividade.

---

## Metodologia

Cada problema é abordado com uma metodologia estruturada para maximizar o aprendizado:

* **Foco em Padrões:** A prioridade é identificar a técnica ou padrão algorítmico mais eficaz para cada tipo de problema (ex: *Two-Pointers*, *Sliding Window*, *Reversal Algorithm*).
* **Análise Comparativa:** As soluções são implementadas em JavaScript e, sempre que relevante, uma abordagem idiomática em Clojure é analisada para contrastar as filosofias de design.
* **Documentação Detalhada:** Cada problema resolvido possui sua própria pasta, contendo um `README.md` detalhado (o "canvas") que documenta o processo de raciocínio, a lógica passo a passo e as nuances da solução final.

---

## Estrutura do Repositório

Cada problema resolvido terá sua própria pasta, nomeada com o número e o título do LeetCode, contendo os seguintes arquivos:

```
/
|-- 007-Reverse-Integer/
|   |-- README.md         (O canvas com a explicação detalhada)
|   |-- solution.js       (A solução final em JavaScript)
|   |-- solution.clj      (A solução/insight em Clojure)
|
|-- 189-Rotate-Array/
|   |-- README.md
|   |-- solution.js
|   |-- solution.clj
|
|-- ... (outros problemas)
|
|-- README.md             (Este arquivo que você está lendo)
```

---

## Problemas Resolvidos

| #   | Problema                                               | Técnica Principal                                   | Linguagens    |
|:----|:-------------------------------------------------------|:----------------------------------------------------|:--------------|
| 7   | [Reverse Integer](007-Reverse-Integer/)                | Manipulação Numérica, Checagem de Overflow          | JS, Clojure   |
| 27  | [Remove Element](027-Remove-Element/)                  | Two Pointers (Ponteiros de Leitura/Escrita)         | JS, Clojure   |
| 26  | [Remove Duplicates from Sorted Array](026-Remove-Duplicates-from-Sorted-Array/) | Two Pointers                                        | JS, Clojure   |
| 80  | [Remove Duplicates from Sorted Array II](080-Remove-Duplicates-from-Sorted-Array-II/) | Two Pointers (Avançado)                             | JS, Clojure   |
| 169 | [Majority Element](169-Majority-Element/)              | Algoritmo de Votação de Boyer-Moore, Hashing        | JS, Clojure   |
| 189 | [Rotate Array](189-Rotate-Array/)                      | Algoritmo de Reversão, Manipulação de Sequências    | JS, Clojure   |


---

## Como Usar

Sinta-se à vontade para clonar o repositório, navegar pelas pastas e usar as explicações como um guia para seus próprios estudos. Cada pasta de problema é um estudo autocontido, projetado para ser lido do `README.md` para as implementações de código.
