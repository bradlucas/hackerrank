(ns hackerrank.functional.recursion.string-compression)


;; String Compression
;; https://www.hackerrank.com/challenges/string-compression


(defn build-letter-counts
  [s]
  ;; ([\a 1] [\b 8] [\a 1] [\c 7] [\a 3])
  (let [counts (map (juxt first count) (partition-by identity s))]
    (apply str (flatten (map (fn [[a b]] (if (> b 1) [a b] [a])) counts)))))


(defn run
  []
  (println (build-letter-counts (read-line))))

