(ns hackerrank.ai.botcleanr
  (:gen-class))


;; 0 0
;; b----
;; -----
;; -----
;; -d---
;; -----


;; 5x5 grid
;;
;; LEFT, RIGHT, UP, DOWN, CLEAN

(defn col
  "For each line return the index of the value"
  [grid val]
  (first (remove neg? (map #(.indexOf % val) grid))))

(defn row
  "For each line return the index of the value. Then return the index of this row"
  [grid val]
  (first (keep-indexed #(when (>= %2 0) %1) (map #(.indexOf % val) grid))))

(defn next-move 
  "Bot's initial position is br and bc. Board is a 5x5 grid with the letter d for dirty cells. Return the next move."
  [[br bc] grid]
    (let [dc (col grid "d")
          dr (row grid "d")]
      (if (and (= bc dc) (= br dr))
        (println "CLEAN")
        (if (< dc bc)
          (println "LEFT")
          (if (> dc bc)
            (println "RIGHT")
            (if (< dr br)
              (println "UP")
              (println "DOWN")))))))

(defn run
  []
  (let [[br bc] (mapv #(Integer/parseInt %) (clojure.string/split (clojure.string/trim (read-line)) #"\s+"))
        board (doall (repeatedly 5 read-line))]
    (next-move [br bc] board)))

;; (run)

