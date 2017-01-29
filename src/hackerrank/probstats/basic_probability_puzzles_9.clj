(ns basic-probability-puzzles-9)

;; Day 3: Basic Probability Puzzles #9
;; https://www.hackerrank.com/challenges/basic-probability-puzzles-9

;; 3 companies
;;
;; 12
;; 15
;; 10

(comment
  P (!A) = 11/12
  P (!B) = 14/15
  P (!C) = 9/10

  P (selected) 100/100 - (P (!A) + P (!B) + P (!C))

)

(let [
      a (/ 11 12)
      b (/ 14 15)
      c (/ 9 10)
      ]
  (- (/ 100 100) (* a b c))
)

;; Answer
;; 23/100


