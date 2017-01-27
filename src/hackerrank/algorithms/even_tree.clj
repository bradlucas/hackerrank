(ns hackerrank.algorithms.even-tree)



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







(defn process
  [num-nodes edges]
  (println num-nodes)
  (println edges))






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
      (process num-nodes edges))))

;; (run)
