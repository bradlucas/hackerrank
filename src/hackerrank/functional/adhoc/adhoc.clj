(ns hackerrank.functional.adhoc.adhoc)

;; https://www.hackerrank.com/challenges/kundu-and-bubble-wrap
;; Timing out

;; http://math.stackexchange.com/questions/1393798/expected-value-from-popping-bubbles/1393810

(defn bubble-wrap 
  "https://www.hackerrank.com/challenges/kundu-and-bubble-wrap"
  [n m]
  (let [nm (* n m)]
    ;; NM * SUM(1, 1/2, 1/3, 1/4, ... 1/NM)
    (double 
     (* nm
        (reduce + (map (fn [n] (/ 1 n)) (range 1 (inc nm))))
      ))))



(defn bubble-wrap2
  "https://www.hackerrank.com/challenges/kundu-and-bubble-wrap"
  [n m]
  (let [nm (* n m)
        rng (doall (range 1 (inc nm)))]
    ;; NM * SUM(1, 1/2, 1/3, 1/4, ... 1/NM)
    (double 
     (* nm
        (reduce + (map (fn [n] (/ 1 n)) rng))
      ))))


(defn bubble-wrap3
  "https://www.hackerrank.com/challenges/kundu-and-bubble-wrap"
  [n m]
  (let [nm (* n m)]
    ;; nm * sumnon-lazy (1, 1/2, 1/3, 1/4, ... 1/NM)
    (double 
     (* nm
        (reduce + (mapv (fn [n] (/ 1 n)) (doall (range 1 (inc nm)))))
      ))))

;; (let [[n m] (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))]
;;   (println (bubble-wrap n m)))


(defn test []
  (do (time (bubble-wrap 100 100)) 
      (time (bubble-wrap2 100 100))
      (time (bubble-wrap3 100 100))))

