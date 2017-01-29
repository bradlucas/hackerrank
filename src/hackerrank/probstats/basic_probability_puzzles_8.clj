(ns basic-probability-puzzles-8)

;; Day 3: Basic Probability Puzzles #8
;; https://www.hackerrank.com/challenges/basic-probability-puzzles-8

;; Probability of not reading the morning paper is 1/2
;; Probability of not reading the evening paper is 2/5
;; Probability of reading both newspapers is 1/5

;; What is the probability that a resident reads a morning or evening paper



(comment
  
  P (A or B) = P (A) + P (B) - P (A and B)


  P (A) = 1/2
  P (B) = 3/5
  P (A and B) = 1/5

  

)

(let [PA (/ 1 2)
      PB (/ 3 5)
      PAB (/ 1 5)]
  (- (+ PA PB) PAB)
  )


;; Answer
;; 9/10

