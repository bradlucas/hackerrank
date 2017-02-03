(ns hackerrank.functional.adhoc.missing-numbers-fp)

;; https://www.hackerrank.com/challenges/missing-numbers-fp

;; n - the size of the first list 
;; This is followed by n numbers that makes up the first list. 
;; m - the size of the second list 
;; This is followed by m numbers that makes up the second list.

;; Print the numbers in ascending order the the elements of B that are not in A

;; Test Case
;; 10
;; 203 204 205 206 207 208 203 204 205 206
;; 13
;; 203 204 204 205 206 207 205 208 203 206 205 206 204

(comment
  (def A [203 204 205 206 207 208 203 204 205 206])
  (def B [203 204 204 205 206 207 205 208 203 206 205 206 204])
)

(defn build-counts
  "Return a map with each element of the set s and the count of it accurance"
  [s]
  (loop [s s
         rtn {}]
    (if (empty? s)
      rtn
      (recur (rest s) (if (rtn (first s)) (assoc rtn (first s) (inc (get rtn (first s)))) (assoc rtn (first s) 1))))))

(defn missing-numbers-fp
  [A B]
  (let [mapa (build-counts A)   ;; put A elements in a map with a count for each occurrence
        mapb (build-counts B)   ;; put B elements in a sorted map with a count for each occurrence
        ]
    ;; remove the mapa counts from mapb
    (loop [nums (keys mapa)
           mapb mapb]
      (if (empty? nums)
        (keys (filter (fn [[k v]] (> v 0)) mapb))
        (recur (rest nums) (let [num (first nums)] (assoc mapb num (- (mapb num) (mapa num)))))))))

(defn run
  []
  (let [num-a (Integer/parseInt (read-line))
        a-list (mapv #(Integer/parseInt %) (clojure.string/split (clojure.string/trim (read-line)) #"\s+"))
        num-b (Integer/parseInt (read-line))
        b-list (mapv #(Integer/parseInt %) (clojure.string/split (clojure.string/trim (read-line)) #"\s+"))]
    (println (clojure.string/join " " (sort (missing-numbers-fp a-list b-list))))))
