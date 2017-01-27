(ns hackerrank.algorithms.strings)


(defn camelcase
  [s]
  ;; return the number of words
  (+ 1 (count (filter #(Character/isUpperCase %) (seq s)))))
