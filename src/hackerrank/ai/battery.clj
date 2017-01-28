(ns hackerrank.ai.battery)

;; The battery life maxes out at 8 hours with a charge time of 4 hours
;; The charge time to battery life is 
;;
;; Graphing data shows that
;; 2 * charge-time = battery-life
;; battery-life <= 8.0

(defn battery-life
  [charge-time]
  (min (*' 2 (float charge-time)) 8.0))


(defn round-two-decimals
  [n]
  (format "%.2f" n))


;; (println (round-two-decimals (battery-life timeCharged)))

