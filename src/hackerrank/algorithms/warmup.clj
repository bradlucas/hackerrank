(ns hackerrank.algorithms.warmup
  (:use [clojure.string :only (split triml)]))

(defn simple-array-sum
  "https://www.hackerrank.com/challenges/simple-array-sum"
  []
  (let [n_t (read-line) 
        n (Integer/parseInt n_t)]
    (
     let [arr_temp (read-line) 
          arr_t (split arr_temp #"\s+") 
          arr (map #(Integer/parseInt %) arr_t)]
      (println (reduce + arr)))))


(defn compare-triplets-ex
  [a0 a1 a2 b0 b1 b2]
  (loop [a_cnt 0
         b_cnt 0
         a_vals [a0 a1 a2]
         b_vals [b0 b1 b2]]
    (if (empty? a_vals)
      [a_cnt b_cnt]
      (let [a (first a_vals)
            b (first b_vals)]
        (if (> a b)
          (recur (inc a_cnt) b_cnt (rest a_vals) (rest b_vals))
          (if (< a b)
            (recur a_cnt (inc b_cnt) (rest a_vals) (rest b_vals))
            (recur a_cnt b_cnt (rest a_vals) (rest b_vals))))))))

(defn compare-triplets
  "https://www.hackerrank.com/challenges/compare-the-triplets"
  []
  (let [a0_temp (read-line) 
        a0_t (split a0_temp #"\s+") 
        a0 (Integer/parseInt (a0_t 0)) 
        a1 (Integer/parseInt (a0_t 1)) 
        a2 (Integer/parseInt (a0_t 2))]
    (let [b0_temp (read-line) 
          b0_t (split b0_temp #"\s+") 
          b0 (Integer/parseInt (b0_t 0)) 
          b1 (Integer/parseInt (b0_t 1)) 
          b2 (Integer/parseInt (b0_t 2))]
      (letfn [(compare-triplets-ex
             [a0 a1 a2 b0 b1 b2]
             (loop [a_cnt 0
                    b_cnt 0
                    a_vals [a0 a1 a2]
                    b_vals [b0 b1 b2]]
               (if (empty? a_vals)
                 [a_cnt b_cnt]
                 (let [a (first a_vals)
                       b (first b_vals)]
                   (if (> a b)
                     (recur (inc a_cnt) b_cnt (rest a_vals) (rest b_vals))
                     (if (< a b)
                       (recur a_cnt (inc b_cnt) (rest a_vals) (rest b_vals))
                       (recur a_cnt b_cnt (rest a_vals) (rest b_vals))))))))]
        ;; (apply print (compare-triplets-ex a0 a1 a2 b0 b1 b2))
        (println (apply format "%d %d" (compare-triplets-ex a0 a1 a2 b0 b1 b2)))))))

