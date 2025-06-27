(defn rotate [nums k]
  (let [n (count nums)]
    (if (or (zero? n) (zero? (mod k n)))
      ;; Se o array for vazio ou a rotação for nula, retorna o array original.
      nums
      ;; Senão, faz a transformação.
      (let [k' (mod k n) ; k normalizado
            tail (take-last k' nums)  ; Pega os últimos k' elementos
            head (drop-last k' nums)] ; Pega todos, menos os últimos k'
        ;; Concatena as duas partes e converte de volta para um vetor.
        (vec (concat tail head))))))

;; Exemplo de uso:
(rotate [1 2 3 4 5 6 7] 3)
