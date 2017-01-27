(ns hackerrank.algorithms.strings)


(defn camelcase
  [s]
  ;; return the number of words
  ;; thisStringHasFiveWords -> 5
  (+ 1 (count (filter #(Character/isUpperCase %) (seq s)))))
