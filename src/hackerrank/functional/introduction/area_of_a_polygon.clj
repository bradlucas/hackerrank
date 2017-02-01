(ns hackerrank.functional.introduction.area-of-a-polygon)

;; Compute the Area of a Polygon
;; https://www.hackerrank.com/challenges/lambda-march-compute-the-area-of-a-polygon


;; 4
;; 0 0
;; 0 1  
;; 1 1  
;; 1 0

;; First number is the number of points
;; Polygon is obtrained by traversing the points in a counter-clockwise fashion

;; https://en.wikipedia.org/wiki/Shoelace_formula
;; = 1/2 [ x1y2 + x2y3 + x3y1 - y1x2 - y2x3 y3x1]

;; Test
;; (3,4), (5,11), (12,8), (9,5), and (5,6) -> 30


;; pairs are listed in the counter-clockwise order
(def pairs [[3, 4] [5, 11] [12, 8] [9, 5] [5, 6]])

(defn x [[a b]] a)
(defn y [[a b]] b)


(defn mult-x-y-pairs
  [points]
  (let [points points ;; (reverse points)
        ]
    (let [head (first points)]
      ;; (println head)
      (loop [pts points
             a []
             b []]
        (when pts
          (let [current (first pts)
                cnt (count pts)]
            (if (= 1 cnt)
              [(conj a (* (x current) (y head))) (conj b (* (y current) (x head)))]
              (let [next (second pts)]
                (recur (rest pts) (conj a (* (x current) (y next))) (conj b (* (y current) (x next))))))))))))


(defn area-of-a-polygon [points]
    (/ ((fn [[a b]] (- (apply + a) (apply + b))) (mult-x-y-pairs points)) 2))


(defn run []
  ;; read number of points
  (let [num-pairs (Integer/parseInt (read-line))  ;; number of pairs
         pairs (mapv (fn [[a b]] [(Integer/parseInt a) (Integer/parseInt b)]) (mapv #(clojure.string/split (clojure.string/trim %) #"\s+") (repeatedly num-pairs read-line)))]    
    (println (format "%.1f" (float (area-of-a-polygon pairs))))))
