(ns basic-probability-puzzles-4)

;; Day 2: Basic Probability Puzzles #4
;; https://www.hackerrank.com/challenges/basic-probability-puzzles-4


(def bag1 {:red 4 :black 5})
(def bag2 {:red 3 :black 7})

;; Draw one ball from bag1 and two balls from bag2

;; What is the probablity that 2 balls are black and 1 ball is red


;; b, br  5/9 7/10 3/10
;; b, rb  5/9 3/10 7/9
;; r, bb  4/9 7/10 6/9



(let [
      bbr  (* (/ 5 9) (/ 7 10) (/ 3 9))
      brb  (* (/ 5 9) (/ 3 10) (/ 7 9))
      rbb  (* (/ 4 9) (/ 7 10) (/ 6 9))
      ]
  (println "bbr" bbr)
  (println "brb" brb)
  (println "rbb" rbb)
  (println "Answer: "(+ bbr brb rbb))
  (+ bbr brb rbb)
)

;; Answer
;; 7/15



