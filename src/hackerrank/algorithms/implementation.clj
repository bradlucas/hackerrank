(ns hackerrank.algorithms.implementation)

(defn utopian-tree
  "https://www.hackerrank.com/challenges/utopian-tree"
  [n]
  (cons n (lazy-seq (utopian-tree (if (even? n) (+ n 1) (* n 2))))))


(defn last-height
  [cycles]
  (last (take (inc cycles) (utopian-tree 1))))



 
(defn angry-professor
  "https://www.hackerrank.com/challenges/angry-professor"
  [class-size count-threshold arrival-times]

  ;; a negative or 0 arrival time means the student arrived on time
  ;; the number of arrival-times which are on time needs to be greater than or equal to the count-threshold
  ;; to not cancel the class

  (let [num-on-time-arrivals (count (filter (complement pos?) arrival-times))]
    (if (< num-on-time-arrivals count-threshold)
      "YES"
      "NO")))



;; (let [t_t (read-line) 
;;       t (Integer/parseInt t_t)]
;;   (loop [a0 t]
;;     (when (> a0 0)
;;       (let [n_temp (read-line) 
;;             n_t (split n_temp #"\s+") 
;;             n (Integer/parseInt (n_t 0)) 
;;             k (Integer/parseInt (n_t 1))]
;;         (let [a_temp (read-line) 
;;               a_t (split a_temp #"\s+") 
;;               a (map #(Integer/parseInt %) a_t)]
;;           (println (angry-professor n k a))))
;;       (recur (- a0 1) ))))


(defn sock-merchant
  [socks]
  ;; how many pairs can you make
  ;; 10 20 20 10 10 30 50 10 20 -> 3
  ;; 
  (count (filter (fn [[a b]] (= a b)) (partition 2 (sort socks)))))
