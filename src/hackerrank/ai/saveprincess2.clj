(ns hackerrank.ai.saveprincess2)

;; Bot saves princess - 2
;; https://www.hackerrank.com/challenges/saveprincess2


;; 5
;; 2 3
;; -----
;; -----
;; p--m-
;; -----
;; -----

;; LEFT

;; Output only the next move

;; build the grid and mark M and P
;; reduce over the grid moving in the direction of P
;; for example, down and to the right or similar

(defn get-col-pos
  "For each line return the index of the value"
  [grid val]
  (first (remove neg? (map #(.indexOf % val) grid))))

(defn get-row-pos
  "For each line return the index of the value. Then return the index of this row"
  [grid val]
  (first (keep-indexed #(when (>= %2 0) %1) (map #(.indexOf % val) grid))))

(defn process [grid]
  (let [princess-col (get-col-pos grid "p")
        princess-row (get-row-pos grid "p")

        bot-col (get-col-pos grid "m")
        bot-row (get-row-pos grid "m")]

    ;; what is the next move
    (if (< princess-col bot-col)
      (println "LEFT")
      (if (> princess-col bot-col)
        (println "RIGHT")
        (if (< princess-row bot-row)
          (println "UP")
          (println "DOWN"))        
        ))
))

(defn run []
  (let [m (Integer/parseInt (read-line))
        bot-pos (read-line)
        grid (doall (repeatedly m read-line))]
    (process grid)))

;; (run)

