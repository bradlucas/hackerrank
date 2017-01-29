(ns basic-probability-puzzles-7)

;; Day 3: Basic Probability Puzzles #7
;; https://www.hackerrank.com/challenges/basic-probability-puzzles-7

;; Plant A produces 500 units per day with a fraction defective output of 0.005
;; Plant B produces 1000 units per day with a fraction defective output of 0.008
;; Plant C produces 2000 units per day with a fraction defective output of 0.010

;; If a random pipe is chosen from the days output, what is the probabitlity that it
;; came from Plant A

;; .005 / (+ 0.005 0.008 0.10)


(def defa (* 500 0.005))
(def defb (* 1000 0.008))
(def defc (* 2000 0.010))


(def total (+ defa defb defc))

(def ans (/ defa total))



;; Answer
;; 0.08196721311475409


;; To prevent floats
;; 
(def ans2 (/ 
           (int (* 10 defa))
           (int (* 10 total))
           ))

;; Answer
;; 5/61

