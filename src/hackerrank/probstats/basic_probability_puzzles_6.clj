(ns basic-probability-puzzles-6)

;; Day 3: Basic Probability Puzzles #6
;; https://www.hackerrank.com/challenges/basic-probability-puzzles-6


;; Bag X has 5 white balls and 4 black balls
;; Bay Y has 7 white balls and 6 black balls

;; You draw one ball from Bag X without looking and place it in Bag Y
;; Now, if you draw from Bag Y what is the probablity that it is black


;; Scenario 1
;; You draw a black from bag 1 then draw a black from bag 2
(defn scenario1
  []
  (let [
        b1 (/ 4 (+ 5 4))
        b2 (/ (+ 1 6) (+ 1 7 6))        ;; you've added one black ball to the bag 2
        ]
    (* b1 b2)
    )
  )


;; Scenario 2
;; You draw a white from bag 1 then draw a black from bag 2
;; Probablity of drawing white then black
(defn scenario2
  []
  (let [
        w1 (/ 5 (+ 5 4)) 
        b2 (/ 6 (+ 1 7 6))                    ;; you've added one whie ball to bag 2
        ]
    (* w1 b2)
    )
  )

(defn run
  []
  (+ (scenario1) (scenario2)))

;; (run)

;; Answer
;; 29/63




