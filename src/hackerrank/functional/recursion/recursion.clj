(ns hackerrank.functional.recursion.recursion)

(defn divide 
  [x y]
  (let [q (quot x y)
        r (rem x y)]
    [q r]))

(defn gcd
  [x y]
  (if (= x y) 
    x
    (if (< x y)  
      (gcd y x)                                       ;; call gcd with x being the larger
      (loop [x x                                      ;; recursively call divide till the reminder is 0 and when that happens return the called divisor      
             y y]
        (let [[q r] (divide x y)]
          (if (= 0 r)
            y
            (recur y r)))))))

(defn gcd 
  "https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---gcd"
  [a b]
  (if (= a b) 
    a
    (let [x (if (> a b) a b)
          y (if (> a b) b a)]
      (let [divide (fn [x y]
                     (let [q (quot x y)
                           r (rem x y)]
                       [q r]))]
        (loop [x x
               y y]
          (let [[q r] (divide x y)]
            (if (= 0 r)
              y
              (recur y r))))))))

(defn fibonacci
  "https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---fibonacci-numbers"
  [n]
  (if (> n 2)
    (+ (fibonacci (- n 1)) (fibonacci (- n 2)))
    (- n 1)))

(defn fibonacci-test
  []
  (println (fibonacci (Integer/parseInt (read-line)))))

  
;; (map (fn [pair] (apply + pair))  (partition 2 [1 3 3 1]))


(defn sum-pairs
  [lst]
  ;; recurse
  ;; return the sum of the first pair
  ;; recurse on the rest
  (loop [rtn []
         lst lst]
    (if (or (= 1 (count lst)) (empty? lst))
      rtn
      (recur (conj rtn (+ (first lst) (second lst))) (rest lst))))
  )


;;(pascals-triangle (- num 1))

(defn pascals-triangle
  "https://www.hackerrank.com/challenges/pascals-triangle
  Input: 6

  1       1
  2      1 1
  3     1 2 1
  4    1 3 3 1
  5   1 4 6 4 1
  6  1 5 10 10 5 1

  2 <= k <= 10
  "
  [num]
  (let [build-row (fn build-row [num]
                    (cond
                     (= num 1) [1]
                     (= num 2) [1 1]
                     :else (flatten (conj [] 1 (sum-pairs (build-row (- num 1))) 1))))]
    (doseq [s (map build-row (range 1 (inc num)))] 
      ;;(println s)
      (println (clojure.string/join " " s)))))


(defn string-mingling
  "https://www.hackerrank.com/challenges/string-mingling"
  []
  (println (apply str (interleave (read-line) (read-line)))))


;; 
;; http://www.flyingmachinestudios.com/programming/a-taste-of-the-lambda-calculus/
;; ((fn ((fn (x y)) x))(fn))



(defn string-reductions
  "https://www.hackerrank.com/challenges/string-reductions"
  [s]
  ;; for a given remove characters that have occurred previously

  ;; add each letter to a set
  ;; then remove each subsequent letter which is in the set
  (loop [ary (seq (char-array s))
         s #{}
         rtn []]
    (if (empty? ary)
      rtn
      (let [c (first ary)
            dup (s c)]
        (recur (rest ary) (if dup s (conj s c)) (if dup rtn (conj rtn c)))))))

(defn make-str
  [col]
  (clojure.string/join "" col))

;; (println (make-str (string-reductions (read-line))))
