(ns hackerrank.functional.introduction.perimeter-of-a-polygon)

;; Compute the Perimeter of a Polygon
;; https://www.hackerrank.com/challenges/lambda-march-compute-the-perimeter-of-a-polygon

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
;;(def pairs [[3, 4] [5, 11] [12, 8] [9, 5] [5, 6]])

(def pairs [[0 0] [0 1] [1 1] [1 0]])

(defn x [[a b]] a)
(defn y [[a b]] b)

(defn sqrt [n] (Math/sqrt n))

(defn abs [n] (> n 0) n (* -1 n))

(defn diff [a b] (abs (- a b)))

(defn square [a] (* a a))

(defn diff-points
  [[x1 y1] [x2 y2]]
  ;;(println x1 y1 x2 y2)
  (sqrt (+ (square (diff x1 x2)) (square (diff y1 y2)))))


(defn perimeter-of-a-polygon [points]
  (let [head (first points)]
    (loop [points points
           acc 0]
      (if (<= (count points) 1)
        (+ acc (diff-points (first points) head))
      (recur (rest points) (+ acc (diff-points (first points) (second points))))))))


(defn run []
  ;; read number of points
  (let [num-pairs (Integer/parseInt (read-line))  ;; number of pairs
         pairs (mapv (fn [[a b]] [(Integer/parseInt a) (Integer/parseInt b)]) (mapv #(clojure.string/split (clojure.string/trim %) #"\s+") (repeatedly num-pairs read-line)))]    
    (println (format "%f" (float (perimeter-of-a-polygon pairs))))))
