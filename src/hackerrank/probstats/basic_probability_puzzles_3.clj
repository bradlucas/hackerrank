(ns basic-probability-puzzles-3)  

;; Day 2: Basic Probability Puzzles #3
;; https://www.hackerrank.com/challenges/basic-probability-puzzles-3

(let 
   [rrb (* (/ 4 7) (/ 5 9) (/ 4 8))
    rbr (* (/ 4 7) (/ 4 9) (/ 4 8))     
    brr (* (/ 3 7) (/ 5 9) (/ 4 8))]
  ;; (println "RRB" rrb)
  ;; (println "RBR" rbr)
  ;; (println "BRR" brr)
  (+ rrb rbr brr))

;; Answer
;; 17/42

