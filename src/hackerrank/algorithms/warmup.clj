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












;; Dashboard  Algorithms  Sorting  Intro to Tutorial Challenges
;; https://www.hackerrank.com/challenges/tutorial-intro

(defn get-value-index 
  [n lst]
  (count (take-while (partial not= n) lst))) 

;; (let [n (Integer/parseInt (read-line))
;;       cnt (Integer/parseInt (read-line))
;;       arr_t (read-line)
;;       arr (map #(Integer/parseInt %) (clojure.string/split arr_t #" "))
;;       ]
;;   (println (get-value-index n arr)))



(defn a-very-big-sum 
  "https://www.hackerrank.com/challenges/a-very-big-sum"
  [arr]
  (apply +' arr))


;; (let [n (Integer/parseInt (read-line))
;;       arr (map #(Integer/parseInt %) (clojure.string/split arr_t #" "))
;;       ]
;;   (println (get-value-index n arr)))



(defn abs
  [n]
  (if (neg? n) (- n) n))

(defn diagonal-difference
  "https://www.hackerrank.com/challenges/diagonal-difference"
  [sqr]

  ;; sqr -> ((1 3 2) (1 3 2) (1 3 2))

  ;; diag1 = sum top left to bottom right
  ;; diag1 = sum bottom left to top right

  ;; return difference -> diag1 - diag2
  (let [cnt (count sqr)
        d1 (apply + (map (fn [[idx row]] (nth row idx)) (partition 2 (interleave (range cnt) sqr))))
        d2 (apply + (map (fn [[idx row]] (nth row idx)) (partition 2 (interleave (reverse (range cnt)) sqr))))]
    (abs (- d1 d2))))


;; ((11 2 4) (4 5 6) (10 8 -12))


(defn plus-minus
  "https://www.hackerrank.com/challenges/plus-minus"
  [a]
  (let [len (count a)
        pos (count (filter pos? a))
        neg (count (filter #(< % 0) a))
        zero (count (filter #(= 0 %) a))
        p (/ pos len)
        n (/ neg len)
        z (/ zero len)
        pp (fn [num] (format "%.6f" (float num)))]
    (println (pp p))
    (println (pp n))
    (println (pp z))))


(defn testing
  []
  (let [a [-4 3 -9 0 4 1]]
    (plus-minus a)))
