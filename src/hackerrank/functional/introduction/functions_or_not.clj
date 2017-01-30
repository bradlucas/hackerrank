(ns hackerrank.functional.introduction.functions-or-not)

;; pairs represent x and y for f(x) -> y
;; to be a function f(x) should always return y

;; 2      - Number of test cases
;; 3      - Number of pairs for the test
;; 1 1  
;; 2 2  
;; 3 3  
;; 4
;; 1 2
;; 2 4
;; 3 6  
;; 4 8  


;; Not a function
;; 1 2
;; 2 3
;; 1 3

(defn functions-or-not
  [pairs]
  (loop [pairs pairs
         fncs {}]
    (if (empty? pairs)
      true
      (let [[a b] (first pairs)
            prev (contains? fncs a)]
        ;; if this is a previous pair make sure b is valid
        (if (and prev (not= b (get fncs a)))
          false
          (recur (rest pairs) (into fncs (hash-map a b))))))))

(defn print-result
  [v]
  (println (if v "YES" "NO")))

(defn run
  []
  (let [n (Integer/parseInt (read-line))]
    (loop [cnt n]                                     ;; look over tests
      (when (> cnt 0)
        (let [num-pairs (Integer/parseInt (read-line))  ;; number of pairs
              pairs (mapv (fn [[a b]] [(Integer/parseInt a) (Integer/parseInt b)]) (mapv #(clojure.string/split (clojure.string/trim %) #"\s+") (repeatedly num-pairs read-line)))]    
          (print-result (functions-or-not pairs)))   
        (recur (dec cnt))))))

;; (run)



