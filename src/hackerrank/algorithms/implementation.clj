(ns hackerrank.algorithms.implementation)

(defn utopian-tree
  "https://www.hackerrank.com/challenges/utopian-tree"
  [n]
  (cons n (lazy-seq (utopian-tree (if (even? n) (+ n 1) (* n 2))))))


(defn last-height
  [cycles]
  (last (take (inc cycles) (utopian-tree 1))))
