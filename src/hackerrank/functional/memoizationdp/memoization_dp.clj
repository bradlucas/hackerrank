(ns hackerrank.functional-programming.memoization-dp.memoization-dp)

;; http://rosettacode.org/wiki/Catalan_numbers#Clojure
;; http://www.geeksforgeeks.org/program-nth-catalan-number/


;; https://rosettacode.org/wiki/Evaluate_binomial_coefficients#Clojure
(defn binomial-coefficient0 [n k]
  (println "binomial-coefficient " n k)
  (let [rprod (fn [a b] (reduce * (range a (inc b))))]
    (let [a (- n k -1)]
      (println "a is " a)

      (try (rprod a n) (catch java.lang.ArithmeticException e (prn a n e)))
      ;;(try (rprod 1 k) (catch java.lang.ArithmeticException e (prn 1 k e)))

      ;; (try
      ;;      (let [num (rprod a n)
      ;;            div (rprod 1 k)]
      ;;        (println num "/" div)
      ;;        (/ num div)
      ;;        )
      ;;    (catch java.lang.ArithmeticException e (prn e a n k num)))
      )))


;; ---

(defn binomial-coefficient 
  ;; http://stackoverflow.com/a/19711241
  [n k]
  (let [rprod (fn [a b] (reduce *' (range a (inc' b))))]
    (/ (rprod (-' n k -1) n) (rprod 1 k))))


(defn number-of-bst
  "https://www.hackerrank.com/challenges/number-of-binary-search-tree"
  [n]
  ;; find the value of 2nCn
  ;; retuern 2nCn/(n + 1)
  (let [c (binomial-coefficient (* 2 n), n)]
    (/ c (inc n))))


;; print the answer mod 10^8+7
(defn exp
  [x n]
  (if (zero? n) 1
      (* x (exp x (dec n)))))

(defn mod-10-8-7
  [n]
  (mod n (+ 7 (exp 10 8))))

(defn format-number-mod-10-8-7
  [n]
  (int (mod-10-8-7 n)))

;; Submission
(defn submission []
  ;; cut-paste the following

(let [n_t (read-line) 
      n (Integer/parseInt n_t)]
  (loop [a0 n]
    (when (> a0 0)
      (let [x_t (read-line) 
            x (Integer/parseInt x_t)]
        (println (format-number-mod-10-8-7 (number-of-bst x))))
      (recur (- a0 1)))))
)




;; fibonacci-fp
;; "https://www.hackerrank.com/challenges/fibonacci-fp"


(def fib-seq (lazy-cat [0 1] (map +' (rest fib-seq) fib-seq)))

(defn fibonacci
  [n]
  (nth fib-seq n))


(defn submission-fibonacci-fp
  []
  ;; cut-paste
(let [n_t (read-line) 
      n (Integer/parseInt n_t)]
  (loop [a0 n]
    (when (> a0 0)
      (let [x_t (read-line) 
            x (Integer/parseInt x_t)]
        (println (format-number-mod-10-8-7 (fibonacci x))))
      (recur (- a0 1)))))

)

