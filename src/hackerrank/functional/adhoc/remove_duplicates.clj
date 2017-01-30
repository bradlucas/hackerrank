(ns hackerrank.functional.adhoc.remove-duplicates)


(defn remove-duplicates
  "https://www.hackerrank.com/challenges/remove-duplicates"
  [s]
  ;; for a given remove characters that have occurred previously

  ;; add each letter to a set
  ;; then remove each subsequent letter which is in the set
  (loop [ary (seq (char-array s))
         s #{}
         rtn []]
    (if (empty? ary)
      rtn
      (let [c (first ary)
            dup (s c)]
        (recur (rest ary) (if dup s (conj s c)) (if dup rtn (conj rtn c)))))))

(defn make-str
  [col]
  (clojure.string/join "" col))

;; (println (make-str (remove-duplicates (read-line))))
