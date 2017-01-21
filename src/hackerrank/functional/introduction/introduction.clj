(ns hackerrank.functional.introduction.introduction)

(defn solve-me-first
  "https://www.hackerrank.com/challenges/fp-solve-me-first"
  []
  (let [a (Integer/parseInt (read-line))
        b (Integer/parseInt (read-line))]
    (println (+ a b))))

(defn hello-world
  "https://www.hackerrank.com/challenges/fp-hello-world"
  []
  (println "Hello World"))

(defn fp-hello-world-n-times
  "https://www.hackerrank.com/challenges/fp-hello-world-n-times"
  []
  (let [f (fn [n] (dotimes [_ n] (println "Hello World")))]
    (f 4)))

(defn fp-list-replication
  "https://www.hackerrank.com/challenges/fp-list-replication"
  []
  ;; first line is the number S where S is the number of times you need to repeat the elements
  ;; the next X lines each tonain an integer. the X elements in the arrau
  ;; for each of the X lines repeat each number X times
  ;; read number of lines
  ;; read 
  (let [cnt 3
        x [1 2 3 4]]
    (let [f (fn [num lst]    
              (loop [cnt num
                     lst lst]
                (if (empty? lst)
                  nil
                  (do
                    (dotimes [_ cnt] (println (first lst)))
                    (recur cnt (rest lst))))))]
      (f cnt x)
      )))

(defn fp-filter-array
  "https://www.hackerrank.com/challenges/fp-filter-array"
  []
  ;; TODO

)


;; Filter Positions in a List
;; Array Of N Elements
;; Reverse a list
;; Sum of Odd Elements

;; List Length
(defn fp-list-length
  "https://www.hackerrank.com/challenges/fp-list-length"
  []
  (let [lst [2 5 1 4 3 7 8 6 0 9]]
    (let [f (fn[lst] (count lst))]
      (f lst)
      )
    )
  ) 

;; Update List

(defn exp [x y]
  (reduce * (repeat y x)))

(defn factorial 
  [x]
  ;; x * (x-1) * (x-2) * ... * 2 1
  ;; 1! = 1
  ;; 2! = 2
  ;; 3! = 6
  ;; 4! = 24
  (loop [rtn x
         x x]
    (if (< x 3)
      rtn
      (recur (* rtn (dec x)) (dec x)))))

(defn term-calc
  [x n]
  (if (= n 0) 
    1
    (if (= n 1)
      x
      (/ (exp x n) (factorial n)))))

(defn eval-ex
  "https://www.hackerrank.com/challenges/eval-ex"
  [x]
  ;; N is number of lines
  ;; N lines with a value to 4 decimal places
  ;; 1 + x + x^2/2! + x^3/3! + ....
  ;; go to 10 terms
  (format "%.4f" (apply + (map (fn [n] (term-calc (double x) n)) (range 0 10)))))


;; (for [line (repeatedly x read-line)] (DateFormat/parse line))

(defn run-eval-ex
  []
  ;; This didn't work
  ;; read number of lines
  ;; read each line
  ;; http://stackoverflow.com/questions/11484113/idiomatic-way-to-write-clojure-code-for-repeatedly-reading-lines-from-the-consol
  (let [num (Integer/parseInt (read-line))]
    (println num)
    ;;(println (map Float/parseFloat (repeatedly num read-line)))
    ;; (for [line (repeatedly num read-line)] 
    ;;   (println (Float/parseFloat line)))
    (doseq [line (repeatedly read-line)]
      (println line)
      )
    
    ;;numbers (for [line (repeatedly num (read-line))] (Float/parseFloat line))
    ;;numbers
    )
  )

;; Submitted answer with stdin/stdout interface
;; (let [n_t (read-line) 
;;       n (Integer/parseInt n_t)]
;;   (loop [a0 n]
;;     (when (> a0 0)
;;       (let [x_t (read-line) 
;;             x (Float/parseFloat x_t)]
;;         (println (eval-ex x)))
;;       (recur (- a0 1)))))





