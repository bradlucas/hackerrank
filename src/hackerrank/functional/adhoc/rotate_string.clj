(ns hackerrank.functional.adhoc.rotate-string)

;; for a given string produce all the possible rotations of the string
;;
;; abc => bca cab abc

(defn rotate
  [s]
  (apply str (concat (drop 1 s) (take 1 s))))

(defn rotate-string
  [s]
  (loop [cnt (count s)
         s s
         rtn []]
    (if (= cnt 0)
      rtn
      (let [s (rotate s)]
        (recur (dec cnt) s (conj rtn s))))))

(defn run []
  ;; for each print rotations
  ;; read number of string
  (let [n (Integer/parseInt (read-line))]
    (loop [n n]
      (when (> n 0)
        (println (clojure.string/join " " (rotate-string (read-line))))
        (recur (- n 1))))))
