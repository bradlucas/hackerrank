(ns hackerrank.functional.adhoc.jumping-bunnies)



(defn gcd 
      [a b]
      (if (zero? b)
      a
      (recur b, (mod a b))))
 
(defn lcm 
      [a b]
      ;; (/ (* a b) (gcd a b)))
      (* b (/ a (gcd a b))))



(defn run []
  (let [num (Integer/parseInt (read-line))
       num-list (mapv #(Integer/parseInt %) (clojure.string/split (clojure.string/trim (read-line)) #"\s+"))]
    (println (reduce lcm num-list))))

;; (run)

