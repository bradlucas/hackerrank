(ns basic-probability-puzzles-9)

;; Day 3: Basic Probability Puzzles #10
;; https://www.hackerrank.com/challenges/basic-probability-puzzles-10


(comment
  P (B) 1/3    ;; !B 2/3
  P (N) 1/5    ;; !N 4/5
  )

(let [
      B (* (/ 1 3) (/ 4 5))
      N (* (/ 2 3) (/ 1 5))
      ]
  (+ B N))


;; Answer
;; 2/5



