(ns hackerrank.algorithms.graph
  (:refer-clojure :exclude [test]))

;; Snakes and Ladders: The Quickest Way Up
;; https://www.hackerrank.com/challenges/the-quickest-way-up

;; |--------------+---------|
;; | Test Case #0 | OK      |
;; | Test Case #1 | OK      |
;; | Test Case #2 | Timeout |
;; | Test Case #3 | Timeout |
;; | Test Case #4 | Timeout |
;; | Test Case #5 | Timeout |
;; | Test Case #6 | Timeout |
;; |--------------+---------|


(defn initial-board [len]
  ;; build 1 to len
  ;; {1 1, 2 2, 3 3, ... 99 99, 100 100}
  (into {} (map (fn [n] {n n}) (range 1 (inc len)))))

(defn merge-ladders-and-snakes 
  [board ladders snakes]
  ;; ladder {32 62} means that which ever node goes to 32 now goes to 62
  ;;
  ;; {... 11 11, 12 98, 13 13 ...}q
  (let [m (dissoc board (keys (merge ladders snakes)))]
    (merge m ladders snakes)))

(defn build-board
  [n ladders snakes]
  (let [b (initial-board n)]
    (merge-ladders-and-snakes b ladders snakes)))

(defn remove-if-in-path 
  [path col]
  ;; return only the items in col that are not in path
  (vec (remove #(contains? (set path) %) col)))


(defn next-nodes-from-board
  "Find the next 6 moves from n on board b"
  ;; for a given path return the current node (last path)
  ;; add 1 to 6 to node making sure the values are less than 101
  ;; merge in the effects of the ladders and snakes
  ;; remove any results which are already in the path
  ;; ladders and snakes need to be in maps
  [b path]
  (let [n (last path)
        next-nodes (filter #(< % 101) (map #(+ n %) (range 1 7)))]
    ;; Try looking only at the max value
    ;; (list (apply max (filter identity (map #(b %) next-nodes))))
    
    (reverse (sort (remove-if-in-path path (filter identity (map #(b %) next-nodes)))))
    )) 


(defn next-nodes
  [ladders snakes path]
  ;; for a given path return the current node (last path)
  ;; add 1 to 6 to node making sure the values are less than 101
  ;; merge in the effects of the ladders and snakes
  ;; remove any results which are already in the path
  ;; ladders and snakes need to be in maps
  
  ;; 

  (let [n (last path)
        next-nodes (filter #(< % 101) (map #(+ n %) (range 1 7)))
        holes (merge ladders snakes)]
    ;; (list (apply max (map (fn [n] (if (contains? holes n) (holes n) n)) next-nodes)))
    (remove-if-in-path path (mapv (fn [n] (if (contains? holes n) (holes n) n)) next-nodes))))


;; http://stackoverflow.com/a/28200932
(defn queue
      ([] clojure.lang.PersistentQueue/EMPTY)
      ([coll] (reduce conj clojure.lang.PersistentQueue/EMPTY coll)))

(defmethod print-method clojure.lang.PersistentQueue
  [q ^java.io.Writer w]
  (.write w "#queue ")
  (print-method (sequence q) w))

(comment
  (let [*data-readers* {'queue #'queue}]
    (read-string (pr-str (queue [1 2 3]))))) 


;; http://stackoverflow.com/a/3249777
(defn in? 
  "true if coll contains elm"
  [coll elm]  
  (some #(= elm %) coll))

(defn breadth-first
  [next-nodes  start]
  (let [target 100]
    (loop [q (queue [[start]])]
      (if (empty? q)
        nil
        (let [path (peek q)]
          (if (= (last path) target)
            path
            (let [children (next-nodes path)]
              (when-not (empty? children)
                  (let [queue (into (pop q) (map #(conj path %) children))]
                    (if (not (empty? queue))
                      (recur queue)))))))))))




(defn snakes-and-ladders
  [snakes ladders]
  (let [f (partial next-nodes ladders snakes)]
    (dec (count (breadth-first f 1)))))

(defn snakes-and-ladders2
  [snakes ladders]
  (let [f (partial next-nodes-from-board (build-board 100 ladders snakes))]
    (dec (count (breadth-first f 1)))))

;; ----------------------------------------------------------------------------------------------------

(defn get-pairs
  "Support routine to read pairs from stdin"
  []
  (into {} 
        (map (fn [[k v]] {k v})   
             (loop [num (Integer/parseInt (read-line))
                    pairs []]
               (if (= num 0)
                 pairs
                 (recur (dec num) (conj pairs (mapv #(Integer/parseInt %) (clojure.string/split (read-line) #"\s+"))) ))))))

(defn run
  "HackerRank support"
  []
  (let [num-test-cases (Integer/parseInt (read-line))]
    (loop [test-case-num num-test-cases]
      (when (> test-case-num 0)
        (let [ladders (get-pairs)
              snakes (get-pairs)]
          (println (snakes-and-ladders snakes ladders)))
        (recur (- test-case-num 1))))))

;; (run)


