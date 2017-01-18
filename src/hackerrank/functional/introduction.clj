(ns hackerrank.functional.introduction)

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

)




;; TODO new...

(defn evaluating-e-to-x
  "https://www.hackerrank.com/challenges/eval-ex"
  []
)
