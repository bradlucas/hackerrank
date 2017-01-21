(ns hackerrank.algorithms.dynprog)


;; @see http://rosettacode.org/wiki/Fibonacci_sequence#Clojure
(defn fibs [v0 v1]
  (map first (iterate (fn [[a b]] [b (+' a (*' b b))]) [v0 v1])))

(defn fibonacci-modified
  "https://www.hackerrank.com/challenges/fibonacci-modified"
  [n v0 v1]
  ;; F0 = V0
  ;; F1 = V1
  ;; Fn = Fn-2 + (Fn-1)^2
  (nth (fibs v0 v1) (dec n)))





