(ns hackerrank.algorithms.bfsshortreach)

;; Breadth First Search: Shortest Reach
;; https://www.hackerrank.com/challenges/bfsshortreach
;;
;; |--------------+---------|
;; | Test Case #0 | OK      |
;; | Test Case #1 | OK      |
;; | Test Case #2 | Timeout |
;; | Test Case #3 | Timeout |
;; | Test Case #4 | OK      |
;; | Test Case #5 | Timeout |
;; | Test Case #6 | Timeout |
;; |--------------+---------|


(defn build-edge [[a b]] 
  (let [rtn (if (not= a b)
              [{:source a :dest b}
               {:source b :dest a}])]
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

(defn breadth-first
  [next start target]
  (loop [q (queue [[start]])]
    (if (empty? q)
      nil
      (let [path (peek q)
            current (last path)]
        (if (= current target)
          path
          (let [children (next current)]
            (recur (into (pop q) (map #(conj path %) children)))))))))

(defn calc-cost [l] 
  (if (> l 0)
    (* 6 l)
    -1))

(defn run-check 
  [nodes f start n]
  (if (and (contains? nodes start) (contains? nodes n))
    (breadth-first f start n)))

(defn process
  [start num-nodes edges]
  (let [cleaned-edges (filter (fn [[a b]] (not= a b )) edges)              ;; remove edges that are [a a]
        graph (build-graph cleaned-edges)                                  ;; build the graph
        children (partial get-children graph)                              ;; function to return the children of a node
        node-range (remove #(= start %) (range 1 (inc num-nodes)))             ;; want the range 1 to nodes but with the start node removed
        nodes-set (set (flatten cleaned-edges))                                ;; set of node numbers  
        ]
    (let [vals (map #(calc-cost (dec (count (run-check nodes-set children start %)))) node-range)]
      (println (clojure.string/join " " vals)))))

(defn get-int []
  (Integer/parseInt (clojure.string/trim (read-line))))

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
  "get num of test
   for each num
     get pair (nodes, edges)
     for each edges
        get pair [a b]"
  []
  (let [num (get-int)]
    (loop [n num]
      (when (> n 0)
        (let [[nodes edges] (get-pair)]
          (let [edges (read-edges edges)
                start (Integer/parseInt (clojure.string/trim (read-line)))]
            (process start nodes edges)
            (println "")))
        (recur (dec n))))))

;; (run)
