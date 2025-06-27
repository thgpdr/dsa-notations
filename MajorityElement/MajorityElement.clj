(defn majority-element [nums]
  (->> nums
       frequencies
       (apply max-key val)
       key))

(comment (majority-element [1, 1, 1, 1, 2, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6]))
