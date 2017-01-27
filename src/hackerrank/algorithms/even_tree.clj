(ns hackerrank.algorithms.even-tree)


;; Even Tree
;; https://www.hackerrank.com/challenges/even-tree


;; |--------------+----|
;; | Test Case #0 | OK |
;; | Test Case #1 | OK |
;; | Test Case #2 |    |
;; | Test Case #3 |    |
;; | Test Case #4 |    |
;; | Test Case #5 |    |
;; | Test Case #6 |    |
;; | Test Case #7 |    |
;; | Test Case #8 |    |
;; | Test Case #9 |    |
;; |--------------+----|



;; Input
;; 10 9            - N number of vertices, M number of edges
;; 2 1             - Edges
;; 3 1
;; 4 3
;; 5 2
;; 6 1
;; 7 2
;; 8 6
;; 9 8
;; 10 8
;;
;; Output
;; 2                - Number of edges that are removeable
;;
;;
;;
;; Assign weight to each node
;; Count total weight of each branch/tree from the root
;; The number of even weighted branches is the answer

(defn build-edge [[a b]] 
  (let [rtn (if (not= a b)
              [;;{:source a :dest b}
               {:source b :dest a}
               ])]
    rtn))

(defn build-graph
  [edges]
  (loop [edges edges
         rtn #{}]
    (if (empty? edges)
      rtn
      (recur (rest edges) (apply conj rtn (build-edge (first edges)))))))

(defn get-children [g n] 
  (let [get-node (fn [b n] (filter (fn [m] (= n (:source m))) g))]
    (map :dest (get-node g n))))

(defn queue
      ([] clojure.lang.PersistentQueue/EMPTY)
      ([coll] (reduce conj clojure.lang.PersistentQueue/EMPTY coll)))


(defn node-count [graph node]
  (let [children (get-children graph node)]
    (if (empty? children)
      1
      (apply + 1 (map (fn [n] (node-count graph n)) children)))))


(defn process
  [num-nodes edges]
  ;; get the node-counts for the children of 1
  (let [graph (build-graph edges)
        f (partial node-count graph)
        node-counts (map f (get-children graph 1))]
    ;; return the number of even counts
    (apply + (map #(rem 2 %) (filter even? node-counts)))))


(defn get-pair [] 
  (mapv #(Integer/parseInt %) (clojure.string/split (clojure.string/trim (read-line)) #"\s+")))

(defn read-edges
  "Read n lines to return n edges/pairs"
  [n]
  (loop [n n
         rtn []]
    (if (= n 0)
      rtn
      (recur (dec n) (conj rtn (mapv #(Integer/parseInt %) (clojure.string/split (clojure.string/trim (read-line)) #"\s+")))))))

(defn run
  "get number of vertices and number of edges
     get pair (nodes, edges)
     for each edges
        get pair [a b]
"
  []
  (let [[num-nodes num-edges] (get-pair)]
    (let [edges (read-edges num-edges)]
      (println (process num-nodes edges)))))

;; (run)



;; TESTING
;; (def g (build-graph [[2 1] [3 1] [4 3] [5 2] [6 1] [7 2] [8 6] [9 8] [10 8]]))
;; (process 10 [[2 1] [3 1] [4 3] [5 2] [6 1] [7 2] [8 6] [9 8] [10 8]])
;;
;; (def g (build-graph [[2,1],[3,1],[4,3],[5,2],[6,5],[7,1],[8,1],[9,2],[10,7],[11,10],[12,3],[13,7],[14,8],[15,12],[16,6],[17,6],[18,10],[19,1],[20,8]]))
;; (process 10 [[2,1],[3,1],[4,3],[5,2],[6,5],[7,1],[8,1],[9,2],[10,7],[11,10],[12,3],[13,7],[14,8],[15,12],[16,6],[17,6],[18,10],[19,1],[20,8]])
